package com.lacviet.surenews.DetailScreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.Model.DetailModel;
import com.lacviet.surenews.Model.HomeNewsModel;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar pbDetail;
    LinearLayout loBody;
    TextView tvTitle, tvTime, tvSubTitle;
    ArrayList<DetailModel> listDetail;
    //
    String url = "";
    String baseSrcUrl = "http://baclieu.gov.vn";
    //
    String tittle = "";
    String time = "";
    String image = "";
    String text = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        addControl();
        actionBar();
        getDatafromPreviousActivity();
        loadData();


    }

    private void getDatafromPreviousActivity() {
        Bundle extras = this.getIntent().getExtras();
        KeyString key = new KeyString();
        url = extras.getString(key.LINK);
        tittle = extras.getString(key.TITLE);
        time = extras.getString(key.TIME);

    }

    private void loadData() {
        tvTitle.setText(tittle);
        tvTime.setText(time);
        //
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                listDetail = new ArrayList<>();
                Document document = Jsoup.parse(response);
                if (document != null) {

                    Elements elementsBody = document.select("p[class=MsoNormal]");
                    for (int i = 0; i < elementsBody.size(); i++) {
                        Element spanTag = elementsBody.get(i).getElementsByTag("span").first();
                        Element imgTag = spanTag.getElementsByTag("img").first();
                        if (imgTag != null) {
                            image = imgTag.attr("src");
                            if (!image.startsWith("http://"))
                            {
                                image = baseSrcUrl+image;
                            }
                            Element spanTextTag = elementsBody.get(i + 1).getElementsByTag("span").first();
                            text = spanTextTag.text();
                            listDetail.add(new DetailModel(text, image));
                            i++;
                        } else {
                            Element spanTextTag = spanTag.getElementsByTag("span").first();
                            text = spanTextTag.text();
                            listDetail.add(new DetailModel(text, null));
                        }
                    }
                    for (DetailModel mo : listDetail) {
                      if(mo.getPhoto()!=null)
                      {
                          View layout2 = LayoutInflater.from(DetailActivity.this).inflate(R.layout.item_image, loBody, false);

                          TextView textView = layout2.findViewById(R.id.tvImageText);
                          ImageView imgView = layout2.findViewById(R.id.imvImage);

                          textView.setText(mo.getText());
                          Picasso.with(DetailActivity.this).load(mo.getPhoto()).into(imgView);

                          loBody.addView(layout2);
                      }
                      else {
                          View layout1 = LayoutInflater.from(DetailActivity.this).inflate(R.layout.item_text, loBody, false);

                          TextView textView = (TextView) layout1.findViewById(R.id.tvText);

                          textView.setText(mo.getText());

                          loBody.addView(layout1);
                      }
                    }

                    pbDetail.setVisibility(View.GONE);

                }
            }
        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetailActivity.this,"Kết nối internet khá yếu!",Toast.LENGTH_LONG);
            }
        });
        requestQueue.add(stringRequest);
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        pbDetail = findViewById(R.id.pbDetail);
        loBody = findViewById(R.id.loBody);
        tvTitle = findViewById(R.id.tvTitle);
        tvTime = findViewById(R.id.tvTime);
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
