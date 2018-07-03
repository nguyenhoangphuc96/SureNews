package com.lacviet.surenews.StatisticalMenu;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lacviet.surenews.DevelopmentMenu.TabBusinessOperationFragment;
import com.lacviet.surenews.GovementMenu.TabCityNewsFragment;
import com.lacviet.surenews.GovementMenu.TabCommandOperatingFragment;
import com.lacviet.surenews.GovementMenu.TabDepartmentNewsFragment;
import com.lacviet.surenews.HomeMenu.TabActivitiesLeaderFragment;

public class StatisticalPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;

    public StatisticalPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new TabSpecializeNewsFragment();
                break;
            case 1:
                frag = new TabStatisticalOperationFragment();
                break;
            case 2:
                frag = new TabSocioEconomicFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Tin chuyên nghành";
                break;
            case 1:
                title = "Tin hoạt động";
                break;
            case 2:
                title = "Tình hình kinh tế xã hội";
                break;
        }
        return title;
    }


}