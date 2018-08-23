package com.lacviet.surenews.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.lacviet.surenews.HomeMenu.TabHomeFragment;
import com.lacviet.surenews.HomeMenu.TabHomeMenuFragment;


import com.lacviet.surenews.HomeMenu.TabVideoFragment;
import com.lacviet.surenews.HomeMenu.TabVideoJiaoZiFragment;
import com.lacviet.surenews.WebAPI.ModelAPI.CategoryModel;
import com.lacviet.surenews.WebAPI.Remote.ApiService;

import java.util.List;

public class MainScreenPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private List<CategoryModel> CategoryList;

    public MainScreenPagerAdapter(FragmentManager fragmentManager, Context context, List<CategoryModel> categoryList) {
        super(fragmentManager);
        this.context = context;
        CategoryList = categoryList;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (CategoryList.get(position).getId().equals("02")) {
            fragment = new TabVideoJiaoZiFragment(CategoryList.get(position).getId());
        } else {
            if (CategoryList.get(position).getId().equals("01"))
                fragment = new TabHomeFragment(CategoryList.get(position).getId());
            else {
                fragment = new TabHomeMenuFragment(CategoryList.get(position).getId());
            }
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return CategoryList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        title = CategoryList.get(position).getCategoryName();
        if(position==0)
        {
            title = "";
        }
        return title;
    }

    public void updateAnswers(List<CategoryModel> items) {
        CategoryList.clear();
        CategoryList.addAll(items);

    }

    public List<CategoryModel> getList() {
        return CategoryList;
    }

}