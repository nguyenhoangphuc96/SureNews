package com.lacviet.surenews.HomeMenu;

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

import com.lacviet.surenews.Adapter.VideoPlayerTabRCVAdapter;
import com.lacviet.surenews.Adapter.VideoPlayerTabRCVAdapter;
import com.lacviet.surenews.Model.HomeNewsModel;
import com.lacviet.surenews.Model.VideoModel;
import com.lacviet.surenews.R;

import java.util.ArrayList;
import java.util.List;

import tcking.github.com.giraffeplayer2.VideoView;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;

public class TabVideoFragment extends Fragment {
    private RecyclerView recyclerView;
    private VideoPlayerTabRCVAdapter mAdapter;
    private List<VideoModel> listVideo;
    public TabVideoFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_tab_video,container,false);
        addControl(view);
        showDataToRecyclerView();
        addData();
        return view;
    }

    private void addData() {
        listVideo = new ArrayList<>();
        listVideo.add(new VideoModel(1,"Nông dân Bạc Liêu trúng mùa giữa cơn đại hạn",
                "",
                "http://video.baobaclieu.vn/uploads/video/2017/05/11/N%C3%B4ng%20d%C3%A2n%20B%E1%BA%A1c%20Li%C3%AAu%20tr%C3%BAng%20m%C3%B9a%20gi%E1%BB%AFa%20c%C6%A1n%20%C4%91%E1%BA%A1i%20h%E1%BA%A1n%20-%20VTC.mp4",
                "Thứ Sáu, 29/06/2018, 08:20"));
        listVideo.add(new VideoModel(2,"BẠC LIÊU ĐẤT & NGƯỜI\n" +
                "Bạc Liêu hôm nay",
                "",
                "http://video.baobaclieu.vn/uploads/video/2017/08/01/bac%20lieu%20hom%20nay%20(moi).mp4",
                "Thứ Tư, 27/06/2018, 13:25"));
        listVideo.add(new VideoModel(3,"BẠC LIÊU ĐẤT & NGƯỜI\n" +
                "Bạc Liêu quê hương tôi",
                "",
                "http://video.baobaclieu.vn/uploads/video/2017/05/11/bac-lieu-que-toi.mp4",
                "Thứ Ba, 15/05/2018, 15:50"));
        listVideo.add(new VideoModel(4,"Cá sấu Bạc Liêu rớt giá thê thảm",
                "",
                "http://video.baobaclieu.vn/uploads/video/2017/05/11/ca-sau-bac-lieu.mp4",
                "30/06/2018"));
        listVideo.add(new VideoModel(5,"Nuôi tôm siêu thâm canh công nghệ cao trong nhà kín",
                "",
                "http://video.baobaclieu.vn/uploads/video/2017/05/18/nuoi%20tom%20trong%20nha%20kinh.mp4",
                "5 ngày trước"));
        mAdapter.updateAnswers(listVideo);
    }

    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabVideo);
    }
    private void showDataToRecyclerView() {
        mAdapter = new VideoPlayerTabRCVAdapter(getContext(), new ArrayList<VideoModel>(0), new VideoPlayerTabRCVAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {

            }
        });
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        //auto stop & play after recyclerView scroll
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
}