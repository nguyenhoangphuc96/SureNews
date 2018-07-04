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
    String baseUrlVideo = "http://video.baobaclieu.vn";
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
        listVideo.add(new VideoModel(1,"BẠC LIÊU ĐẤT & NGƯỜI\n" +
                "Bạc Liêu hôm nay",
                "",
                baseUrlVideo+"/uploads/video/2017/08/01/bac lieu hom nay (moi).mp4",
                "2h trước"));
        listVideo.add(new VideoModel(2,"BẠC LIÊU ĐẤT & NGƯỜI\n" +
                "Bạc Liêu quê hương tôi",
                "",
                baseUrlVideo+"/uploads/video/2017/05/11/bac-lieu-que-toi.mp4",
                "3h trước"));
        listVideo.add(new VideoModel(3,"Nông dân Bạc Liêu trúng mùa giữa cơn đại hạn",
                "",
                baseUrlVideo+"/uploads/video/2017/05/11/Nông dân Bạc Liêu trúng mùa giữa cơn đại hạn - VTC.mp4",
                "2 ngày trước"));
        listVideo.add(new VideoModel(4,"BẠC LIÊU ĐẤT & NGƯỜI\n" +
                "Tấm gương vượt khó",
                "",
                baseUrlVideo+"/uploads/video/2017/05/11/ncna260317.mp4",
                "2 ngày trước"));
        listVideo.add(new VideoModel(5,"Nuôi tôm siêu thâm canh công nghệ cao trong nhà kín",
                "",
                baseUrlVideo+"/uploads/video/2017/05/18/nuoi tom trong nha kinh.mp4",
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