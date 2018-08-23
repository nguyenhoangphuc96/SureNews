package com.lacviet.surenews.Tags;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lacviet.surenews.Adapter.HomeTabRCVAdapterTemp;
import com.lacviet.surenews.DevelopmentMenu.DetailDevelopmentActivity;
import com.lacviet.surenews.GovementMenu.DetailGovernmentActivity;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.AllNewsJsonResponse;
import com.lacviet.surenews.WebAPI.ModelAPI.NewsModel;
import com.lacviet.surenews.WebAPI.Remote.ApiService;
import com.lacviet.surenews.WebAPI.Remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListNewsDevelopmentActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView tvTitleToolbar;
    RecyclerView recyclerView;
    ProgressBar pbListNews;
    //
    HomeTabRCVAdapterTemp mAdapter;
    List<NewsModel> listNews;
    //api
    ApiService mService;
    String categoryId = "";
    String tag = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        addControl();
        actionBar();
        getDatafromPreviousActivity();
        showDataToRecyclerView();
        loadData();

    }

    private void loadData() {
        mService = ApiUtils.getSOService();
        mService.getAllInvestmentNewsByTag(categoryId,tag,1,10).enqueue(new Callback<AllNewsJsonResponse>() {
            @Override
            public void onResponse(Call<AllNewsJsonResponse> call, Response<AllNewsJsonResponse> response) {

                if (response.isSuccessful()) {
                    listNews = new ArrayList<>();
                    listNews = response.body().getNewsModels();
                    mAdapter.updateAnswers(listNews);
                    pbListNews.setVisibility(View.GONE);
                    Log.d("AnswersPresenter", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Toast.makeText(ListNewsDevelopmentActivity.this, "Error" + statusCode + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllNewsJsonResponse> call, Throwable t) {
                Toast.makeText(ListNewsDevelopmentActivity.this, "Vui lòng kiểm tra kết nối!", Toast.LENGTH_SHORT).show();
                Log.d("AnswersPresenter", "error loading from API");

            }
        });
    }

    private void startDetailActivity(String id, String categoryId) {
        Intent intent = new Intent(ListNewsDevelopmentActivity.this, DetailDevelopmentActivity.class);
        KeyString key = new KeyString();
        intent.putExtra(key.ID, id);
        intent.putExtra(key.CATEGORY_ID, categoryId);
        startActivity(intent);
    }
    private void showDataToRecyclerView() {
        mAdapter = new HomeTabRCVAdapterTemp(this, new ArrayList<NewsModel>(0), new HomeTabRCVAdapterTemp.PostItemListener() {


            @Override
            public void onPostClick(String id, String title, String time, String subTitle, String categoryId) {
                startDetailActivity(id,categoryId);
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
    private void getDatafromPreviousActivity() {
        Bundle extras = this.getIntent().getExtras();
        KeyString key = new KeyString();
        categoryId = extras.getString(key.CATEGORY_ID);
        tag = extras.getString(key.TAG);
    }
    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        recyclerView = findViewById(R.id.rcvListNews);
        pbListNews = findViewById(R.id.pbListNews);
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
}