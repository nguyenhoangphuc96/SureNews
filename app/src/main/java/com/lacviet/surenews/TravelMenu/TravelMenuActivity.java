package com.lacviet.surenews.TravelMenu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.lacviet.surenews.GovementMenu.GovementPagerAdapter;
import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.AllCategoryJsonResponse;
import com.lacviet.surenews.WebAPI.ModelAPI.CategoryModel;
import com.lacviet.surenews.WebAPI.Remote.ApiService;
import com.lacviet.surenews.WebAPI.Remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TravelMenuActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    TextView tvTitleToolbar;
    ViewPager pager;
    TabLayout tabLayout;
    //
    TravelPagerAdapter adapter;
    ProgressBar pbTravel;
    //api
    ApiService mService;
    List<CategoryModel> categoryModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        addControl();
        actionBar();
        loadCategoryTabName();
    }
    private void loadCategoryTabName() {
        mService.getAllCategorysTravel().enqueue(new Callback<AllCategoryJsonResponse>() {
            @Override
            public void onResponse(Call<AllCategoryJsonResponse> call, Response<AllCategoryJsonResponse> response) {

                if (response.isSuccessful()) {

                    categoryModelList = new ArrayList<>();

                    for (CategoryModel md: response.body().getCategoryModels()) {
                        categoryModelList.add(md);
                    }
                    showTabLayout();
                    //
                    pbTravel.setVisibility(View.GONE);


                    Log.d("AnswersPresenter", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Toast.makeText(TravelMenuActivity.this, "Error" + statusCode + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllCategoryJsonResponse> call, Throwable t) {
                Toast.makeText(TravelMenuActivity.this, "Vui lòng kiểm tra kết nối", Toast.LENGTH_SHORT).show();
                Log.d("AnswersPresenter", "error loading from API");

            }
        });
    }
    private void showTabLayout() {
        // Set up the ViewPager with the sections adapter.
        FragmentManager manager = getSupportFragmentManager();
        adapter = new TravelPagerAdapter(manager,this,categoryModelList);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
        pager.setOffscreenPageLimit(categoryModelList.size());//no reload when change tab
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        pager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabLayoutTravel);
        pbTravel = findViewById(R.id.pbTravel);
        //
        mService = ApiUtils.getSOService();
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        tvTitleToolbar.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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