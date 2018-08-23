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
    //traffic safety
    View layoutTraffic;
    RecyclerView rcvTraffic;
    ProgressBar pbTraffic;
    List<NewsModel> listTraffic;
    //political
    View layoutPolitical;
    RecyclerView rcvPolitical;
    ProgressBar pbPolitical;
    List<NewsModel> listPolitical;
    //sociocultural
    View layoutSociocultural;
    RecyclerView rcvSociocultural;
    ProgressBar pbSociocultural;
    List<NewsModel> listSociocultural;
    //administrative
    View layoutAdministrative;
    RecyclerView rcvAdministrative;
    ProgressBar pbAdministrative;
    List<NewsModel> listAdministrative;
    //leader
    View layoutLeader;
    RecyclerView rcvLeader;
    ProgressBar pbLeader;
    List<NewsModel> listLeader;

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

        return view;
    }
    //Leader
    private void loadDataLeader() {
        mService.getAllNewsByPage("10",1,4).enqueue(new Callback<AllNewsJsonResponse>() {
            @Override
            public void onResponse(Call<AllNewsJsonResponse> call, Response<AllNewsJsonResponse> response) {

                if (response.isSuccessful()) {

                    listLeader = response.body().getNewsModels();
                    mAdapter.updateAnswers(listLeader);
                    pbLeader.setVisibility(View.GONE);
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
    private void addLeader() {
        layoutLeader = LayoutInflater.from(getActivity()).inflate(R.layout.view_leader, loBody, false);
        rcvLeader = layoutLeader.findViewById(R.id.rcvLeader);
        pbLeader = layoutLeader.findViewById(R.id.pbLeader);
        showDataToRecyclerViewLeader();
        loBody.addView(layoutLeader);
    }

    private void showDataToRecyclerViewLeader() {
        mAdapter = new HomeTabRCVAdapterTemp(getContext(), new ArrayList<NewsModel>(0), new HomeTabRCVAdapterTemp.PostItemListener() {


            @Override
            public void onPostClick(String id, String title, String time, String subTitle, String categoryId) {
                startDetailActivity(id);
            }

        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rcvLeader.setLayoutManager(layoutManager);
        rcvLeader.setAdapter(mAdapter);
        rcvLeader.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcvLeader.getContext(),
                layoutManager.getOrientation());
        rcvLeader.addItemDecoration(dividerItemDecoration);
        rcvLeader.setNestedScrollingEnabled(false);
    }
    //administrative
    private void loadDataAdministrative() {
        mService.getAllNewsByPage("10",1,4).enqueue(new Callback<AllNewsJsonResponse>() {
            @Override
            public void onResponse(Call<AllNewsJsonResponse> call, Response<AllNewsJsonResponse> response) {

                if (response.isSuccessful()) {

                    listAdministrative = response.body().getNewsModels();
                    mAdapter.updateAnswers(listAdministrative);
                    pbAdministrative.setVisibility(View.GONE);
                    //
                    addLeader();
                    loadDataLeader();
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
    private void addAdministrative() {
        layoutAdministrative = LayoutInflater.from(getActivity()).inflate(R.layout.view_administrative, loBody, false);
        rcvAdministrative = layoutAdministrative.findViewById(R.id.rcvAdministrative);
        pbAdministrative = layoutAdministrative.findViewById(R.id.pbAdministrative);
        showDataToRecyclerViewAdministrative();
        loBody.addView(layoutAdministrative);
    }

    private void showDataToRecyclerViewAdministrative() {
        mAdapter = new HomeTabRCVAdapterTemp(getContext(), new ArrayList<NewsModel>(0), new HomeTabRCVAdapterTemp.PostItemListener() {


            @Override
            public void onPostClick(String id, String title, String time, String subTitle, String categoryId) {
                startDetailActivity(id);
            }

        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rcvAdministrative.setLayoutManager(layoutManager);
        rcvAdministrative.setAdapter(mAdapter);
        rcvAdministrative.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcvAdministrative.getContext(),
                layoutManager.getOrientation());
        rcvAdministrative.addItemDecoration(dividerItemDecoration);
        rcvAdministrative.setNestedScrollingEnabled(false);
    }
    //Sociocultural
    private void loadDataSociocultural() {
        mService.getAllNewsByPage("2",1,4).enqueue(new Callback<AllNewsJsonResponse>() {
            @Override
            public void onResponse(Call<AllNewsJsonResponse> call, Response<AllNewsJsonResponse> response) {

                if (response.isSuccessful()) {

                    listSociocultural = response.body().getNewsModels();
                    mAdapter.updateAnswers(listSociocultural);
                    pbSociocultural.setVisibility(View.GONE);
                    //
                    addAdministrative();
                    loadDataAdministrative();
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
    private void addSociocultural() {
        layoutSociocultural = LayoutInflater.from(getActivity()).inflate(R.layout.view_sociocultural, loBody, false);
        rcvSociocultural = layoutSociocultural.findViewById(R.id.rcvSociocultural);
        pbSociocultural = layoutSociocultural.findViewById(R.id.pbSociocultural);
        showDataToRecyclerViewSociocultural();
        loBody.addView(layoutSociocultural);
    }

    private void showDataToRecyclerViewSociocultural() {
        mAdapter = new HomeTabRCVAdapterTemp(getContext(), new ArrayList<NewsModel>(0), new HomeTabRCVAdapterTemp.PostItemListener() {


            @Override
            public void onPostClick(String id, String title, String time, String subTitle, String categoryId) {
                startDetailActivity(id);
            }

        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rcvSociocultural.setLayoutManager(layoutManager);
        rcvSociocultural.setAdapter(mAdapter);
        rcvSociocultural.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcvSociocultural.getContext(),
                layoutManager.getOrientation());
        rcvSociocultural.addItemDecoration(dividerItemDecoration);
        rcvSociocultural.setNestedScrollingEnabled(false);
    }
    //Political
    private void loadDataPolitical() {
        mService.getAllNewsByPage("8",1,4).enqueue(new Callback<AllNewsJsonResponse>() {
            @Override
            public void onResponse(Call<AllNewsJsonResponse> call, Response<AllNewsJsonResponse> response) {

                if (response.isSuccessful()) {

                    listPolitical = response.body().getNewsModels();
                    mAdapter.updateAnswers(listPolitical);
                    pbPolitical.setVisibility(View.GONE);
                    //
                    addSociocultural();
                    loadDataSociocultural();
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
    private void addPolitical() {
        layoutPolitical = LayoutInflater.from(getActivity()).inflate(R.layout.view_political, loBody, false);
        rcvPolitical = layoutPolitical.findViewById(R.id.rcvPolitical);
        pbPolitical = layoutPolitical.findViewById(R.id.pbPolitical);
        showDataToRecyclerViewPolitical();
        loBody.addView(layoutPolitical);
    }

    private void showDataToRecyclerViewPolitical() {
        mAdapter = new HomeTabRCVAdapterTemp(getContext(), new ArrayList<NewsModel>(0), new HomeTabRCVAdapterTemp.PostItemListener() {


            @Override
            public void onPostClick(String id, String title, String time, String subTitle, String categoryId) {
                startDetailActivity(id);
            }

        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rcvPolitical.setLayoutManager(layoutManager);
        rcvPolitical.setAdapter(mAdapter);
        rcvPolitical.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcvPolitical.getContext(),
                layoutManager.getOrientation());
        rcvPolitical.addItemDecoration(dividerItemDecoration);
        rcvPolitical.setNestedScrollingEnabled(false);
    }
    //Traffic
    private void loadDataTraffic() {
        mService.getAllNewsByPage("8",1,4).enqueue(new Callback<AllNewsJsonResponse>() {
            @Override
            public void onResponse(Call<AllNewsJsonResponse> call, Response<AllNewsJsonResponse> response) {

                if (response.isSuccessful()) {

                    listTraffic = response.body().getNewsModels();
                    mAdapter.updateAnswers(listTraffic);
                    pbTraffic.setVisibility(View.GONE);
                    //
                    addPolitical();
                    loadDataPolitical();
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
    private void addTrafficSafety() {
        layoutTraffic = LayoutInflater.from(getActivity()).inflate(R.layout.view_traffic_safety, loBody, false);
        rcvTraffic = layoutTraffic.findViewById(R.id.rcvTraffic);
        pbTraffic = layoutTraffic.findViewById(R.id.pbTraffic);
        showDataToRecyclerViewTraffic();
        loBody.addView(layoutTraffic);
    }

    private void showDataToRecyclerViewTraffic() {
        mAdapter = new HomeTabRCVAdapterTemp(getContext(), new ArrayList<NewsModel>(0), new HomeTabRCVAdapterTemp.PostItemListener() {


            @Override
            public void onPostClick(String id, String title, String time, String subTitle, String categoryId) {
                startDetailActivity(id);
            }

        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rcvTraffic.setLayoutManager(layoutManager);
        rcvTraffic.setAdapter(mAdapter);
        rcvTraffic.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcvTraffic.getContext(),
                layoutManager.getOrientation());
        rcvTraffic.addItemDecoration(dividerItemDecoration);
        rcvTraffic.setNestedScrollingEnabled(false);
    }
    //Hot home
    private void addHotHome() {
        layoutHotHome = LayoutInflater.from(getActivity()).inflate(R.layout.view_hot_home, loBody, false);
        recyclerView = layoutHotHome.findViewById(R.id.rcvTabHotHome);
        pbTabhome = layoutHotHome.findViewById(R.id.pbTabHotHome);
        showDataToRecyclerView();
        loBody.addView(layoutHotHome);
    }
    //Video
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
                    //
                    addTrafficSafety();
                    loadDataTraffic();
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
                    //
                    addVideoView();
                    loadDataVideoView();
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