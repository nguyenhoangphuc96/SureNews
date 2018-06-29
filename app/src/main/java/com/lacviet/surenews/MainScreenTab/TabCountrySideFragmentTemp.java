package com.lacviet.surenews.MainScreenTab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.lacviet.surenews.Adapter.HomeTabRCVAdapterTemp;
import com.lacviet.surenews.DetailScreen.DetailCountryActivityTemp;
import com.lacviet.surenews.DetailScreen.DetailHomeActivityTemp;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.Model.NewsModel;
import com.lacviet.surenews.R;

import java.util.ArrayList;

public class TabCountrySideFragmentTemp extends Fragment {
    private RecyclerView recyclerView;
    private HomeTabRCVAdapterTemp mAdapter;
    private ArrayList<NewsModel> listNews = new ArrayList<>();
    ProgressBar pb;
    String baseSrcUrl = "http://baclieu.gov.vn";

    public TabCountrySideFragmentTemp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_countryside, container, false);
        addControl(view);
        showDataToRecyclerView();
        addData();
        return view;
    }

    private void addData() {
        listNews.add(new NewsModel(1,
                "Xã Hưng Hội: Tích cực xây dựng nông thôn mới",
                "Thứ Ba, 12/06/2018, 14:40",
                "Để hoàn thành mục tiêu về đích nông thôn mới vào cuối năm 2018, xã Hưng Hội (huyện Vĩnh Lợi) đang thực hiện nhiều công trình, phần việc. Trong đó, nổi bật là phong trào vận động người dân hiến đất, đóng góp ngày công lao động để xây dựng các công trình công cộng, giao thông nông thôn, trồng hàng rào cây xanh…",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/xa%20hung%20hoi%2011262018_144430.jpg"));
        listNews.add(new NewsModel(2,
                "Huyện Đông Hải: Tổ chức lễ công nhận xã Định thành đạt chuẩn Nông thôn mới",
                "Thứ Hai, 26/03/2018, 09:15",
                "(BL-CL) Chiều 23/3, UBND huyện Đông Hải long trọng tổ chức lễ công bố Quyết định của Chủ tịch UBND tỉnh Bạc Liêu về việc công nhận xã Định Thành đạt chuẩn nông thôn mới (NTM) năm 2017. Đến dự lễ có các đồng chí: Dương Thành Trung - Chủ tịch UBND tỉnh; Lê Minh Chiến - Phó Chủ tịch Thường trực UBND tỉnh; Vương Phương Nam - Phó Chủ tịch UBND tỉnh; Quảng Trọng Ninh - Trưởng Ban Dân vận Tỉnh ủy, Chủ tịch Ủy ban MTTQ Việt Nam tỉnh; Nguyễn Bình Tân - Trưởng Ban Tuyên giáo Tỉnh ủy; đại diện lãnh đạo các huyện, thị xã, thành phố và đông đảo người dân xã Định Thành.",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/chu%20tich2632018_92056.jpg"));
        listNews.add(new NewsModel(3,
                "Tuổi trẻ Bạc Liêu chung tay xây dựng nông thôn mới và văn minh đô thị",
                "Thứ Năm, 20/04/2017, 08:05",
                "Với chủ đề hoạt động của Tháng Thanh niên là:“Tuổi trẻ Bạc Liêu chung tay xây dựng nông thôn mới và văn minh đô thị”, tuổi trẻ Bạc Liêu đã ra sức thực hiện nhiều công trình, phần việc thiết thực, có ý nghĩa xã hội sâu sắc, để lại nhiều hiệu ứng tốt đẹp trong lòng người dân.",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/20-4-2017Untitled-12042017_92227.jpg"));
        listNews.add(new NewsModel(4,
                "Huyện Hòa Bình: Đẩy mạnh xây dựng nông thôn mới, đô thị văn minh",
                "Thứ Năm, 20/04/2017, 07:40",
                "Nâng cao chất lượng khu dân cư tiên tiến, khu dân cư văn hóa gắn với cuộc vận động xây dựng nông thôn mới (XDNTM), đô thị văn minh là việc làm được Ủy ban MTTQ Việt Nam huyện Hòa Bình tập trung đẩy mạnh, và ngày càng phát huy hiệu quả thiết thực...",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/NTM2042017_7429.jpg"));
        listNews.add(new NewsModel(5,
                "Họp Ban Chỉ đạo Chương trình xây dựng nông thôn mới giai đoạn 2016 – 2020",
                "Thứ Năm, 09/06/2016, 16:05",
                "Sáng 9/6, đồng chí Lê Minh Khái, Bí thư Tỉnh ủy đã chủ trì cuộc họp công bố Quyết định về việc thành lập Ban Chỉ đạo thực hiện Chương trình mục tiêu Quốc gia xây dựng nông thôn mới trên địa bàn tỉnh Bạc Liêu giai đoạn 2016 – 2020; đánh giá kết quả thực hiện Chương trình giai đoạn 2011 – 2015 và triển khai kế hoạch giai đoạn 2016 – 2020.",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2016-6/QC962016_16125.jpg"));

        mAdapter.updateAnswers(listNews);
        pb.setVisibility(View.GONE);


    }


    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabCountryside);
        pb = view.findViewById(R.id.pbTabCountryside);
    }

    private void showDataToRecyclerView() {
        mAdapter = new HomeTabRCVAdapterTemp(getContext(), new ArrayList<NewsModel>(0), new HomeTabRCVAdapterTemp.PostItemListener() {

            @Override
            public void onPostClick(int id, String title, String time, String subTitle) {
                startDetailActivity(id, title, time, subTitle);
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

    private void startDetailActivity(int id, String title, String time, String subTitle) {
        Intent intent = new Intent(getContext(), DetailCountryActivityTemp.class);
        KeyString key = new KeyString();
        intent.putExtra(key.ID, id);
        intent.putExtra(key.TITLE, title);
        intent.putExtra(key.SUB_TITLE, subTitle);
        intent.putExtra(key.TIME, time);
        startActivity(intent);
    }
}