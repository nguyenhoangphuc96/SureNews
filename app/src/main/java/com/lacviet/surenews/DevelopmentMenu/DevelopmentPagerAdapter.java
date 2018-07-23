package com.lacviet.surenews.DevelopmentMenu;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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

                break;
            case 1:

                break;
            case 2:

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
                title = "Dự án đầu tư";
                break;
            case 1:
                title = "Hợp tác - đầu tư";
                break;
            case 2:
                title = "Chủ trương - chính sách";
                break;


        }
        return title;
    }


}