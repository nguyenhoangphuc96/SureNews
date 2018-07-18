package com.lacviet.surenews.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lacviet.surenews.DevelopmentMenu.TabInvestCollabFragment;
import com.lacviet.surenews.DevelopmentMenu.TabInvestProjectFragment;
import com.lacviet.surenews.DevelopmentMenu.TabPolicyFragment;
import com.lacviet.surenews.GovementMenu.TabDepartmentNewsFragment;
import com.lacviet.surenews.HomeMenu.TabActivitiesLeaderFragment;
import com.lacviet.surenews.HomeMenu.TabAdministrativeReformFragment;
import com.lacviet.surenews.HomeMenu.TabEconomyFragment;
import com.lacviet.surenews.HomeMenu.TabHotHomeFragment;
import com.lacviet.surenews.HomeMenu.TabLawFragment;
import com.lacviet.surenews.HomeMenu.TabPoliticalNewsFragment;
import com.lacviet.surenews.HomeMenu.TabSocioculturalFragment;
import com.lacviet.surenews.HomeMenu.TabTrafficSafetyFragment;
import com.lacviet.surenews.MainScreenTab.TabCountrySideFragmentTemp;
import com.lacviet.surenews.MainScreenTab.TabHomeFragmentTemp;
import com.lacviet.surenews.MainScreenTab.TabNewsFragment;
import com.lacviet.surenews.HomeMenu.TabVideoFragment;
import com.lacviet.surenews.StatisticalMenu.TabSocioEconomicFragment;
import com.lacviet.surenews.StatisticalMenu.TabSpecializeNewsFragment;
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
        Fragment frag=null;
        switch (position){

            case 0:
                frag = new TabHotHomeFragment();
                break;
            case 1:
                frag = new TabVideoFragment();
                break;
            case 2:
                frag = new TabActivitiesLeaderFragment();
                break;
            case 3:
                frag = new TabPoliticalNewsFragment();
                break;
            case 4:
                frag = new TabEconomyFragment();
                break;
            case 5:
                frag = new TabInvestCollabFragment();
                break;
            case 6:
                frag = new TabDepartmentNewsFragment();
                break;
            case 7:
                frag = new TabPolicyFragment();
                break;
            case 8:
                frag = new TabInvestProjectFragment();
                break;
            case 9:
                frag = new TabDepartmentNewsFragment();
                break;
            case 10:
                frag = new TabPolicyFragment();
                break;
            case 11:
                frag = new TabInvestProjectFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return CategoryList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        title = CategoryList.get(position).getCategoryName();
       /* switch (position){
            case 0:
                title = "Tin nổi bật";
                break;
            case 1:
                title = "Video";
                break;
            case 2:
                title = CategoryList.get(2).getCategoryName();
                break;
            case 3:
                title = CategoryList.get(3).getCategoryName();
                break;
            case 4:
                title = "Kinh tế";
                break;
            case 5:
                title = "Văn hóa - xã hội";
                break;
            case 6:
                title = "An toàn giao thông";
                break;
            case 7:
                title = "Pháp luật";
                break;
            case 8:
                title = "Cải cách hành chánh";
                break;
        }*/
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