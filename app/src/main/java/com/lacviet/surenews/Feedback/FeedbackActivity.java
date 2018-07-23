package com.lacviet.surenews.Feedback;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.lacviet.surenews.Chart.ChartActivity;
import com.lacviet.surenews.R;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;


public class FeedbackActivity extends AppCompatActivity implements IPickResult, View.OnClickListener {
    private Toolbar toolbar;
    private TextView tvTitleToolbar,tvSend;
    ImageView imv1, imv2, imv3;
    CardView cv1,cv2,cv3;
    Spinner spnfeedback;
    Boolean flagImv1= false;
    Boolean flagImv2= false;
    Boolean flagImv3= false;
    //

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback1);
        addControl();
        actionBar();
        dropDownSpinner();
        addEvent();

    }

    private void addEvent() {
        imv1.setOnClickListener(this);
        imv2.setOnClickListener(this);
        imv3.setOnClickListener(this);
        tvSend.setOnClickListener(this);

    }


    private void actionBar() {
        setSupportActionBar(toolbar);
        tvTitleToolbar.setText(toolbar.getTitle());
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

    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        imv1 = findViewById(R.id.imvFeedback1);
        imv2 = findViewById(R.id.imvFeedback2);
        imv3 = findViewById(R.id.imvFeedback3);
        cv1 = findViewById(R.id.cvFeedback1);
        cv2 = findViewById(R.id.cvFeedback2);
        cv3 = findViewById(R.id.cvFeedback3);

        tvSend = findViewById(R.id.tvSend);
        spnfeedback = findViewById(R.id.spinnerFeedback);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.imvFeedback1:{
                PickImageDialog.build(new PickSetup()).show(FeedbackActivity.this);
                flagImv1 = true;

                break;
            }
            case R.id.imvFeedback2:{
                PickImageDialog.build(new PickSetup()).show(FeedbackActivity.this);
                flagImv2 = true;

                break;
            }
            case R.id.imvFeedback3:{
                PickImageDialog.build(new PickSetup()).show(FeedbackActivity.this);
                flagImv3 = true;
                break;
            }
            case R.id.tvSend:{
                startConfirmSDTActivity();

            }
            default:break;
        }
    }

    private void startConfirmSDTActivity() {
        Intent intent = new Intent(FeedbackActivity.this,SDTConfirmActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPickResult(PickResult pickResult) {
        if(flagImv1)
        {
            imv1.setImageBitmap(pickResult.getBitmap());
            cv2.setVisibility(View.VISIBLE);
            flagImv1=false;
        }
        if (flagImv2){
            imv2.setImageBitmap(pickResult.getBitmap());
            cv3.setVisibility(View.VISIBLE);
            flagImv2=false;
        }
        if (flagImv3)
        {
            imv3.setImageBitmap(pickResult.getBitmap());
            flagImv3=false;
        }

    }
    private void dropDownSpinner() {


        String[] items = new String[]{"An ninh - Trật tự", "An toàn giao thông", "An toàn thực phẩm", "Khác"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnfeedback.setAdapter(adapter);

        spnfeedback.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (parent.getChildAt(0) != null) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                    ((TextView) parent.getChildAt(0)).setTextSize(13);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feedback, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_chart: {
                Intent intent = new Intent(FeedbackActivity.this, ChartActivity.class);
                startActivity(intent);

                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
