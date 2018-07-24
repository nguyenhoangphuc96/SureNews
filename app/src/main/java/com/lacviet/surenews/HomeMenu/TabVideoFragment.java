package com.lacviet.surenews.HomeMenu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lacviet.surenews.Adapter.HomeTabRCVAdapterTemp;
import com.lacviet.surenews.Adapter.VideoPlayerTabRCVAdapter;
import com.lacviet.surenews.Adapter.VideoPlayerTabRCVAdapter;
import com.lacviet.surenews.Model.HomeNewsModel;
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
import tcking.github.com.giraffeplayer2.VideoView;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;

public class TabVideoFragment extends Fragment {
    private RecyclerView recyclerView;
    private VideoPlayerTabRCVAdapter mAdapter;
    private List<NewsModel> listNewsModel;
    private List<VideoModel> listVideo;
    ProgressBar pbVideo;
    //api
    ApiService mService;
    String categoryId;

    public TabVideoFragment() {
        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public TabVideoFragment(String categoryId) {
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
                                newsModel.getDescription(),newsModel.getBody(),newsModel.getPublishedDate(),newsModel.getItemImg()));

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
        mAdapter = new VideoPlayerTabRCVAdapter(getContext(), new ArrayList<VideoModel>(0), new VideoPlayerTabRCVAdapter.PostItemListener() {


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
        //auto stop & play after recyclerView scroll
        /*recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == SCROLL_STATE_IDLE) {
                    int playPosition = layoutManager.findFirstVisibleItemPosition();
                    if (playPosition == -1) {//no visible item
                        return;
                    }
                    int firstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                    int lastCompletelyVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();

                    for (int i = firstCompletelyVisibleItemPosition; i <=lastCompletelyVisibleItemPosition; i++) {
                        View viewByPosition = layoutManager.findViewByPosition(i);
                        if (viewByPosition != null) {
                            VideoView videoView = (VideoView) viewByPosition.findViewById(R.id.video_view);
                            if (videoView!=null && videoView.isCurrentActivePlayer()) {
                                return;//current active player is visible,do nothing
                            }
                        }
                    }


                    //try find first visible item (visible part > 50%)
                    if (firstCompletelyVisibleItemPosition >= 0 && playPosition != firstCompletelyVisibleItemPosition) {
                        int[] recyclerView_xy = new int[2];
                        int[] f_xy = new int[2];

                        VideoView videoView = (VideoView) layoutManager.findViewByPosition(playPosition).findViewById(R.id.video_view);
                        videoView.getLocationInWindow(f_xy);
                        recyclerView.getLocationInWindow(recyclerView_xy);
                        int unVisibleY = f_xy[1] - recyclerView_xy[1];

                        if (unVisibleY < 0 && Math.abs(unVisibleY) * 1.0 / videoView.getHeight() > 0.5) {//No visible part > 50%,play next
                            playPosition = firstCompletelyVisibleItemPosition;
                        }
                    }
                    VideoView videoView = (VideoView) layoutManager.findViewByPosition(playPosition).findViewById(R.id.video_view);
                    if (videoView != null) {
                        videoView.getPlayer().start();
                    }

                }

            }

        });*/

    }

    @Override
    public void onPause() {
        super.onPause();
    }


    // Tìm ID ứng với tên của file nguồn (Trong thư mục raw).
    public int getRawResIdByName(String resName) {
        String pkgName = getContext().getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

}