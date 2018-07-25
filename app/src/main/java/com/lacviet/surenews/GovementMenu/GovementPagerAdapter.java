package com.lacviet.surenews.GovementMenu;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lacviet.surenews.HomeMenu.TabHomeMenuFragment;
import com.lacviet.surenews.HomeMenu.TabVideoFragment;
import com.lacviet.surenews.WebAPI.ModelAPI.CategoryModel;

import java.util.List;

public class GovementPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private List<CategoryModel> CategoryList;

    public GovementPagerAdapter(FragmentManager fragmentManager, Context context, List<CategoryModel> categoryList) {
        super(fragmentManager);
        this.context = context;
        CategoryList = categoryList;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        fragment = new TabGovermentMenuFragment(CategoryList.get(position).getId());
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