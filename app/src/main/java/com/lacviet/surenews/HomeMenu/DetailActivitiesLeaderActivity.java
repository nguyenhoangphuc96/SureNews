package com.lacviet.surenews.HomeMenu;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lacviet.surenews.Adapter.SamenewsRCVAdapter;
import com.lacviet.surenews.DetailScreen.DetailCountryActivityTemp;
import com.lacviet.surenews.DetailScreen.DetailHomeActivityTemp;
import com.lacviet.surenews.DevelopmentMenu.DetailInvestProjectActivity;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.Model.NewsModel;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class DetailActivitiesLeaderActivity extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar pbDetail;
    LinearLayout loBody;
    TextView tvTitle, tvTime, tvSubTitle,textView;
    ArrayList<String> listDetailHome1 = new ArrayList<>();
    ArrayList<String> listDetailHome2 = new ArrayList<>();
    ArrayList<String> listDetailHome3 = new ArrayList<>();
    ArrayList<String> listDetailHome4 = new ArrayList<>();
    ArrayList<String> listDetailHome5 = new ArrayList<>();
    ArrayList<String> listDetailHome6 = new ArrayList<>();
    ArrayList<String> listDetailHome7 = new ArrayList<>();
    ArrayList<String> listDetailHome8 = new ArrayList<>();
    ArrayList<String> listDetailHome9 = new ArrayList<>();
    ArrayList<String> listDetailHome10 = new ArrayList<>();
    ArrayList<String> listDetailHome11 = new ArrayList<>();
    ArrayList<String> listDetailHome12 = new ArrayList<>();
    ArrayList<String> listDetailHome13 = new ArrayList<>();
    ArrayList<String> listDetailHome14 = new ArrayList<>();
    //
    String baseSrcUrl = "http://baclieu.gov.vn";
    String baseUrlSoNgoaiVu = "http://songoaivu.baclieu.gov.vn";
    String baseSrcUrlNew = "http://congthongtin.bioportal.vn";
    //
    int id;
    String title = "";
    String time = "";
    String subtitle = "";
    String image = "";
    String text = "";
    //change size
    float sizeTitleDefault,sizeContentDefault,sizeTimeDefault,sizeTitle,sizeContent,sizeTime,sizecaptionImage;

    //
    View layoutImage,layoutText,layoutAuthor;
    //same news
    View layoutSameNews;
    SamenewsRCVAdapter mAdapter;
    RecyclerView recyclerView;
    ProgressBar pbSameNew;
    ArrayList<NewsModel> listSameNews = new ArrayList<>();
    //
    TextToSpeech textToSpeech;
    Boolean isClickSpeak = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        addControl();
        actionBar();
        textSize();
        getDatafromPreviousActivity();
        initData();
        loadData();
        addSamenews();


    }
    private void addSamenews() {
        layoutSameNews = LayoutInflater.from(DetailActivitiesLeaderActivity.this).inflate(R.layout.view_same_news, loBody, false);
        recyclerView = layoutSameNews.findViewById(R.id.rcvSameNews);
        pbSameNew = layoutSameNews.findViewById(R.id.pbSameNews);
        showDataToRecyclerView();
        addData();
        loBody.addView(layoutSameNews);


    }
    private void addData() {
        listSameNews.add(new NewsModel(1,
                "Triển khai nhiệm vụ công tác 6 tháng cuối năm 2018 của ngành Lao động - Thương binh và Xã hội",
                "Thứ Năm, 28/06/2018, 08:00",
                "Chiều 26/6, Giám đốc Sở Lao động - Thương binh và Xã hội (LĐTB&XH) Trần Hồng Chiến đã chủ trì Hội nghị sơ kết 6 tháng đầu năm và triển khai phương hướng nhiệm vụ công tác 6 tháng cuối năm 2018 của Ngành LĐTB&XH.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/28-62862018_8816.jpg"));
        listSameNews.add(new NewsModel(2,
                "Khởi công Dự án Bệnh viện Đa khoa Bạc Liêu - Sài Gòn",
                "Thứ Hai, 25/06/2018, 09:25",
                "Ngày 24/6, Công ty Cổ phần Bệnh viện Đa khoa Bạc Liêu - Sài Gòn tổ chức lễ khởi công xây dựng dự án Bệnh viện Đa khoa Bạc Liêu - Sài Gòn. Đồng chí Vương Phương Nam, Phó Chủ tịch UBND tỉnh cùng đại diện Lãnh đạo các Sở, Ban, Ngành đã đến dự.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/khoi%20cong%20bv%20da%20khoa2562018_164113.jpg"));
        listSameNews.add(new NewsModel(3,
                "Bạc Liêu: Định hướng thành lập HTX công nghệ cao phát triển tôm",
                "Thứ Hai, 25/06/2018, 09:25",
                "Để chuẩn bị cho việc thành lập Hợp tác xã công nghệ cao phát triển tôm Bạc Liêu, sáng 22/6, Chủ tịch UBND tỉnh Dương Thành Trung đã chủ trì buổi họp mặt với Lãnh đạo các Sở, Ban, Ngành liên quan và các doanh nghiệp, hộ nuôi tôm trên địa bàn tỉnh. Dự buổi Họp mặt có ông Đặng Huy Đông, nguyên Thứ trưởng Bộ Kế hoạch và Đầu tư.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/dinh%20huong%20thanh%20lap%20htx2562018_104544.jpg"));
        listSameNews.add(new NewsModel(4,
                "Tập huấn cấp giấy phép lao động qua mạng điện tử cho người lao động nước ngoài",
                "Thứ Hai, 25/06/2018, 09:25",
                "Sáng ngày 21/6, Sở Lao động - Thương binh và Xã hội (LĐTB&XH) tổ chức Hội nghị tập huấn cấp giấy phép lao động cho người lao động nước ngoài làm việc tại Việt Nam trên địa bàn tỉnh Bạc Liêu cho các doanh nghiệp, đơn vị, tổ chức, cá nhân có sử dụng lao động nước ngoài trên địa bàn tỉnh.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/tap%20huan%20cap%20giay%20phep2262018_13461.jpg"));
        listSameNews.add(new NewsModel(5,
                "Đại hội Công đoàn tỉnh Bạc Liêu lần thứ X, nhiệm kỳ 2018 - 2023 thành công tốt đẹp",
                "Thứ Bảy, 23/06/2018, 10:30",
                "Đại hội Công đoàn tỉnh Bạc Liêu lần thứ X, nhiệm kỳ 2018 - 2023 được diễn ra trong 2 ngày 21 và 22/6/2018. Dự đại hội có ông Trần Thanh Hải, Phó Chủ tịch Thường trực Tổng LĐLĐ Việt Nam; bà Lê Thị Ái Nam, Phó Bí thư Thường trực Tỉnh ủy, Chủ tịch HĐND tỉnh và 246 đại biểu đại diện cho hơn 32.000 công nhân, viên chức, lao động (CNVCLĐ) trong tỉnh.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/dai%20hoi%20cong%20doan2562018_103755.jpg"));
        listSameNews.add(new NewsModel(6,
                "Phiên họp Ủy ban nhân dân tỉnh tháng 6/2018 - lần 2",
                "Thứ Năm, 28/06/2018, 08:00",
                "Chiều ngày 21/6, Chủ tịch UBND tỉnh Dương Thành Trung chủ trì phiên họp UBND tỉnh tháng 6/2018 - lần 2 để xem xét, cho ý kiến đối với các nội dung thuộc thẩm quyền của HĐND tỉnh.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/phien%20hop%20ubnd%20th6%20l22262018_13386.jpg"));
        listSameNews.add(new NewsModel(7,
                "Sở Lao động - Thương binh và Xã hội triển khai các quyết định của Chủ tịch UBND tỉnh",
                "Thứ Năm, 28/06/2018, 08:00",
                "Sáng 21/6, Sở Lao động - Thương binh và Xã hội (LĐTB&XH) tổ chức Hội nghị triển khai các quyết định của Chủ tịch UBND tỉnh về Quy chế phối hợp cai nghiện ma túy tại gia đình, cộng đồng; Quy chế phối hợp, hỗ trợ, giúp đỡ người sau cai nghiện ma túy, người mại dâm hoàn lương, người bị mua bán trở về.",
                baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/so%20lao%20dong2262018_104830.jpg"));
        listSameNews.add(new NewsModel(8,
                "Xã Hưng Hội: Tích cực xây dựng nông thôn mới",
                "Thứ Ba, 12/06/2018, 14:40",
                "Để hoàn thành mục tiêu về đích nông thôn mới vào cuối năm 2018, xã Hưng Hội (huyện Vĩnh Lợi) đang thực hiện nhiều công trình, phần việc. Trong đó, nổi bật là phong trào vận động người dân hiến đất, đóng góp ngày công lao động để xây dựng các công trình công cộng, giao thông nông thôn, trồng hàng rào cây xanh…",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/xa%20hung%20hoi%2011262018_144430.jpg"));
        listSameNews.add(new NewsModel(9,
                "Huyện Đông Hải: Tổ chức lễ công nhận xã Định thành đạt chuẩn Nông thôn mới",
                "Thứ Hai, 26/03/2018, 09:15",
                "(BL-CL) Chiều 23/3, UBND huyện Đông Hải long trọng tổ chức lễ công bố Quyết định của Chủ tịch UBND tỉnh Bạc Liêu về việc công nhận xã Định Thành đạt chuẩn nông thôn mới (NTM) năm 2017. Đến dự lễ có các đồng chí: Dương Thành Trung - Chủ tịch UBND tỉnh; Lê Minh Chiến - Phó Chủ tịch Thường trực UBND tỉnh; Vương Phương Nam - Phó Chủ tịch UBND tỉnh; Quảng Trọng Ninh - Trưởng Ban Dân vận Tỉnh ủy, Chủ tịch Ủy ban MTTQ Việt Nam tỉnh; Nguyễn Bình Tân - Trưởng Ban Tuyên giáo Tỉnh ủy; đại diện lãnh đạo các huyện, thị xã, thành phố và đông đảo người dân xã Định Thành.",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/chu%20tich2632018_92056.jpg"));
        listSameNews.add(new NewsModel(10,
                "Tuổi trẻ Bạc Liêu chung tay xây dựng nông thôn mới và văn minh đô thị",
                "Thứ Năm, 20/04/2017, 08:05",
                "Với chủ đề hoạt động của Tháng Thanh niên là:“Tuổi trẻ Bạc Liêu chung tay xây dựng nông thôn mới và văn minh đô thị”, tuổi trẻ Bạc Liêu đã ra sức thực hiện nhiều công trình, phần việc thiết thực, có ý nghĩa xã hội sâu sắc, để lại nhiều hiệu ứng tốt đẹp trong lòng người dân.",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/20-4-2017Untitled-12042017_92227.jpg"));
        listSameNews.add(new NewsModel(11,
                "Huyện Hòa Bình: Đẩy mạnh xây dựng nông thôn mới, đô thị văn minh",
                "Thứ Năm, 20/04/2017, 07:40",
                "Nâng cao chất lượng khu dân cư tiên tiến, khu dân cư văn hóa gắn với cuộc vận động xây dựng nông thôn mới (XDNTM), đô thị văn minh là việc làm được Ủy ban MTTQ Việt Nam huyện Hòa Bình tập trung đẩy mạnh, và ngày càng phát huy hiệu quả thiết thực...",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/NTM2042017_7429.jpg"));
        listSameNews.add(new NewsModel(12,
                "Họp Ban Chỉ đạo Chương trình xây dựng nông thôn mới giai đoạn 2016 – 2020",
                "Thứ Năm, 09/06/2016, 16:05",
                "Sáng 9/6, đồng chí Lê Minh Khái, Bí thư Tỉnh ủy đã chủ trì cuộc họp công bố Quyết định về việc thành lập Ban Chỉ đạo thực hiện Chương trình mục tiêu Quốc gia xây dựng nông thôn mới trên địa bàn tỉnh Bạc Liêu giai đoạn 2016 – 2020; đánh giá kết quả thực hiện Chương trình giai đoạn 2011 – 2015 và triển khai kế hoạch giai đoạn 2016 – 2020.",
                baseSrcUrl + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2016-6/QC962016_16125.jpg"));
        listSameNews.add(new NewsModel(13,
                "Triển khai kế hoạch sản xuất nông nghiệp 6 tháng cuối năm 2018",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 14/6, Sở Nông nghiệp và Phát triển nông thôn (NN&PTNT) tổ chức Hội nghị sơ kết 6 tháng đầu năm và triển khai kế hoạch, giải pháp thực hiện 6 tháng cuối năm 2018. Ông Lương Ngọc Lân, Giám đốc Sở NN&PTNT dự và chủ trì Hội nghị.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/trien%20khai%20ke%20hoach%20nn%206%20thang%20cuoi%20nam1562018_153449.jpg"));
        listSameNews.add(new NewsModel(14,
                "Các giải pháp trọng tâm để phát triển ngành tôm bền vững",
                "Thứ Hai, 25/06/2018, 09:25",
                "Ngày 03/6, tại Trung tâm Văn hóa tỉnh Bạc Liêu, Bộ NN&PTNT phối hợp với UBND tỉnh Bạc Liêu tổ chức Hội nghị “Các giải pháp trọng tâm để phát triển ngành tôm bền vững”. Đồng chí Nguyễn Xuân Cường - Ủy viên BCH Trung ương Đảng - Bộ trưởng Bộ NN&PTNT và đồng chí Nguyễn Quang Dương - Ủy viên BCH Trung ương Đảng - Bí thư Tỉnh ủy Bạc Liêu đồng chủ trì Hội nghị.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/cac%20giai%20phap%20trong%20tam562018_85247.jpg"));
        listSameNews.add(new NewsModel(15,
                "Bạc Liêu: Định hướng thành lập HTX công nghệ cao phát triển tôm",
                "Thứ Hai, 25/06/2018, 09:25",
                "Để chuẩn bị cho việc thành lập Hợp tác xã công nghệ cao phát triển tôm Bạc Liêu, sáng 22/6, Chủ tịch UBND tỉnh Dương Thành Trung đã chủ trì buổi họp mặt với Lãnh đạo các Sở, Ban, Ngành liên quan và các doanh nghiệp, hộ nuôi tôm trên địa bàn tỉnh. Dự buổi Họp mặt có ông Đặng Huy Đông, nguyên Thứ trưởng Bộ Kế hoạch và Đầu tư.",
                baseSrcUrlNew+"/PublishingImages/dinh%20huong%20thanh%20lap%20htx2562018_104544.jpg"));
        listSameNews.add(new NewsModel(16,
                "Hội thi tiếng hát nông dân tỉnh Bạc Liêu năm 2018",
                "Thứ Sáu, 29/06/2018, 08:20",
                "Sáng ngày 26 tháng 6 năm 2018, tại Nhà khách Hùng Vương; Hội Nông dân tỉnh Bạc Liêu tổ chức hội thi Tiếng hát nông dân năm 2018. Hội thi có 22 thí sinh là hội viên Hội Nông dân thuộc 7 huyện, thị xã, thành phố trong tỉnh dự thi.",
                baseUrlSoNgoaiVu + "/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/302962018_82446.jpg"));
        listSameNews.add(new NewsModel(17,
                "Lớp bồi dưỡng kiến thức và kỹ năng đối ngoại cho cán bộ, công chức, viên chức làm công tác Hội nhập quốc tế tỉnh Bạc Liêu năm 2018",
                "Thứ Tư, 27/06/2018, 13:25",
                "Thực hiện Quyết định số 2007/QĐ-TTg ngày 16/11/2015 của Thủ tướng Chính phủ về việc phê duyệt “Đề án bồi dưỡng kiến thức và kỹ năng cho công chức, viên chức làm công tác hội nhập quốc tế”, Kế hoạch bồi dưỡng kiến thức và kỹ năng cho cán bộ, công chức, viên chức làm công tác hội nhập quốc tế trên địa bàn tỉnh Bạc Liêu giai đoạn 2016 - 2020 của Ủy ban nhân dân tỉnh Bạc Liêu (tại Quyết định số 1701/QĐ-UBND ngày 07/10/2016), sáng ngày 21/6/2018, Sở Ngoại vụ chủ trì, phối hợp với Cục Ngoại vụ, Bộ Ngoại giao tổ chức Lớp bồi dưỡng kiến thức và kỹ năng đối ngoại cho cán bộ, công chức, viên chức làm công tác Hội nhập quốc tế tỉnh Bạc Liêu năm 2018, với thời gian 02 ngày (ngày 21 và 22/6/2018); đây là lớp bồi dưỡng thứ 2 do Sở Ngoại vụ tổ chức trong năm 2018.",
                baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/1%20NHỎ2762018_132823.jpg"));
        listSameNews.add(new NewsModel(18,
                "Cụm Thi đua số 5 - Khu vực Tây Nam Bộ tổ chức tọa đàm, trao đổi kinh nghiệm về chuyên môn, nghiệp vụ",
                "Thứ Ba, 15/05/2018, 15:50",
                "Ngày 11 tháng 5 năm 2018, tại thành phố Cần Thơ, Cụm thi đua số 5 đã tổ chức buổi tọa đàm, trao đổi kinh nghiệm nhằm nâng cao trình độ, chuyên môn, nghiệp vụ giữa các cơ quan ngoại vụ các tỉnh khu vực Tây Nam Bộ.",
                baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/11752018_95250.png"));
        listSameNews.add(new NewsModel(19,
                "Đến năm 2020 cơ bản hoàn thành hỗ trợ nhà ở cho đối tượng chính sách, người có công",
                "30/06/2018",
                "Ngày 12/11, UBND tỉnh Bạc Liêu ban hành Kế hoạch thực hiện Chương trình của Ban Chấp hành Đảng bộ tỉnh (khóa XIV) về “Một số vấn đề cải cách chính sách tiền lương, bảo hiểm xã hội, trợ cấp ưu đãi người có công và định hướng cải cách đến năm 2020”",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-7/trao-nha2972013_91022.jpg"));
        listSameNews.add(new NewsModel(20,
                "Bảo đảm cân đối cung cầu, bình ổn thị trường vào dịp Tết Nguyên đán Giáp Ngọ 2014",
                "29/06/2018",
                "Ngày 17/12, UBND tỉnh vừa ký Quyết định số 2685/QĐ-UBND ban hành Kế hoạch thực hiện Chương trình dữ trữ hàng hóa bình ổn giá vào dịp Tết Nguyên đán Giáp Ngọ 2014 trên địa bàn tỉnh Bạc Liêu.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-12/hang_binh_on_120122013_143459.jpg"));
        listSameNews.add(new NewsModel(21,
                "Quy hoạch Bảo vệ và phát triển rừng tỉnh Bạc Liêu giai đoạn 2014-2020",
                "29/06/2018",
                "UBND tỉnh vừa ban hành Quy hoạch Bảo vệ và phát triển rừng tỉnh Bạc Liêu giai đoạn 2014-2020.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2014-1/trongrung1012014_134836.jpg"));
        listSameNews.add(new NewsModel(22,
                "Ủy ban An toàn giao thông Quốc gia làm việc với tỉnh Bạc Liêu",
                "Thứ Hai, 25/06/2018, 09:25",
                "Chiều ngày 20/3, Ủy ban An toàn giao thông (ATGT) Quốc gia do đồng chí Khuất Việt Hùng, Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia làm Trưởng đoàn đã có buổi làm việc với tỉnh Bạc Liêu về việc kiểm tra, đôn đốc công tác bảo đảm trật tự ATGT trên địa bàn tỉnh.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/uy%20ban%20an%20toan%20gt2232018_9574.jpg"));
        listSameNews.add(new NewsModel(23,
                "Hội nghị chuyên đề về công tác giải quyết khiếu nại, tố cáo",
                "Thứ Bảy, 23/06/2018, 10:30",
                "Chiều ngày 22/5, UBND tỉnh tổ chức Hội nghị chuyên đề về công tác giải quyết khiếu nại, tố cáo. Dự và chủ trì Hội nghị có đồng chí Nguyễn Quang Dương, Ủy viên BCH Trung ương Đảng, Bí thư Tỉnh ủy; đồng chí Dương Thành Trung, Phó Bí thư Tỉnh ủy, Chủ tịch UBND tỉnh.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/hoi%20nghi%20chuyen%20de2452018_83311.jpg"));
        listSameNews.add(new NewsModel(24,
                "Hội nghị triển khai văn bản pháp luật và hướng dẫn nghiệp vụ cho công chức 2018",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 10/4 tại Hội trường Công an tỉnh, Sở Tư pháp tổ chức Hội nghị triển khai văn bản pháp luật và hướng dẫn nghiệp vụ cho công chức tư pháp năm 2018. Tham dự Hội nghị có đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20nghi%20trien%20khai%20VBPL1342018_84612.jpg"));
        listSameNews.add(new NewsModel(25,
                "Hội đồng nhân dân tỉnh giám sát việc thực hiện công tác cải hành chính tại huyện Hồng Dân",
                "Thứ Năm, 28/06/2018, 08:00",
                "Ngày 30/3, Đoàn giám sát của HĐND tỉnh do ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh làm trưởng đoàn đã đến tiếp xúc cử tri tại xã Ninh Hòa, huyện Hồng Dân chuyên đề về cải cách hành chính.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20dong%20nhan%20dan242018_103857.jpg"));
        listSameNews.add(new NewsModel(11,
                "Kế hoạch triển khai công tác bảo đảm trật tự an toàn giao thông năm 2015",
                "29/06/2018",
                "Ban An toàn giao thông tỉnh vừa ban hành Kế hoạch triển khai công tác bảo đảm trật tự an toàn giao thông (TTAGT) năm 2015 nhằm phấn đấu giảm cả 3 tiêu chí về số vụ, số người chết và số người bị thương do tai nạn giao thông từ 5 đến 10% so với năm 2014; không để xảy ra ùn tắc giao thông trên địa bàn.",
                "http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2015-3/NamATGT2632015_16515.jpg"));
        mAdapter.updateAnswers(listSameNews);
        pbSameNew.setVisibility(View.GONE);


    }
    private void showDataToRecyclerView() {
        mAdapter = new SamenewsRCVAdapter(this, new ArrayList<NewsModel>(0), new SamenewsRCVAdapter.PostItemListener() {

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
        Intent intent = new Intent(this, DetailHomeActivityTemp.class);
        KeyString key = new KeyString();
        intent.putExtra(key.ID, id);
        intent.putExtra(key.TITLE,title);
        intent.putExtra(key.SUB_TITLE,subTitle);
        intent.putExtra(key.TIME,time);
        startActivity(intent);
    }
    private void initData() {
        switch (id) {
            case 1:{
                listDetailHome1.add(baseSrcUrlNew+"/PublishingImages/khoi%20cong%20bv%20da%20khoa2562018_164113.jpg");
                listDetailHome1.add("Đồng chí Vương Phương Nam - Phó Chủ tịch UBND tỉnh (người thứ 3, từ phải qua) thực hiện nghi thức khởi công xây dựng dự án");
                listDetailHome1.add(baseSrcUrlNew+"/PublishingImages/khoi%20cong%20bv%20da%20khoa%2012562018_163640.jpg");
                listDetailHome1.add("Phối cảnh Bệnh viện Đa khoa Bạc Liêu – Sài Gòn");
                listDetailHome1.add("Dự án tọa lạc tại khóm 10, phường 1, thành phố Bạc Liêu với tổng diện tích trên 37.000m2, diện tích xây dựng 8.424 m2, diện tích sàn xây dựng lên đến 55.671 m2. Quy mô xây dựng 10 tầng, công suất 400 giường bệnh ngoại trú/ngày, 436 giường bệnh nội trú, khu khách sạn 21 phòng với 112 giường... Tổng mức đầu tư toàn dự án trên 1.369 tỷ đồng. Dự kiến dự án sẽ hoàn thành đưa vào khai thác vào cuối năm 2020./.");
                listDetailHome1.add("Châu Khánh");
                break;
            }
            case 2:{
                //
                listDetailHome2.add(baseSrcUrlNew+"/PublishingImages/dai%20hoi%20dai%20bieu1162018_933.jpg");
                listDetailHome2.add("Ban chấp hành LHH khóa IV, nhiệm kỳ 2018 - 2023 ra mắt Đại hội");
                listDetailHome2.add("Tham dự Đại hội có đồng chí Phạm Văn Tân, Phó Chủ tịch - Tổng Thư ký LHH Việt nam; đồng chí Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh; Lãnh đạo LHH các tỉnh khu vực đồng bằng sông Cửu Long, cùng 78 đại biểu chính thức đại diện cho hơn 7.000 thành viên của  LHH trong tỉnh.");
                listDetailHome2.add("Trong nhiệm kỳ qua, LHH đã không ngừng đổi mới về nội dung và phương thức hoạt động; ra sức tập hợp, đoàn kết, phát huy tiềm năng, trí tuệ của đội ngũ trí trức khoa học công nghệ tỉnh nhà, phục vụ đắc lực cho sự phát triển kinh tế - xã hội. Đến nay, hệ thống LHH đã phát triển mới 04 Hội thành viên nâng tổng số lên 23 Hội thành viên và Tổ chức liên kết với trên 7.000 hội viên.");
                listDetailHome2.add("Trong nhiệm kỳ 2018 - 2023, LHH đã đề một số mục tiêu quan trọng cần thực hiện như: Phấn đấu đến năm 2023, LHH trở thành tổ chức chính trị - xã hội vững mạnh trong hệ thống tổ chức LHH Việt Nam, giữ vai trò nòng cốt trong tập hợp, đoàn kết, phát huy tiềm năng, trí tuệ, xây dựng đội ngũ trí thức khoa học và công nghệ của tỉnh đáp ứng yêu cầu phát triển kinh tế - xã hội, an ninh - quốc phòng của tỉnh");
                listDetailHome2.add("Phát biểu chỉ đạo tại Đại hội, đồng chí Phạm Văn Tân, Phó Chủ tịch - Tổng Thư ký LHH Việt Nam, đã biểu dương nỗ lực của cán bộ, thành viên LHH tỉnh trong nhiệm kỳ qua, đồng thời đề nghị LHH tỉnh Bạc Liêu trong thời gian tới tiếp tục củng cố, kiện toàn, phát triển tổ chức LHH và các Hội thành viên; tập hợp, đoàn kết, phát huy tiềm năng trí tuệ đội ngũ trí thức, thực hiện tốt chủ trương của Đảng, chính sách pháp luật của Nhà nước; thông tin tuyên truyền, phổ biến kiến thức và chuyển giao khoa học công nghệ vào sản xuất, đời sống; tăng cường công tác tư vấn, phản biện và giám định xã hội; tổ chức tốt các phong trào sáng tạo kỹ thuật.");
                listDetailHome2.add("Đại hội đã bầu ra 39 đồng chí vào Ban Chấp hành, 7 đồng chí vào Ban Thường vụ LHH nhiệm kỳ 2018 - 2023. Ông Lâm Thành Đắc được bầu giữ chức vụ Chủ tịch LHH khoá IV, nhiệm kỳ 2018 - 2023./.");
                listDetailHome2.add("Sự Nghiệp");
                break;
            }
            case 3:{
                //
                listDetailHome3.add(baseSrcUrlNew+"/PublishingImages/dai%20hoi%20cong%20doan2562018_103755.jpg");
                listDetailHome3.add("Lãnh đạo Tổng LĐLĐ Việt Nam và Lãnh đạo Tỉnh ủy tặng hoa chúc mừng Ban Chấp hành Công đoàn tỉnh Bạc Liêu khóa X, nhiệm kỳ 2018 - 2023");
                listDetailHome3.add("Trong nhiệm kỳ qua, dưới sự lãnh đạo, chỉ đạo của Tổng LĐLĐ Việt Nam, Ban Chấp hành Đảng bộ tỉnh, phong trào CNVCLĐ tỉnh nhà có sự phát triển. Nội dung, phương thức hoạt động có nhiều đổi mới, chức năng đại diện bảo vệ quyền lợi hợp pháp, chính đáng và chăm lo lợi ích của đoàn viên, người lao động ngày càng được đẩy mạnh, mang lại lợi ích thiết thực, động viên CNVCLĐ hăng hái thi đua lao động, sản xuất.\n" +
                        "\n" +
                        "Công tác xây dựng tổ chức Công đoàn và phát triển đoàn viên được chú trọng, tỷ lệ công đoàn cơ sở đạt tiêu chuẩn vững mạnh ngày càng tăng. Nhiệm kỳ qua đã thành lập mới 47 công đoàn cơ sở và kết nạp gần 6.700 đoàn viên mới. Công đoàn các cấp đã xây dựng quỹ Mái ấm công đoàn và trợ vốn cho CNVCLĐ nghèo gần 13,4 tỷ đồng. Từ nguồn quỹ này đã xây dựng mới và sửa chữa gần 200 căn Mái ấm công đoàn và hỗ trợ cho trên 7.000 lượt CNVCLĐ nghèo phát triển kinh tế gia đình.\n" +
                        "\n" +
                        "Phát biểu chỉ đạo tại Đại hội, Phó Bí thư Thường trực Tỉnh ủy, Chủ tịch HĐND tỉnh - Lê Thị Ái Nam thay mặt Tỉnh ủy ghi nhận và nhiệt liệt biểu dương những thành tích mà tổ chức Công đoàn và phong trào CNVCLĐ tỉnh nhà đạt được trong nhiệm kỳ qua. Đồng thời chỉ đạo tổ chức Công đoàn tỉnh nhà cần tăng cường hơn nữa công tác tuyên truyền về đường lối, chủ trương của Đảng, chính sách, pháp luật của nhà nước, giáo dục nâng cao bản lĩnh chính trị, giác ngộ giai cấp, ý thức kỷ luật, tác phong công nghiệp, kỹ năng nghề nghiệp cho đoàn viên, CNVCLĐ. Công đoàn các cấp cần phải làm tốt vai trò là người đại diện và bảo vệ quyền lợi hợp pháp, chính đáng của giai cấp công nhân và người lao động. Bên cạnh đó, tiếp tục đẩy mạnh, nâng cao chất lượng các phong trào thi đua yêu nước trong CNVCLĐ gắn với việc thực hiện các chương trình phát triển kinh tế - xã hội của tỉnh.\n" +
                        "\n" +
                        "Đại hội đã bầu ra Ban Chấp hành Công đoàn tỉnh Bạc Liêu khóa X, nhiệm kỳ 2018 - 2023 gồm 34 đồng chí. Ông Nguyễn Văn Khanh được bầu làm Chủ tịch./.\n");
                listDetailHome3.add("HLam");
                break;
            }
            case 4:{
                //
                listDetailHome4.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/uy%20ban%20an%20toan%20gt2232018_9574.jpg");
                listDetailHome4.add("Ông Khuất Việt Hùng, Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia phát biểu tại buổi làm việc");
                listDetailHome4.add("Tiếp và làm việc với Đoàn có đồng chí Phan Như Nguyện, Phó Chủ tịch UBND tỉnh; Ngô Hữu Dũng, Giám đốc Sở Giao thông vận tải, Phó Trưởng Ban  Thường trực Ban ATGT tỉnh và đại diện Lãnh đạo các sở, ngành liên quan.");
                listDetailHome4.add("Theo báo cáo của Ban ATGT tỉnh, trong 02 tháng đầu năm 2018, toàn tỉnh xảy ra 11 vụ tai nạn giao thông (TNGT) làm chết 08 người, bị thương 08 người, tổng thiệt hại tài sản ước tính 36 triệu đồng. Riêng trong 07 ngày nghỉ Tết Nguyên đán Mậu Tuất 2018, toàn tỉnh xảy ra 01 vụ TNGT, làm bị thương 01 người, giảm cả 03 tiêu chí so với 07 ngày nghỉ Tết Nguyên đán Đinh Dậu 2017. Tại các Lễ hội Xuân năm 2018 không xảy ra ùn tắc giao thông và TNGT.");
                listDetailHome4.add("Bên cạnh đó, công tác đảm bảo trật tự ATGT trên địa bàn tỉnh vẫn còn gặp nhiều khó khăn, trở ngại như: Hiệu lực, hiệu quả của công tác tuần tra, kiểm soát, xử lý vi phạm của các lực lượng thực thi công vụ tuy đã được nâng cao nhưng chưa đáp ứng được yêu cầu nhiệm vụ; công tác quản lý phương tiện và người lái phương tiện đường thủy nội địa còn gặp nhiều khó khăn; trên tuyến Quốc lộ 1, tại khu vực Nhà thờ Tắc Sậy, lưu lượng khách đến đây hàng ngày rất đông, thường xảy ra ùn tắc giao thông cục bộ…");
                listDetailHome4.add("Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia - Khuất Việt Hùng đánh giá cao nỗ lực của tỉnh trong việc thực hiện nhiệm vụ đảm bảo trật tự ATGT trong thời gian qua. Tuy nhiên, ông cũng lưu ý để giảm số vụ TNGT và số người chết do TNGT, Bạc Liêu cần rà soát lại những “Điểm đen” thường xảy ra TNGT để có hướng xử lý, khắc phục kịp thời; tăng cường công tác tuyên truyền về Luật Giao thông đường bộ cho mọi tầng lớp nhân dân. Nghiên cứu và có thể cho lắp hệ thống camera trên các trục đường chính để giám sát việc chấp hành Luật Giao thông đường bộ… Ông cũng nhắc nhở trong dịp Lễ hội Nghinh Ông sắp tới tại  huyện Đông Hải, Ban Tổ chức Lễ hội cần có kế hoạch tổ chức thật an toàn để bảo đảm trật tự ATGT./.");
                listDetailHome4.add("Nghiệp - Hình");
                break;
            }
            case 5:{
                //
                listDetailHome5.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/hoi%20nghi%20chuyen%20de2452018_83311.jpg");
                listDetailHome5.add("Bí thư Tỉnh ủy Nguyễn Quang Dương phát biểu chỉ đạo Hội nghị");
                listDetailHome5.add("Phát biểu khai mạc Hội nghị, Chủ tịch UBND tỉnh Dương Thành Trung nhấn mạnh vai trò quan trọng của công tác tiếp công dân, giải quyết khiếu nại, tố cáo nhằm đảm bảo quyền và lợi ích chính đáng của công dân, củng cố niềm tin của nhân dân đối với chính quyền và góp phần nâng cao hiệu lực, hiệu quả quản lý nhà nước.");
                listDetailHome5.add("Trong những năm qua, công tác tiếp dân, giải quyết đơn thư khiếu nại, tố cáo luôn được tỉnh quan tâm, chỉ đạo và đạt được nhiều kết quả quan trọng. Từ năm 2015 đến Quý I năm 2018, các ngành, các cấp đã tích cực tham mưu giải quyết 1.818/1.883 vụ thuộc thẩm quyền, đạt tỷ lệ 96,5%.");
                listDetailHome5.add("Tại Hội nghị, các tham luận tập trung đề cập tới những khó khăn, bất cập cũng như kiến nghị giải quyết liên quan tới thủ tục cấp đổi, cấp lần đầu giấy chứng nhận quyền sử dụng đất, đền bù, giải phóng mặt bằng. Đồng thời, các tham luận cũng đưa ra nhiều giải pháp tăng cường lãnh đạo, chỉ đạo công tác tiếp công dân, giải quyết khiếu nại, tố cáo và phòng, chống tham nhũng; tăng cường phối hợp giữa các phòng, ban chuyên môn với các phường, xã để giải quyết dứt điểm các vụ việc tại cấp cơ sở; thực hiện công khai, minh bạch, khách quan và dân chủ trong giải quyết công việc và công tác cán bộ; tăng cường đối thoại giữa lãnh đạo tỉnh với công dân; phát huy vai trò của các cơ quan thông tin đại chúng trong phòng, chống tham nhũng, lãng phí...");
                listDetailHome5.add("Phát biểu chỉ đạo Hội nghị, đồng chí Nguyễn Quang Dương, Ủy viên BCH Trung ương Đảng, Bí thư Tỉnh ủy đã ghi nhận những kết quả mà các cấp, các ngành đã đạt được trong công tác giải quyết khiếu nại tố cáo trên địa bàn tỉnh. Đồng chí đề nghị, trong thời gian tới, các cấp, các ngành trong quá trình giải quyết khiếu nại, tố cáo cần tập trung tìm nguyên nhân để có hướng giải quyết cho phù hợp; xử lý nghiêm các cán bộ có sai phạm dẫn đến khiếu nại, tố cáo của người dân; đối với các vụ khiếu nại, tố cáo phức tạp kéo dài, phải có phương pháp và kế hoạch giải quyết từng vụ; cố gắng giải quyết các vụ khiếu nại, tố cáo ngay tại cơ sở./.");
                listDetailHome5.add("Đức Hình");
                break;
            }
            case 6:{
                listDetailHome6.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20nghi%20trien%20khai%20VBPL1342018_84612.jpg");
                listDetailHome6.add("Đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp phát biểu khai mạc Hội nghị");
                listDetailHome6.add("Phát biểu khai mạc Hội nghị, đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp cho biết Hội nghị sẽ triển khai nội dung về hướng dẫn trình tự, thủ tục trong xử lý vi phạm hành chính; một số nội dung cơ bản của Luật Đấu giá tài sản và Nghị định số 62/2017/NĐ-CP ngày 16/5/2014 của Chính phủ quy định chi tiết một số điều và biện pháp thi hành Luật Đấu giá tài sản; nội dung cơ bản của Luật Hộ tịch, công tác chứng thực, lý lịch tư pháp....");
                listDetailHome6.add("Hội nghị triển khai các văn bản pháp luật nhằm nâng cao nhận thức, tinh thần trách nhiệm, tính chủ động của Lãnh đạo các cơ quan, đơn vị, cán bộ, công chức trong công tác quản lý nhà nước về hộ tịch, công tác thi hành Luật Đấu giá, xử lý vi phạm hành chính. Hội nghị tập huấn lần này diễn ra trong 1,5 ngày, từ ngày 10/4 đến hết buổi sáng ngày 11/4./.");
                listDetailHome6.add("Đức Hình");
                break;
            }
            case 7:{
                listDetailHome7.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20dong%20nhan%20dan242018_103857.jpg");
                listDetailHome7.add("Ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh phát biểu tại buổi làm việc");
                listDetailHome7.add("Nhìn chung, người dân địa phương khá hài lòng về công tác CCHC của địa phương, đa số các thủ tục được giải quyết kịp thời, đúng thời hạn. Tuy nhiên, vẫn có ý kiến đóng góp về sự chậm trễ ở lĩnh vực đất đai, xác nhận hồ sơ người có công… Để khắc phục sự chậm trễ như đã qua, UBND xã Ninh Hòa kiến nghị với Đoàn một số nội dung như: Có cơ chế hỗ trợ về cơ sở vật chất, trang thiết bị đối với bộ phận một cửa; tổ chức các lớp tập huấn nâng cao nghiệp vụ cho cán bộ, công chức phụ trách Bộ phận tiếp nhận và trả kết quả; hỗ trợ để xã được cập nhật và triển khai các văn bản mới…");
                listDetailHome7.add("Buổi chiều cùng ngày, Đoàn giám sát làm việc với UBND huyện Hồng Dân về công tác cải cách hành chính của huyện, giai đoạn 2015 - 2017. Theo báo cáo đánh giá cho thấy, huyện Hồng Dân đã nghiêm túc thực hiện các quy định về kỷ luật, kỷ cương hành chính tại cơ quan, đơn vị; giải quyết nhanh chóng, đúng quy định các thủ tục hành chính cho tổ chức, công dân; tổ chức tiếp nhận, xử lý phản ánh, kiến nghị của cá nhân, tổ chức theo quy định; công khai minh bạch các thủ tục hành chính trên tất cả các lĩnh vực tại trụ sở cơ quan, bộ phận tiếp nhận và trả kết quả theo cơ chế một cửa của huyện; hầu hết các đơn vị xã, thị trấn đều đạt điểm hài lòng của người dân về dân chủ cơ sở từ 56 - 60/60 điểm; mức độ hài lòng của người dân về tính công khai, minh bạch của các đơn vị đạt 69/70 điểm…");
                listDetailHome7.add("Ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh ghi nhận kết quả cải cách hành chính của huyện trong thời gian qua, đồng thời, đề nghị UBND huyện lưu ý việc tăng cường trách nhiệm của cấp ủy, người đứng đầu trong thực hiện công tác cải cách hành chính; cần có kế hoạch thu gọn một số thủ tục rườm rà; chấn chỉnh việc niêm yết, công bố các thủ tục hành chính mới theo hướng công khai, đơn giản và thuận tiện cho người dân; huyện cần quan tâm hơn nữa công tác giáo dục, tuyên truyền cho cán bộ, công chức về tinh thần, trách nhiệm, chấp hành kỷ cương, kỷ luật trong thực hiện công vụ; đặc biệt, huyện phải quan tâm, phát huy tốt hiệu quả Trung tâm hành chính công của huyện./.");
                listDetailHome7.add("Ngọc Hiền");
                break;
            }
            case 8: {
                listDetailHome8.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/trien%20khai%20ke%20hoach%20nn%206%20thang%20cuoi%20nam1562018_153449.jpg");
                listDetailHome8.add("Ông Lương Ngọc Lân, Giám đốc Sở NN&PTNT phát biểu tại Hội nghị");
                listDetailHome8.add("Trong 6 tháng đầu năm, tổng sản lượng nuôi trồng và khai thác thủy sản trên địa bàn tỉnh ước đạt hơn 153 ngàn tấn; diện tích nuôi trồng thủy sản hơn 123.000 ha. Về nông nghiệp, ngành đã thông báo hướng dẫn thời vụ sản xuất lúa, rau, màu năm 2018; tiếp tục triển khai thực hiện Đề án “Tái cơ cấu ngành trồng trọt tỉnh Bạc Liêu đến năm 2020, định hướng đến năm 2030 theo hướng nâng cao giá trị gia tăng và phát triển bền vững”. Đồng thời, tiếp tục quản lý, bảo vệ, sử dụng và phát triển rừng hiện có; chăm sóc diện tích rừng trồng. Bên cạnh đó, kiểm tra, cấp lại và cấp mới giấy chứng nhận đủ điều kiện an toàn thực phẩm cho 81 cơ sở chế biến, kinh doanh, bảo quản nông sản; kiểm tra thủ tục hành chính và điều kiện an toàn thực phẩm tại 30 cơ sở thu mua, sơ chế nguyên liệu thủy sản trên địa bàn.\n" +
                        "\n" +
                        "Hoạt động sản xuất, kinh doanh giống thủy sản đảm bảo nhu cầu thả nuôi của người dân nhưng chất lượng không đều; tình hình bệnh vàng lùn, lùn xoắn lá còn phức tạp, sẽ có nguy cơ phát sinh mạnh trong thời gian tới, lượng mưa thấp và không đều nên việc xuống giống lúa Hè Thu bị ảnh hưởng…\n" +
                        "\n" +
                        "Trong 6 tháng cuối năm, ngành Nông nghiệp tiếp tục thực hiện chỉ đạo của Trung ương, UBND tỉnh về nuôi trồng, phòng chống dịch bệnh thủy sản, bảo vệ môi trường trong nuôi trồng thủy sản; tiếp tục tuyên truyền vận động ngư dân an tâm bám biển bảo vệ chủ quyền tổ quốc, tuyên truyền về ranh giới biển và vùng khai thác cho các tàu khai thác xa bờ; thường xuyên theo dõi diễn biến bất thường của thời tiết và phối hợp chặt chẽ với các lực lượng chức năng có liên quan để kịp thời chỉ đạo và đề xuất các giải pháp phù hợp hỗ trợ ngư dân yên tâm sản xuất trên biển; chỉ đạo nông dân xuống giống lúa theo lịch thời vụ; chăm sóc, bảo vệ trà lúa hiện có…");
                listDetailHome8.add("Khánh Vy");

                break;
            }
            case 9: {
                listDetailHome9.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/cac%20giai%20phap%20trong%20tam562018_85247.jpg");
                listDetailHome9.add("Bộ trưởng Bộ NN&PTNT Nguyễn Xuân Cường phát biểu tại Hội nghị");
                listDetailHome9.add("Theo báo cáo của Tổng cục Thủy sản, diện tích thả nuôi tôm nước lợ 5 tháng đầu năm trên địa bàn cả nước gần 637.000 ha, sản lượng thu hoạch gần 195.000 tấn. Giá tôm nguyên liệu đầu năm vẫn giữ ở mức cao. Tuy nhiên, từ tháng 3 đến nay, giá tôm nguyên liệu liên tục sụt giảm.\n" +
                        "\n" +
                        "Theo Hiệp hội chế biến và xuất khẩu thủy sản Việt Nam thì giá tôm nguyên liệu liên tục giảm là do: Nhu cầu tại các thị trường lớn sụt giảm; Trung Quốc tăng cường kiểm soát tình trạng buôn lậu tôm dẫn đến lượng tôm tiêu thụ qua đường tiểu ngạch giảm; sản lượng thu hoạch tôm thẻ chân trắng ở một số nước tăng… Do đó, các nhà nhập khẩu đã nhân cơ hội này để gây sức ép giảm giá. Chỉ tính trong quý II/2018, giá tôm nguyên liệu giảm từ 10.000 - 30.000 đồng/kg.\n" +
                        "\n" +
                        "Tại Hội nghị các chuyên gia cũng đưa ra một số nguyên nhân khác dẫn đến việc giá tôm liên tục giảm và đề ra một số giải pháp nhằm ổn định sản xuất giúp bà con nuôi tôm yên tâm sản xuất.\n" +
                        "\n" +
                        "Phát biểu chỉ đạo tại Hội nghị, Bộ trưởng Bộ NN&PTNT Nguyễn Xuân Cường mong muốn người dân nuôi tôm phải bình tĩnh trước tình hình hiện nay; không bán tôm cỡ nhỏ và cần điều chỉnh quy trình nuôi hợp lí nhằm giảm bớt chi phí sản xuất. Bên cạnh đó, các doanh nghiệp cần đồng hành cùng người nuôi tôm trong giai đoạn khó khăn này, xem đây là cơ hội để nuôi dưỡng thị trường lâu dài theo hướng bền vững./.");
                listDetailHome9.add("Sự Nghiệp");
                break;
            }
            case 10: {
                listDetailHome10.add(baseSrcUrlNew+"/PublishingImages/dinh%20huong%20thanh%20lap%20htx2562018_104544.jpg");
                listDetailHome10.add("Chủ tịch UBND tỉnh Dương Thành Trung phát biểu tại buổi họp mặt");
                listDetailHome10.add("Tại buổi họp mặt, nguyên Thứ trưởng Bộ Kế hoạch và Đầu tư, Đặng Huy Đông cho biết: Việc thực hiện mô hình HTX công nghệ cao phát triển tôm sẽ giúp bà con được liên kết với các nhà cung ứng vật tư đầu vào (thức ăn, thuốc, chế phẩm sinh học, giống, bạt lót...); sử dụng vật tư với giá thấp hơn so với giá mua ở các đại lý bên ngoài, kiểm soát tốt hơn chất lượng tôm nguyên liệu nhằm hạn chế rủi ro, thiệt hại cho người nuôi.\n" +
                        "\n" +
                        "Ông Dương Thành Trung, Chủ tịch UBND tỉnh nhận định: Việc thành lập HTX công nghệ cao phát triển tôm Bạc Liêu là việc làm cần thiết để bảo vệ lợi ích chính đáng của các doanh nghiệp, hộ nuôi tôm. Vì vậy, các doanh nghiệp và các hộ nôi tôm nhỏ lẻ cần liên kết lại với nhau, thống nhất về quy trình nuôi tôm sạch, nhằm tạo ra sản phẩm có chất lượng, đem lại lợi nhuận cao hơn cho người nuôi. Từ đó khẳng định được thương hiệu con tôm Bạc Liêu, đồng thời, ông khẳng định tỉnh sẽ hỗ trợ tích cực để Hợp tác xã công nghệ cao phát triển tôm Bạc Liêu được thành lập và đi vào hoạt động trong thời gian tới./.");
                listDetailHome10.add("Sự Nghiệp");
                break;
            }
            case 11:{
                //
                listDetailHome11.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/uy%20ban%20an%20toan%20gt2232018_9574.jpg");
                listDetailHome11.add("Ông Khuất Việt Hùng, Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia phát biểu tại buổi làm việc");
                listDetailHome11.add("Tiếp và làm việc với Đoàn có đồng chí Phan Như Nguyện, Phó Chủ tịch UBND tỉnh; Ngô Hữu Dũng, Giám đốc Sở Giao thông vận tải, Phó Trưởng Ban  Thường trực Ban ATGT tỉnh và đại diện Lãnh đạo các sở, ngành liên quan.");
                listDetailHome11.add("Theo báo cáo của Ban ATGT tỉnh, trong 02 tháng đầu năm 2018, toàn tỉnh xảy ra 11 vụ tai nạn giao thông (TNGT) làm chết 08 người, bị thương 08 người, tổng thiệt hại tài sản ước tính 36 triệu đồng. Riêng trong 07 ngày nghỉ Tết Nguyên đán Mậu Tuất 2018, toàn tỉnh xảy ra 01 vụ TNGT, làm bị thương 01 người, giảm cả 03 tiêu chí so với 07 ngày nghỉ Tết Nguyên đán Đinh Dậu 2017. Tại các Lễ hội Xuân năm 2018 không xảy ra ùn tắc giao thông và TNGT.");
                listDetailHome11.add("Bên cạnh đó, công tác đảm bảo trật tự ATGT trên địa bàn tỉnh vẫn còn gặp nhiều khó khăn, trở ngại như: Hiệu lực, hiệu quả của công tác tuần tra, kiểm soát, xử lý vi phạm của các lực lượng thực thi công vụ tuy đã được nâng cao nhưng chưa đáp ứng được yêu cầu nhiệm vụ; công tác quản lý phương tiện và người lái phương tiện đường thủy nội địa còn gặp nhiều khó khăn; trên tuyến Quốc lộ 1, tại khu vực Nhà thờ Tắc Sậy, lưu lượng khách đến đây hàng ngày rất đông, thường xảy ra ùn tắc giao thông cục bộ…");
                listDetailHome11.add("Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia - Khuất Việt Hùng đánh giá cao nỗ lực của tỉnh trong việc thực hiện nhiệm vụ đảm bảo trật tự ATGT trong thời gian qua. Tuy nhiên, ông cũng lưu ý để giảm số vụ TNGT và số người chết do TNGT, Bạc Liêu cần rà soát lại những “Điểm đen” thường xảy ra TNGT để có hướng xử lý, khắc phục kịp thời; tăng cường công tác tuyên truyền về Luật Giao thông đường bộ cho mọi tầng lớp nhân dân. Nghiên cứu và có thể cho lắp hệ thống camera trên các trục đường chính để giám sát việc chấp hành Luật Giao thông đường bộ… Ông cũng nhắc nhở trong dịp Lễ hội Nghinh Ông sắp tới tại  huyện Đông Hải, Ban Tổ chức Lễ hội cần có kế hoạch tổ chức thật an toàn để bảo đảm trật tự ATGT./.");
                listDetailHome11.add("Nghiệp - Hình");
                break;
            }
            case 12:{
                //
                listDetailHome12.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/hoi%20nghi%20chuyen%20de2452018_83311.jpg");
                listDetailHome12.add("Bí thư Tỉnh ủy Nguyễn Quang Dương phát biểu chỉ đạo Hội nghị");
                listDetailHome12.add("Phát biểu khai mạc Hội nghị, Chủ tịch UBND tỉnh Dương Thành Trung nhấn mạnh vai trò quan trọng của công tác tiếp công dân, giải quyết khiếu nại, tố cáo nhằm đảm bảo quyền và lợi ích chính đáng của công dân, củng cố niềm tin của nhân dân đối với chính quyền và góp phần nâng cao hiệu lực, hiệu quả quản lý nhà nước.");
                listDetailHome12.add("Trong những năm qua, công tác tiếp dân, giải quyết đơn thư khiếu nại, tố cáo luôn được tỉnh quan tâm, chỉ đạo và đạt được nhiều kết quả quan trọng. Từ năm 2015 đến Quý I năm 2018, các ngành, các cấp đã tích cực tham mưu giải quyết 1.818/1.883 vụ thuộc thẩm quyền, đạt tỷ lệ 96,5%.");
                listDetailHome12.add("Tại Hội nghị, các tham luận tập trung đề cập tới những khó khăn, bất cập cũng như kiến nghị giải quyết liên quan tới thủ tục cấp đổi, cấp lần đầu giấy chứng nhận quyền sử dụng đất, đền bù, giải phóng mặt bằng. Đồng thời, các tham luận cũng đưa ra nhiều giải pháp tăng cường lãnh đạo, chỉ đạo công tác tiếp công dân, giải quyết khiếu nại, tố cáo và phòng, chống tham nhũng; tăng cường phối hợp giữa các phòng, ban chuyên môn với các phường, xã để giải quyết dứt điểm các vụ việc tại cấp cơ sở; thực hiện công khai, minh bạch, khách quan và dân chủ trong giải quyết công việc và công tác cán bộ; tăng cường đối thoại giữa lãnh đạo tỉnh với công dân; phát huy vai trò của các cơ quan thông tin đại chúng trong phòng, chống tham nhũng, lãng phí...");
                listDetailHome12.add("Phát biểu chỉ đạo Hội nghị, đồng chí Nguyễn Quang Dương, Ủy viên BCH Trung ương Đảng, Bí thư Tỉnh ủy đã ghi nhận những kết quả mà các cấp, các ngành đã đạt được trong công tác giải quyết khiếu nại tố cáo trên địa bàn tỉnh. Đồng chí đề nghị, trong thời gian tới, các cấp, các ngành trong quá trình giải quyết khiếu nại, tố cáo cần tập trung tìm nguyên nhân để có hướng giải quyết cho phù hợp; xử lý nghiêm các cán bộ có sai phạm dẫn đến khiếu nại, tố cáo của người dân; đối với các vụ khiếu nại, tố cáo phức tạp kéo dài, phải có phương pháp và kế hoạch giải quyết từng vụ; cố gắng giải quyết các vụ khiếu nại, tố cáo ngay tại cơ sở./.");
                listDetailHome12.add("Đức Hình");
                break;
            }
            case 13:{
                listDetailHome13.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20nghi%20trien%20khai%20VBPL1342018_84612.jpg");
                listDetailHome13.add("Đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp phát biểu khai mạc Hội nghị");
                listDetailHome13.add("Phát biểu khai mạc Hội nghị, đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp cho biết Hội nghị sẽ triển khai nội dung về hướng dẫn trình tự, thủ tục trong xử lý vi phạm hành chính; một số nội dung cơ bản của Luật Đấu giá tài sản và Nghị định số 62/2017/NĐ-CP ngày 16/5/2014 của Chính phủ quy định chi tiết một số điều và biện pháp thi hành Luật Đấu giá tài sản; nội dung cơ bản của Luật Hộ tịch, công tác chứng thực, lý lịch tư pháp....");
                listDetailHome13.add("Hội nghị triển khai các văn bản pháp luật nhằm nâng cao nhận thức, tinh thần trách nhiệm, tính chủ động của Lãnh đạo các cơ quan, đơn vị, cán bộ, công chức trong công tác quản lý nhà nước về hộ tịch, công tác thi hành Luật Đấu giá, xử lý vi phạm hành chính. Hội nghị tập huấn lần này diễn ra trong 1,5 ngày, từ ngày 10/4 đến hết buổi sáng ngày 11/4./.");
                listDetailHome13.add("Đức Hình");
                break;
            }
            case 14:{
                listDetailHome14.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20dong%20nhan%20dan242018_103857.jpg");
                listDetailHome14.add("Ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh phát biểu tại buổi làm việc");
                listDetailHome14.add("Nhìn chung, người dân địa phương khá hài lòng về công tác CCHC của địa phương, đa số các thủ tục được giải quyết kịp thời, đúng thời hạn. Tuy nhiên, vẫn có ý kiến đóng góp về sự chậm trễ ở lĩnh vực đất đai, xác nhận hồ sơ người có công… Để khắc phục sự chậm trễ như đã qua, UBND xã Ninh Hòa kiến nghị với Đoàn một số nội dung như: Có cơ chế hỗ trợ về cơ sở vật chất, trang thiết bị đối với bộ phận một cửa; tổ chức các lớp tập huấn nâng cao nghiệp vụ cho cán bộ, công chức phụ trách Bộ phận tiếp nhận và trả kết quả; hỗ trợ để xã được cập nhật và triển khai các văn bản mới…");
                listDetailHome14.add("Buổi chiều cùng ngày, Đoàn giám sát làm việc với UBND huyện Hồng Dân về công tác cải cách hành chính của huyện, giai đoạn 2015 - 2017. Theo báo cáo đánh giá cho thấy, huyện Hồng Dân đã nghiêm túc thực hiện các quy định về kỷ luật, kỷ cương hành chính tại cơ quan, đơn vị; giải quyết nhanh chóng, đúng quy định các thủ tục hành chính cho tổ chức, công dân; tổ chức tiếp nhận, xử lý phản ánh, kiến nghị của cá nhân, tổ chức theo quy định; công khai minh bạch các thủ tục hành chính trên tất cả các lĩnh vực tại trụ sở cơ quan, bộ phận tiếp nhận và trả kết quả theo cơ chế một cửa của huyện; hầu hết các đơn vị xã, thị trấn đều đạt điểm hài lòng của người dân về dân chủ cơ sở từ 56 - 60/60 điểm; mức độ hài lòng của người dân về tính công khai, minh bạch của các đơn vị đạt 69/70 điểm…");
                listDetailHome14.add("Ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh ghi nhận kết quả cải cách hành chính của huyện trong thời gian qua, đồng thời, đề nghị UBND huyện lưu ý việc tăng cường trách nhiệm của cấp ủy, người đứng đầu trong thực hiện công tác cải cách hành chính; cần có kế hoạch thu gọn một số thủ tục rườm rà; chấn chỉnh việc niêm yết, công bố các thủ tục hành chính mới theo hướng công khai, đơn giản và thuận tiện cho người dân; huyện cần quan tâm hơn nữa công tác giáo dục, tuyên truyền cho cán bộ, công chức về tinh thần, trách nhiệm, chấp hành kỷ cương, kỷ luật trong thực hiện công vụ; đặc biệt, huyện phải quan tâm, phát huy tốt hiệu quả Trung tâm hành chính công của huyện./.");
                listDetailHome14.add("Ngọc Hiền");
                break;
            }
            default:
                break;
        }





    }

    private void loadData() {
        switch (id) {
            case 1:{
                loadDataById(listDetailHome1);
                break;
            }
            case 2:{
                loadDataById(listDetailHome2);
                break;
            }
            case 3:{
                loadDataById(listDetailHome3);
                break;
            }
            case 4:{
                loadDataById(listDetailHome4);
                break;
            }
            case 5:{
                loadDataById(listDetailHome5);
                break;
            }
            case 6:{
                loadDataById(listDetailHome6);
                break;
            }
            case 7:{
                loadDataById(listDetailHome7);
                break;
            }
            case 8:{
                loadDataById(listDetailHome8);
                break;
            }
            case 9:{
                loadDataById(listDetailHome9);
                break;
            }
            case 10:{
                loadDataById(listDetailHome10);
                break;
            }
            case 11:{
                loadDataById(listDetailHome11);
                break;
            }
            case 12:{
                loadDataById(listDetailHome12);
                break;
            }
            case 13:{
                loadDataById(listDetailHome13);
                break;
            }
            case 14:{
                loadDataById(listDetailHome14);
                break;
            }
            default:
                break;
        }




    }

    private void textSize() {
        TypedValue varSizeTitle = new TypedValue();
        getResources().getValue(R.dimen.textsize_title_default,varSizeTitle,true);
        sizeTitleDefault=varSizeTitle.getFloat();
        sizeTitle=varSizeTitle.getFloat();
        //
        TypedValue varSizeContent = new TypedValue();
        getResources().getValue(R.dimen.textsize_content_default,varSizeContent,true);
        sizeContentDefault=varSizeContent.getFloat();
        sizeContent=varSizeContent.getFloat();
        //
        TypedValue varSizeTime = new TypedValue();
        getResources().getValue(R.dimen.textsize_time_default,varSizeTime,true);
        sizeTimeDefault=varSizeTime.getFloat();
        sizeTime=varSizeTime.getFloat();
        //
        sizecaptionImage=15;
    }
    private void loadDataById(ArrayList<String> listDetailHome) {
        //
        tvTitle.setText(title);
        tvTime.setText(time);
        tvSubTitle.setText(subtitle);
        //body
        for(int i = 0; i<listDetailHome.size()-1;i++)
        {
            if (listDetailHome.get(i).startsWith("http")) {
                layoutImage = LayoutInflater.from(DetailActivitiesLeaderActivity.this).inflate(R.layout.item_image, loBody, false);

                textView = layoutImage.findViewById(R.id.tvImageText);
                ImageView imgView = layoutImage.findViewById(R.id.imvImage);
                image = listDetailHome.get(i);
                text = listDetailHome.get(i+1);
                //
                textView.setText(text);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizecaptionImage);
                Picasso.with(DetailActivitiesLeaderActivity.this).load(image).into(imgView);

                loBody.addView(layoutImage);
                i++;

            } else {
                layoutText = LayoutInflater.from(DetailActivitiesLeaderActivity.this).inflate(R.layout.item_text, loBody, false);

                textView = (TextView) layoutText.findViewById(R.id.tvText);

                textView.setText(listDetailHome.get(i));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizeContent);

                loBody.addView(layoutText);
            }
        }
        //author
        layoutAuthor = LayoutInflater.from(DetailActivitiesLeaderActivity.this).inflate(R.layout.item_text, loBody, false);

        textView = (TextView) layoutAuthor.findViewById(R.id.tvText);

        textView.setText(listDetailHome.get(listDetailHome.size()-1));
        textView.setTypeface(null, Typeface.ITALIC);
        textView.setGravity(Gravity.END);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizeContent);
        loBody.addView(layoutAuthor);

        pbDetail.setVisibility(View.GONE);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_decrease_size: {
                sizeContent=sizeContent-1;
                tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,--sizeTitle);
                tvSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizeContent);
                tvTime.setTextSize(TypedValue.COMPLEX_UNIT_SP,--sizeTime);
                //

                loBody.removeViews(3,loBody.getChildCount()-3);
                loadData();
                addSamenews();
                return true;
            }
            case R.id.menu_default_size: {
                sizeContent = sizeContentDefault;
                sizeTime=sizeTimeDefault;
                sizeTitle=sizeTitleDefault;
                tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizeTitleDefault);
                tvSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizeContentDefault);
                tvTime.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizeTimeDefault);
                //
                loBody.removeViews(3,loBody.getChildCount()-3);
                loadData();
                addSamenews();
                return true;
            }
            case R.id.menu_increase_size: {
                sizeContent=sizeContent+1;
                tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,++sizeTitle);
                tvSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizeContent);
                tvTime.setTextSize(TypedValue.COMPLEX_UNIT_SP,++sizeTime);
                //

                loBody.removeViews(3,loBody.getChildCount()-3);
                loadData();
                addSamenews();
                return true;
            }
            case R.id.menu_speak: {

                if (!isClickSpeak) {
                    textToSpeech = new TextToSpeech(DetailActivitiesLeaderActivity.this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if (status != TextToSpeech.ERROR) {
                                textToSpeech.setLanguage(new Locale("vi"));
                                speakData();
                            }
                        }
                    });
                    //
                    if (!textToSpeech.isSpeaking()){
                        isClickSpeak = false;
                    }
                    else {
                        isClickSpeak = true;
                    }
                }
                else {
                    textToSpeech.stop();
                    isClickSpeak = false;
                }
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void speakData() {
        switch (id) {
            case 1: {
                speakById(listDetailHome1);
                break;
            }
            case 2: {
                speakById(listDetailHome2);
                break;
            }
            case 3: {
                speakById(listDetailHome3);
                break;
            }
            case 4: {
                speakById(listDetailHome4);
                break;
            }
            case 5: {
                speakById(listDetailHome5);
                break;
            }
            case 6: {
                speakById(listDetailHome6);
                break;
            }
            case 7: {
                speakById(listDetailHome7);
                break;
            }
            case 8: {
                speakById(listDetailHome8);
                break;
            }
            case 9: {
                speakById(listDetailHome9);
                break;
            }
            case 10: {
                speakById(listDetailHome10);
                break;
            }
            case 11: {
                speakById(listDetailHome11);
                break;
            }
            case 12: {
                speakById(listDetailHome12);
                break;
            }
            case 13: {
                speakById(listDetailHome13);
                break;
            }
            case 14: {
                speakById(listDetailHome14);
                break;
            }

            default:
                break;
        }


    }
    private void speakById(ArrayList<String> listDetailHome) {
        String stringToSpeech;
        //
        stringToSpeech = title + "." + subtitle;
        //body
        for (int i = 0; i < listDetailHome.size(); i++) {
            if (listDetailHome.get(i).startsWith("http")) {
                i++;
            } else {
                stringToSpeech = stringToSpeech+listDetailHome.get(i);
            }
        }
        textToSpeech.speak(stringToSpeech,TextToSpeech.QUEUE_FLUSH,null);
        isClickSpeak=true;

    }
    @Override
    protected void onPause() {
        super.onPause();
        //shut down speech when close app
        if(textToSpeech!=null) {
            textToSpeech.shutdown();
            isClickSpeak = false;
        }
    }

    private void getDatafromPreviousActivity() {
        Bundle extras = this.getIntent().getExtras();
        KeyString key = new KeyString();
        id = extras.getInt(key.ID);
        title = extras.getString(key.TITLE);
        time = extras.getString(key.TIME);
        subtitle = extras.getString(key.SUB_TITLE);


    }


    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        pbDetail = findViewById(R.id.pbDetail);
        loBody = findViewById(R.id.loBody);
        tvTitle = findViewById(R.id.tvTitle);
        tvTime = findViewById(R.id.tvTime);
        tvSubTitle = findViewById(R.id.tvSubTitle);
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}