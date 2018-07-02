package com.lacviet.surenews.HomeMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lacviet.surenews.Adapter.VideoTabRCVAdapter;
import com.lacviet.surenews.Adapter.VideoTabRCVAdapter;
import com.lacviet.surenews.Model.HomeNewsModel;
import com.lacviet.surenews.Model.VideoModel;
import com.lacviet.surenews.R;

import java.util.ArrayList;
import java.util.List;

public class TabVideoFragment extends Fragment {
    private RecyclerView recyclerView;
    private VideoTabRCVAdapter mAdapter;
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
        listVideo.add(new VideoModel(1,"Clip: Khách sạn siêu sang Trung Quốc đổ sập chỉ trong 10 giây",
                "",
                "http://streaming1.danviet.vn/upload/2-2018/videoclip/2018-06-28/1530198322-videoplayback--1-.mp4",
                "2h trước"));
        listVideo.add(new VideoModel(2,"Thái Lan: Khoan hang động để tìm kiếm đội bóng mất tích",
                "",
                "http://streaming1.danviet.vn/upload/2-2018/videoclip/2018-06-28/1530147487-rescuers-continue-search-for-thai-soccer-team_x264.mp4",
                "3h trước"));
        listVideo.add(new VideoModel(3,"Xót xa cặp vợ chồng bới rác vớt vát tài sản ở căn nhà bị lũ đánh sập",
                "",
                "http://streaming1.danviet.vn/upload/2-2018/videoclip/2018-06-28/1530182479-x--t-xa-c---p-v----ch---ng-b---i-t--m-k--t-s---t-trong-c--n-nh---b----l-------nh.mp4",
                "2 ngày trước"));
        listVideo.add(new VideoModel(4,"Hà Giang huy động xe chuyên dụng đưa hàng nghìn sĩ tử đi thi",
                "",
                "https://v.vnecdn.net/vnexpress/video/web/mp4/2018/06/25/ha-giang-huy-dong-xe-chuyen-dung-dua-thi-sinh-di-thi-1529915206.mp4",
                "2 ngày trước"));
        listVideo.add(new VideoModel(5,"Tàu vũ trụ Nhật Bản tiếp cận được tiểu hành tinh có dấu hiệu của sự sống",
                "",
                "http://streaming1.danviet.vn/upload/2-2018/videoclip/2018-06-29/1530243373-taus.mp4",
                "5 ngày trước"));
        mAdapter.updateAnswers(listVideo);
    }

    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabVideo);
    }
    private void showDataToRecyclerView() {
        mAdapter = new VideoTabRCVAdapter(getContext(), new ArrayList<VideoModel>(0), new VideoTabRCVAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {

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
}