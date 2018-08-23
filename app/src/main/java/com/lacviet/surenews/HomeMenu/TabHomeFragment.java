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
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.Model.VideoModel;
import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.AllNewsJsonResponse;
import com.lacviet.surenews.WebAPI.ModelAPI.NewsModel;
import com.lacviet.surenews.WebAPI.Remote.ApiService;
import com.lacviet.surenews.WebAPI.Remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabHomeFragment extends Fragment {
    //hot home
    View layoutHotHome;
    RecyclerView recyclerView;
    HomeTabRCVAdapterTemp mAdapter;
    List<NewsModel> listNews = new ArrayList<>();
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
    List<NewsModel> listNewsModel;
    List<VideoModel> listVideo;
    public TabHomeFragment(){

    }
    @SuppressLint("ValidFragment")
    public TabHomeFragment(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_home, container, false);
        addControl(view);
        addHotHome();
        loadDataHot();
        addVideoView();
        loadDataVideoView();
        return view;
    }

    private void addHotHome() {
        layoutHotHome = LayoutInflater.from(getActivity()).inflate(R.layout.view_hot_home, loBody, false);
        recyclerView = layoutHotHome.findViewById(R.id.rcvTabHotHome);
        pbTabhome = layoutHotHome.findViewById(R.id.pbTabHotHome);
        showDataToRecyclerView();
        loBody.addView(layoutHotHome);
    }

    private void loadDataVideoView() {
        mService.getAllNewsByPage("02",1,3).enqueue(new Callback<AllNewsJsonResponse>() {
            @Override
            public void onResponse(Call<AllNewsJsonResponse> call, Response<AllNewsJsonResponse> response) {

                if (response.isSuccessful()) {
                    listNewsModel = new ArrayList<>();
                    listVideo = new ArrayList<>();

                    listNewsModel = response.body().getNewsModels();
                    //
                    for (NewsModel newsModel: listNewsModel) {
                        listVideo.add(new VideoModel(newsModel.getId(),newsModel.getTitle(),
                                newsModel.getDescription(),newsModel.getBody().replaceAll(" ","%20"),newsModel.getPublishedDate(),newsModel.getItemImg().replaceAll(" ","%20")));

                    }

                    videoJiaoZiTabRCVAdapter.updateAnswers(listVideo);

                    pbVideo.setVisibility(View.GONE);
                    Log.d("AnswersPresenter", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Toast.makeText(getActivity(), "Error" + statusCode + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllNewsJsonResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Vui lòng kiểm tra kết nối", Toast.LENGTH_SHORT).show();
                Log.d("AnswersPresenter", "error loading from API");

            }
        });
    }

    private void addVideoView() {
        layoutVideo = LayoutInflater.from(getActivity()).inflate(R.layout.view_video, loBody, false);
        rcvVideo = layoutVideo.findViewById(R.id.rcvTabVideo);
        pbVideo = layoutVideo.findViewById(R.id.pbTabVideo);
        showDataToRecyclerViewVideo();
        loBody.addView(layoutVideo);
    }

    private void showDataToRecyclerViewVideo() {
        videoJiaoZiTabRCVAdapter = new VideoJiaoZiTabRCVAdapter(getContext(), new ArrayList<VideoModel>(0), new VideoJiaoZiTabRCVAdapter.PostItemListener() {


            @Override
            public void onPostClick(long id) {

            }
        });
        //final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rcvVideo.setLayoutManager(layoutManager);
        rcvVideo.setAdapter(videoJiaoZiTabRCVAdapter);
        rcvVideo.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcvVideo.getContext(),
                layoutManager.getOrientation());
        rcvVideo.addItemDecoration(dividerItemDecoration);

        rcvVideo.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                recyclerView.setLayoutManager(layoutManager);
            }

        });
        rcvVideo.setNestedScrollingEnabled(false);
    }

    private void loadDataHot() {
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
        recyclerView.setNestedScrollingEnabled(false);

    }

    private void startDetailActivity(String id) {
        Intent intent = new Intent(getContext(), DetailActivityNew.class);
        KeyString key = new KeyString();
        intent.putExtra(key.ID, id);
        startActivity(intent);
    }
}