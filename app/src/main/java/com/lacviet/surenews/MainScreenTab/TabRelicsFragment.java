package com.lacviet.surenews.MainScreenTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lacviet.surenews.Adapter.HomeTabRCVAdapter;
import com.lacviet.surenews.Model.HomeNewsModel;
import com.lacviet.surenews.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class TabRelicsFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeTabRCVAdapter mAdapter;
    private ArrayList<HomeNewsModel> listHomeNews = new ArrayList<>();
    ProgressBar pbTabhome;
    //
    String url = "http://baclieu.gov.vn/gioithieu/lists/posts/post.aspx?Source=%2fgioithieu&Category=Di+t%C3%ADch+l%E1%BB%8Bch+s%E1%BB%AD+v%C3%A0+ki%E1%BA%BFn+tr%C3%BAc&Mode=2";
    String baseSrcUrl = "http://baclieu.gov.vn/";
    //
    String tittle = "";
    String time = "";
    String avatar = "";
    String subTittle = "";
    String link = "";
    ArrayList<String> arrTitle = new ArrayList<>();
    ArrayList<String> arrTime = new ArrayList<>();
    ArrayList<String> arrAvatar = new ArrayList<>();
    ArrayList<String> arrSubtitle = new ArrayList<>();
    ArrayList<String> arrLink = new ArrayList<>();
    public TabRelicsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_relics, container, false);
        addControl(view);
        showDataToRecyclerView();
        loadData();
        return view;
    }

    private void loadData() {
        //
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document document = Jsoup.parse(response);
                if (document != null) {

                    Elements elementsTittle = document.select("td[class=TitleFront]");
                    for (Element element : elementsTittle) {
                        Element elementTittle = element.getElementsByTag("a").first();
                        Element elementTime = element.getElementsByTag("span").first();
                        Element elementLink = element.getElementsByTag("a").first();
                        if (elementTittle != null) {
                            tittle = elementTittle.text();
                        }
                        if (elementTime != null) {
                            time = elementTime.text();
                        }
                        if (elementLink != null) {
                            link = elementLink.attr("href");
                        }
                        if (!link.startsWith("http://")) {
                            link = baseSrcUrl + link;
                        }

                        arrTitle.add(tittle);
                        arrTime.add(time);
                        arrLink.add(link);
                    }
                    Elements elementsAvatar = document.select("td[class=tinHT]");
                    for (Element element : elementsAvatar) {
                        Element elementAvatar = element.getElementsByTag("img").first();
                        if (elementAvatar != null) {
                            avatar = elementAvatar.attr("src");
                        }
                        if (!avatar.startsWith("http://")) {
                            avatar = baseSrcUrl + avatar;
                        }
                        arrAvatar.add(avatar);
                    }
                    Elements elementsContent = document.select("div.ContentText");
                    for (Element element : elementsContent) {
                        Element elementContent = element.getElementsByTag("div").first();
                        if (elementContent != null) {
                            subTittle = elementContent.text();
                        }
                        arrSubtitle.add(subTittle);
                    }
                    for (int i = 0; i < arrTitle.size() / 2; i++) {
                        tittle = arrTitle.get(i);
                        time = arrTime.get(i);
                        avatar = arrAvatar.get(i);
                        subTittle = arrSubtitle.get(i);
                        link = arrLink.get(i);
                        listHomeNews.add(new HomeNewsModel(1, tittle, subTittle, avatar, time, link));
                    }

                    mAdapter.updateAnswers(listHomeNews);
                    pbTabhome.setVisibility(View.GONE);
                }

            }
        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Kết nối internet khá yếu!",Toast.LENGTH_LONG);
            }
        });
        requestQueue.add(stringRequest);
    }


    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabRelics);
        pbTabhome =view.findViewById(R.id.pbTabRelics);
    }

    private void showDataToRecyclerView() {
        mAdapter = new HomeTabRCVAdapter(getContext(), new ArrayList<HomeNewsModel>(0), new HomeTabRCVAdapter.PostItemListener() {

            @Override
            public void onPostClick(String link, String title,String time) {

            }
        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}