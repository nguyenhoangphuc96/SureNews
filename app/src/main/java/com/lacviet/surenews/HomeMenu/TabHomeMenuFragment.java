package com.lacviet.surenews.HomeMenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lacviet.surenews.Adapter.HomeTabRCVAdapterTemp;
import com.lacviet.surenews.Adapter.VideoJiaoZiTabRCVAdapter;
import com.lacviet.surenews.DetailScreen.DetailActivityNew;
import com.lacviet.surenews.GovementMenu.DetailGovernmentActivity;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.Model.VideoModel;
import com.lacviet.surenews.R;
import com.lacviet.surenews.Tags.TagsRCVAdapter;
import com.lacviet.surenews.WebAPI.ModelAPI.AllNewsJsonResponse;
import com.lacviet.surenews.WebAPI.ModelAPI.NewsModel;
import com.lacviet.surenews.WebAPI.Remote.ApiService;
import com.lacviet.surenews.WebAPI.Remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TabHomeMenuFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeTabRCVAdapterTemp mAdapter;
    private List<NewsModel> listNews = new ArrayList<>();
    ProgressBar pbTabhome;
    //api
    ApiService mService;
    String categoryId;
    //video
    LinearLayout loBody;
    View layoutVideo;
    VideoJiaoZiTabRCVAdapter videoJiaoZiTabRCVAdapter;
    RecyclerView rcvVideo;
    ProgressBar pbVideo;

    public TabHomeMenuFragment(){

    }
    @SuppressLint("ValidFragment")
    public TabHomeMenuFragment(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_home_menu, container, false);
        addControl(view);
        showDataToRecyclerView();
        loadData();
        return view;
    }
    private void loadData() {
        mService.getAllNewsByPage(categoryId,1,10).enqueue(new Callback<AllNewsJsonResponse>() {
            @Override
            public void onResponse(Call<AllNewsJsonResponse> call, Response<AllNewsJsonResponse> response) {

                if (response.isSuccessful()) {

                    listNews = response.body().getNewsModels();
                    mAdapter.updateAnswers(listNews);
                    pbTabhome.setVisibility(View.GONE);
                    Log.d("AnswersPresenter", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Toast.makeText(getActivity(), "Error" + statusCode + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllNewsJsonResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Vui lòng kiểm tra kết nối!", Toast.LENGTH_SHORT).show();
                Log.d("AnswersPresenter", "error loading from API");

            }
        });
    }


    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabHotHome);
        pbTabhome =view.findViewById(R.id.pbTabHotHome);
        //
        mService = ApiUtils.getSOService();
        //
        loBody = view.findViewById(R.id.loBody);
    }

    private void showDataToRecyclerView() {
        mAdapter = new HomeTabRCVAdapterTemp(getContext(), new ArrayList<NewsModel>(0), new HomeTabRCVAdapterTemp.PostItemListener() {


            @Override
            public void onPostClick(String id, String title, String time, String subTitle, String categoryId) {
                startDetailActivity(id);
            }

        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    private void startDetailActivity(String id) {
        Intent intent = new Intent(getContext(), DetailActivityNew.class);
        KeyString key = new KeyString();
        intent.putExtra(key.ID, id);
        startActivity(intent);
    }
}