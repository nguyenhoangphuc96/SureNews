package com.lacviet.surenews.DevelopmentMenu;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lacviet.surenews.GovementMenu.TabCityNewsFragment;
import com.lacviet.surenews.GovementMenu.TabCommandOperatingFragment;
import com.lacviet.surenews.GovementMenu.TabDepartmentNewsFragment;
import com.lacviet.surenews.HomeMenu.TabActivitiesLeaderFragment;

public class DevelopmentPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;

    public DevelopmentPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new TabInvestNewsFragment();
                break;
            case 1:
                frag = new TabBusinessOperationFragment();
                break;
            case 2:
                frag = new TabReflectsAnswerFragment();
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
                title = "Tin đầu tư - phát triển";
                break;
            case 1:
                title = "Hoạt động doanh nghiệp";
                break;
            case 2:
                title = "Phản ánh - giải đáp";
                break;


        }
        return title;
    }


}