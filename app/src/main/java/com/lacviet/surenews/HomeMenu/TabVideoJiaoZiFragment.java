package com.lacviet.surenews.HomeMenu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lacviet.surenews.Adapter.VideoJiaoZiTabRCVAdapter;
import com.lacviet.surenews.Adapter.VideoPlayerTabRCVAdapter;
import com.lacviet.surenews.Model.VideoModel;
import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.AllNewsJsonResponse;
import com.lacviet.surenews.WebAPI.ModelAPI.NewsModel;
import com.lacviet.surenews.WebAPI.Remote.ApiService;
import com.lacviet.surenews.WebAPI.Remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZMediaManager;
import cn.jzvd.JZMediaSystem;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabVideoJiaoZiFragment extends Fragment  {
    private RecyclerView recyclerView;
    private VideoJiaoZiTabRCVAdapter mAdapter;
    private List<NewsModel> listNewsModel;
    private List<VideoModel> listVideo;
    ProgressBar pbVideo;
    //api
    ApiService mService;
    String categoryId;

    public TabVideoJiaoZiFragment() {
        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public TabVideoJiaoZiFragment(String categoryId) {
        this.categoryId = categoryId;
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_tab_video,container,false);
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
                    listNewsModel = new ArrayList<>();
                    listVideo = new ArrayList<>();

                    listNewsModel = response.body().getNewsModels();
                    //
                    for (NewsModel newsModel: listNewsModel) {
                        listVideo.add(new VideoModel(newsModel.getId(),newsModel.getTitle(),
                                newsModel.getDescription(),newsModel.getBody().replaceAll(" ","%20"),newsModel.getPublishedDate(),newsModel.getItemImg().replaceAll(" ","%20")));

                    }

                    mAdapter.updateAnswers(listVideo);

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



    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabVideo);
        pbVideo = view.findViewById(R.id.pbTabVideo);
        //
        mService = ApiUtils.getSOService();
    }
    private void showDataToRecyclerView() {
        mAdapter = new VideoJiaoZiTabRCVAdapter(getContext(), new ArrayList<VideoModel>(0), new VideoJiaoZiTabRCVAdapter.PostItemListener() {


            @Override
            public void onPostClick(long id) {

            }
        });
        //final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                recyclerView.setLayoutManager(layoutManager);
            }

        });


    }


    // Tìm ID ứng với tên của file nguồn (Trong thư mục raw).
    public int getRawResIdByName(String resName) {
        String pkgName = getContext().getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayer.goOnPlayOnPause();
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.isVisible())
        {
            if (!isVisibleToUser)   // If we are becoming invisible, then...
            {
                //pause or stop video
                //JZVideoPlayer.releaseAllVideos();
                JZVideoPlayer.goOnPlayOnPause();

            }

            if (isVisibleToUser) // If we are becoming visible, then...
            {
                //play your video
                JZVideoPlayer.goOnPlayOnResume();

            }
        }
    }
}