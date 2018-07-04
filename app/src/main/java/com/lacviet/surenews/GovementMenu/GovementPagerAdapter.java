package com.lacviet.surenews.GovementMenu;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lacviet.surenews.HomeMenu.TabActivitiesLeaderFragment;
import com.lacviet.surenews.HomeMenu.TabAdministrativeReformFragment;
import com.lacviet.surenews.HomeMenu.TabEconomyFragment;
import com.lacviet.surenews.HomeMenu.TabHotHomeFragment;
import com.lacviet.surenews.HomeMenu.TabLawFragment;
import com.lacviet.surenews.HomeMenu.TabPoliticalNewsFragment;
import com.lacviet.surenews.HomeMenu.TabSocioculturalFragment;
import com.lacviet.surenews.HomeMenu.TabTrafficSafetyFragment;
import com.lacviet.surenews.HomeMenu.TabVideoFragment;

public class GovementPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;

    public GovementPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new TabZoningFragment();
                break;
            case 1:
                frag = new TabActivitiesLeaderFragment();
                break;
            case 2:
                frag = new TabDepartmentNewsFragment();
                break;
            case 3:
                frag = new TabCityNewsFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Quy hoạch phát triển";
                break;
            case 1:
                title = "Hoạt động lãnh đạo";
                break;
            case 2:
                title = "Tin hoạt động sở ngành";
                break;
            case 3:
                title = "Tin thành phố";
                break;

        }
        return title;
    }


}