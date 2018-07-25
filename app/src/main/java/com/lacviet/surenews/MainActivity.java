package com.lacviet.surenews;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lacviet.surenews.Adapter.MainScreenPagerAdapter;
import com.lacviet.surenews.DevelopmentMenu.DevelopmentMenuActivity;
import com.lacviet.surenews.Feedback.FeedbackActivity;
import com.lacviet.surenews.GovementMenu.GovementMenuActivity;
import com.lacviet.surenews.StatisticalMenu.StatisticalMenuActivity;
import com.lacviet.surenews.WebAPI.ModelAPI.AllCategoryJsonResponse;
import com.lacviet.surenews.WebAPI.ModelAPI.CategoryModel;
import com.lacviet.surenews.WebAPI.Remote.ApiService;
import com.lacviet.surenews.WebAPI.Remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    TextView tvTitleToolbar;
    ViewPager pager;
    TabLayout tabLayout;
    MainScreenPagerAdapter adapter;
    ProgressBar pbMain;
    //api
    ApiService mService;
    List<CategoryModel> categoryModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        actionBar();
        loadCategoryTabName();
        eventNavigation();
        //

    }

    private void loadCategoryTabName() {
            mService.getAllCategorys(true).enqueue(new Callback<AllCategoryJsonResponse>() {
                @Override
                public void onResponse(Call<AllCategoryJsonResponse> call, Response<AllCategoryJsonResponse> response) {

                    if (response.isSuccessful()) {

                        categoryModelList = new ArrayList<>();

                        for (CategoryModel md: response.body().getCategoryModels()) {
                            categoryModelList.add(md);
                        }
                        showTabLayout();
                        //
                        pbMain.setVisibility(View.GONE);
                        

                        Log.d("AnswersPresenter", "posts loaded from API");
                    } else {
                        int statusCode = response.code();
                        Toast.makeText(MainActivity.this, "Error" + statusCode + response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<AllCategoryJsonResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Vui lòng kiểm tra kết nối", Toast.LENGTH_SHORT).show();
                    Log.d("AnswersPresenter", "error loading from API");

                }
            });
        }


    private void eventNavigation() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:{
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        return true;
                    }
                    case R.id.nav_govement:{
                        Intent intent = new Intent(MainActivity.this, GovementMenuActivity.class);
                        startActivity(intent);
                        return true;
                    }
                    case R.id.nav_development:{
                        Intent intent = new Intent(MainActivity.this, DevelopmentMenuActivity.class);
                        startActivity(intent);
                        return true;
                    }


                }
                return true;
            }
        });
    }

    private void showTabLayout() {
        // Set up the ViewPager with the sections adapter.
        FragmentManager manager = getSupportFragmentManager();
        adapter = new MainScreenPagerAdapter(manager,MainActivity.this,categoryModelList);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
        pager.setOffscreenPageLimit(categoryModelList.size());//no reload when change tab
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbarMainscreen);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        navigationView = findViewById(R.id.ngvMainscreen);
        drawerLayout = findViewById(R.id.drawerLayout);
        pager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabLayoutMain);
        pbMain = findViewById(R.id.pbmain);
        //
        mService = ApiUtils.getSOService();

    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        tvTitleToolbar.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    /*@Override
    public void onWindowFocusChanged(boolean hasFocus){

        // set toolbar logo to center programmatically
        int offset = (toolbar.getWidth() / 2) - (imvLogo.getWidth() / 2);
        // set
        imvLogo.setX(offset);

    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_feedback:
                Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
