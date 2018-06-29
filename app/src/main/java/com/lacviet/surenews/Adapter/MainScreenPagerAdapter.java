package com.lacviet.surenews.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lacviet.surenews.MainScreenTab.TabCountrySideFragmentTemp;
import com.lacviet.surenews.MainScreenTab.TabCountrysideFragment;
import com.lacviet.surenews.MainScreenTab.TabHomeFragment;
import com.lacviet.surenews.MainScreenTab.TabHomeFragmentTemp;
import com.lacviet.surenews.MainScreenTab.TabNewsFragment;
import com.lacviet.surenews.MainScreenTab.TabRelicsFragment;
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
                frag = new TabHomeFragmentTemp();
                break;
            case 1:
                frag = new TabVideoFragment();
                break;
            case 2:
                frag = new TabCountrySideFragmentTemp();
                break;
            case 3:
                frag = new TabNewsFragment();
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
                title = "Trang chủ";
                break;
            case 1:
                title = "Video";
                break;
            case 2:
                title = "Xây dựng nông thôn mới";
                break;
            case 3:
                title = "Tin tức - sự kiện";
                break;
        }
        return title;
    }


}