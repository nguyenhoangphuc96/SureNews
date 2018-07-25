package com.lacviet.surenews.DevelopmentMenu;

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

import com.lacviet.surenews.Adapter.MainScreenPagerAdapter;
import com.lacviet.surenews.GovementMenu.GovementMenuActivity;
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

public class DevelopmentMenuActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    TextView tvTitleToolbar;
    ViewPager pager;
    TabLayout tabLayout;
    //
    DevelopmentPagerAdapter adapter;
    ProgressBar pbDevelopment;
    //api
    ApiService mService;
    List<CategoryModel> categoryModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development);
        addControl();
        actionBar();
        loadCategoryTabName();
    }

    private void loadCategoryTabName() {
        mService.getAllCategorysDevelopment().enqueue(new Callback<AllCategoryJsonResponse>() {
            @Override
            public void onResponse(Call<AllCategoryJsonResponse> call, Response<AllCategoryJsonResponse> response) {

                if (response.isSuccessful()) {

                    categoryModelList = new ArrayList<>();

                    for (CategoryModel md: response.body().getCategoryModels()) {
                        categoryModelList.add(md);
                    }
                    showTabLayout();
                    //
                    pbDevelopment.setVisibility(View.GONE);


                    Log.d("AnswersPresenter", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Toast.makeText(DevelopmentMenuActivity.this, "Error" + statusCode + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllCategoryJsonResponse> call, Throwable t) {
                Toast.makeText(DevelopmentMenuActivity.this, "Vui lòng kiểm tra kết nối", Toast.LENGTH_SHORT).show();
                Log.d("AnswersPresenter", "error loading from API");

            }
        });
    }

    private void showTabLayout() {
        // Set up the ViewPager with the sections adapter.
        FragmentManager manager = getSupportFragmentManager();
        adapter = new DevelopmentPagerAdapter(manager,this,categoryModelList);
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
        tabLayout = findViewById(R.id.tabLayoutDevelopment);
        pbDevelopment = findViewById(R.id.pbDevelopment);
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