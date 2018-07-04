package com.lacviet.surenews.GovementMenu;

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
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.Model.NewsModel;
import com.lacviet.surenews.R;

import java.util.ArrayList;

public class TabDepartmentNewsFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeTabRCVAdapterTemp mAdapter;
    private ArrayList<NewsModel> listNews = new ArrayList<>();
    ProgressBar pbTabhome;
    String baseSrcUrl = "http://congthongtin.bioportal.vn";
    String baseUrlSoNgoaiVu = "http://songoaivu.baclieu.gov.vn";

    public TabDepartmentNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_department_news, container, false);
        addControl(view);
        showDataToRecyclerView();
        addData();

        return view;
    }

    private void addData() {
        listNews.add(new NewsModel(1,
                "Hội thi tiếng hát nông dân tỉnh Bạc Liêu năm 2018",
                "Thứ Sáu, 29/06/2018, 08:20",
                "Sáng ngày 26 tháng 6 năm 2018, tại Nhà khách Hùng Vương; Hội Nông dân tỉnh Bạc Liêu tổ chức hội thi Tiếng hát nông dân năm 2018. Hội thi có 22 thí sinh là hội viên Hội Nông dân thuộc 7 huyện, thị xã, thành phố trong tỉnh dự thi.",
                baseUrlSoNgoaiVu + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/302962018_82446.jpg"));
        listNews.add(new NewsModel(2,
                "Lớp bồi dưỡng kiến thức và kỹ năng đối ngoại cho cán bộ, công chức, viên chức làm công tác Hội nhập quốc tế tỉnh Bạc Liêu năm 2018",
                "Thứ Tư, 27/06/2018, 13:25",
                "Thực hiện Quyết định số 2007/QĐ-TTg ngày 16/11/2015 của Thủ tướng Chính phủ về việc phê duyệt “Đề án bồi dưỡng kiến thức và kỹ năng cho công chức, viên chức làm công tác hội nhập quốc tế”, Kế hoạch bồi dưỡng kiến thức và kỹ năng cho cán bộ, công chức, viên chức làm công tác hội nhập quốc tế trên địa bàn tỉnh Bạc Liêu giai đoạn 2016 - 2020 của Ủy ban nhân dân tỉnh Bạc Liêu (tại Quyết định số 1701/QĐ-UBND ngày 07/10/2016), sáng ngày 21/6/2018, Sở Ngoại vụ chủ trì, phối hợp với Cục Ngoại vụ, Bộ Ngoại giao tổ chức Lớp bồi dưỡng kiến thức và kỹ năng đối ngoại cho cán bộ, công chức, viên chức làm công tác Hội nhập quốc tế tỉnh Bạc Liêu năm 2018, với thời gian 02 ngày (ngày 21 và 22/6/2018); đây là lớp bồi dưỡng thứ 2 do Sở Ngoại vụ tổ chức trong năm 2018.",
                baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/1%20NHỎ2762018_132823.jpg"));
        listNews.add(new NewsModel(3,
                "Cụm Thi đua số 5 - Khu vực Tây Nam Bộ tổ chức tọa đàm, trao đổi kinh nghiệm về chuyên môn, nghiệp vụ",
                "Thứ Ba, 15/05/2018, 15:50",
                "Ngày 11 tháng 5 năm 2018, tại thành phố Cần Thơ, Cụm thi đua số 5 đã tổ chức buổi tọa đàm, trao đổi kinh nghiệm nhằm nâng cao trình độ, chuyên môn, nghiệp vụ giữa các cơ quan ngoại vụ các tỉnh khu vực Tây Nam Bộ.",
                baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/11752018_95250.png"));
        listNews.add(new NewsModel(4,
                "Đến năm 2020 cơ bản hoàn thành hỗ trợ nhà ở cho đối tượng chính sách, người có công",
                "30/06/2018",
                "Ngày 12/11, UBND tỉnh Bạc Liêu ban hành Kế hoạch thực hiện Chương trình của Ban Chấp hành Đảng bộ tỉnh (khóa XIV) về “Một số vấn đề cải cách chính sách tiền lương, bảo hiểm xã hội, trợ cấp ưu đãi người có công và định hướng cải cách đến năm 2020”",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-7/trao-nha2972013_91022.jpg"));
        listNews.add(new NewsModel(5,
                "Bảo đảm cân đối cung cầu, bình ổn thị trường vào dịp Tết Nguyên đán Giáp Ngọ 2014",
                "29/06/2018",
                "Ngày 17/12, UBND tỉnh vừa ký Quyết định số 2685/QĐ-UBND ban hành Kế hoạch thực hiện Chương trình dữ trữ hàng hóa bình ổn giá vào dịp Tết Nguyên đán Giáp Ngọ 2014 trên địa bàn tỉnh Bạc Liêu.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-12/hang_binh_on_120122013_143459.jpg"));
        listNews.add(new NewsModel(6,
                "Quy hoạch Bảo vệ và phát triển rừng tỉnh Bạc Liêu giai đoạn 2014-2020",
                "29/06/2018",
                "UBND tỉnh vừa ban hành Quy hoạch Bảo vệ và phát triển rừng tỉnh Bạc Liêu giai đoạn 2014-2020.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2014-1/trongrung1012014_134836.jpg"));
        listNews.add(new NewsModel(7,
                "Ủy ban An toàn giao thông Quốc gia làm việc với tỉnh Bạc Liêu",
                "Thứ Hai, 25/06/2018, 09:25",
                "Chiều ngày 20/3, Ủy ban An toàn giao thông (ATGT) Quốc gia do đồng chí Khuất Việt Hùng, Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia làm Trưởng đoàn đã có buổi làm việc với tỉnh Bạc Liêu về việc kiểm tra, đôn đốc công tác bảo đảm trật tự ATGT trên địa bàn tỉnh.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/uy%20ban%20an%20toan%20gt2232018_9574.jpg"));
        listNews.add(new NewsModel(8,
                "Hội nghị chuyên đề về công tác giải quyết khiếu nại, tố cáo",
                "Thứ Bảy, 23/06/2018, 10:30",
                "Chiều ngày 22/5, UBND tỉnh tổ chức Hội nghị chuyên đề về công tác giải quyết khiếu nại, tố cáo. Dự và chủ trì Hội nghị có đồng chí Nguyễn Quang Dương, Ủy viên BCH Trung ương Đảng, Bí thư Tỉnh ủy; đồng chí Dương Thành Trung, Phó Bí thư Tỉnh ủy, Chủ tịch UBND tỉnh.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/hoi%20nghi%20chuyen%20de2452018_83311.jpg"));
        listNews.add(new NewsModel(9,
                "Hội nghị triển khai văn bản pháp luật và hướng dẫn nghiệp vụ cho công chức 2018",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 10/4 tại Hội trường Công an tỉnh, Sở Tư pháp tổ chức Hội nghị triển khai văn bản pháp luật và hướng dẫn nghiệp vụ cho công chức tư pháp năm 2018. Tham dự Hội nghị có đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20nghi%20trien%20khai%20VBPL1342018_84612.jpg"));
        listNews.add(new NewsModel(10,
                "Hội đồng nhân dân tỉnh giám sát việc thực hiện công tác cải hành chính tại huyện Hồng Dân",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 30/3, Đoàn giám sát của HĐND tỉnh do ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh làm trưởng đoàn đã đến tiếp xúc cử tri tại xã Ninh Hòa, huyện Hồng Dân chuyên đề về cải cách hành chính.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20dong%20nhan%20dan242018_103857.jpg"));
        listNews.add(new NewsModel(11,
                "Kế hoạch triển khai công tác bảo đảm trật tự an toàn giao thông năm 2015",
                "29/06/2018",
                "Ban An toàn giao thông tỉnh vừa ban hành Kế hoạch triển khai công tác bảo đảm trật tự an toàn giao thông (TTAGT) năm 2015 nhằm phấn đấu giảm cả 3 tiêu chí về số vụ, số người chết và số người bị thương do tai nạn giao thông từ 5 đến 10% so với năm 2014; không để xảy ra ùn tắc giao thông trên địa bàn.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2015-3/NamATGT2632015_16515.jpg"));

        mAdapter.updateAnswers(listNews);
        pbTabhome.setVisibility(View.GONE);


    }


    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabDepartmentNews);
        pbTabhome = view.findViewById(R.id.pbTabDepartmentNews);
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
        Intent intent = new Intent(getContext(), DetailDepartmentNewsActivity.class);
        KeyString key = new KeyString();
        intent.putExtra(key.ID, id);
        intent.putExtra(key.TITLE, title);
        intent.putExtra(key.SUB_TITLE, subTitle);
        intent.putExtra(key.TIME, time);
        startActivity(intent);
    }
}