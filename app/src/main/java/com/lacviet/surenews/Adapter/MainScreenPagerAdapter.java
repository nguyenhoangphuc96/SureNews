package com.lacviet.surenews.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lacviet.surenews.MainScreenTab.TabHomeFragment;
import com.lacviet.surenews.MainScreenTab.TabNewsFragment;
import com.lacviet.surenews.MainScreenTab.TabVideoFragment;

public class MainScreenPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;

    public MainScreenPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new TabHomeFragment();
                break;
            case 1:
                frag = new TabVideoFragment();
                break;
            case 2:
                frag = new TabNewsFragment();
                break;
            case 3:
                frag = new TabHomeFragment();
                break;
            case 4:
                frag = new TabHomeFragment();
                break;
            case 5:
                frag = new TabHomeFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 6;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Trang chủ";
                break;
            case 1:
                title = "Video";
                break;
            case 2:
                title = "Thời sự";
                break;
            case 3:
                title = "Thể thao";
                break;
            case 4:
                title = "Giải trí";
                break;
            case 5:
                title = "Thời trang";
                break;
        }
        return title;
    }


}