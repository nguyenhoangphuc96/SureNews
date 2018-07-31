package com.lacviet.surenews.Feedback;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lacviet.surenews.Chart.ChartActivity;
import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.FieldModel;
import com.lacviet.surenews.WebAPI.ModelAPI.FieldModelJsonRespone;
import com.lacviet.surenews.WebAPI.Remote.ApiService;
import com.lacviet.surenews.WebAPI.Remote.ApiUtils;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FeedbackActivity extends AppCompatActivity implements IPickResult, View.OnClickListener {
    private Toolbar toolbar;
    private TextView tvTitleToolbar, tvSend;
    ImageView imv1, imv2, imv3;
    CardView cv1, cv2, cv3;
    Spinner spnfeedback;
    Boolean flagImv1 = false;
    Boolean flagImv2 = false;
    Boolean flagImv3 = false;
    ArrayAdapter<String> adapter;
    //api
    private ApiService mService;
    List<FieldModel> listFieldModel;
    ArrayList<String> listFieldName;
    ArrayList<String> listFieldId;
    String fieldId = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback1);
        addControl();
        actionBar();
        dropDownSpinner();
        loadField();
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
        //
        mService = ApiUtils.getSOService();
        //
        listFieldModel = new ArrayList<>();
        listFieldId = new ArrayList<>();
        listFieldName = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.imvFeedback1: {
                PickImageDialog.build(new PickSetup()).show(FeedbackActivity.this);
                flagImv1 = true;

                break;
            }
            case R.id.imvFeedback2: {
                PickImageDialog.build(new PickSetup()).show(FeedbackActivity.this);
                flagImv2 = true;

                break;
            }
            case R.id.imvFeedback3: {
                PickImageDialog.build(new PickSetup()).show(FeedbackActivity.this);
                flagImv3 = true;
                break;
            }
            case R.id.tvSend: {
                startConfirmSDTActivity();

            }
            default:
                break;
        }
    }

    private void startConfirmSDTActivity() {
        Intent intent = new Intent(FeedbackActivity.this, SDTConfirmActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPickResult(PickResult pickResult) {
        if (flagImv1) {
            imv1.setImageBitmap(pickResult.getBitmap());
            cv2.setVisibility(View.VISIBLE);
            flagImv1 = false;
        }
        if (flagImv2) {
            imv2.setImageBitmap(pickResult.getBitmap());
            cv3.setVisibility(View.VISIBLE);
            flagImv2 = false;
        }
        if (flagImv3) {
            imv3.setImageBitmap(pickResult.getBitmap());
            flagImv3 = false;
        }

    }

    private void dropDownSpinner() {


        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listFieldName);

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
                fieldId = listFieldId.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void loadField() {


        mService.getAllField().enqueue(new Callback<FieldModelJsonRespone>() {
            @Override
            public void onResponse(Call<FieldModelJsonRespone> call, Response<FieldModelJsonRespone> response) {

                if (response.isSuccessful()) {
                    listFieldModel = response.body().getFieldModels();
                    for (FieldModel fieldModel : listFieldModel) {
                        listFieldName.add(fieldModel.getName());
                        listFieldId.add(fieldModel.getId());
                    }
                    adapter.notifyDataSetChanged();
                    Log.d("AnswersPresenter", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Toast.makeText(FeedbackActivity.this, "Error" + statusCode + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FieldModelJsonRespone> call, Throwable t) {
                Toast.makeText(FeedbackActivity.this, "Vui lòng kiểm tra kết nối", Toast.LENGTH_SHORT).show();
                Log.d("AnswersPresenter", "error loading from API");

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
