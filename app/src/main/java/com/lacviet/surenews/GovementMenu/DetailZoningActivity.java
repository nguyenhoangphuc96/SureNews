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

public class DetailZoningActivity extends AppCompatActivity {
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
    //
    String baseSrcUrl = "http://congthongtin.bioportal.vn";
    String baseSrcUrlOld = "http://baclieu.gov.vn";
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
                listDetailHome1.add("Kế hoạch đề ra một số chỉ tiêu như: Phấn đấu đến năm 2020, có trên 50% lực lượng lao động tham gia bảo hiểm xã hội; trên 35% lực lượng lao động tham gia bảo hiểm thất nghiệp và trên 80% dân số tham gia bảo hiểm y tế.\n" +
                        "\n" +
                        "Về chính sách ưu đãi người có công, phấn đấu đến năm 2020 hoàn thành dứt điểm công tác rà soát công nhận bổ sung các đối tượng chính sách người có công trong tỉnh; Tiếp tục phụng dưỡng Bà Mẹ Việt Nam anh hùng; phấn đấu 100% hộ gia đình chính sách có mức sống bằng hoặc cao hơn mức sống trung bình khu dân cư; cơ bản hoàn thành việc hỗ trợ nhà ở cho các đối tượng chính sách, người có công gặp khó khăn về nhà ở");
                listDetailHome1.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-7/trao-nha2972013_91022.jpg");
                listDetailHome1.add("Trao tặng nhà tình nghĩa cho gia đình thương binh Lê Văn Thính ngụ ấp Bà Ai II, xã Lộc Ninh, huyện Hồng Dân.\n" +
                        "Ảnh: www.baclieu.gov.vn");
                listDetailHome1.add("Ngoài ra, đầu tư sửa chữa nâng cấp, xây dựng mới các công trình ghi công liệt sĩ, nghĩa trang liệt sĩ các huyện để trở thành những công trình văn hóa lịch sử của tỉnh; thực hiện tốt chủ trương tham gia tìm kiếm, quy tập hài cốt lịch sử\n" +
                        "\n" +
                        "Với các chỉ tiêu trên, nhiệm vụ, giải pháp được xác định là: Tăng cường công tác quản lý nhà nước, đẩy mạnh công tác tuyên truyền, phổ biến quan điểm, chính sách pháp luật, tăng cường công tác thanh tra, kiểm tra về cải cách chính sách tiền lương, bảo hiểm xã hội, trợ cấp ưu đãi người có công. Trong đó: tổ chức rà soát, đánh giá chất lượng đội ngũ cán bộ, công chức, viên chức để thực hiện chính sách tinh giảm biên chế; đẩy mạnh xã hội hóa dịch vụ BHXH, chuyển các loại hình trợ giúp xã hội sang cung cấp dịch vụ bảo trợ xã hội dựa vào cộng đồng, bảo đảm các đối tượng bảo trợ xã hội có cuộc sống ổn định; Triển khai thực hiện tốt Pháp lệnh ưu đãi người có công với cách mạng; giải quyết kịp thời các chính sách ưu đãi, hỗ trợ với người có công và thân nhân về điều kiện phát triển , sản xuất, ưu tiên sắp xếp việc làm và tiếp cận các dịch vụ xã hội cơ bản, nhất là y tế, giáo dục, đào tạo.");
                listDetailHome1.add("V.T");
                break;
            }
            case 2: {
                listDetailHome2.add("Chương trình dự trữ hàng hóa bình ổn giá vào dịp Tết Nguyên đán Giáp Ngọ năm 2014 trên địa bàn tỉnh Bạc Liêu được thực hiện từ ngày 17/12/2013 đến ngày 03/3/2014, nhằm bình ổn thị trường nhân dịp Tết Nguyên đán Giáp Ngọ năm 2014, góp phần cân đối cung cầu hàng hóa, đáp ứng nhu cầu của nhân dân, nhất là các mặt hàng thiết yếu, từ đó hạn chế tốc độ tăng giá, kiềm chế lạm phát, thúc đẩy sản xuất – kinh doanh phát triển, bảo đảm an sinh xã hội trên địa bàn tỉnh trong dịp Tết Nguyên đán Giáp Ngọ năm 2014.");
                listDetailHome2.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-12/hang_binh_on_120122013_143459.jpg");
                listDetailHome2.add("Ảnh minh họa.");
                listDetailHome2.add("Theo Kế hoạch, các hàng hóa trong danh mục của Chương trình gồm: Lương thực (gạo tẻ, gạo nếp); Thực phẩm (dầu ăn, nước chấm, gia vị, thịt gia súc, gia cầm, trứng gia cầm, các sản phẩm chế biến từ sản phẩm gia súc, gia cầm, bánh, kẹo, mứt, nước giải khát, đường ăn, bột ngọt, sữa, rau, củ, quả; thực phẩm đông lạnh, trữ mát, đóng hộp, hàng công nghệ; mì gói, mì ly, cháo gói, phở, hủ tiếu, bún gói)…\n" +
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
                listDetailHome2.add("TT");
                break;
            }
            case 3: {
                listDetailHome3.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2014-1/trongrung1012014_134836.jpg");
                listDetailHome3.add("Các đồng chí lãnh đạo tỉnh tham gia trồng rừng phòng hộ ở xã Vĩnh Hậu A, huyện Hòa Bình, tại lễ phát động trồng rừng nhân kỷ niệm 40 năm Ngày thành lập lực lượng Kiểm lâm Việt Nam (21/5/1973 - 21/5/2013)");
                listDetailHome3.add("Theo Quy hoạch, mục tiêu kinh tế là quản lý, bảo vệ và phát triển rừng của tỉnh đến năm 2020 đạt diện tích 8.938,7 ha đất lâm nghiệp (trong đó đất có rừng là 6.244,2 ha); sử dụng tài nguyên rừng và quỹ đất được quy hoạch cho lâm nghiệp có hiệu quả và bền vững; tập trung đầu tư, phát triển rừng phòng hộ, phòng hộ môi trường và trồng cây phân tán; bảo vệ hệ thống đê biển và các công trình ven biển, cửa sông; phát triển bền vững các mô hình lâm – ngư và ngư – lâm kết hợp, góp phần nâng cao thu nhập, cải thiện đời sống người làm nghề rừng; góp phần phát triển kinh tế - xã hội, ổn định đời sống của cộng đồng dân cư trên địa bàn vùng ven biển và củng cố an ninh, quốc phòng.\n" +
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
                listDetailHome3.add("L.Đ");
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
            case 8:{
                listDetailHome8.add("Thực hiện chủ đề Năm an toàn giao thông 2015 “Siết chặt quản lý kinh doanh vận tải và kiểm soát tải trọng phương tiện” với mục tiêu “Tính mạng con người là trên hết”, Kế hoạch đề ra một số nhiệm vụ trọng tâm như: Tăng cường sự lãnh đạo, chỉ đạo thường xuyên của cấp ủy đảng, chính quyền, các ngành, các tổ chức đoàn thể từ tỉnh đến cơ sở đối với công tác bảo đảm TTATGT, chống ùn tắc giao thông.");
                listDetailHome8.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2015-3/NamATGT2632015_16515.jpg");
                listDetailHome8.add("Lực lượng ĐVTN ra quân hưởng ứng Năm ATGT 2015");
                listDetailHome8.add("Ngoài ra, tập trung tuyên truyền, phổ biến quy định pháp luật về quản lý hoạt động vận tải khách và hàng hóa ở các lĩnh vực đường bộ, đường thủy nội địa đến các cơ quan, đơn vị, doanh nghiệp vận tải, người điều khiển phương tiện. Đổi mới công tác tuyên truyền, phổ biến, giáo dục pháp luật về TTATGT tới mọi tầng lớp nhân dân để nâng cao ý thức tự giác chấp hành pháp luật khi tham gia giao thông, đẩy mạnh xây dựng văn hóa giao thông.\n" +
                        "\n" +
                        "Tiếp tục nâng cao năng lực hiệu quả quản lý nhà nước trong lĩnh vực bảo đảm TTATGT. Trong đó, chú trọng công tác quản lý hoạt động vận tải, quản lý việc đào tạo, sát hạch cấp giấy phép lái xe, đăng ký, đăng kiểm phương tiện giao thông. Đẩy mạnh tiến độ, siết chặt quản lý chất lượng các công trình kết cấu hạ tầng giao thông; xây dựng và tổ chức thực hiện có hiệu quả kế hoạch bảo trì, bảo dưỡng kết cấu hạ tầng giao thông; nghiên cứu, tổ chức giao thông khoa học, hợp lý; đẩy nhanh rà soát, lắp đặt hệ thống biển báo phù hợp với quy chuẩn kỹ thuật quốc gia về báo hiệu đường bộ; thường xuyên rà soát và khắc phục kịp thời các điểm đen, vị trí mất ATGT.\n" +
                        "\n" +
                        "Đẩy mạnh hoạt động tuần tra, kiểm soát và xử lý các hành vi vi phạm TTATGT. Tăng cường kiểm tra, xử lý nghiêm các hành vi vi phạm của xe chở khách, hành vi chở quá tải trọng phương tiện trong vận tải hàng hóa. Tăng cường thanh tra, kiểm tra, xử lý nghiêm các hành vi sai phạm của người thực thi công vụ trong khi làm nhiệm vụ.\n" +
                        "\n" +
                        "Ngoài ra, tiếp tục nhân rộng các mô hình an toàn giao thông; đầu tư camera quan sát giao thông, nhận dạng biển số đen, xử lý vi phạm tốc độ, vượt đèn đỏ; nâng cao hiệu quả quản lý trật tự lòng đường, vỉa hè, hành lang an toàn giao thông đường bộ, hành lang an toàn giao thông đường thủy");
                listDetailHome8.add("NL");
            }
            case 9:{
                listDetailHome9.add(baseSrcUrlOld+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/xa%20hung%20hoi%2011262018_144430.jpg");
                listDetailHome9.add("Đường liên ấp của xã Hưng Hội được bê-tông hóa.");
                listDetailHome9.add(baseSrcUrlOld+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/xa%20hung%20hoi%2021262018_14452.jpg");
                listDetailHome9.add("Xã Hưng Hội làm lộ giao thông nông thôn. Ảnh: C.L");
                listDetailHome9.add("Là xã có khá đông đồng bào Khmer sinh sống, đời sống kinh tế của người dân còn gặp nhiều khó khăn, vì vậy khi thực hiện phong trào xây dựng nông thôn mới (XDNTM) xã Hưng Hội có xuất phát điểm khá thấp. Song, nhờ sự nỗ lực của địa phương và sự đồng tình hưởng ứng của người dân, đến cuối tháng 5/2018, xã Hưng Hội đã đạt 14/19 tiêu chí XDNTM. Còn 5 tiêu chí chưa đạt là: Quy hoạch, thủy lợi, điện, bưu điện, nhà ở dân cư và thu nhập. Tuy nhiên, các tiêu chí này đã thực hiện được nhiều tiểu mục.");
                listDetailHome9.add("Từ đầu năm đến nay, xã Hưng Hội đã thi công 3 tuyến lộ bê-tông với chiều dài 610m, sửa chữa một tuyến lộ nhựa dài 1.900m. Tổng kinh phí thực hiện các công trình hơn 232 triệu đồng, trong đó, người dân đóng góp hơn một nửa. Ông Hứa Sa Thi (ấp Cái Giá, xã Hưng Hội) bày tỏ: “Trước đây, con lộ trước nhà tôi sình lầy, khó đi lắm. Khi chính quyền đến vận động làm lộ bê-tông, bà con rất phấn khởi và đóng góp tiền, ngày công cùng với chính quyền xây dựng hoàn thành công trình”. Ngoài ra, từ nguồn vốn hỗ trợ gần 2 tỷ đồng (theo Nghị định 35/NĐ-CP của Thủ tướng Chính phủ), xã đã sên vét 26 tuyến kênh nội đồng, 4 tuyến kênh cấp 3 và làm 6 tuyến lộ bê-tông với chiều dài gần 3km.");
                listDetailHome9.add("Để đạt mục tiêu xã nông thôn mới vào cuối năm 2018, cấp ủy, chính quyền xã Hưng Hội đã xây dựng lộ trình cụ thể, xác định nội dung công việc cần thực hiện cũng như giải pháp huy động các nguồn lực. Trong đó, nhiệm vụ trọng tâm là tiếp tục hoàn thiện hệ thống giao thông nông thôn, giao thông nội đồng và kênh mương phục vụ sản xuất nông nghiệp. Triển khai xây nhà văn hóa xã, khu xử lý rác thải tập trung và xây trường học đạt chuẩn, góp phần nâng cao dân trí cho người dân");
                listDetailHome9.add("Ông Trương Thuôl (ấp Cái Giá, xã Hưng Hội) chia sẻ: “Từ khi thực hiện chương trình XDNTM, đời sống người dân trong xã được nâng lên rất nhiều. Trường học được xây dựng khang trang; lưới điện được kéo về mang ánh sáng đến mọi nhà; đường làng, ngõ xóm xanh - sạch - đẹp, được bê-tông hóa, giúp người dân thuận tiện đi lại, giao thương hàng hóa”.");
                listDetailHome9.add("Song song với việc tập trung hoàn thiện cơ sở hạ tầng nông thôn mới, thời gian qua, cấp ủy, chính quyền xã còn tập trung lãnh đạo phát triển kinh tế, nâng cao thu nhập cho người dân. Trong sản xuất nông nghiệp, xã tập trung chỉ đạo nông dân áp dụng các tiến bộ khoa học - kỹ thuật vào sản xuất, luân canh tăng vụ, chuyển đổi cơ cấu giống cây trồng, chuyển giao nhiều mô hình mới như trồng rau trong nhà lưới, sản xuất rau an toàn… Một số hộ chuyển sang trồng màu cho thu nhập gấp 2 - 3 lần trồng lúa");
                listDetailHome9.add("Bên cạnh những kết quả đạt được trong sản xuất nông nghiệp và xây dựng cơ sở hạ tầng, đời sống văn hóa của người dân xã Hưng Hội cũng không ngừng được nâng cao. Chính quyền xã thường xuyên tuyên truyền, vận động bà con thực hiện tốt hương ước, quy ước xây dựng nếp sống văn hóa tại khu dân cư; việc cưới, việc tang và lễ hội được tổ chức tiết kiệm, tránh lãng phí; ý thức, trách nhiệm cộng đồng của người dân ngày càng được nâng cao.");
                listDetailHome9.add("Theo ông Lâm Anh Tuấn, Chủ tịch UBND xã Hưng Hội: “Để hoàn thành 19/19 tiêu chí XDNTM trong năm 2018, nguồn kinh phí thực hiện các công trình, phần việc còn lại khá lớn. Vì vậy, xã sẽ tranh thủ sự hỗ trợ của tỉnh, huyện, đồng thời huy động nguồn vốn xã hội hóa cùng với ngân sách xã để thực hiện hoàn thành các tiêu chí XDNTM”.");
                listDetailHome9.add("Chí Linh-BBL");
                listDetailHome9.add("Nguồn: baobaclieu.vn");
                break;
            }
            case 10:{
                //
                listDetailHome10.add(baseSrcUrlOld+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/chu%20tich2632018_92056.jpg");
                listDetailHome10.add("Chủ tịch UBND tỉnh - Dương Thành Trung (bìa trái) trao bằng công nhận xã Định Thành đạt chuẩn NTM. Ảnh: C.L");
                listDetailHome10.add("Từ năm 2011 đến nay, tổng kinh phí triển khai thực hiện chương trình xây dựng NTM đạt trên 150 tỷ đồng, trong đó: vốn ngân sách Trung ương hơn 4,1 tỷ đồng, vốn ngân sách tỉnh, huyện trên 67 tỷ đồng, vốn ngân sách xã là 0,7 tỷ đồng, vốn tín dụng hơn 1 tỷ đồng, vốn nhân dân đóng góp gần 66,5 tỷ đồng, nguồn vốn vận động doanh nghiệp gần 2 tỷ đồng và vốn lồng ghép trên 8,7 tỷ đồng. Báo cáo tại buổi lễ, ông Nguyễn Hoàng Ly - Bí thư Đảng ủy, Chủ tịch UBND xã Định Thành cho biết, nhiều năm qua Đảng bộ, chính quyền và nhân dân luôn tích cực tập trung tuyên truyền, vận động người dân thực hiện phong trào xây dựng NTM. Trong đó, việc đầu tư phát triển, hoàn thiện cơ sở hạ tầng thiết yếu nhằm phục vụ phát triển sản xuất, nâng cao đời sống của người dân cũng là lĩnh vực được địa phương chú trọng quan tâm trong quá trình xây dựng NTM");
                listDetailHome10.add("Phát biểu tại buổi lễ, ông Dương Thành Trung - Chủ tịch UBND tỉnh, chúc mừng kết quả mà Đảng bộ, chính quyền và nhân dân xã Định Thành đã đạt được trong phong trào xây dựng NTM. Đồng thời, đề nghị địa phương tiếp tục giữ vững các tiêu chí và phấn đấu đạt chuẩn xã NTM kiểu mẫu trong thời gian tới, nhất là đề ra các chủ trương, giải pháp để ngày càng nâng cao mức sống cho người dân; tạo điều kiện phát triển các mô hình kinh tế hiệu quả giúp người dân nâng cao thu nhập; đặc biệt là cần làm rõ vai trò, nhiệm vụ và lợi ích của người dân trong xây dựng NTM.");
                listDetailHome10.add("Nhân dịp này, UBND tỉnh đã trao bằng khen cho 1 tập thể và 7 cá nhân có thành tích xuất sắc trong phong trào xây dựng NTM của địa phương. Ủy ban MTTQ Việt Nam tỉnh tặng 1 căn nhà đại đoàn kết trị giá 25 triệu đồng.");
                listDetailHome10.add("Nguồn: Báo Bạc Liêu");
                break;
            }
            case 11:{
                //
                listDetailHome11.add("Trong Tháng Thanh niên, các cấp bộ Đoàn tích cực tuyên truyền và vận động nhân dân tham gia xây dựng nông thôn mới theo các tiêu chí cụ thể, đồng thời tổ chức ra quân phát quang các tuyến đường liên xã dài hơn 23 km; cắt tỉa hàng rào cây xanh; tu sửa hơn 22 km đường giao thông nông thôn; đắp 10 móng cầu bê tông; xây dựng 03 cây cầu giao thông nông thôn; sửa chữa 36 cây cầu gỗ và bê tông. Bên cạnh đó, phối hợp với các ngành chức năng tổ chức hơn 130 cuộc ra quân lập lại trật tự đô thị, tuyên truyền nhắc nhở các hộ dân trên địa bàn đô thị không buôn bán, đậu xe lấn chiếm vỉa hè với hơn 4.300 lực lượng đoàn viên thanh niên (ĐVTN) tham gia.");
                listDetailHome11.add(baseSrcUrlOld+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/20-4-2017Untitled-12042017_92227.jpg");
                listDetailHome11.add("Tuổi trẻ Bạc Liêu thực hiện những công trình, phần việc thiết thực (ảnh KV)");
                listDetailHome11.add("Phát huy tinh thần xung kích, tình nguyện của tuổi trẻ tham gia bảo vệ môi trường, trong Tháng Thanh niên, các cấp bộ Đoàn tổ chức nhiều buổi ra quân dọn vệ sinh và tuyên truyền về nước sạch, vệ sinh môi trường, trồng 4.500 cây xanh các loại; vận động nhân dân tháo dỡ hơn 300 nhà vệ sinh trên sông, ao đìa; thu gom xử lý 16 tấn rác thải; xây dựng 18 nhà tiêu hợp vệ sinh. Ngoài ra, các cấp bộ Đoàn cũng triển khai thực hiện quyết liệt những hoạt động chăm lo, hỗ trợ thanh thiếu nhi và an sinh xã hội: Tổ chức 05 buổi tư vấn hướng nghiệp và giới thiệu việc làm cho hơn 1.200 ĐVTN; tặng hơn 400 suất quà cho gia đình chính sách và hộ nghèo; tặng quà và học bổng cho các em học sinh có hoàn cảnh khó khăn với tổng trị giá 430 triệu đồng; khám chữa bệnh và cấp phát thuốc miễn phí cho 950 gia đình chính sách, hộ nghèo, người già neo đơn, gia đình có hoàn cảnh khó khăn.");
                listDetailHome11.add("Đồng chí Trương Hồng Trang, nguyên Bí Thư Tỉnh Đoàn khẳng định: Tổ chức các phong trào hành động, các công trình, phần việc cụ thể, thiết thực trong Tháng Thanh niên đã giúp tuổi trẻ Bạc Liêu phát huy vai trò, khả năng, tinh thần tình nguyện, sức sáng tạo của tuổi trẻ trong xây dựng nông thôn mới và văn minh đô thị. Qua đó, tạo được hình ảnh đẹp về thế hệ thanh niên thời kỳ mới, dám dấn thân vào những việc mới, việc khó để thực hiện nhiệm vụ xây dựng và bảo vệ quê hương, đất nước.");
                listDetailHome11.add("Khánh Vy");
                break;
            }
            case 12:{
                //
                listDetailHome12.add(baseSrcUrlOld+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/NTM2042017_7429.jpg");
                listDetailHome12.add("Một trong những khu dân cư tiêu biểu của xã Vĩnh Bình (huyện Hòa Bình) nhờ thực hiện cuộc vận động xây dựng nông thôn mới, đô thị văn minh. Ảnh: X.T");
                listDetailHome12.add("Với tinh thần chủ động, hàng năm MTTQ Việt Nam huyện Hòa Bình đều đề ra kế hoạch và phát động nhiều phong trào thi đua yêu nước: “Toàn dân đoàn kết xây dựng đời sống văn hóa ở khu dân cư gắn với XDNTM”, thi đua thực hiện các nhiệm vụ trọng tâm của huyện về phát triển kinh tế, giảm nghèo, vệ sinh môi trường, đảm bảo an ninh trật tự, tham gia hưởng ứng “Ngày Vì người nghèo”…");
                listDetailHome12.add("Ông Hứa Ngọc Thoanh, Chủ tịch Ủy ban MTTQ Việt Nam huyện Hòa Bình, cho biết: Qua các phong trào thi đua do MTTQ huyện phát động đã phát huy được sức mạnh và tinh thần đoàn kết, tự quản của nhân dân, tạo động lực cho phát triển kinh tế, góp phần thực hiện chính sách giảm nghèo, đền ơn đáp nghĩa, nâng cao ý thức tự giác của nhân dân trong thực hiện chủ trương, chính sách, pháp luật của Đảng và Nhà nước, phát huy các giá trị truyền thống tốt đẹp của dân tộc, giữ vững an ninh chính trị, trật tự an toàn xã hội, xây dựng hệ thống chính trị vững mạnh...");
                listDetailHome12.add("Để triển khai thực hiện có hiệu quả Đề án số 04/ĐA-MTTW-BTT ngày 28/12/2015 của Ban Thường trực Ủy ban Trung ương MTTQ Việt Nam về tổ chức thực hiện cuộc vận động “Toàn dân đoàn kết XDNTM, đô thị văn minh”; từ năm 2016 đến nay, MTTQ các cấp trong huyện đã tích cực tham mưu với cấp ủy đảng, chính quyền và các tổ chức thành viên triển khai thực hiện nhiều biện pháp, đa dạng các hình thức tuyên truyền, nhằm tiếp tục đạt hiệu quả, chất lượng cao trong thực hiện cuộc vận động. Đồng thời phát động nhiều phong trào thi đua để vận động nông dân tham gia XDNTM, như: tăng cường ứng dụng khoa học - kỹ thuật trong sản xuất nông nghiệp, nâng cao thu nhập, giải quyết việc làm; chủ động tham gia góp phần tích cực thực hiện các tiêu chí về môi trường, giao thông nông thôn, giữ gìn an ninh trật tự… Đồng thời, quan tâm phát hiện, xây dựng các nhân tố điển hình tiên tiến trong các phong trào, kịp thời nhân rộng gương người tốt - việc tốt, làm cho phong trào thi đua ngày càng lan tỏa trong từng cộng đồng dân cư, góp phần để đạt các tiêu chí cơ bản về nông thôn mới, làm thay đổi bộ mặt nông thôn của huyện.");
                listDetailHome12.add("Theo đó, thời gian qua Ủy ban MTTQ Việt Nam huyện Hòa Bình đã thu được những kết quả tích cực như: từ việc làm tốt công tác tuyên truyền, nâng cao nhận thức, các tổ chức, cá nhân đã ủng hộ nhiều tỷ đồng vào quỹ “Vì người nghèo - An sinh xã hội” của địa phương; xây dựng hàng trăm căn nhà đại đoàn kết, nhà tình thương cho hộ nghèo… Bên cạnh đó còn phát động và phối hợp tổ chức tặng quà tết, khám chữa bệnh miễn phí, tặng học bổng, mua thẻ bảo hiểm y tế cho hộ nghèo, trẻ em có hoàn cảnh khó khăn… Từ cuộc vận động không chỉ phát huy tinh thần “tương thân tương ái”, “lá lành đùm lá rách” của các tầng lớp nhân dân, mà còn góp phần động viên, khích lệ hộ nghèo nỗ lực vươn lên ổn định đời sống, chăm lo phát triển sản xuất, thoát nghèo bền vững.");
                listDetailHome12.add("Để phát huy quyền làm chủ của nhân dân, MTTQ các cấp trong huyện đã tăng cường vận động nhân dân tích cực tham gia góp ý xây dựng Đảng, chính quyền; xây dựng hệ thống chính trị ở địa phương, tổng hợp, phản ánh ý kiến, kiến nghị của nhân dân đến cấp ủy đảng, chính quyền các cấp. Đồng thời thường xuyên quan tâm củng cố, nâng cao hiệu quả hoạt động của Ban giám sát đầu tư cộng đồng, góp phần hạn chế lãng phí, tiêu cực, thất thoát, nâng cao chất lượng các công trình XDNTM.");
                listDetailHome12.add("Xuân Thưởng – Báo Bạc Liêu Online");
                break;
            }
            case 13:{
                //
                listDetailHome13.add("Dự họp có đồng chí Dương Thành Trung, Chủ tịch UBND tỉnh và lãnh đạo các sở, ban, ngành, hội, đoàn thể, huyện, thị xã, thành phố.");
                listDetailHome13.add(baseSrcUrlOld+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2016-6/QC962016_16125.jpg");
                listDetailHome13.add("Quang cảnh cuộc họp");
                listDetailHome13.add("Phát biểu tại cuộc họp, Bí thư Tỉnh ủy Lê Minh Khái nhấn mạnh: Chương trình xây dựng nông thôn mới là một trong hai chương trình trọng điểm của quốc gia. Chương trình đã được các cấp, các ngành từ Trung ương đến địa phương xây dựng kế hoạch và triển khai thực hiện chặt chẽ. Kết quả Chương trình đã mang lại nhiều ý nghĩa quan trọng đối với cư dân khu vực nông thôn ở các địa phương, nhất là những tỉnh nông nghiệp như Bạc Liêu.");
                listDetailHome13.add("Qua 5 năm triển khai Chương trình xây dựng nông thôn mới, Bạc Liêu đã đạt được những kết quả bước đầu. Bộ mặt một số khu vực nông thôn trong tỉnh cơ bản được cải thiện, đời sống nhân dân có bước chuyển biến tốt cả vật chất lẫn tinh thần. Chương trình xây dựng nông thôn mới đã huy động sự vào cuộc của cả hệ thống chính trị và sự hưởng ứng nhiệt tình của người dân.");
                listDetailHome13.add("Tính đến cuối năm 2015, Bạc Liêu có 8 xã đạt 19 tiêu chí đã được công nhận nông thôn mới và 2 xã đạt 19 tiêu chí chờ xem xét, công nhận; 9 xã đạt 15-18 tiêu chí, 39 xã đạt 5-14 tiêu chí, không còn xã đạt dưới 5 tiêu chí. Tinh thần tự nguyện, tự giác của người dân đã giúp cho việc thực hiện một số tiêu chí mang tính chất nhân dân làm là chính, nhà nước chỉ hỗ trợ một phần như: tiêu chí nhà ở dân cư, thu nhập, tỷ lệ hộ nghèo… đạt kết quả khá tích cực.");
                listDetailHome13.add("Tuy nhiên trong quá trình thực hiện, tỉnh Bạc Liêu còn gặp một số khó khăn, hạn chế nhất định. Việc xây dựng nông thôn mới cần nhu cầu vốn rất lớn, nhưng thực tế Bạc Liêu vẫn là tỉnh nghèo, với quy mô xã lớn, dân cư thưa thớt, sông ngòi chằng chịt, nền địa chất yếu; doanh nghiệp đầu tư vào khu vực nông nghiệp, nông thôn không nhiều, vốn ngân sách ít nên sự hỗ trợ của Nhà nước có giới hạn, dẫn đến một số tiêu chí cần nhiều vốn đầu tư từ sự hỗ trợ của ngân sách đạt thấp. Kinh phí hàng năm phân bổ cho Chương trình chưa đáp ứng yêu cầu; Các xã mặc dù đã được công nhận đạt chuẩn nông thôn mới, nhưng một số tiêu chí quan trọng chỉ đạt ở mức thấp.");
                listDetailHome13.add("Giai đoạn 2016 – 2020, Bạc Liêu đề ra mục tiêu có 25 xã đạt 19/19 tiêu chí; có 2 huyện đạt chuẩn huyện nông thôn mới. Cùng với việc phấn đấu tăng số xã đạt 19 tiêu chí nông thôn mới, Chương trình xây dựng nông thôn mới của tỉnh Bạc Liêu thời gian tới tập trung  xây dựng và nâng cấp cơ bản hoàn thành các công trình thiết yếu đáp ứng nhu cầu phát triển sản xuất và đời sống cư dân nông thôn; Nâng cao chất lượng cuộc sống của cư dân nông thôn");
                listDetailHome13.add("Bí thư Tỉnh ủy Lê Minh Khái đề nghị: Thời gian tới, khi xây dựng Chương trình xây dựng nông thôn mới giai đoạn 2016 – 2020, các địa phương cần tính toán kỹ, bám sát nội dung Nghị quyết Đại hội Đảng lần thứ XII và Nghị quyết Đại hội Đảng bộ tỉnh lần thứ XV đã đề ra. Chương trình kế hoạch hành động cần tập trung vào một số giải pháp như: hoàn thiện bộ máy Ban Chỉ đạo các cấp, đảm bảo năng lực, thực hiện hiệu quả nhiệm vụ; Ưu tiên thực hiện những tiêu chí không cần nhiều nguồn lực kinh phí để hoàn thành trước, tạo động lực cho việc huy động các nguồn lực đầu tư vào các tiêu chí cần nhiều nguồn kinh phí.");
                listDetailHome13.add("Mục tiêu “đến năm 2020 có hơn 50% số xã trong tỉnh đạt 19 tiêu chí nông thôn mới” được xác định là mục tiêu lớn, dự báo gặp nhiều khó khăn trong quá trình thực hiện. Do đó, Bí thư Tỉnh ủy Lê Minh Khái lưu ý: Các địa phương cần quyết tâm, tập trung mọi nguồn lực, tạo phong trào thi đua mạnh mẽ thực hiện hoàn thành mục tiêu trên. Ngoài ra, cần cập nhật kịp thời những điều chỉnh về tiêu chí nông thôn mới của Trung ương để địa phương cơ sở nắm bắt, xây dựng kế hoạch, phân bổ nguồn lực hợp lý.");
                listDetailHome13.add("VT");
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
                layoutImage = LayoutInflater.from(DetailZoningActivity.this).inflate(R.layout.item_image, loBody, false);

                textView = layoutImage.findViewById(R.id.tvImageText);
                ImageView imgView = layoutImage.findViewById(R.id.imvImage);
                image = listDetailHome.get(i);
                text = listDetailHome.get(i+1);
                //
                textView.setText(text);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizecaptionImage);
                Picasso.with(DetailZoningActivity.this).load(image).into(imgView);

                loBody.addView(layoutImage);
                i++;

            } else {
                layoutText = LayoutInflater.from(DetailZoningActivity.this).inflate(R.layout.item_text, loBody, false);

                textView = (TextView) layoutText.findViewById(R.id.tvText);

                textView.setText(listDetailHome.get(i));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,sizeContent);

                loBody.addView(layoutText);
            }
        }
        //author
        layoutAuthor = LayoutInflater.from(DetailZoningActivity.this).inflate(R.layout.item_text, loBody, false);

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