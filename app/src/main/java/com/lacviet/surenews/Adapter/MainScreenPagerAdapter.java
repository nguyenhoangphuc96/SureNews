package com.lacviet.surenews.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;




import com.lacviet.surenews.HomeMenu.TabHomeMenuFragment;


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
        return new TabHomeMenuFragment(CategoryList.get(position).getId());
    }

    @Override
    public int getCount() {
        return CategoryList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        title = CategoryList.get(position).getCategoryName();
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