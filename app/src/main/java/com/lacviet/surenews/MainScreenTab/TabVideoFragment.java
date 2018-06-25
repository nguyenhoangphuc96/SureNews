package com.lacviet.surenews.MainScreenTab;

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
        listVideo.add(new VideoModel(1,"Cuộc phân định ngôi đầu bảng của Nga và Uruguay",
                "",
                "https://v.vnecdn.net/vnexpress/video/web/mp4/2018/06/25/gau-nga-khang-dinh-suc-manh-tuyet-doi-o-bang-a-1529895740.mp4",
                "2h trước"));
        listVideo.add(new VideoModel(2,"Cầu thủ Senegal mong HLV giữ 'đầu tỉnh táo' trước đội Nhật Bản",
                "",
                "https://v.vnecdn.net/vnexpress/video/web/mp4/2018/06/24/tuyen-nhat-ban-se-cham-soc-ky-luong-sadio-mane-1529820041.mp4",
                "2h trước"));
        listVideo.add(new VideoModel(3,"Nguyên phó thống đốc ngân hàng nhà nước ra tòa",
                "",
                "https://v.vnecdn.net/vnexpress/video/web/mp4/2018/06/25/nguyen-pho-thong-doc-ngan-hang-nha-nuoc-dang-thanh-binh-hau--1529905342.mp4",
                "2h trước"));
        listVideo.add(new VideoModel(4,"Hà Giang huy động xe chuyên dụng đưa hàng nghìn sĩ tử đi thi",
                "",
                "https://v.vnecdn.net/vnexpress/video/web/mp4/2018/06/25/ha-giang-huy-dong-xe-chuyen-dung-dua-thi-sinh-di-thi-1529915206.mp4",
                "2h trước"));
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