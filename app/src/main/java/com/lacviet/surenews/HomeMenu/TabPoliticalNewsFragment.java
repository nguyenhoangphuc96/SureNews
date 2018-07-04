package com.lacviet.surenews.HomeMenu;

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

public class TabPoliticalNewsFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeTabRCVAdapterTemp mAdapter;
    private ArrayList<NewsModel> listNews = new ArrayList<>();
    ProgressBar pbTabhome;
    String baseSrcUrl = "http://congthongtin.bioportal.vn";


    public TabPoliticalNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_political_news, container, false);
        addControl(view);
        showDataToRecyclerView();
        addData();

        return view;
    }
    private void addData() {
        listNews.add(new NewsModel(1,
                "Kiên quyết cắt giảm đầu tư công",
                "Thứ Năm, 28/06/2018, 08:00",
                "Bộ Kế hoạch và Đầu tư sẽ từng bước điều chỉnh cơ cấu đầu tư theo hướng giảm dần đầu tư công, tăng cường huy động vốn của các thành phần kinh tế trong và ngoài nước để đầu tư vào các dự án kết cấu hạ tầng kinh tế - xã hội có khả năng thu hồi vốn.",
                "http://ubmttq.baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2012-3/BTruongVInh16112011_163752232012_151326.jpg"));
        listNews.add(new NewsModel(2,
                "Kiềm chế lạm phát vẫn là mục tiêu ưu tiên số một",
                "Thứ Hai, 25/06/2018, 09:25",
                "Chính phủ đặt mục tiêu ưu tiên chống lạm phát là số một. Từ nay đến cuối năm phải điều hành chính sách tiền tệ, chính sách tài khóa chặt chẽ.",
                "http://ubmttq.baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2012-3/kiemchelamphat132012_16639.jpg"));
        listNews.add(new NewsModel(3,
                "Thận trọng, linh hoạt trong điều hành chính sách tiền tệ những tháng cuối năm",
                "Thứ Hai, 25/06/2018, 09:25",
                "Trong những tháng cuối năm 2011, Ngân hàng Nhà nước tiếp tục chính sách tiền tệ chặt chẽ, linh hoạt để góp phần kiềm chế lạm phát, ổn định kinh tế vĩ mô, bảo đảm an sinh xã hội theo đúng các mục tiêu Chính phủ đề ra.",
                "http://ubmttq.baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2012-3/tiente_cuoinam132012_154048.jpg"));
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
                "Triển khai kế hoạch sản xuất nông nghiệp 6 tháng cuối năm 2018",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 14/6, Sở Nông nghiệp và Phát triển nông thôn (NN&PTNT) tổ chức Hội nghị sơ kết 6 tháng đầu năm và triển khai kế hoạch, giải pháp thực hiện 6 tháng cuối năm 2018. Ông Lương Ngọc Lân, Giám đốc Sở NN&PTNT dự và chủ trì Hội nghị.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/trien%20khai%20ke%20hoach%20nn%206%20thang%20cuoi%20nam1562018_153449.jpg"));
        listNews.add(new NewsModel(9,
                "Các giải pháp trọng tâm để phát triển ngành tôm bền vững",
                "Thứ Hai, 25/06/2018, 09:25",
                "Ngày 03/6, tại Trung tâm Văn hóa tỉnh Bạc Liêu, Bộ NN&PTNT phối hợp với UBND tỉnh Bạc Liêu tổ chức Hội nghị “Các giải pháp trọng tâm để phát triển ngành tôm bền vững”. Đồng chí Nguyễn Xuân Cường - Ủy viên BCH Trung ương Đảng - Bộ trưởng Bộ NN&PTNT và đồng chí Nguyễn Quang Dương - Ủy viên BCH Trung ương Đảng - Bí thư Tỉnh ủy Bạc Liêu đồng chủ trì Hội nghị.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/cac%20giai%20phap%20trong%20tam562018_85247.jpg"));
        listNews.add(new NewsModel(10,
                "Bạc Liêu: Định hướng thành lập HTX công nghệ cao phát triển tôm",
                "Thứ Hai, 25/06/2018, 09:25",
                "Để chuẩn bị cho việc thành lập Hợp tác xã công nghệ cao phát triển tôm Bạc Liêu, sáng 22/6, Chủ tịch UBND tỉnh Dương Thành Trung đã chủ trì buổi họp mặt với Lãnh đạo các Sở, Ban, Ngành liên quan và các doanh nghiệp, hộ nuôi tôm trên địa bàn tỉnh. Dự buổi Họp mặt có ông Đặng Huy Đông, nguyên Thứ trưởng Bộ Kế hoạch và Đầu tư.",
                baseSrcUrl+"/PublishingImages/dinh%20huong%20thanh%20lap%20htx2562018_104544.jpg"));
        listNews.add(new NewsModel(11,
                "Ủy ban An toàn giao thông Quốc gia làm việc với tỉnh Bạc Liêu",
                "Thứ Hai, 25/06/2018, 09:25",
                "Chiều ngày 20/3, Ủy ban An toàn giao thông (ATGT) Quốc gia do đồng chí Khuất Việt Hùng, Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia làm Trưởng đoàn đã có buổi làm việc với tỉnh Bạc Liêu về việc kiểm tra, đôn đốc công tác bảo đảm trật tự ATGT trên địa bàn tỉnh.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/uy%20ban%20an%20toan%20gt2232018_9574.jpg"));
        listNews.add(new NewsModel(12,
                "Hội nghị chuyên đề về công tác giải quyết khiếu nại, tố cáo",
                "Thứ Bảy, 23/06/2018, 10:30",
                "Chiều ngày 22/5, UBND tỉnh tổ chức Hội nghị chuyên đề về công tác giải quyết khiếu nại, tố cáo. Dự và chủ trì Hội nghị có đồng chí Nguyễn Quang Dương, Ủy viên BCH Trung ương Đảng, Bí thư Tỉnh ủy; đồng chí Dương Thành Trung, Phó Bí thư Tỉnh ủy, Chủ tịch UBND tỉnh.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/hoi%20nghi%20chuyen%20de2452018_83311.jpg"));
        listNews.add(new NewsModel(13,
                "Hội nghị triển khai văn bản pháp luật và hướng dẫn nghiệp vụ cho công chức 2018",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 10/4 tại Hội trường Công an tỉnh, Sở Tư pháp tổ chức Hội nghị triển khai văn bản pháp luật và hướng dẫn nghiệp vụ cho công chức tư pháp năm 2018. Tham dự Hội nghị có đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20nghi%20trien%20khai%20VBPL1342018_84612.jpg"));
        listNews.add(new NewsModel(14,
                "Hội đồng nhân dân tỉnh giám sát việc thực hiện công tác cải hành chính tại huyện Hồng Dân",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 30/3, Đoàn giám sát của HĐND tỉnh do ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh làm trưởng đoàn đã đến tiếp xúc cử tri tại xã Ninh Hòa, huyện Hồng Dân chuyên đề về cải cách hành chính.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20dong%20nhan%20dan242018_103857.jpg"));

        mAdapter.updateAnswers(listNews);
        pbTabhome.setVisibility(View.GONE);


    }


    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabPoliticalNews);
        pbTabhome =view.findViewById(R.id.pbTabPoliticalNews);
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
        Intent intent = new Intent(getContext(), DetailPoliticalNewsActivity.class);
        KeyString key = new KeyString();
        intent.putExtra(key.ID, id);
        intent.putExtra(key.TITLE,title);
        intent.putExtra(key.SUB_TITLE,subTitle);
        intent.putExtra(key.TIME,time);
        startActivity(intent);
    }
}
