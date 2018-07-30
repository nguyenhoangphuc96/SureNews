package com.lacviet.surenews.TravelMenu;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lacviet.surenews.GovementMenu.TabGovermentMenuFragment;
import com.lacviet.surenews.WebAPI.ModelAPI.CategoryModel;

import java.util.List;

public class TravelPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private List<CategoryModel> CategoryList;

    public TravelPagerAdapter(FragmentManager fragmentManager, Context context, List<CategoryModel> categoryList) {
        super(fragmentManager);
        this.context = context;
        CategoryList = categoryList;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        fragment = new TabTravelMenuFragment(CategoryList.get(position).getId());
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