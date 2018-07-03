package com.lacviet.surenews.HomeMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lacviet.surenews.DetailScreen.DetailCountryActivityTemp;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivitiesLeaderActivity extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar pbDetail;
    LinearLayout loBody;
    TextView tvTitle, tvTime, tvSubTitle;
    ArrayList<String> listDetailHome1 = new ArrayList<>();
    ArrayList<String> listDetailHome2 = new ArrayList<>();
    ArrayList<String> listDetailHome3 = new ArrayList<>();
    ArrayList<String> listDetailHome4 = new ArrayList<>();
    ArrayList<String> listDetailHome5 = new ArrayList<>();
    ArrayList<String> listDetailHome6 = new ArrayList<>();
    ArrayList<String> listDetailHome7 = new ArrayList<>();
    //
    String baseSrcUrl = "http://congthongtin.bioportal.vn";
    //
    int id;
    String title = "";
    String time = "";
    String subtitle = "";
    String image = "";
    String text = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        addControl();
        actionBar();
        getDatafromPreviousActivity();
        initData();
        loadData();


    }

    private void initData() {
        switch (id) {
            case 1:{
                listDetailHome1.add(baseSrcUrl+"/PublishingImages/khoi%20cong%20bv%20da%20khoa2562018_164113.jpg");
                listDetailHome1.add("Đồng chí Vương Phương Nam - Phó Chủ tịch UBND tỉnh (người thứ 3, từ phải qua) thực hiện nghi thức khởi công xây dựng dự án");
                listDetailHome1.add(baseSrcUrl+"/PublishingImages/khoi%20cong%20bv%20da%20khoa%2012562018_163640.jpg");
                listDetailHome1.add("Phối cảnh Bệnh viện Đa khoa Bạc Liêu – Sài Gòn");
                listDetailHome1.add("Dự án tọa lạc tại khóm 10, phường 1, thành phố Bạc Liêu với tổng diện tích trên 37.000m2, diện tích xây dựng 8.424 m2, diện tích sàn xây dựng lên đến 55.671 m2. Quy mô xây dựng 10 tầng, công suất 400 giường bệnh ngoại trú/ngày, 436 giường bệnh nội trú, khu khách sạn 21 phòng với 112 giường... Tổng mức đầu tư toàn dự án trên 1.369 tỷ đồng. Dự kiến dự án sẽ hoàn thành đưa vào khai thác vào cuối năm 2020./.");
                listDetailHome1.add("Châu Khánh");
                break;
            }
            case 2:{
                //
                listDetailHome2.add(baseSrcUrl+"/PublishingImages/dai%20hoi%20dai%20bieu1162018_933.jpg");
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
                listDetailHome3.add(baseSrcUrl+"/PublishingImages/dai%20hoi%20cong%20doan2562018_103755.jpg");
                listDetailHome3.add("Lãnh đạo Tổng LĐLĐ Việt Nam và Lãnh đạo Tỉnh ủy tặng hoa chúc mừng Ban Chấp hành Công đoàn tỉnh Bạc Liêu khóa X, nhiệm kỳ 2018 - 2023");
                listDetailHome3.add("Trong nhiệm kỳ qua, dưới sự lãnh đạo, chỉ đạo của Tổng LĐLĐ Việt Nam, Ban Chấp hành Đảng bộ tỉnh, phong trào CNVCLĐ tỉnh nhà có sự phát triển. Nội dung, phương thức hoạt động có nhiều đổi mới, chức năng đại diện bảo vệ quyền lợi hợp pháp, chính đáng và chăm lo lợi ích của đoàn viên, người lao động ngày càng được đẩy mạnh, mang lại lợi ích thiết thực, động viên CNVCLĐ hăng hái thi đua lao động, sản xuất.\n" +
                        "\n" +
                        "Công tác xây dựng tổ chức Công đoàn và phát triển đoàn viên được chú trọng, tỷ lệ công đoàn cơ sở đạt tiêu chuẩn vững mạnh ngày càng tăng. Nhiệm kỳ qua đã thành lập mới 47 công đoàn cơ sở và kết nạp gần 6.700 đoàn viên mới. Công đoàn các cấp đã xây dựng quỹ Mái ấm công đoàn và trợ vốn cho CNVCLĐ nghèo gần 13,4 tỷ đồng. Từ nguồn quỹ này đã xây dựng mới và sửa chữa gần 200 căn Mái ấm công đoàn và hỗ trợ cho trên 7.000 lượt CNVCLĐ nghèo phát triển kinh tế gia đình.\n" +
                        "\n" +
                        "Phát biểu chỉ đạo tại Đại hội, Phó Bí thư Thường trực Tỉnh ủy, Chủ tịch HĐND tỉnh - Lê Thị Ái Nam thay mặt Tỉnh ủy ghi nhận và nhiệt liệt biểu dương những thành tích mà tổ chức Công đoàn và phong trào CNVCLĐ tỉnh nhà đạt được trong nhiệm kỳ qua. Đồng thời chỉ đạo tổ chức Công đoàn tỉnh nhà cần tăng cường hơn nữa công tác tuyên truyền về đường lối, chủ trương của Đảng, chính sách, pháp luật của nhà nước, giáo dục nâng cao bản lĩnh chính trị, giác ngộ giai cấp, ý thức kỷ luật, tác phong công nghiệp, kỹ năng nghề nghiệp cho đoàn viên, CNVCLĐ. Công đoàn các cấp cần phải làm tốt vai trò là người đại diện và bảo vệ quyền lợi hợp pháp, chính đáng của giai cấp công nhân và người lao động. Bên cạnh đó, tiếp tục đẩy mạnh, nâng cao chất lượng các phong trào thi đua yêu nước trong CNVCLĐ gắn với việc thực hiện các chương trình phát triển kinh tế - xã hội của tỉnh.\n" +
                        "\n" +
                        "Đại hội đã bầu ra Ban Chấp hành Công đoàn tỉnh Bạc Liêu khóa X, nhiệm kỳ 2018 - 2023 gồm 34 đồng chí. Ông Nguyễn Văn Khanh được bầu làm Chủ tịch./.\n" +
                        "\n" +
                        "HLam");
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
            default:
                break;
        }




    }

    private void loadDataById(ArrayList<String> listDetailHome) {
        //
        tvTitle.setText(title);
        tvTime.setText(time);
        tvSubTitle.setText(subtitle);
        //body
        for(int i = 0; i<listDetailHome.size();i++)
        {
            if (listDetailHome.get(i).startsWith("http://")) {
                View layout2 = LayoutInflater.from(DetailActivitiesLeaderActivity.this).inflate(R.layout.item_image, loBody, false);

                TextView textView = layout2.findViewById(R.id.tvImageText);
                ImageView imgView = layout2.findViewById(R.id.imvImage);
                image = listDetailHome.get(i);
                text = listDetailHome.get(i+1);
                //
                textView.setText(text);
                Picasso.with(DetailActivitiesLeaderActivity.this).load(image).into(imgView);

                loBody.addView(layout2);
                i++;

            } else {
                View layout1 = LayoutInflater.from(DetailActivitiesLeaderActivity.this).inflate(R.layout.item_text, loBody, false);

                TextView textView = (TextView) layout1.findViewById(R.id.tvText);

                textView.setText(listDetailHome.get(i));

                loBody.addView(layout1);
            }
        }
        pbDetail.setVisibility(View.GONE);

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