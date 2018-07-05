package com.lacviet.surenews.GovementMenu;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

import com.lacviet.surenews.DetailScreen.DetailHomeActivityTemp;
import com.lacviet.surenews.DevelopmentMenu.DetailInvestProjectActivity;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailDepartmentNewsActivity extends AppCompatActivity {
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
    //
    String baseSrcUrl = "http://congthongtin.bioportal.vn";
    String baseUrlSoNgoaiVu = "http://songoaivu.baclieu.gov.vn";
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


    }


    private void initData() {
        switch (id) {
            case 1: {
                listDetailHome1.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/302962018_82446.jpg");
                listDetailHome1.add("Ảnh: Bà Lê Thanh Giang - Chủ tịch HND tỉnh, Trưởng BTC Hội thi trao cờ lưu niệm cho các trưởng đoàn.");
                listDetailHome1.add("Đến dự Hội thi có các đ/c trong Ban tổ chức, Ban Giám khảo, đại diện lãnh đạo các Sở ngành liên quan, Hội nông dân các địa phương, đông đảo cổ động viên. Với sự tranh tài của 22 thí sinh dự thi 21 tiết mục gồm: cổ nhạc, tân nhạc và ca tài tử. Kết quả, Ban tổ chức đã trao 2 giải nhất, 4 giải nhì, 5 giải ba và 10 giải khuyến khích; giải nhất thể loại tân nhạc thuộc về thí sinh Phạm Văn Sâm (huyện Vĩnh Lợi), giải Nhất thể loại cổ nhạc thuộc về đôi song ca Huỳnh Văn Em - Đỗ Thị Ngọc Huyền (huyện Hồng Dân).\n" +
                        "Nhằm duy trì và phát triển phong trào văn hóa, văn nghệ trong cán bộ, hội viên Hội Nông dân các cấp trong tỉnh; góp phần bảo tồn và phát huy giá trị nghệ thuật đờn ca tài tử Nam bộ, bản Dạ cổ hoài lang và bài ca vọng cổ tiêu biểu của Bạc Liêu.");
                listDetailHome1.add("Văn Công Diệp");
                break;
            }
            case 2: {
                listDetailHome2.add("Đối tượng tham dự Lớp bồi dưỡng là cán bộ, công chức, viên chức làm công tác hội nhập quốc tế thuộc các cơ quan Đảng của tỉnh; các Sở, ban, ngành, đơn vị; Mặt trận Tổ quốc và các đoàn thể cấp tỉnh; các hội đặc thù; các cơ quan, đơn vị cấp huyện; các trường Đại học, Cao đẳng trên địa bàn tỉnh. Các giảng viên, báo cáo viên trình bày các chuyên đề gồm: PGS.TS Trần Việt Thái, Phó Viện trưởng Viện Nghiên cứu chiến lược Bộ Ngoại giao; ông Phạm Thành Nam, Phó Vụ trưởng Vụ Kinh tế đa phương và ông Vũ Xuân Trường, nguyên Đại sứ Việt Nam tại Philippin, chuyên gia kinh tế, Bộ Ngoại giao.");
                listDetailHome2.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/1%20NHỎ2762018_132823.jpg");
                listDetailHome2.add("Ông Vưu Nghị Bình, Giám đốc Sở Ngoại vụ phát biểu khai giảng lớp bồi dưỡng");
                listDetailHome2.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/1.2%20nhỏ2762018_132918.jpg");
                listDetailHome2.add("Quang cảnh lớp bồi dưỡng");
                listDetailHome2.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/2%20NHỎ2762018_133025.jpg");
                listDetailHome2.add("PGS.TS Trần Việt Thái, Phó Viện trưởng Viện Nghiên cứu Chiến lược, Bộ Ngoại giao trình bày chuyên đề đường lối đối ngoại của Đảng và Nhà nước về Hội nhập quốc tế");
                listDetailHome2.add("Phát biểu tại lớp bồi dưỡng, ông Vưu Nghị Bình, Giám đốc Sở Ngoại vụ cho rằng việc tổ chức lớp học này là hết sức quan trọng, thiết thực và bổ ích, nhằm giúp cho học viên nắm rõ về cục diện quan hệ quốc tế và chiến lược hội nhập quốc tế; về đường lối đối ngoại của Đảng và Nhà nước, các định hướng lớn trong quan hệ đa phương đến năm 2030, vai trò nòng cốt của Việt Nam trong ASEAN; về công tác Ngoại giao kinh tế và kỹ năng xúc tiến đầu tư, thương mại; về các hiệp định thương mại và đầu tư của Việt Nam với các đối tác lớn, cơ hội, thách thức của Việt Nam khi tham gia. Để lớp bồi dưỡng đạt kết quả cao, Giám đốc Sở Ngoại vụ đề nghị các đồng chí tham dự lớp học phải có mặt đầy đủ, tập trung theo dõi, lắng nghe và tiếp thu các nội dung mà các giảng viên trình bày; đồng thời, cũng mong rằng từ những thông tin, kiến thức được lĩnh hội, cập nhật qua lớp bồi dưỡng này, các đồng chí sẽ nghiên cứu, vận dụng sáng tạo trong quá trình triển khai thực hiện các nhiệm vụ liên quan đến lĩnh vực công tác đối ngoại và hội nhập quốc tế nhằm đạt được kết quả cao nhất, góp phần đẩy mạnh phát triển kinh tế - xã hội, giữ vững ổn định an ninh – chính trị của tỉnh.\n" +
                        "\n" +
                        "Sau 02 ngày học tập, Ban Tổ chức lớp đã trao Giấy chứng nhận cho các học viên hoàn thành lớp bồi dưỡng.");
                listDetailHome2.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/3-nhỏ2762018_133233.jpg");
                listDetailHome2.add("Đại diện các đoàn, đơn vị nhận giấy chứng nhận và chụp hình với ông Vưu Nghị Bình, Giám đốc Sở Ngoại vụ");
                listDetailHome2.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/3--nhỏ2762018_133420.jpg");
                listDetailHome2.add("Đại diện các đoàn, đơn vị nhận giấy chứng nhận và chụp hình với ông Phạm Thành Nam, Phó Vụ trưởng Vụ Hợp tác kinh tế đa phương, Bộ Ngoại giao");
                listDetailHome2.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/3---2762018_133611.jpg");
                listDetailHome2.add("Đại diện các đoàn, đơn vị nhận giấy chứng nhận và chụp hình với ông Nguyễn Quốc Liêm, Phó Giám đốc Sở Ngoại vụ");
                listDetailHome2.add("Theo kế hoạch, từ nay đến cuối năm 2018, Sở Ngoại vụ sẽ tham mưu Ủy ban nhân dân tỉnh mở thêm 02 lớp dành cho cán bộ, công chức, viên chức và doanh nghiệp làm công tác hội nhập quốc tế./.");
                listDetailHome2.add("Bá Thép");
                break;
            }
            case 3: {
                listDetailHome3.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/11752018_95250.png");
                listDetailHome3.add("Quang cảnh hội nghị");
                listDetailHome3.add("Tham dự buổi tọa đàm có đại diện Lãnh đạo 13 cơ quan ngoại vụ các tỉnh và 50 cán bộ, công chức thuộc Cụm thi đua số 5. Về phía Hàn Quốc, có ông Jeong Woo Jin, Phó Tổng Lãnh sự quán Hàn Quốc; ông Lee Bok Hang, Lãnh sự phụ trách visa; ông Ahn Seong Ho, Lãnh sự phụ trách thương mại - đầu tư cùng các cán bộ khác của Lãnh sự quán Hàn Quốc.\n" +
                        "\n" +
                        "Tại buổi tọa đàm ông Nguyễn Thanh Điền, Giám đốc Sở Ngoại vụ tỉnh Cà Mau và ông Phạm Thế Vinh, Giám đốc Sở Ngoại vụ thành phố Cần Thơ đồng chủ trì đã nêu lên tình hình thực hiện nhiệm vụ trên các lĩnh vực trong thời gian qua, những thuận lợi, khó khăn, vướng mắc thường gặp và đây là dịp để các cơ quan ngoại vụ của địa phương cùng trao đổi học tập kinh nghiệm.\n" +
                        "\n" +
                        "Phát biểu về hoạt động lãnh sự ông Nguyễn Hữu Xuân, Giám đốc Sở Ngoại vụ tỉnh Đồng Tháp đã nêu lên một số nội dung về công tác lãnh sự và lễ tân đối ngoại, chia sẻ về quy trình đón tiếp đoàn, quản lý đoàn ra nước ngoài,… Ông Nguyễn Việt Thông, Phó Giám đốc Sở Ngoại vụ tỉnh Kiên Giang phát biểu về công tác ngoại giao kinh tế. Kết thúc phiên thứ nhất, ông Nguyễn Thanh Điền, Giám đốc Sở Ngoại vụ tỉnh Cà Mau - Cụm trưởng đã phát biểu và đánh giá cao ý kiến thảo luận của các đại biểu, đồng thời đề nghị trong thời gian tới cụm cần tổ chức nhiều hơn các hoạt động giao lưu, hội thảo theo chuyên đề để các địa phương có điều kiện học tập, trao đổi kinh nghiệm.");
                listDetailHome3.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/21752018_95413.png");
                listDetailHome3.add("Đoàn Sở Ngoại vụ tỉnh Bạc Liêu chụp ảnh lưu niệm với Đoàn Lãnh sự quán Hàn Quốc tại thành phố Hồ Chí Minh");
                listDetailHome3.add("Tại phiên 2, đã tổ chức giao lưu, trao đổi kinh nghiệm giữa các cơ quan ngoại vụ khu vực Tây Nam Bộ với Tổng Lãnh sự quán Hàn Quốc tại Thành phố Hồ Chí Minh, các tỉnh đã nêu lên những khó khăn vướng mắc về công tác kêu gọi đầu tư, hợp tác, thủ tục xin visa đối với Hàn Quốc… và những kiến nghị nhằm tăng cường sự phối hợp chặt chẽ từ các bên, thúc đẩy hơn nữa quan hệ hợp tác giữa Việt Nam – Hàn Quốc với các tỉnh, thành khu vực đồng bằng sông Cửu Long và Hàn Quốc trong thời gian tới.\n" +
                        "\n" +
                        "Qua trao đổi Phó Tổng lãnh sự Hàn Quốc và các viên chức lãnh sự, thương mại, hợp tác quốc tế đã trả lời những câu hỏi làm rõ hơn những khó khăn, thuận lợi trong việc làm thủ tục xin cấp visa, mở rộng hợp tác thu hút đầu tư giữa Việt Nam - Hàn Quốc. Đồng thời trong thời gian tới sẽ tăng cường kết nối, giao lưu với các cơ quan ngoại vụ của địa phương để thắt chặt hơn nữa mối quan hệ hợp tác, hữu nghị./.");
                listDetailHome3.add("Bài và ảnh: Ngọc Hân");
                break;
            }
            case 4: {
                listDetailHome4.add("Kế hoạch đề ra một số chỉ tiêu như: Phấn đấu đến năm 2020, có trên 50% lực lượng lao động tham gia bảo hiểm xã hội; trên 35% lực lượng lao động tham gia bảo hiểm thất nghiệp và trên 80% dân số tham gia bảo hiểm y tế.\n" +
                        "\n" +
                        "Về chính sách ưu đãi người có công, phấn đấu đến năm 2020 hoàn thành dứt điểm công tác rà soát công nhận bổ sung các đối tượng chính sách người có công trong tỉnh; Tiếp tục phụng dưỡng Bà Mẹ Việt Nam anh hùng; phấn đấu 100% hộ gia đình chính sách có mức sống bằng hoặc cao hơn mức sống trung bình khu dân cư; cơ bản hoàn thành việc hỗ trợ nhà ở cho các đối tượng chính sách, người có công gặp khó khăn về nhà ở");
                listDetailHome4.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-7/trao-nha2972013_91022.jpg");
                listDetailHome4.add("Trao tặng nhà tình nghĩa cho gia đình thương binh Lê Văn Thính ngụ ấp Bà Ai II, xã Lộc Ninh, huyện Hồng Dân.\n" +
                        "Ảnh: www.baclieu.gov.vn");
                listDetailHome4.add("Ngoài ra, đầu tư sửa chữa nâng cấp, xây dựng mới các công trình ghi công liệt sĩ, nghĩa trang liệt sĩ các huyện để trở thành những công trình văn hóa lịch sử của tỉnh; thực hiện tốt chủ trương tham gia tìm kiếm, quy tập hài cốt lịch sử\n" +
                        "\n" +
                        "Với các chỉ tiêu trên, nhiệm vụ, giải pháp được xác định là: Tăng cường công tác quản lý nhà nước, đẩy mạnh công tác tuyên truyền, phổ biến quan điểm, chính sách pháp luật, tăng cường công tác thanh tra, kiểm tra về cải cách chính sách tiền lương, bảo hiểm xã hội, trợ cấp ưu đãi người có công. Trong đó: tổ chức rà soát, đánh giá chất lượng đội ngũ cán bộ, công chức, viên chức để thực hiện chính sách tinh giảm biên chế; đẩy mạnh xã hội hóa dịch vụ BHXH, chuyển các loại hình trợ giúp xã hội sang cung cấp dịch vụ bảo trợ xã hội dựa vào cộng đồng, bảo đảm các đối tượng bảo trợ xã hội có cuộc sống ổn định; Triển khai thực hiện tốt Pháp lệnh ưu đãi người có công với cách mạng; giải quyết kịp thời các chính sách ưu đãi, hỗ trợ với người có công và thân nhân về điều kiện phát triển , sản xuất, ưu tiên sắp xếp việc làm và tiếp cận các dịch vụ xã hội cơ bản, nhất là y tế, giáo dục, đào tạo.");
                listDetailHome4.add("V.T");
                break;
            }
            case 5: {
                listDetailHome5.add("Chương trình dự trữ hàng hóa bình ổn giá vào dịp Tết Nguyên đán Giáp Ngọ năm 2014 trên địa bàn tỉnh Bạc Liêu được thực hiện từ ngày 17/12/2013 đến ngày 03/3/2014, nhằm bình ổn thị trường nhân dịp Tết Nguyên đán Giáp Ngọ năm 2014, góp phần cân đối cung cầu hàng hóa, đáp ứng nhu cầu của nhân dân, nhất là các mặt hàng thiết yếu, từ đó hạn chế tốc độ tăng giá, kiềm chế lạm phát, thúc đẩy sản xuất – kinh doanh phát triển, bảo đảm an sinh xã hội trên địa bàn tỉnh trong dịp Tết Nguyên đán Giáp Ngọ năm 2014.");
                listDetailHome5.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-12/hang_binh_on_120122013_143459.jpg");
                listDetailHome5.add("Ảnh minh họa.");
                listDetailHome5.add("Theo Kế hoạch, các hàng hóa trong danh mục của Chương trình gồm: Lương thực (gạo tẻ, gạo nếp); Thực phẩm (dầu ăn, nước chấm, gia vị, thịt gia súc, gia cầm, trứng gia cầm, các sản phẩm chế biến từ sản phẩm gia súc, gia cầm, bánh, kẹo, mứt, nước giải khát, đường ăn, bột ngọt, sữa, rau, củ, quả; thực phẩm đông lạnh, trữ mát, đóng hộp, hàng công nghệ; mì gói, mì ly, cháo gói, phở, hủ tiếu, bún gói)…\n" +
                        "\n" +
                        "Đồng thời, tham gia chương trình dự trữ hàng hóa bình ổn giá vào dịp Tết Nguyên đán năm 2014 có các doanh nghiệp, cửa hàng: Siêu thị Co.opmart Bạc Liêu; Siêu thị Vinatex Bạc Liêu; Công ty Lương Thực Bạc Liêu; Công ty Cổ phần Xăng dầu – Dầu khí Bạc Liêu; Chi nhánh Công ty Cổ phần Thương nghiệp Cà Mau tại Bạc Liêu; Doanh nghiệp tư nhân Thanh Hưng; Doanh nghiệp tư nhân Nghệ Thành.\n" +
                        "\n" +
                        "Kế hoạch cũng nêu rõ, các tổ chức kinh doanh phải theo đúng Phương án kinh doanh, tham gia cân đối cung cầu hàng hóa, ổn định giá cả các mặt hàng trong quá trình tham gia Chương trình như: Hàng hóa phục vụ phải đảm bảo chất lượng, an toàn vệ sinh thực phẩm; lượng hàng hóa phục vụ Chương trình có khả năng đáp ứng đủ một phần nhu cầu tiêu dùng của nhân dân trên địa bàn tỉnh, kể cả trong trường hợp có xảy ra biến động thị trương bất thường.\n" +
                        "\n" +
                        "Giá bán các mặt hàng trong Chương trình phải đảm bảo luôn thấp hơn giá bán các mặt hàng cùng chủng loại, chất lượng và cùng thời điểm trên thị trường ít nhất là 5% trong suốt thời gian thực hiện Chương trình.\n" +
                        "\n" +
                        "Các điểm bán hàng bình ổn phải treo băng gôn theo đúng nội dung và thời gian, vị trí, bố trí hàng hóa, trưng bày ở khu riêng biệt, vị trí thuận tiện, để người dân dễ nhận biết và mua sắm.\n" +
                        "\n" +
                        "Ngoài ra, các ngành chức năng có liên quan thành lập Đoàn kiểm tra để quản lý, kiểm soát quá trình thực hiện mua hàng hóa tạm trữ và bán phục vụ Tết Nguyên đán Giáp Ngọ năm 2014 của các Doanh nghiệp tham gia Chương trình. Trong đó, tập trung kiểm tra, giám sát nhằm phát hiện và xử lý nghiêm các hành vi vi phạm pháp luật như: đầu cơ, găm hàng, kinh doanh hàng cấm, hàng nhập lậu, hàng gian, hàng giả, hàng không hóa đơn, chứng từ, không rõ nguồn gốc, xuất xứ, không nhãn mác, gian lận thương mại…");
                listDetailHome5.add("TT");
                break;
            }
            case 6: {
                listDetailHome6.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2014-1/trongrung1012014_134836.jpg");
                listDetailHome6.add("Các đồng chí lãnh đạo tỉnh tham gia trồng rừng phòng hộ ở xã Vĩnh Hậu A, huyện Hòa Bình, tại lễ phát động trồng rừng nhân kỷ niệm 40 năm Ngày thành lập lực lượng Kiểm lâm Việt Nam (21/5/1973 - 21/5/2013)");
                listDetailHome6.add("Theo Quy hoạch, mục tiêu kinh tế là quản lý, bảo vệ và phát triển rừng của tỉnh đến năm 2020 đạt diện tích 8.938,7 ha đất lâm nghiệp (trong đó đất có rừng là 6.244,2 ha); sử dụng tài nguyên rừng và quỹ đất được quy hoạch cho lâm nghiệp có hiệu quả và bền vững; tập trung đầu tư, phát triển rừng phòng hộ, phòng hộ môi trường và trồng cây phân tán; bảo vệ hệ thống đê biển và các công trình ven biển, cửa sông; phát triển bền vững các mô hình lâm – ngư và ngư – lâm kết hợp, góp phần nâng cao thu nhập, cải thiện đời sống người làm nghề rừng; góp phần phát triển kinh tế - xã hội, ổn định đời sống của cộng đồng dân cư trên địa bàn vùng ven biển và củng cố an ninh, quốc phòng.\n" +
                        "\n" +
                        "Về môi trường, bảo vệ và phát triển hệ sinh thái rừng đặc trưng, tăng cường tính đa dạng sinh học của tài nguyên rừng, phục hồi các hệ sinh thái rừng ngập mặn ven biển; góp phần giảm nhẹ thiên tai, chống xói mòn, giữ nguồn nước, bảo vệ môi trường sống và tạo nguồn thu từ các dịch vụ môi trường. Nâng tỷ lệ che phủ rừng, cây phân tán và cây lâu năm đến năm 2015 đạt 13,54% diện tích tự nhiên; đến năm 2020 đạt 14,70% diện tích tự nhiên và định hướng đến năm 2030 đạt 16,50% diện tích tự nhiên, nâng cao chất lượng rừng, tăng khả năng hấp thụ khí CO2, giảm phát thải khí nhà kính. Giảm đến mức thấp nhất các vi phạm về tài nguyên rừng, hạn chế việc dâng cao mực nước trong các mô hình lâm – ngư kết hợp làm ảnh hưởng đến sự sinh trưởng và phát triển của cây rừng.\n" +
                        "\n" +
                        "Mục tiêu về xã hội là tạo công ăn việc làm, nâng cao nhận thức, năng lực và mức sống của người dân vùng rừng; từng bước tạo điều kiện cho người dân làm nghề rừng có thể sống và gắn bó với rừng (bao gồm cả khu vực chế biến gỗ, lâm sản ngoài gỗ và các làng nghề thủ công mỹ nghệ, dịch vụ du lịch sinh thái), bình quân mỗi năm sử dụng 1.000 lao động.\n" +
                        "\n" +
                        "Thực hiện tốt công tác chăm lo đời sống vật chất, tinh thần cho người làm nghề rừng; đồng thời, có chính sách hỗ trợ trường học, đường, điện, đào tạo nghề, nhằm góp phần giảm nghèo, ổn định dân cư trong rừng phòng hộ ven biển và các khu rừng đặc dụng.\n" +
                        "\n" +
                        "Quy hoạch cũng nêu rõ nhiệm vụ cụ thể đến năm 2020 là bảo vệ diện tích đất lâm nghiệp và diện tích có rừng hiện có 5.840,2 ha (5.426,7 ha đất rừng vùng nội địa và 413,5 ha đất bãi bồi quy hoạch phát triển rừng); trồng rừng 2.226,6 ha, trong đó, trồng rừng phòng hộ ven biển 564 ha, trồng rừng kết hợp hợp khoanh nuôi tái sinh bãi bồi 1.512,6 ha, trồng rừng trên đất trống khu quy hoạch rừng đặc dụng 150 ha, trồng rừng trên đất nuôi tôm quảng canh kết hợp du lịch sinh thái phía trong đê biển Đông đoạn từ chân đê biển Đông đến kênh 130 thuộc huyện Đông Hải và huyện Hòa Bình 275 ha, trồng rừng phòng hộ môi trường, bảo vệ kết cấu hạ tầng, trồng cây phân tán 30 triệu cây.\n" +
                        "\n" +
                        "Đến năm 2020, nuôi dưỡng nâng cao chất lượng rừng 1.037,4 ha; việc phát triển rừng phòng hộ môi trường (trồng cây xanh) mỗi năm cung cấp cho thị trường 7.540 – 11.310 m3gỗ xây dựng và 45.000 m3 củi; giá trị sản xuất (theo giá hiện hành) đạt khoảng 60 tỷ đồng năm 2015 và 90 tỷ đồng năm 2020; xây dựng mới 1 nhà máy chế biến gỗ và lâm sản tại khu công nghiệp Trà Kha, Phường 8, thành phố Bạc Liêu với công suất thiết kế 3.000 m3 gỗ/năm.\n" +
                        "\n" +
                        "Ngoài ra, còn xây dựng 1 vườn ươm, diện tích 3 ha tại rừng phòng hộ ven biển và 2 khu rừng giống trên lâm phần rừng phòng hộ ven biển; đầu tư xây dựng các hệ thống kết cấu hạ tầng phục vụ bảo vệ và phát triển rừng gồm: xây dựng lại 9 Trạm Kiểm lâm bảo vệ rừng phòng hộ ven biển, 1 Đội Kiểm lâm cơ động và Phòng cháy chữa cháy rừng số 1 và 1 Hạt Kiểm lâm liên huyện rừng phòng hộ biển Đông.\n" +
                        "\n" +
                        "Tổng nhu cầu vốn đầu tư là 198 tỷ đồng, trong đó: giai đoạn 2014 - 2015 là 115 tỷ; giai đoạn 2016 -2020 là 83 tỷ.");
                listDetailHome6.add("L.Đ");
                break;
            }
            case 7:{
                //
                listDetailHome7.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/uy%20ban%20an%20toan%20gt2232018_9574.jpg");
                listDetailHome7.add("Ông Khuất Việt Hùng, Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia phát biểu tại buổi làm việc");
                listDetailHome7.add("Tiếp và làm việc với Đoàn có đồng chí Phan Như Nguyện, Phó Chủ tịch UBND tỉnh; Ngô Hữu Dũng, Giám đốc Sở Giao thông vận tải, Phó Trưởng Ban  Thường trực Ban ATGT tỉnh và đại diện Lãnh đạo các sở, ngành liên quan.");
                listDetailHome7.add("Theo báo cáo của Ban ATGT tỉnh, trong 02 tháng đầu năm 2018, toàn tỉnh xảy ra 11 vụ tai nạn giao thông (TNGT) làm chết 08 người, bị thương 08 người, tổng thiệt hại tài sản ước tính 36 triệu đồng. Riêng trong 07 ngày nghỉ Tết Nguyên đán Mậu Tuất 2018, toàn tỉnh xảy ra 01 vụ TNGT, làm bị thương 01 người, giảm cả 03 tiêu chí so với 07 ngày nghỉ Tết Nguyên đán Đinh Dậu 2017. Tại các Lễ hội Xuân năm 2018 không xảy ra ùn tắc giao thông và TNGT.");
                listDetailHome7.add("Bên cạnh đó, công tác đảm bảo trật tự ATGT trên địa bàn tỉnh vẫn còn gặp nhiều khó khăn, trở ngại như: Hiệu lực, hiệu quả của công tác tuần tra, kiểm soát, xử lý vi phạm của các lực lượng thực thi công vụ tuy đã được nâng cao nhưng chưa đáp ứng được yêu cầu nhiệm vụ; công tác quản lý phương tiện và người lái phương tiện đường thủy nội địa còn gặp nhiều khó khăn; trên tuyến Quốc lộ 1, tại khu vực Nhà thờ Tắc Sậy, lưu lượng khách đến đây hàng ngày rất đông, thường xảy ra ùn tắc giao thông cục bộ…");
                listDetailHome7.add("Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia - Khuất Việt Hùng đánh giá cao nỗ lực của tỉnh trong việc thực hiện nhiệm vụ đảm bảo trật tự ATGT trong thời gian qua. Tuy nhiên, ông cũng lưu ý để giảm số vụ TNGT và số người chết do TNGT, Bạc Liêu cần rà soát lại những “Điểm đen” thường xảy ra TNGT để có hướng xử lý, khắc phục kịp thời; tăng cường công tác tuyên truyền về Luật Giao thông đường bộ cho mọi tầng lớp nhân dân. Nghiên cứu và có thể cho lắp hệ thống camera trên các trục đường chính để giám sát việc chấp hành Luật Giao thông đường bộ… Ông cũng nhắc nhở trong dịp Lễ hội Nghinh Ông sắp tới tại  huyện Đông Hải, Ban Tổ chức Lễ hội cần có kế hoạch tổ chức thật an toàn để bảo đảm trật tự ATGT./.");
                listDetailHome7.add("Nghiệp - Hình");
                break;
            }
            case 8:{
                //
                listDetailHome8.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/hoi%20nghi%20chuyen%20de2452018_83311.jpg");
                listDetailHome8.add("Bí thư Tỉnh ủy Nguyễn Quang Dương phát biểu chỉ đạo Hội nghị");
                listDetailHome8.add("Phát biểu khai mạc Hội nghị, Chủ tịch UBND tỉnh Dương Thành Trung nhấn mạnh vai trò quan trọng của công tác tiếp công dân, giải quyết khiếu nại, tố cáo nhằm đảm bảo quyền và lợi ích chính đáng của công dân, củng cố niềm tin của nhân dân đối với chính quyền và góp phần nâng cao hiệu lực, hiệu quả quản lý nhà nước.");
                listDetailHome8.add("Trong những năm qua, công tác tiếp dân, giải quyết đơn thư khiếu nại, tố cáo luôn được tỉnh quan tâm, chỉ đạo và đạt được nhiều kết quả quan trọng. Từ năm 2015 đến Quý I năm 2018, các ngành, các cấp đã tích cực tham mưu giải quyết 1.818/1.883 vụ thuộc thẩm quyền, đạt tỷ lệ 96,5%.");
                listDetailHome8.add("Tại Hội nghị, các tham luận tập trung đề cập tới những khó khăn, bất cập cũng như kiến nghị giải quyết liên quan tới thủ tục cấp đổi, cấp lần đầu giấy chứng nhận quyền sử dụng đất, đền bù, giải phóng mặt bằng. Đồng thời, các tham luận cũng đưa ra nhiều giải pháp tăng cường lãnh đạo, chỉ đạo công tác tiếp công dân, giải quyết khiếu nại, tố cáo và phòng, chống tham nhũng; tăng cường phối hợp giữa các phòng, ban chuyên môn với các phường, xã để giải quyết dứt điểm các vụ việc tại cấp cơ sở; thực hiện công khai, minh bạch, khách quan và dân chủ trong giải quyết công việc và công tác cán bộ; tăng cường đối thoại giữa lãnh đạo tỉnh với công dân; phát huy vai trò của các cơ quan thông tin đại chúng trong phòng, chống tham nhũng, lãng phí...");
                listDetailHome8.add("Phát biểu chỉ đạo Hội nghị, đồng chí Nguyễn Quang Dương, Ủy viên BCH Trung ương Đảng, Bí thư Tỉnh ủy đã ghi nhận những kết quả mà các cấp, các ngành đã đạt được trong công tác giải quyết khiếu nại tố cáo trên địa bàn tỉnh. Đồng chí đề nghị, trong thời gian tới, các cấp, các ngành trong quá trình giải quyết khiếu nại, tố cáo cần tập trung tìm nguyên nhân để có hướng giải quyết cho phù hợp; xử lý nghiêm các cán bộ có sai phạm dẫn đến khiếu nại, tố cáo của người dân; đối với các vụ khiếu nại, tố cáo phức tạp kéo dài, phải có phương pháp và kế hoạch giải quyết từng vụ; cố gắng giải quyết các vụ khiếu nại, tố cáo ngay tại cơ sở./.");
                listDetailHome8.add("Đức Hình");
                break;
            }
            case 9:{
                listDetailHome9.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20nghi%20trien%20khai%20VBPL1342018_84612.jpg");
                listDetailHome9.add("Đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp phát biểu khai mạc Hội nghị");
                listDetailHome9.add("Phát biểu khai mạc Hội nghị, đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp cho biết Hội nghị sẽ triển khai nội dung về hướng dẫn trình tự, thủ tục trong xử lý vi phạm hành chính; một số nội dung cơ bản của Luật Đấu giá tài sản và Nghị định số 62/2017/NĐ-CP ngày 16/5/2014 của Chính phủ quy định chi tiết một số điều và biện pháp thi hành Luật Đấu giá tài sản; nội dung cơ bản của Luật Hộ tịch, công tác chứng thực, lý lịch tư pháp....");
                listDetailHome9.add("Hội nghị triển khai các văn bản pháp luật nhằm nâng cao nhận thức, tinh thần trách nhiệm, tính chủ động của Lãnh đạo các cơ quan, đơn vị, cán bộ, công chức trong công tác quản lý nhà nước về hộ tịch, công tác thi hành Luật Đấu giá, xử lý vi phạm hành chính. Hội nghị tập huấn lần này diễn ra trong 1,5 ngày, từ ngày 10/4 đến hết buổi sáng ngày 11/4./.");
                listDetailHome9.add("Đức Hình");
                break;
            }
            case 10:{
                listDetailHome10.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20dong%20nhan%20dan242018_103857.jpg");
                listDetailHome10.add("Ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh phát biểu tại buổi làm việc");
                listDetailHome10.add("Nhìn chung, người dân địa phương khá hài lòng về công tác CCHC của địa phương, đa số các thủ tục được giải quyết kịp thời, đúng thời hạn. Tuy nhiên, vẫn có ý kiến đóng góp về sự chậm trễ ở lĩnh vực đất đai, xác nhận hồ sơ người có công… Để khắc phục sự chậm trễ như đã qua, UBND xã Ninh Hòa kiến nghị với Đoàn một số nội dung như: Có cơ chế hỗ trợ về cơ sở vật chất, trang thiết bị đối với bộ phận một cửa; tổ chức các lớp tập huấn nâng cao nghiệp vụ cho cán bộ, công chức phụ trách Bộ phận tiếp nhận và trả kết quả; hỗ trợ để xã được cập nhật và triển khai các văn bản mới…");
                listDetailHome10.add("Buổi chiều cùng ngày, Đoàn giám sát làm việc với UBND huyện Hồng Dân về công tác cải cách hành chính của huyện, giai đoạn 2015 - 2017. Theo báo cáo đánh giá cho thấy, huyện Hồng Dân đã nghiêm túc thực hiện các quy định về kỷ luật, kỷ cương hành chính tại cơ quan, đơn vị; giải quyết nhanh chóng, đúng quy định các thủ tục hành chính cho tổ chức, công dân; tổ chức tiếp nhận, xử lý phản ánh, kiến nghị của cá nhân, tổ chức theo quy định; công khai minh bạch các thủ tục hành chính trên tất cả các lĩnh vực tại trụ sở cơ quan, bộ phận tiếp nhận và trả kết quả theo cơ chế một cửa của huyện; hầu hết các đơn vị xã, thị trấn đều đạt điểm hài lòng của người dân về dân chủ cơ sở từ 56 - 60/60 điểm; mức độ hài lòng của người dân về tính công khai, minh bạch của các đơn vị đạt 69/70 điểm…");
                listDetailHome10.add("Ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh ghi nhận kết quả cải cách hành chính của huyện trong thời gian qua, đồng thời, đề nghị UBND huyện lưu ý việc tăng cường trách nhiệm của cấp ủy, người đứng đầu trong thực hiện công tác cải cách hành chính; cần có kế hoạch thu gọn một số thủ tục rườm rà; chấn chỉnh việc niêm yết, công bố các thủ tục hành chính mới theo hướng công khai, đơn giản và thuận tiện cho người dân; huyện cần quan tâm hơn nữa công tác giáo dục, tuyên truyền cho cán bộ, công chức về tinh thần, trách nhiệm, chấp hành kỷ cương, kỷ luật trong thực hiện công vụ; đặc biệt, huyện phải quan tâm, phát huy tốt hiệu quả Trung tâm hành chính công của huyện./.");
                listDetailHome10.add("Ngọc Hiền");
                break;
            }
            case 11:{
                listDetailHome11.add("Thực hiện chủ đề Năm an toàn giao thông 2015 “Siết chặt quản lý kinh doanh vận tải và kiểm soát tải trọng phương tiện” với mục tiêu “Tính mạng con người là trên hết”, Kế hoạch đề ra một số nhiệm vụ trọng tâm như: Tăng cường sự lãnh đạo, chỉ đạo thường xuyên của cấp ủy đảng, chính quyền, các ngành, các tổ chức đoàn thể từ tỉnh đến cơ sở đối với công tác bảo đảm TTATGT, chống ùn tắc giao thông.");
                listDetailHome11.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2015-3/NamATGT2632015_16515.jpg");
                listDetailHome11.add("Lực lượng ĐVTN ra quân hưởng ứng Năm ATGT 2015");
                listDetailHome11.add("Ngoài ra, tập trung tuyên truyền, phổ biến quy định pháp luật về quản lý hoạt động vận tải khách và hàng hóa ở các lĩnh vực đường bộ, đường thủy nội địa đến các cơ quan, đơn vị, doanh nghiệp vận tải, người điều khiển phương tiện. Đổi mới công tác tuyên truyền, phổ biến, giáo dục pháp luật về TTATGT tới mọi tầng lớp nhân dân để nâng cao ý thức tự giác chấp hành pháp luật khi tham gia giao thông, đẩy mạnh xây dựng văn hóa giao thông.\n" +
                        "\n" +
                        "Tiếp tục nâng cao năng lực hiệu quả quản lý nhà nước trong lĩnh vực bảo đảm TTATGT. Trong đó, chú trọng công tác quản lý hoạt động vận tải, quản lý việc đào tạo, sát hạch cấp giấy phép lái xe, đăng ký, đăng kiểm phương tiện giao thông. Đẩy mạnh tiến độ, siết chặt quản lý chất lượng các công trình kết cấu hạ tầng giao thông; xây dựng và tổ chức thực hiện có hiệu quả kế hoạch bảo trì, bảo dưỡng kết cấu hạ tầng giao thông; nghiên cứu, tổ chức giao thông khoa học, hợp lý; đẩy nhanh rà soát, lắp đặt hệ thống biển báo phù hợp với quy chuẩn kỹ thuật quốc gia về báo hiệu đường bộ; thường xuyên rà soát và khắc phục kịp thời các điểm đen, vị trí mất ATGT.\n" +
                        "\n" +
                        "Đẩy mạnh hoạt động tuần tra, kiểm soát và xử lý các hành vi vi phạm TTATGT. Tăng cường kiểm tra, xử lý nghiêm các hành vi vi phạm của xe chở khách, hành vi chở quá tải trọng phương tiện trong vận tải hàng hóa. Tăng cường thanh tra, kiểm tra, xử lý nghiêm các hành vi sai phạm của người thực thi công vụ trong khi làm nhiệm vụ.\n" +
                        "\n" +
                        "Ngoài ra, tiếp tục nhân rộng các mô hình an toàn giao thông; đầu tư camera quan sát giao thông, nhận dạng biển số đen, xử lý vi phạm tốc độ, vượt đèn đỏ; nâng cao hiệu quả quản lý trật tự lòng đường, vỉa hè, hành lang an toàn giao thông đường bộ, hành lang an toàn giao thông đường thủy");
                listDetailHome11.add("NL");
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
                layoutImage = LayoutInflater.from(DetailDepartmentNewsActivity.this).inflate(R.layout.item_image, loBody, false);

                textView = layoutImage.findViewById(R.id.tvImageText);
                ImageView imgView = layoutImage.findViewById(R.id.imvImage);
                image = listDetailHome.get(i);
                text = listDetailHome.get(i+1);
                //
                textView.setText(text);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizecaptionImage);
                Picasso.with(DetailDepartmentNewsActivity.this).load(image).into(imgView);

                loBody.addView(layoutImage);
                i++;

            } else {
                layoutText = LayoutInflater.from(DetailDepartmentNewsActivity.this).inflate(R.layout.item_text, loBody, false);

                textView = (TextView) layoutText.findViewById(R.id.tvText);

                textView.setText(listDetailHome.get(i));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizeContent);

                loBody.addView(layoutText);
            }
        }
        //author
        layoutAuthor = LayoutInflater.from(DetailDepartmentNewsActivity.this).inflate(R.layout.item_text, loBody, false);

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
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
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