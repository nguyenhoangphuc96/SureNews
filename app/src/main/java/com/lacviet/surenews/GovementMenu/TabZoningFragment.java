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

public class TabZoningFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeTabRCVAdapterTemp mAdapter;
    private ArrayList<NewsModel> listNews = new ArrayList<>();
    ProgressBar pbTabhome;
    String baseSrcUrl = "http://congthongtin.bioportal.vn";
    String baseSrcUrlOld = "http://baclieu.gov.vn";


    public TabZoningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_zoning, container, false);
        addControl(view);
        showDataToRecyclerView();
        addData();

        return view;
    }
    private void addData() {
        listNews.add(new NewsModel(1,
                "Đến năm 2020 cơ bản hoàn thành hỗ trợ nhà ở cho đối tượng chính sách, người có công",
                "30/06/2018",
                "Ngày 12/11, UBND tỉnh Bạc Liêu ban hành Kế hoạch thực hiện Chương trình của Ban Chấp hành Đảng bộ tỉnh (khóa XIV) về “Một số vấn đề cải cách chính sách tiền lương, bảo hiểm xã hội, trợ cấp ưu đãi người có công và định hướng cải cách đến năm 2020”",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-7/trao-nha2972013_91022.jpg"));
        listNews.add(new NewsModel(2,
                "Bảo đảm cân đối cung cầu, bình ổn thị trường vào dịp Tết Nguyên đán Giáp Ngọ 2014",
                "29/06/2018",
                "Ngày 17/12, UBND tỉnh vừa ký Quyết định số 2685/QĐ-UBND ban hành Kế hoạch thực hiện Chương trình dữ trữ hàng hóa bình ổn giá vào dịp Tết Nguyên đán Giáp Ngọ 2014 trên địa bàn tỉnh Bạc Liêu.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-12/hang_binh_on_120122013_143459.jpg"));
        listNews.add(new NewsModel(3,
                "Quy hoạch Bảo vệ và phát triển rừng tỉnh Bạc Liêu giai đoạn 2014-2020",
                "29/06/2018",
                "UBND tỉnh vừa ban hành Quy hoạch Bảo vệ và phát triển rừng tỉnh Bạc Liêu giai đoạn 2014-2020.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2014-1/trongrung1012014_134836.jpg"));
        listNews.add(new NewsModel(4,
                "Ủy ban An toàn giao thông Quốc gia làm việc với tỉnh Bạc Liêu",
                "Thứ Hai, 25/06/2018, 09:25",
                "Chiều ngày 20/3, Ủy ban An toàn giao thông (ATGT) Quốc gia do đồng chí Khuất Việt Hùng, Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia làm Trưởng đoàn đã có buổi làm việc với tỉnh Bạc Liêu về việc kiểm tra, đôn đốc công tác bảo đảm trật tự ATGT trên địa bàn tỉnh.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/uy%20ban%20an%20toan%20gt2232018_9574.jpg"));
        listNews.add(new NewsModel(5,
                "Hội nghị chuyên đề về công tác giải quyết khiếu nại, tố cáo",
                "Thứ Bảy, 23/06/2018, 10:30",
                "Chiều ngày 22/5, UBND tỉnh tổ chức Hội nghị chuyên đề về công tác giải quyết khiếu nại, tố cáo. Dự và chủ trì Hội nghị có đồng chí Nguyễn Quang Dương, Ủy viên BCH Trung ương Đảng, Bí thư Tỉnh ủy; đồng chí Dương Thành Trung, Phó Bí thư Tỉnh ủy, Chủ tịch UBND tỉnh.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/hoi%20nghi%20chuyen%20de2452018_83311.jpg"));
        listNews.add(new NewsModel(6,
                "Hội nghị triển khai văn bản pháp luật và hướng dẫn nghiệp vụ cho công chức 2018",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 10/4 tại Hội trường Công an tỉnh, Sở Tư pháp tổ chức Hội nghị triển khai văn bản pháp luật và hướng dẫn nghiệp vụ cho công chức tư pháp năm 2018. Tham dự Hội nghị có đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20nghi%20trien%20khai%20VBPL1342018_84612.jpg"));
        listNews.add(new NewsModel(7,
                "Hội đồng nhân dân tỉnh giám sát việc thực hiện công tác cải hành chính tại huyện Hồng Dân",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 30/3, Đoàn giám sát của HĐND tỉnh do ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh làm trưởng đoàn đã đến tiếp xúc cử tri tại xã Ninh Hòa, huyện Hồng Dân chuyên đề về cải cách hành chính.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20dong%20nhan%20dan242018_103857.jpg"));
        listNews.add(new NewsModel(8,
                "Kế hoạch triển khai công tác bảo đảm trật tự an toàn giao thông năm 2015",
                "29/06/2018",
                "Ban An toàn giao thông tỉnh vừa ban hành Kế hoạch triển khai công tác bảo đảm trật tự an toàn giao thông (TTAGT) năm 2015 nhằm phấn đấu giảm cả 3 tiêu chí về số vụ, số người chết và số người bị thương do tai nạn giao thông từ 5 đến 10% so với năm 2014; không để xảy ra ùn tắc giao thông trên địa bàn.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2015-3/NamATGT2632015_16515.jpg"));
        listNews.add(new NewsModel(9,
                "Xã Hưng Hội: Tích cực xây dựng nông thôn mới",
                "Thứ Ba, 12/06/2018, 14:40",
                "Để hoàn thành mục tiêu về đích nông thôn mới vào cuối năm 2018, xã Hưng Hội (huyện Vĩnh Lợi) đang thực hiện nhiều công trình, phần việc. Trong đó, nổi bật là phong trào vận động người dân hiến đất, đóng góp ngày công lao động để xây dựng các công trình công cộng, giao thông nông thôn, trồng hàng rào cây xanh…",
                baseSrcUrlOld + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/xa%20hung%20hoi%2011262018_144430.jpg"));
        listNews.add(new NewsModel(10,
                "Huyện Đông Hải: Tổ chức lễ công nhận xã Định thành đạt chuẩn Nông thôn mới",
                "Thứ Hai, 26/03/2018, 09:15",
                "(BL-CL) Chiều 23/3, UBND huyện Đông Hải long trọng tổ chức lễ công bố Quyết định của Chủ tịch UBND tỉnh Bạc Liêu về việc công nhận xã Định Thành đạt chuẩn nông thôn mới (NTM) năm 2017. Đến dự lễ có các đồng chí: Dương Thành Trung - Chủ tịch UBND tỉnh; Lê Minh Chiến - Phó Chủ tịch Thường trực UBND tỉnh; Vương Phương Nam - Phó Chủ tịch UBND tỉnh; Quảng Trọng Ninh - Trưởng Ban Dân vận Tỉnh ủy, Chủ tịch Ủy ban MTTQ Việt Nam tỉnh; Nguyễn Bình Tân - Trưởng Ban Tuyên giáo Tỉnh ủy; đại diện lãnh đạo các huyện, thị xã, thành phố và đông đảo người dân xã Định Thành.",
                baseSrcUrlOld + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/chu%20tich2632018_92056.jpg"));
        listNews.add(new NewsModel(11,
                "Tuổi trẻ Bạc Liêu chung tay xây dựng nông thôn mới và văn minh đô thị",
                "Thứ Năm, 20/04/2017, 08:05",
                "Với chủ đề hoạt động của Tháng Thanh niên là:“Tuổi trẻ Bạc Liêu chung tay xây dựng nông thôn mới và văn minh đô thị”, tuổi trẻ Bạc Liêu đã ra sức thực hiện nhiều công trình, phần việc thiết thực, có ý nghĩa xã hội sâu sắc, để lại nhiều hiệu ứng tốt đẹp trong lòng người dân.",
                baseSrcUrlOld + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/20-4-2017Untitled-12042017_92227.jpg"));
        listNews.add(new NewsModel(12,
                "Huyện Hòa Bình: Đẩy mạnh xây dựng nông thôn mới, đô thị văn minh",
                "Thứ Năm, 20/04/2017, 07:40",
                "Nâng cao chất lượng khu dân cư tiên tiến, khu dân cư văn hóa gắn với cuộc vận động xây dựng nông thôn mới (XDNTM), đô thị văn minh là việc làm được Ủy ban MTTQ Việt Nam huyện Hòa Bình tập trung đẩy mạnh, và ngày càng phát huy hiệu quả thiết thực...",
                baseSrcUrlOld + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/NTM2042017_7429.jpg"));
        listNews.add(new NewsModel(13,
                "Họp Ban Chỉ đạo Chương trình xây dựng nông thôn mới giai đoạn 2016 – 2020",
                "Thứ Năm, 09/06/2016, 16:05",
                "Sáng 9/6, đồng chí Lê Minh Khái, Bí thư Tỉnh ủy đã chủ trì cuộc họp công bố Quyết định về việc thành lập Ban Chỉ đạo thực hiện Chương trình mục tiêu Quốc gia xây dựng nông thôn mới trên địa bàn tỉnh Bạc Liêu giai đoạn 2016 – 2020; đánh giá kết quả thực hiện Chương trình giai đoạn 2011 – 2015 và triển khai kế hoạch giai đoạn 2016 – 2020.",
                baseSrcUrlOld + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2016-6/QC962016_16125.jpg"));


        mAdapter.updateAnswers(listNews);
        pbTabhome.setVisibility(View.GONE);


    }


    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabZoning);
        pbTabhome =view.findViewById(R.id.pbTabZoning);
    }

    private void showDataToRecyclerView() {
        mAdapter = new HomeTabRCVAdapterTemp(getContext(), new ArrayList<NewsModel>(0), new HomeTabRCVAdapterTemp.PostItemListener() {

            @Override
            public void onPostClick(int id, String title, String time, String subTitle) {
                startDetailActivity(id,title,time,subTitle);
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
        Intent intent = new Intent(getContext(), DetailZoningActivity.class);
        KeyString key = new KeyString();
        intent.putExtra(key.ID, id);
        intent.putExtra(key.TITLE,title);
        intent.putExtra(key.SUB_TITLE,subTitle);
        intent.putExtra(key.TIME,time);
        startActivity(intent);
    }
}