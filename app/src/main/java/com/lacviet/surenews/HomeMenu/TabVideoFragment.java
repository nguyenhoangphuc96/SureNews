package com.lacviet.surenews.HomeMenu;

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
        listVideo.add(new VideoModel(1,"Nông dân Bạc Liêu trúng mùa giữa cơn đại hạn",
                "",
                "android.resource://" + getContext().getPackageName() + "/"+getRawResIdByName("v1"),
                "Thứ Sáu, 29/06/2018, 08:20"));
        listVideo.add(new VideoModel(2,"BẠC LIÊU ĐẤT & NGƯỜI\n" +
                "Bạc Liêu hôm nay",
                "",
                "android.resource://" + getContext().getPackageName() + "/"+getRawResIdByName("v2"),
                "Thứ Tư, 27/06/2018, 13:25"));
        listVideo.add(new VideoModel(3,"BẠC LIÊU ĐẤT & NGƯỜI\n" +
                "Bạc Liêu quê hương tôi",
                "",
                "android.resource://" + getContext().getPackageName() + "/"+getRawResIdByName("v3"),
                "Thứ Ba, 15/05/2018, 15:50"));
        listVideo.add(new VideoModel(4,"BẠC LIÊU ĐẤT & NGƯỜI\n" +
                "Tấm gương vượt khó",
                "",
                "android.resource://" + getContext().getPackageName() + "/"+getRawResIdByName("v4"),
                "30/06/2018"));
        listVideo.add(new VideoModel(5,"Nuôi tôm siêu thâm canh công nghệ cao trong nhà kín",
                "",
                "android.resource://" + getContext().getPackageName() + "/"+getRawResIdByName("v5"),
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
    // Tìm ID ứng với tên của file nguồn (Trong thư mục raw).
    public int getRawResIdByName(String resName) {
        String pkgName = getContext().getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
}