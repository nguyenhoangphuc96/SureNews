package com.lacviet.surenews.Feedback;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lacviet.surenews.Chart.ChartActivity;
import com.lacviet.surenews.MainActivity;
import com.lacviet.surenews.R;
import com.lacviet.surenews.TravelMenu.TravelMenuActivity;
import com.lacviet.surenews.Util;
import com.lacviet.surenews.WebAPI.ModelAPI.FeedbackModel;
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
    EditText edtTitle,edtContent,edtCreateby,edtPhone;
    ArrayAdapter<String> adapter;
    //api
    private ApiService mService;
    List<FieldModel> listFieldModel;
    ArrayList<String> listFieldName;
    ArrayList<String> listFieldId;
    String fieldId = "";
    String title = "";
    String content = "";
    String createby = "";
    String phone = "";
    String attachments = "";
    FeedbackModel feedbackModel;
    ProgressBar pbFeedback;

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
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtFeedbackContent);
        edtCreateby = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtSDT);
        tvSend = findViewById(R.id.tvSend);
        spnfeedback = findViewById(R.id.spinnerFeedback);
        //
        mService = ApiUtils.getSOService();
        //
        listFieldModel = new ArrayList<>();
        listFieldId = new ArrayList<>();
        listFieldName = new ArrayList<>();
        //
        pbFeedback = findViewById(R.id.pbFeedback);

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

                title = edtTitle.getText().toString().trim();
                content = edtContent.getText().toString().trim();
                createby = edtCreateby.getText().toString().trim();
                phone = edtPhone.getText().toString().trim();
                //image
                Bitmap bitmap = ((BitmapDrawable)imv1.getDrawable()).getBitmap();
                if(bitmap == ((BitmapDrawable)getResources().getDrawable(R.drawable.img_add_photo)).getBitmap())
                {
                    attachments = "";
                }
                else {
                    attachments = Util.BitMapToString(bitmap);
                }
                if(TextUtils.isEmpty(title)) {
                    edtTitle.setError("Tiêu đề không được để trống!");
                }
                else {
                    if(TextUtils.isEmpty(createby)) {
                        edtCreateby.setError("Người gủi không được để trống!");
                    }
                    else {
                        if(TextUtils.isEmpty(phone)) {
                            edtPhone.setError("Số điện thoại không được để trống!");
                        }
                        else {
                            pbFeedback.setVisibility(View.VISIBLE);
                            title = edtTitle.getText().toString().trim();
                            content = edtContent.getText().toString().trim();
                            createby = edtCreateby.getText().toString().trim();
                            phone = edtPhone.getText().toString().trim();
                            //
                            feedbackModel = new FeedbackModel();
                            feedbackModel.setFieldId(fieldId);
                            feedbackModel.setTitle(title);
                            feedbackModel.setContent(content);
                            feedbackModel.setCreateBy(createby);
                            feedbackModel.setPhone(phone);
                            feedbackModel.setAttachments(attachments);
                            postFeedbackModel(feedbackModel);
                            //postFeedback(fieldId,title,content,createby,phone,attachments);
                        }
                    }
                }




            }
            default:
                break;
        }
    }

    private void postFeedbackModel(FeedbackModel feedbackModel) {
        mService.postFeedbackModel(feedbackModel).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()) {
                    pbFeedback.setVisibility(View.GONE);
                    showDialogSuccess();
                    Log.d("AnswersPresenter","post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(FeedbackActivity.this, "Vui lòng kiểm tra kết nối!", Toast.LENGTH_SHORT).show();
                Log.d("AnswersPresenter", "Unable to submit post to API.");
            }
        });
    }

    private void postFeedback(String fieldId, String title, String content, String createby, String phone, String attachments) {
        mService.postFeedback(fieldId,title,content,createby,phone,"").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()) {
                    showDialogSuccess();
                    Log.d("AnswersPresenter","post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(FeedbackActivity.this, "Vui lòng kiểm tra kết nối!", Toast.LENGTH_SHORT).show();
                Log.d("AnswersPresenter", "Unable to submit post to API.");
            }
        });
    }

    private void startConfirmSDTActivity() {
        Intent intent = new Intent(FeedbackActivity.this, SDTConfirmActivity.class);
        startActivity(intent);
    }
    private void showDialogSuccess() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Gửi phản ánh thành công!");
        alertDialogBuilder
                .setMessage("Bạn có muốn tiếp tục gửi phản ánh khác?")
                .setCancelable(false)
                .setPositiveButton("Có",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                startActivity(getIntent());
                            }
                        })

                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startMainActivity();
                        //dialog.cancel();
                    }
                })
                .setIcon(R.drawable.ic_success);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void startMainActivity() {
        Intent intent = new Intent(FeedbackActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPickResult(PickResult pickResult) {
        imv1.setImageBitmap(pickResult.getBitmap());

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
