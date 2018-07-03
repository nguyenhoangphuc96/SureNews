package com.lacviet.surenews.StatisticalMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lacviet.surenews.R;

public class TabStatisticalOperationFragment extends Fragment {


    public TabStatisticalOperationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_statistical_operation, container, false);


        return view;
    }
}