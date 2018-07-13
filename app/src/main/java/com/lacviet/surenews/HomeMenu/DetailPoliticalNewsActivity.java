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
import com.lacviet.surenews.DetailScreen.DetailHomeActivityTemp;
import com.lacviet.surenews.DevelopmentMenu.DetailInvestProjectActivity;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.Model.NewsModel;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class DetailPoliticalNewsActivity extends AppCompatActivity {
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
        layoutSameNews = LayoutInflater.from(DetailPoliticalNewsActivity.this).inflate(R.layout.view_same_news, loBody, false);
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
            case 1: {
                listDetailHome1.add("Bộ Kế hoạch và Đầu tư sẽ từng bước điều chỉnh cơ cấu đầu tư theo hướng giảm dần đầu tư công, tăng cường huy động vốn của các thành phần kinh tế trong và ngoài nước để đầu tư vào các dự án kết cấu hạ tầng kinh tế - xã hội có khả năng thu hồi vốn.");
                listDetailHome1.add(" Ngày 15/11, Bộ Kế hoạch và Đầu tư tổ chức Hội nghị phổ biến và hướng dẫn thực hiện Chỉ thị số 1792/CT-TTg của Thủ tướng Chính phủ về tăng cường quản lý đầu tư từ nguồn vốn ngân sách Nhà nước và vốn trái phiếu Chính phủ.");
                listDetailHome1.add("http://ubmttq.baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2012-3/BTruongVInh16112011_163752232012_151326.jpg");
                listDetailHome1.add("Bộ trưởng Bộ Kế hoạch và Đầu tư  Bùi Quang Vinh: sẽ không có ngoại lệ khi thực hiện Chỉ thị 1792/CT - TTg của Thủ tướng Chính phủ.");
                listDetailHome1.add("Nhận thức được những bất cập và nhằm khắc phục các tồn tại trong công tác quản lý đầu tư công, đồng thời triển khai giải pháp tổng thể về tái cơ cấu đầu tư mà trọng tâm là đầu tư công, ngày 15/10/2011 Thủ tướng Chính phủ đã ban hành Chỉ thị 1792/CT-TTg.");
                listDetailHome1.add("Một điểm mới tại Chỉ thị 1792 là các bộ, ngành, địa phương phải thẩm định về nguồn vốn và cân đối vốn trước khi trình cấp có thẩm quyền quyết định. Từ đó, Bộ Kế hoạch và Đầu tư chủ trì, phối hợp với Bộ Tài chính thẩm định nguồn vốn và cân đối vốn của các dự án đầu tư thuộc thẩm quyền phê duyệt của Chính phủ, vốn ngân sách Trung ương bổ sung có mục tiêu cho địa phương, vốn trái phiếu Chính phủ...");
                listDetailHome1.add("Sau đó, các bộ, ngành ở Trung ương và các địa phương tự tổ chức thẩm định các dự án do các bộ, ngành quản lý và các dự án thuộc cân đối ngân sách địa phương.\n" +
                        "\n" +
                        "Bộ Kế hoạch và Đầu tư sẽ từng bước điều chỉnh cơ cấu đầu tư theo hướng giảm dần đầu tư công, tăng cường huy động vốn của các thành phần kinh tế trong và ngoài nước để đầu tư vào các dự án kết cấu hạ tầng kinh tế - xã hội có khả năng thu hồi vốn.");
                listDetailHome1.add("Không có ngoại lệ với các dự án mới");
                listDetailHome1.add("Theo Bộ trưởng Bộ Kế hoạch và Đầu tư Bùi Quang Vinh, để hoàn thành số dự án đang thi công dở dang theo Nghị quyết số 881/NQ-UBTVQH12 của Ủy ban Thường vụ Quốc hội và Quyết định 184/QĐ-TTg của Thủ tướng Chính phủ về việc giao kế hoạch vốn trái phiếu Chính phủ năm 2011, cần trên 500.000 tỷ đồng. Tuy nhiên, Nghị quyết về Kế hoạch vốn trái phiếu Chính phủ giai đoạn 2011-2015 vừa được Quốc hội thông qua tại Kỳ họp thứ 2 này chỉ cho phép bố trí không quá 225.000 tỷ, tương đương với 36% nhu cầu của các công trình dở dang. Như vậy, sẽ có 2/3 khối lượng dự án, công trình sẽ không có vốn bố trí.\n" +
                        "\n" +
                        "Trong khi đó, đây là các dự án đường giao thông, thủy lợi, bệnh viện, trường học. Do vậy, chuyển đổi hình thức đầu tư là việc không thể không làm.\n" +
                        "\n" +
                        "Bộ trưởng Bùi Quang Vinh cho rằng, một số dự án chuyển đổi được sang hình thức đầu tư khác như BT, BOT, đối tác công - tư (PPP), song việc kêu gọi đầu tư theo hình thức này chỉ áp dụng được với các công trình có khả năng hoàn vốn cao.\n" +
                        "\n" +
                        "Với các dự án ở các tỉnh miền núi, biên giới buộc phải chuyển hình thức đầu tư, Nhà nước sẽ quan tâm hỗ trợ nhiều hơn thông qua điều chỉnh hỗ trợ vốn đầu tư cao hơn các tỉnh khác. Tuy nhiên, nếu các địa phương này vẫn tiếp tục bố trí vốn đầu tư dàn trải thì sẽ phải tự giải quyết.\n" +
                        "\n" +
                        "Bộ trưởng Bùi Quang Vinh cũng thẳng thắn cho biết: Sẽ không có ngoại lệ, thậm chí, những dự án mà địa phương đã có quyết định đầu tư từ trước mà chưa triển khai thì vẫn có thể nằm trong phạm vi điều chỉnh của Chỉ thị 1792.\n" +
                        "\n" +
                        "Việc bố trí vốn đầu tư cho các dự án sử dụng vốn ngân sách Nhà nước, bao gồm đầu tư từ vốn ngân sách Trung ương và ngân sách địa phương kế hoạch năm 2012 phải đảm bảo nguyên tắc ưu tiên các lĩnh vực nông nghiệp, nông thôn, giáo dục, y tế, quốc phòng, an ninh...\n" +
                        "\n" +
                        "Trong đó, tập trung bố trí vốn cho các dự án đã hoàn thành và đã bàn giao, đưa vào sử dụng trước ngày 31/12/2011 nhưng chưa bố trí đủ vốn, theo thứ tự ưu tiên: Các dự án hoàn thành và đã bàn giao, đưa vào sử dụng trước ngày 31/12/2011 nhưng chưa bố trí đủ vốn; các dự án cần hoàn thành trong năm 2012 và vốn đối ứng cho các dự án ODA theo tiến độ thực hiện dự án, số vốn còn lại (nếu có) bố trí cho một số dự án chuyển tiếp và một số dự án thật sự cần thiết.\n" +
                        "\n" +
                        "Tiếp đến, các công trình chuyển tiếp sang năm 2013 và cuối cùng mới đến các dự án đầu tư mới. Các dự án khởi công mới phải là các dự án thật sự cần thiết, có đủ các thủ tục đầu tư theo quy định và phải báo cáo Bộ Kế hoạch và Đầu tư rà soát, tổng hợp trình Thủ tướng Chính phủ quyết định cho phép bố trí vốn kế hoạch năm 2012.\n" +
                        "\n" +
                        "Đối với các bộ, ngành ở Trung ương, việc bố trí vốn cho từng dự án theo theo đúng ngành, lĩnh vực và chương trình được giao. Bên cạnh đó, việc bố trí vốn đầu tư đối với các dự án chuyển tiếp phải bảo đảm dự án nhóm B hoàn thành trong 5 năm, dựa án nhóm C hoàn thành trong 3 năm.\n" +
                        "\n" +
                        "Đối với các địa phương, các dự án sử dụng vốn ngân sách Trung ương có thể bố trí thêm vốn đầu tư từ các nguồn vốn ngân sách địa phương và các nguồn vốn hợp pháp khác để thực hiện...");
                listDetailHome1.add("Theo Văn Chính – www.chinhphu.vn");
                break;
            }
            case 2: {
                listDetailHome2.add("http://ubmttq.baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2012-3/kiemchelamphat132012_16639.jpg");
                listDetailHome2.add("Toàn cảnh buổi họp báo Chính phủ thường kỳ ngày 26/9/2011. Ảnh: Chinhphu.vn");
                listDetailHome2.add("\"Kiềm chế lạm phát vẫn là mục tiêu ưu tiên số một\". Đây là vấn đề được Bộ trưởng, Chủ nhiệm Văn phòng Chính phủ Vũ Đức Đam nhấn mạnh trong buổi họp báo thường kỳ tháng 9/2011 của Chính phủ do Văn phòng Chính phủ tổ chức chiều 26/9.\n" +
                        "Bộ trưởng, Chủ nhiệm Văn phòng Chính phủ Vũ Đức Đam, Bộ trưởng Bộ Thông tin và Truyền thông Nguyễn Bắc Son chủ trì họp báo.\n" +
                        "\n" +
                        "Theo Bộ trưởng, Chủ nhiệm VPCP Vũ Đức Đam, tại phiên họp Chính phủ thường kỳ tháng 9/2011, nhìn vào bức tranh kinh tế - xã hội tháng 9 và 9 tháng đầu năm 2011, các thành viên Chính phủ đều thống nhất đánh giá, nhiệm vụ kiềm chế lạm phát, ổn định kinh tế vĩ mô, bảo đảm an sinh xã hội đạt được kết quả tích cực bước đầu.\n" +
                        "\n" +
                        "Điều đó được thể hiện rõ ở các chỉ số: lạm phát đang giảm dần, tăng trưởng GDP quý sau cao hơn quý trước (quý I tăng 5,43%; quý II tăng 5,67%; quý III tăng 6,11%). Kim ngạch xuất khẩu tiếp tục tăng trưởng cao so với cùng kỳ năm trước và so với kế hoạch đề ra.\n" +
                        "\n" +
                        "Theo Bộ trưởng Vũ Đức Đam, điều đáng mừng bắt đầu từ tháng 5, chỉ số tăng giá tiêu dùng (CPI) đã giảm. Tháng 9/2011, CPI tăng 0,82%, là mức tăng thấp nhất kể từ đầu năm và tháng thứ 2 liên tiếp tăng dưới 1%.\n" +
                        "\n" +
                        "Bộ trưởng cho biết, Chính phủ đặt mục tiêu ưu tiên chống lạm phát là số một. Từ nay đến cuối năm phải điều hành chính sách tiền tệ, chính sách tài khóa chặt chẽ.\n" +
                        "\n" +
                        "“Tinh thần của Chính phủ, Thủ tướng Chính phủ trong tất cả mọi vấn đề đều nhìn nhận rất thẳng thắn, cầu thị, đánh giá đúng tình hình, không tô hồng cũng như bôi đen. Nhưng chúng ta không được chủ quan vì tình hình còn rất khó khăn”, Bộ trưởng Vũ Đức Đam nhấn mạnh.\n" +
                        "\n" +
                        "Chính vì vậy, ngay từ bây giờ phải cơ cấu lại đầu tư, tập trung vào những công trình, dự án trọng điểm, thúc đẩy sản xuất và nhằm đạt được tốc độ tăng trưởng đã đề ra là 6%.\n" +
                        "\n" +
                        "Về mục tiêu kiềm chế lạm phát, Bộ trưởng Vũ Đức Đam cho biết Chính phủ đã bàn rất kỹ về các giải pháp kiềm chế lạm phát đồng thời đã giao cho Bộ Kế hoạch và Đầu tư, Bộ Tài chính và Ngân hàng Nhà nước nghiên cứu độc lập, phân tích tình hình, thực trạng lạm phát, nguyên nhân và đề ra giải pháp lâu dài.\n" +
                        "\n" +
                        "Theo Bộ trưởng, lạm phát ở nước ta ở mức cao và kéo dài do nhiều nguyên nhân, một trong những nguyên nhân của lạm phát là chính sách tiền tệ, tổng mức đầu tư vượt quá tiết kiệm, tín dụng, tổng phương tiện thanh toán tăng nhanh, giá cả thế giới và trong nước cũng tăng...\n" +
                        "\n" +
                        "Bộ trưởng Vũ Đức Đam cho rằng, trong những nguyên nhân trên có yếu tố tác động tâm lý về lạm phát kỳ vọng, đồng thời không ít những mặt hàng thiết yếu Chính phủ luôn phải bù giá. Trong khi đó chúng ta cần phải tiến sát đến cơ chế kinh tế thị trường, không thể bao cấp, bù lỗ mãi được.\n" +
                        "\n" +
                        "Bộ trưởng cũng nhấn mạnh đến việc thực hiện Nghị quyết 11 của Chính phủ không chỉ trong năm nay mà còn tiếp tục thực hiện trong những năm tới.\n" +
                        "\n" +
                        "Kiên quyết cắt giảm đầu tư công\n" +
                        "\n" +
                        "Trong thời điểm này trước hết cần tháo gỡ khó khăn cho sản xuất, kiên quyết cắt giảm đầu tư công, tái cấu trúc đầu tư, tái cấu trúc doanh nghiệp và tái cấu trúc hệ thống tài chính, đồng thời khuyến khích các dòng vốn khác tiếp tục đầu tư phát triển kinh tế - xã hội đất nước. Theo Bộ trưởng Vũ Đức Đam, để thực hiện được điều này trách nhiệm của Chính phủ và của toàn xã hội là rất lớn.\n" +
                        "\n" +
                        "Bộ trưởng cũng cho biết, Chính phủ đặc biệt quan tâm tới tất cả các hình thức đầu tư trong nước và đã giao các bộ rà soát các thủ tục còn vướng mắc ở đâu, để quyết liệt phải tháo gỡ, từ đó tiếp tục thu hút đầu tư.\n" +
                        "\n" +
                        "Công khai, minh bạch hóa giá xăng dầu\n" +
                        "\n" +
                        "Về điều hành giá xăng dầu hiện nay, Bộ trưởng Vũ Đức Đam nêu rõ, chính sách điều hành giá xăng dầu cũng như những mặt hàng thiết yếu khác là chủ trương của Chính phủ và được thực hiện theo lộ trình từ nhiều năm nay.\n" +
                        "\n" +
                        "Điều hành giá xăng dầu phải công khai, minh bạch hóa giá. Sử dụng quỹ bình ổn giá công khai và theo đúng quy định, Bộ trưởng nhấn mạnh.\n" +
                        "\n" +
                        "Nợ quốc gia trong giới hạn an toàn\n" +
                        "\n" +
                        "Thông tin cho báo chí về chỉ số nợ quốc gia, Thứ trưởng Bộ Tài chính Nguyễn Công Nghiệp cho biết, đến 31/12/2010 nợ quốc gia bằng 42,2% GDP, trong đó có 62% là nợ nước ngoài của Chính phủ và 38% là nợ nước ngoài của doanh nghiệp. Trong số 62% nợ nước ngoài của Chính phủ thì 93% là nợ ODA và ưu đãi, chỉ 7% là nợ thương mại.\n" +
                        "\n" +
                        "Hiện nay tỷ lệ nợ của Việt Nam là tỉ lệ trung bình trong các nước có cùng hệ số tín nhiệm. Chính phủ đã chỉ đạo kiển soát giới hạn nợ quốc gia theo hướng không quá 50% GDP.\n" +
                        "\n" +
                        "Về biến động của giá vàng trong những ngày vừa qua, Phó Thống đốc Ngân hàng Nhà nước Việt Nam Nguyễn Đồng Tiến cho biết, Ngân hàng Nhà nước khuyến cáo người dân bình tĩnh, thận trọng để không mất tiền cho những hoạt động mua bán vàng không cần thiết. Ngân hàng Nhà nước sẽ theo dõi chặt chẽ để có những giải pháp phù hợp, trong đó có việc nhập khẩu vàng để cân bằng giá vàng trong nước và thế giới.");
                listDetailHome2.add("Theo Mai Chi – www.chinhphu.vn");

                break;
            }
            case 3: {
                listDetailHome3.add("Ngày 7/9, Ngân hàng Nhà nước Việt Nam (NHNN) tổ chức Hội nghị sơ kết triển khai Nghị quyết 11/NQ-CP của Chính phủ và Chỉ thị 01/CT-NHNN của NHNN về kiềm chế lạm phát, ổn định kinh tế vĩ mô, bảo đảm an sinh xã hội, đồng thời triển khai nhiệm vụ những tháng cuối năm 2011.");
                listDetailHome3.add("http://ubmttq.baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2012-3/tiente_cuoinam132012_154048.jpg");
                listDetailHome3.add("NHNN tiếp tục điều hành thận trọng đến cuối năm với mục tiêu kiềm chế lạm phát");
                listDetailHome3.add("Cơ cấu tín dụng chuyển dịch hợp lý\n" +
                        "\n" +
                        "Trong 8 tháng đầu năm, NHNN đã điều hành chính sách tiền tệ chặt chẽ, thận trọng để kiểm soát lạm phát, hỗ trợ ổn định kinh tế vĩ mô, bảo đảm an toàn hệ thống.\n" +
                        "\n" +
                        "Tổng phương tiện thanh toán đến ngày 30/8 tăng 9,16% so với cuối năm 2010, thấp hơn mức tăng 19,87% và 16,41% của cùng kỳ năm 2009 và 2010. Tín dụng đối với nền kinh tế đến ngày 30/8 tăng 8,85% so với cuối năm 2010, thấp hơn mức tăng 16,9% của cùng kỳ năm 2010 nhưng bằng khoảng 50% tốc độ tăng tín dụng dự kiến cả năm 2011 (khoảng 15-18%).\n" +
                        "\n" +
                        "Cơ cấu tín dụng chuyển hướng tích cực, theo đúng chỉ đạo của Chính phủ. Ước đến cuối tháng 8, tín dụng đối với lĩnh vực sản xuất tăng 14,79%, trong đó tín dụng nông nghiệp, nông thôn tăng 30,5%; tín dụng xuất khẩu tăng 35,02%; tín dụng phi sản xuất giảm -16,95%, trong đó, dư nợ cho vay để đầu tư, kinh doanh chứng khoán giảm -43,03%, dư nợ cho vay để đầu tư kinh doanh bất động sản giảm -10,1%, dư nợ cho vay tiêu dùng giảm -23,12%.  \n" +
                        "\n" +
                        "Hiện nay, lãi suất thị trường nội tệ liên ngân hàng ổn định ở mức thấp hơn các mức lãi suất điều hành của NHNN, qua đêm ở mức 10,5-11%/năm, 1-2 tuần 11-13%/năm. Đến cuối tháng 8/2011, một số TCTD hạ lãi suất đối với một số khoản cho vay sản xuất kinh doanh thông thường trong biên độ 17-19%/năm.  \n" +
                        "\n" +
                        "Từ đầu tháng 8 do giá vàng thế giới tăng đột biến đẩy hoạt động mua bán, đầu cơ vàng trong nước lên cao, ảnh hưởng đến ổn định tỷ giá. Tuy nhiên nhờ những biện pháp can thiệp kịp thời và kiên quyết của NHNN, đến nay tỷ giá đã ổn định trở lại.\n" +
                        "\n" +
                        "Đối với thị trường vàng, đến nay mặc dù giá vàng thế giới vẫn ở mức cao nhưng chênh lệch giữa giá vàng trong nước và thế giới hầu như không đáng kể và có những thời điểm giá vàng trong nước còn thấp hơn giá vàng thế giới.\n" +
                        "\n" +
                        "Ngoài ra, thanh khoản VND và ngoại tệ của hệ thống các tổ chức tín dụng (TCTD) về cơ bản được đảm bảo, hoạt động của hệ thống các TCTD an toàn, đảm bảo thanh khoản, nợ xấu trong tầm kiểm soát , thanh toán không dùng tiền mặt ngày càng phát triển...\n" +
                        "\n" +
                        "Đảm bảo hài hòa mức tăng và lượng cung ứng tiền các tháng\n" +
                        "\n" +
                        "Trong những tháng cuối năm 2011, để góp phần đạt được các mục tiêu của Chính phủ, NHNN tiếp tục chính sách tiền tệ chặt chẽ, linh hoạt, đảm bảo tăng trưởng tín dụng dưới 20% (khoảng 15-18%), tổng phương tiện thanh toán tăng 15-16%, tỷ giá ổn định, lãi suất cho vay giảm dần theo mức giảm của lạm phát, đảm bảo an toàn hệ thống.\n" +
                        "\n" +
                        "Cụ thể, NHNN tiếp tục kiểm soát tăng trưởng tín dụng bằng VND, điều hành linh hoạt tùy theo tình hình nhưng đảm bảo tăng trưởng dưới 20%, đảm bảo hài hòa về mức tăng và lượng cung ứng tiền qua các tháng.\n" +
                        "\n" +
                        "NHNN kiểm soát tăng trưởng tín dụng bằng ngoại tệ, tăng cường thanh tra, kiểm tra một số TCTD có tăng trưởng tín dụng ngoại tệ cao và hệ số sử dụng vốn ngoại tệ cao; sửa đổi cơ chế cho vay bằng ngoại tệ theo hướng quy định điều kiện chặt chẽ hơn đối với khách hàng không có nguồn thu ngoại tệ từ hoạt động sản xuất kinh doanh để trả nợ vay; ban hành quy chế trần giao dịch kỳ hạn nhằm tăng chi phí vay bằng ngoại tệ; yêu cầu các TCTD quan tâm điều hành, đảm bảo thanh khoản ngoại tệ nhằm hạn chế rủi ro cho các TCTD và góp phần ổn định thị trường ngoại hối.\n" +
                        "\n" +
                        "NHNN giữ nguyên các mức lãi suất điều hành như hiện nay, duy trì trần lãi suất huy động vốn bằng VND 14%/năm để tạo điều kiện cho các TCTD đưa mặt bằng lãi suất cho vay về biên độ 17-19% đối với lĩnh vực sản xuất kinh doanh thông thường; giữ nguyên trần lãi suất bằng ngoại tệ của các TCTD đối với khách hàng là tổ chức và dân cư. Ban hành Thông tư quy định về hoạt động ủy thác, nhận ủy thác của TCTD để tránh việc các TCTD lợi dụng đưa lãi suất huy động lên cao.\n" +
                        "\n" +
                        "Thống đốc NHNN ban hành Chỉ thị về việc chấp hành trần lãi suất huy động và xử lý nghiêm khắc các TCTD vi phạm.\n" +
                        "\n" +
                        "Tiếp tục điều hành tỷ giá theo hướng ổn định, nếu cần phải điều chỉnh thì chỉ điều chỉnh theo diễn biến tỷ giá thực của đồng Việt Nam (không quá 1%). NHNN sẵn sàng bán ra can thiệp thị trường nếu cần thiết để hỗ trợ bình ổn tỷ giá.\n" +
                        "\n" +
                        "Đối với thị trường vàng, NHNN đặt mục tiêu bình ổn là làm cho giá vàng trong nước diễn biến phù hợp với giá vàng quốc tế, chống đầu cơ, làm giá.\n" +
                        "\n" +
                        "NHNN xây dựng và trình Chính phủ phương án bình ổn thị trường vàng trong ngắn hạn và Phương án NHNN huy động vàng trong nền kinh tế để tăng dự trữ ngoại hối Nhà nước, đảm bảo quyền lợi của người dân có vàng cũng như tăng cường nguồn lực can thiệp của Nhà nước; trình Chính phủ Nghị định về quản lý hoạt động sản xuất- kinh doanh vàng.\n" +
                        "\n" +
                        "Đồng thời, NHNN cũng tăng cường công tác thông tin, tuyên truyền, đối thoại chính sách về tình hình tiền tệ và hoạt động ngân hàng để hạn chế các tác động tiêu cực do yếu tố tâm lý, hỗ trợ cho các giải pháp ổn định thị trường tiền tệ.");
                listDetailHome3.add("Huy Thắng – www.chinhphu.vn");
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
            case 1: {
                loadDataById(listDetailHome1);
                break;
            }
            case 2: {
                loadDataById(listDetailHome2);
                break;
            }
            case 3: {
                loadDataById(listDetailHome3);
                break;
            }
            case 4: {
                loadDataById(listDetailHome4);
                break;
            }
            case 5: {
                loadDataById(listDetailHome5);
                break;
            }
            case 6: {
                loadDataById(listDetailHome6);
                break;
            }
            case 7: {
                loadDataById(listDetailHome7);
                break;
            }
            case 8: {
                loadDataById(listDetailHome8);
                break;
            }
            case 9: {
                loadDataById(listDetailHome9);
                break;
            }
            case 10: {
                loadDataById(listDetailHome10);
                break;
            }
            case 11: {
                loadDataById(listDetailHome11);
                break;
            }
            case 12: {
                loadDataById(listDetailHome12);
                break;
            }
            case 13: {
                loadDataById(listDetailHome13);
                break;
            }
            case 14: {
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
                layoutImage = LayoutInflater.from(DetailPoliticalNewsActivity.this).inflate(R.layout.item_image, loBody, false);

                textView = layoutImage.findViewById(R.id.tvImageText);
                ImageView imgView = layoutImage.findViewById(R.id.imvImage);
                image = listDetailHome.get(i);
                text = listDetailHome.get(i+1);
                //
                textView.setText(text);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizecaptionImage);
                Picasso.with(DetailPoliticalNewsActivity.this).load(image).into(imgView);

                loBody.addView(layoutImage);
                i++;

            } else {
                layoutText = LayoutInflater.from(DetailPoliticalNewsActivity.this).inflate(R.layout.item_text, loBody, false);

                textView = (TextView) layoutText.findViewById(R.id.tvText);

                textView.setText(listDetailHome.get(i));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizeContent);

                loBody.addView(layoutText);
            }
        }
        //author
        layoutAuthor = LayoutInflater.from(DetailPoliticalNewsActivity.this).inflate(R.layout.item_text, loBody, false);

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
                    textToSpeech = new TextToSpeech(DetailPoliticalNewsActivity.this, new TextToSpeech.OnInitListener() {
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