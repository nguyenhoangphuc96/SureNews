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
import com.lacviet.surenews.DetailScreen.DetailHomeActivityTemp;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.Model.NewsModel;
import com.lacviet.surenews.R;

import java.util.ArrayList;

public class TabHotHomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeTabRCVAdapterTemp mAdapter;
    private ArrayList<NewsModel> listNews = new ArrayList<>();
    ProgressBar pbTabhome;
    String baseSrcUrl = "http://baclieu.gov.vn";
    String baseSrcUrlNew = "http://congthongtin.bioportal.vn";
    public TabHotHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_hot_home, container, false);
        addControl(view);
        showDataToRecyclerView();
        addData();
        return view;
    }

    private void addData() {
        listNews.add(new NewsModel(1,
                "Triển khai nhiệm vụ công tác 6 tháng cuối năm 2018 của ngành Lao động - Thương binh và Xã hội",
                "Thứ Năm, 28/06/2018, 08:00",
                "Chiều 26/6, Giám đốc Sở Lao động - Thương binh và Xã hội (LĐTB&XH) Trần Hồng Chiến đã chủ trì Hội nghị sơ kết 6 tháng đầu năm và triển khai phương hướng nhiệm vụ công tác 6 tháng cuối năm 2018 của Ngành LĐTB&XH.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/28-62862018_8816.jpg"));
        listNews.add(new NewsModel(2,
                "Khởi công Dự án Bệnh viện Đa khoa Bạc Liêu - Sài Gòn",
                "Thứ Hai, 25/06/2018, 09:25",
                "Ngày 24/6, Công ty Cổ phần Bệnh viện Đa khoa Bạc Liêu - Sài Gòn tổ chức lễ khởi công xây dựng dự án Bệnh viện Đa khoa Bạc Liêu - Sài Gòn. Đồng chí Vương Phương Nam, Phó Chủ tịch UBND tỉnh cùng đại diện Lãnh đạo các Sở, Ban, Ngành đã đến dự.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/khoi%20cong%20bv%20da%20khoa2562018_164113.jpg"));
        listNews.add(new NewsModel(3,
                "Bạc Liêu: Định hướng thành lập HTX công nghệ cao phát triển tôm",
                "Thứ Hai, 25/06/2018, 09:25",
                "Để chuẩn bị cho việc thành lập Hợp tác xã công nghệ cao phát triển tôm Bạc Liêu, sáng 22/6, Chủ tịch UBND tỉnh Dương Thành Trung đã chủ trì buổi họp mặt với Lãnh đạo các Sở, Ban, Ngành liên quan và các doanh nghiệp, hộ nuôi tôm trên địa bàn tỉnh. Dự buổi Họp mặt có ông Đặng Huy Đông, nguyên Thứ trưởng Bộ Kế hoạch và Đầu tư.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/dinh%20huong%20thanh%20lap%20htx2562018_104544.jpg"));
        listNews.add(new NewsModel(4,
                "Tập huấn cấp giấy phép lao động qua mạng điện tử cho người lao động nước ngoài",
                "Thứ Hai, 25/06/2018, 09:25",
                "Sáng ngày 21/6, Sở Lao động - Thương binh và Xã hội (LĐTB&XH) tổ chức Hội nghị tập huấn cấp giấy phép lao động cho người lao động nước ngoài làm việc tại Việt Nam trên địa bàn tỉnh Bạc Liêu cho các doanh nghiệp, đơn vị, tổ chức, cá nhân có sử dụng lao động nước ngoài trên địa bàn tỉnh.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/tap%20huan%20cap%20giay%20phep2262018_13461.jpg"));
        listNews.add(new NewsModel(5,
                "Đại hội Công đoàn tỉnh Bạc Liêu lần thứ X, nhiệm kỳ 2018 - 2023 thành công tốt đẹp",
                "Thứ Bảy, 23/06/2018, 10:30",
                "Đại hội Công đoàn tỉnh Bạc Liêu lần thứ X, nhiệm kỳ 2018 - 2023 được diễn ra trong 2 ngày 21 và 22/6/2018. Dự đại hội có ông Trần Thanh Hải, Phó Chủ tịch Thường trực Tổng LĐLĐ Việt Nam; bà Lê Thị Ái Nam, Phó Bí thư Thường trực Tỉnh ủy, Chủ tịch HĐND tỉnh và 246 đại biểu đại diện cho hơn 32.000 công nhân, viên chức, lao động (CNVCLĐ) trong tỉnh.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/dai%20hoi%20cong%20doan2562018_103755.jpg"));
        listNews.add(new NewsModel(6,
                "Phiên họp Ủy ban nhân dân tỉnh tháng 6/2018 - lần 2",
                "Thứ Năm, 28/06/2018, 08:00",
                "Chiều ngày 21/6, Chủ tịch UBND tỉnh Dương Thành Trung chủ trì phiên họp UBND tỉnh tháng 6/2018 - lần 2 để xem xét, cho ý kiến đối với các nội dung thuộc thẩm quyền của HĐND tỉnh.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/phien%20hop%20ubnd%20th6%20l22262018_13386.jpg"));
        listNews.add(new NewsModel(7,
                "Sở Lao động - Thương binh và Xã hội triển khai các quyết định của Chủ tịch UBND tỉnh",
                "Thứ Năm, 28/06/2018, 08:00",
                "Sáng 21/6, Sở Lao động - Thương binh và Xã hội (LĐTB&XH) tổ chức Hội nghị triển khai các quyết định của Chủ tịch UBND tỉnh về Quy chế phối hợp cai nghiện ma túy tại gia đình, cộng đồng; Quy chế phối hợp, hỗ trợ, giúp đỡ người sau cai nghiện ma túy, người mại dâm hoàn lương, người bị mua bán trở về.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/so%20lao%20dong2262018_104830.jpg"));
        listNews.add(new NewsModel(8,
                "Xã Hưng Hội: Tích cực xây dựng nông thôn mới",
                "Thứ Ba, 12/06/2018, 14:40",
                "Để hoàn thành mục tiêu về đích nông thôn mới vào cuối năm 2018, xã Hưng Hội (huyện Vĩnh Lợi) đang thực hiện nhiều công trình, phần việc. Trong đó, nổi bật là phong trào vận động người dân hiến đất, đóng góp ngày công lao động để xây dựng các công trình công cộng, giao thông nông thôn, trồng hàng rào cây xanh…",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/xa%20hung%20hoi%2011262018_144430.jpg"));
        listNews.add(new NewsModel(9,
                "Huyện Đông Hải: Tổ chức lễ công nhận xã Định thành đạt chuẩn Nông thôn mới",
                "Thứ Hai, 26/03/2018, 09:15",
                "(BL-CL) Chiều 23/3, UBND huyện Đông Hải long trọng tổ chức lễ công bố Quyết định của Chủ tịch UBND tỉnh Bạc Liêu về việc công nhận xã Định Thành đạt chuẩn nông thôn mới (NTM) năm 2017. Đến dự lễ có các đồng chí: Dương Thành Trung - Chủ tịch UBND tỉnh; Lê Minh Chiến - Phó Chủ tịch Thường trực UBND tỉnh; Vương Phương Nam - Phó Chủ tịch UBND tỉnh; Quảng Trọng Ninh - Trưởng Ban Dân vận Tỉnh ủy, Chủ tịch Ủy ban MTTQ Việt Nam tỉnh; Nguyễn Bình Tân - Trưởng Ban Tuyên giáo Tỉnh ủy; đại diện lãnh đạo các huyện, thị xã, thành phố và đông đảo người dân xã Định Thành.",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/chu%20tich2632018_92056.jpg"));
        listNews.add(new NewsModel(10,
                "Tuổi trẻ Bạc Liêu chung tay xây dựng nông thôn mới và văn minh đô thị",
                "Thứ Năm, 20/04/2017, 08:05",
                "Với chủ đề hoạt động của Tháng Thanh niên là:“Tuổi trẻ Bạc Liêu chung tay xây dựng nông thôn mới và văn minh đô thị”, tuổi trẻ Bạc Liêu đã ra sức thực hiện nhiều công trình, phần việc thiết thực, có ý nghĩa xã hội sâu sắc, để lại nhiều hiệu ứng tốt đẹp trong lòng người dân.",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/20-4-2017Untitled-12042017_92227.jpg"));
        listNews.add(new NewsModel(11,
                "Huyện Hòa Bình: Đẩy mạnh xây dựng nông thôn mới, đô thị văn minh",
                "Thứ Năm, 20/04/2017, 07:40",
                "Nâng cao chất lượng khu dân cư tiên tiến, khu dân cư văn hóa gắn với cuộc vận động xây dựng nông thôn mới (XDNTM), đô thị văn minh là việc làm được Ủy ban MTTQ Việt Nam huyện Hòa Bình tập trung đẩy mạnh, và ngày càng phát huy hiệu quả thiết thực...",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/NTM2042017_7429.jpg"));
        listNews.add(new NewsModel(12,
                "Họp Ban Chỉ đạo Chương trình xây dựng nông thôn mới giai đoạn 2016 – 2020",
                "Thứ Năm, 09/06/2016, 16:05",
                "Sáng 9/6, đồng chí Lê Minh Khái, Bí thư Tỉnh ủy đã chủ trì cuộc họp công bố Quyết định về việc thành lập Ban Chỉ đạo thực hiện Chương trình mục tiêu Quốc gia xây dựng nông thôn mới trên địa bàn tỉnh Bạc Liêu giai đoạn 2016 – 2020; đánh giá kết quả thực hiện Chương trình giai đoạn 2011 – 2015 và triển khai kế hoạch giai đoạn 2016 – 2020.",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2016-6/QC962016_16125.jpg"));
        listNews.add(new NewsModel(13,
                "Triển khai kế hoạch sản xuất nông nghiệp 6 tháng cuối năm 2018",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 14/6, Sở Nông nghiệp và Phát triển nông thôn (NN&PTNT) tổ chức Hội nghị sơ kết 6 tháng đầu năm và triển khai kế hoạch, giải pháp thực hiện 6 tháng cuối năm 2018. Ông Lương Ngọc Lân, Giám đốc Sở NN&PTNT dự và chủ trì Hội nghị.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/trien%20khai%20ke%20hoach%20nn%206%20thang%20cuoi%20nam1562018_153449.jpg"));
        listNews.add(new NewsModel(14,
                "Các giải pháp trọng tâm để phát triển ngành tôm bền vững",
                "Thứ Hai, 25/06/2018, 09:25",
                "Ngày 03/6, tại Trung tâm Văn hóa tỉnh Bạc Liêu, Bộ NN&PTNT phối hợp với UBND tỉnh Bạc Liêu tổ chức Hội nghị “Các giải pháp trọng tâm để phát triển ngành tôm bền vững”. Đồng chí Nguyễn Xuân Cường - Ủy viên BCH Trung ương Đảng - Bộ trưởng Bộ NN&PTNT và đồng chí Nguyễn Quang Dương - Ủy viên BCH Trung ương Đảng - Bí thư Tỉnh ủy Bạc Liêu đồng chủ trì Hội nghị.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/cac%20giai%20phap%20trong%20tam562018_85247.jpg"));
        listNews.add(new NewsModel(15,
                "Bạc Liêu: Định hướng thành lập HTX công nghệ cao phát triển tôm",
                "Thứ Hai, 25/06/2018, 09:25",
                "Để chuẩn bị cho việc thành lập Hợp tác xã công nghệ cao phát triển tôm Bạc Liêu, sáng 22/6, Chủ tịch UBND tỉnh Dương Thành Trung đã chủ trì buổi họp mặt với Lãnh đạo các Sở, Ban, Ngành liên quan và các doanh nghiệp, hộ nuôi tôm trên địa bàn tỉnh. Dự buổi Họp mặt có ông Đặng Huy Đông, nguyên Thứ trưởng Bộ Kế hoạch và Đầu tư.",
                baseSrcUrlNew+"/PublishingImages/dinh%20huong%20thanh%20lap%20htx2562018_104544.jpg"));

        mAdapter.updateAnswers(listNews);
        pbTabhome.setVisibility(View.GONE);


    }


    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabHotHome);
        pbTabhome =view.findViewById(R.id.pbTabHotHome);
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
        Intent intent = new Intent(getContext(), DetailHomeActivityTemp.class);
        KeyString key = new KeyString();
        intent.putExtra(key.ID, id);
        intent.putExtra(key.TITLE,title);
        intent.putExtra(key.SUB_TITLE,subTitle);
        intent.putExtra(key.TIME,time);
        startActivity(intent);
    }
}