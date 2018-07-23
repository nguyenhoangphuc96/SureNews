package com.lacviet.surenews.GovementMenu;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lacviet.surenews.Adapter.MainScreenPagerAdapter;
import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class GovementMenuActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    TextView tvTitleToolbar;
    ViewPager pager;
    TabLayout tabLayout;
    //
    List<CategoryModel> categoryModelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govement);
        addControl();
        actionBar();
        showTabLayout();
    }
    private void showTabLayout() {
        // Set up the ViewPager with the sections adapter.
        FragmentManager manager = getSupportFragmentManager();
        MainScreenPagerAdapter adapter = new MainScreenPagerAdapter(manager,this,categoryModelList);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
        pager.setOffscreenPageLimit(4);//no reload when change tab
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        pager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabLayoutGovement);
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
