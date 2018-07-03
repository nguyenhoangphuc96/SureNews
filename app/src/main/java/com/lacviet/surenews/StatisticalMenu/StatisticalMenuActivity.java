package com.lacviet.surenews.StatisticalMenu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lacviet.surenews.R;

public class StatisticalMenuActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    TextView tvTitleToolbar;
    ViewPager pager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistical);
        addControl();
        actionBar();
        showTabLayout();
    }
    private void showTabLayout() {
        // Set up the ViewPager with the sections adapter.
        FragmentManager manager = getSupportFragmentManager();
        StatisticalPagerAdapter adapter = new StatisticalPagerAdapter(manager,this);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
        pager.setOffscreenPageLimit(3);//no reload when change tab
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        pager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabLayoutStatistical);
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