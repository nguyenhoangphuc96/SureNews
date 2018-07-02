package com.lacviet.surenews.DetailScreen;

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

import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailCountryActivityTemp extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar pbDetail;
    LinearLayout loBody;
    TextView tvTitle, tvTime, tvSubTitle;
    ArrayList<String> listDetailHome1 = new ArrayList<>();
    ArrayList<String> listDetailHome2 = new ArrayList<>();
    ArrayList<String> listDetailHome3 = new ArrayList<>();
    ArrayList<String> listDetailHome4 = new ArrayList<>();
    ArrayList<String> listDetailHome5 = new ArrayList<>();
    //
    String baseSrcUrl = "http://baclieu.gov.vn";
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
                listDetailHome1.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/xa%20hung%20hoi%2011262018_144430.jpg");
                listDetailHome1.add("Đường liên ấp của xã Hưng Hội được bê-tông hóa.");
                listDetailHome1.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/xa%20hung%20hoi%2021262018_14452.jpg");
                listDetailHome1.add("Xã Hưng Hội làm lộ giao thông nông thôn. Ảnh: C.L");
                listDetailHome1.add("Là xã có khá đông đồng bào Khmer sinh sống, đời sống kinh tế của người dân còn gặp nhiều khó khăn, vì vậy khi thực hiện phong trào xây dựng nông thôn mới (XDNTM) xã Hưng Hội có xuất phát điểm khá thấp. Song, nhờ sự nỗ lực của địa phương và sự đồng tình hưởng ứng của người dân, đến cuối tháng 5/2018, xã Hưng Hội đã đạt 14/19 tiêu chí XDNTM. Còn 5 tiêu chí chưa đạt là: Quy hoạch, thủy lợi, điện, bưu điện, nhà ở dân cư và thu nhập. Tuy nhiên, các tiêu chí này đã thực hiện được nhiều tiểu mục.");
                listDetailHome1.add("Từ đầu năm đến nay, xã Hưng Hội đã thi công 3 tuyến lộ bê-tông với chiều dài 610m, sửa chữa một tuyến lộ nhựa dài 1.900m. Tổng kinh phí thực hiện các công trình hơn 232 triệu đồng, trong đó, người dân đóng góp hơn một nửa. Ông Hứa Sa Thi (ấp Cái Giá, xã Hưng Hội) bày tỏ: “Trước đây, con lộ trước nhà tôi sình lầy, khó đi lắm. Khi chính quyền đến vận động làm lộ bê-tông, bà con rất phấn khởi và đóng góp tiền, ngày công cùng với chính quyền xây dựng hoàn thành công trình”. Ngoài ra, từ nguồn vốn hỗ trợ gần 2 tỷ đồng (theo Nghị định 35/NĐ-CP của Thủ tướng Chính phủ), xã đã sên vét 26 tuyến kênh nội đồng, 4 tuyến kênh cấp 3 và làm 6 tuyến lộ bê-tông với chiều dài gần 3km.");
                listDetailHome1.add("Để đạt mục tiêu xã nông thôn mới vào cuối năm 2018, cấp ủy, chính quyền xã Hưng Hội đã xây dựng lộ trình cụ thể, xác định nội dung công việc cần thực hiện cũng như giải pháp huy động các nguồn lực. Trong đó, nhiệm vụ trọng tâm là tiếp tục hoàn thiện hệ thống giao thông nông thôn, giao thông nội đồng và kênh mương phục vụ sản xuất nông nghiệp. Triển khai xây nhà văn hóa xã, khu xử lý rác thải tập trung và xây trường học đạt chuẩn, góp phần nâng cao dân trí cho người dân");
                listDetailHome1.add("Ông Trương Thuôl (ấp Cái Giá, xã Hưng Hội) chia sẻ: “Từ khi thực hiện chương trình XDNTM, đời sống người dân trong xã được nâng lên rất nhiều. Trường học được xây dựng khang trang; lưới điện được kéo về mang ánh sáng đến mọi nhà; đường làng, ngõ xóm xanh - sạch - đẹp, được bê-tông hóa, giúp người dân thuận tiện đi lại, giao thương hàng hóa”.");
                listDetailHome1.add("Song song với việc tập trung hoàn thiện cơ sở hạ tầng nông thôn mới, thời gian qua, cấp ủy, chính quyền xã còn tập trung lãnh đạo phát triển kinh tế, nâng cao thu nhập cho người dân. Trong sản xuất nông nghiệp, xã tập trung chỉ đạo nông dân áp dụng các tiến bộ khoa học - kỹ thuật vào sản xuất, luân canh tăng vụ, chuyển đổi cơ cấu giống cây trồng, chuyển giao nhiều mô hình mới như trồng rau trong nhà lưới, sản xuất rau an toàn… Một số hộ chuyển sang trồng màu cho thu nhập gấp 2 - 3 lần trồng lúa");
                listDetailHome1.add("Bên cạnh những kết quả đạt được trong sản xuất nông nghiệp và xây dựng cơ sở hạ tầng, đời sống văn hóa của người dân xã Hưng Hội cũng không ngừng được nâng cao. Chính quyền xã thường xuyên tuyên truyền, vận động bà con thực hiện tốt hương ước, quy ước xây dựng nếp sống văn hóa tại khu dân cư; việc cưới, việc tang và lễ hội được tổ chức tiết kiệm, tránh lãng phí; ý thức, trách nhiệm cộng đồng của người dân ngày càng được nâng cao.");
                listDetailHome1.add("Theo ông Lâm Anh Tuấn, Chủ tịch UBND xã Hưng Hội: “Để hoàn thành 19/19 tiêu chí XDNTM trong năm 2018, nguồn kinh phí thực hiện các công trình, phần việc còn lại khá lớn. Vì vậy, xã sẽ tranh thủ sự hỗ trợ của tỉnh, huyện, đồng thời huy động nguồn vốn xã hội hóa cùng với ngân sách xã để thực hiện hoàn thành các tiêu chí XDNTM”.");
                listDetailHome1.add("Chí Linh-BBL");
                listDetailHome1.add("Nguồn: baobaclieu.vn");
                break;
            }
            case 2:{
                //
                listDetailHome2.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/chu%20tich2632018_92056.jpg");
                listDetailHome2.add("Chủ tịch UBND tỉnh - Dương Thành Trung (bìa trái) trao bằng công nhận xã Định Thành đạt chuẩn NTM. Ảnh: C.L");
                listDetailHome2.add("Từ năm 2011 đến nay, tổng kinh phí triển khai thực hiện chương trình xây dựng NTM đạt trên 150 tỷ đồng, trong đó: vốn ngân sách Trung ương hơn 4,1 tỷ đồng, vốn ngân sách tỉnh, huyện trên 67 tỷ đồng, vốn ngân sách xã là 0,7 tỷ đồng, vốn tín dụng hơn 1 tỷ đồng, vốn nhân dân đóng góp gần 66,5 tỷ đồng, nguồn vốn vận động doanh nghiệp gần 2 tỷ đồng và vốn lồng ghép trên 8,7 tỷ đồng. Báo cáo tại buổi lễ, ông Nguyễn Hoàng Ly - Bí thư Đảng ủy, Chủ tịch UBND xã Định Thành cho biết, nhiều năm qua Đảng bộ, chính quyền và nhân dân luôn tích cực tập trung tuyên truyền, vận động người dân thực hiện phong trào xây dựng NTM. Trong đó, việc đầu tư phát triển, hoàn thiện cơ sở hạ tầng thiết yếu nhằm phục vụ phát triển sản xuất, nâng cao đời sống của người dân cũng là lĩnh vực được địa phương chú trọng quan tâm trong quá trình xây dựng NTM");
                listDetailHome2.add("Phát biểu tại buổi lễ, ông Dương Thành Trung - Chủ tịch UBND tỉnh, chúc mừng kết quả mà Đảng bộ, chính quyền và nhân dân xã Định Thành đã đạt được trong phong trào xây dựng NTM. Đồng thời, đề nghị địa phương tiếp tục giữ vững các tiêu chí và phấn đấu đạt chuẩn xã NTM kiểu mẫu trong thời gian tới, nhất là đề ra các chủ trương, giải pháp để ngày càng nâng cao mức sống cho người dân; tạo điều kiện phát triển các mô hình kinh tế hiệu quả giúp người dân nâng cao thu nhập; đặc biệt là cần làm rõ vai trò, nhiệm vụ và lợi ích của người dân trong xây dựng NTM.");
                listDetailHome2.add("Nhân dịp này, UBND tỉnh đã trao bằng khen cho 1 tập thể và 7 cá nhân có thành tích xuất sắc trong phong trào xây dựng NTM của địa phương. Ủy ban MTTQ Việt Nam tỉnh tặng 1 căn nhà đại đoàn kết trị giá 25 triệu đồng.");
                listDetailHome2.add("Nguồn: Báo Bạc Liêu");
                break;
            }
            case 3:{
                //
                listDetailHome3.add("Trong Tháng Thanh niên, các cấp bộ Đoàn tích cực tuyên truyền và vận động nhân dân tham gia xây dựng nông thôn mới theo các tiêu chí cụ thể, đồng thời tổ chức ra quân phát quang các tuyến đường liên xã dài hơn 23 km; cắt tỉa hàng rào cây xanh; tu sửa hơn 22 km đường giao thông nông thôn; đắp 10 móng cầu bê tông; xây dựng 03 cây cầu giao thông nông thôn; sửa chữa 36 cây cầu gỗ và bê tông. Bên cạnh đó, phối hợp với các ngành chức năng tổ chức hơn 130 cuộc ra quân lập lại trật tự đô thị, tuyên truyền nhắc nhở các hộ dân trên địa bàn đô thị không buôn bán, đậu xe lấn chiếm vỉa hè với hơn 4.300 lực lượng đoàn viên thanh niên (ĐVTN) tham gia.");
                listDetailHome3.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/20-4-2017Untitled-12042017_92227.jpg");
                listDetailHome3.add("Tuổi trẻ Bạc Liêu thực hiện những công trình, phần việc thiết thực (ảnh KV)");
                listDetailHome3.add("Phát huy tinh thần xung kích, tình nguyện của tuổi trẻ tham gia bảo vệ môi trường, trong Tháng Thanh niên, các cấp bộ Đoàn tổ chức nhiều buổi ra quân dọn vệ sinh và tuyên truyền về nước sạch, vệ sinh môi trường, trồng 4.500 cây xanh các loại; vận động nhân dân tháo dỡ hơn 300 nhà vệ sinh trên sông, ao đìa; thu gom xử lý 16 tấn rác thải; xây dựng 18 nhà tiêu hợp vệ sinh. Ngoài ra, các cấp bộ Đoàn cũng triển khai thực hiện quyết liệt những hoạt động chăm lo, hỗ trợ thanh thiếu nhi và an sinh xã hội: Tổ chức 05 buổi tư vấn hướng nghiệp và giới thiệu việc làm cho hơn 1.200 ĐVTN; tặng hơn 400 suất quà cho gia đình chính sách và hộ nghèo; tặng quà và học bổng cho các em học sinh có hoàn cảnh khó khăn với tổng trị giá 430 triệu đồng; khám chữa bệnh và cấp phát thuốc miễn phí cho 950 gia đình chính sách, hộ nghèo, người già neo đơn, gia đình có hoàn cảnh khó khăn.");
                listDetailHome3.add("Đồng chí Trương Hồng Trang, nguyên Bí Thư Tỉnh Đoàn khẳng định: Tổ chức các phong trào hành động, các công trình, phần việc cụ thể, thiết thực trong Tháng Thanh niên đã giúp tuổi trẻ Bạc Liêu phát huy vai trò, khả năng, tinh thần tình nguyện, sức sáng tạo của tuổi trẻ trong xây dựng nông thôn mới và văn minh đô thị. Qua đó, tạo được hình ảnh đẹp về thế hệ thanh niên thời kỳ mới, dám dấn thân vào những việc mới, việc khó để thực hiện nhiệm vụ xây dựng và bảo vệ quê hương, đất nước.");
                listDetailHome3.add("Khánh Vy");
                break;
            }
            case 4:{
                //
                listDetailHome4.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/NTM2042017_7429.jpg");
                listDetailHome4.add("Một trong những khu dân cư tiêu biểu của xã Vĩnh Bình (huyện Hòa Bình) nhờ thực hiện cuộc vận động xây dựng nông thôn mới, đô thị văn minh. Ảnh: X.T");
                listDetailHome4.add("Với tinh thần chủ động, hàng năm MTTQ Việt Nam huyện Hòa Bình đều đề ra kế hoạch và phát động nhiều phong trào thi đua yêu nước: “Toàn dân đoàn kết xây dựng đời sống văn hóa ở khu dân cư gắn với XDNTM”, thi đua thực hiện các nhiệm vụ trọng tâm của huyện về phát triển kinh tế, giảm nghèo, vệ sinh môi trường, đảm bảo an ninh trật tự, tham gia hưởng ứng “Ngày Vì người nghèo”…");
                listDetailHome4.add("Ông Hứa Ngọc Thoanh, Chủ tịch Ủy ban MTTQ Việt Nam huyện Hòa Bình, cho biết: Qua các phong trào thi đua do MTTQ huyện phát động đã phát huy được sức mạnh và tinh thần đoàn kết, tự quản của nhân dân, tạo động lực cho phát triển kinh tế, góp phần thực hiện chính sách giảm nghèo, đền ơn đáp nghĩa, nâng cao ý thức tự giác của nhân dân trong thực hiện chủ trương, chính sách, pháp luật của Đảng và Nhà nước, phát huy các giá trị truyền thống tốt đẹp của dân tộc, giữ vững an ninh chính trị, trật tự an toàn xã hội, xây dựng hệ thống chính trị vững mạnh...");
                listDetailHome4.add("Để triển khai thực hiện có hiệu quả Đề án số 04/ĐA-MTTW-BTT ngày 28/12/2015 của Ban Thường trực Ủy ban Trung ương MTTQ Việt Nam về tổ chức thực hiện cuộc vận động “Toàn dân đoàn kết XDNTM, đô thị văn minh”; từ năm 2016 đến nay, MTTQ các cấp trong huyện đã tích cực tham mưu với cấp ủy đảng, chính quyền và các tổ chức thành viên triển khai thực hiện nhiều biện pháp, đa dạng các hình thức tuyên truyền, nhằm tiếp tục đạt hiệu quả, chất lượng cao trong thực hiện cuộc vận động. Đồng thời phát động nhiều phong trào thi đua để vận động nông dân tham gia XDNTM, như: tăng cường ứng dụng khoa học - kỹ thuật trong sản xuất nông nghiệp, nâng cao thu nhập, giải quyết việc làm; chủ động tham gia góp phần tích cực thực hiện các tiêu chí về môi trường, giao thông nông thôn, giữ gìn an ninh trật tự… Đồng thời, quan tâm phát hiện, xây dựng các nhân tố điển hình tiên tiến trong các phong trào, kịp thời nhân rộng gương người tốt - việc tốt, làm cho phong trào thi đua ngày càng lan tỏa trong từng cộng đồng dân cư, góp phần để đạt các tiêu chí cơ bản về nông thôn mới, làm thay đổi bộ mặt nông thôn của huyện.");
                listDetailHome4.add("Theo đó, thời gian qua Ủy ban MTTQ Việt Nam huyện Hòa Bình đã thu được những kết quả tích cực như: từ việc làm tốt công tác tuyên truyền, nâng cao nhận thức, các tổ chức, cá nhân đã ủng hộ nhiều tỷ đồng vào quỹ “Vì người nghèo - An sinh xã hội” của địa phương; xây dựng hàng trăm căn nhà đại đoàn kết, nhà tình thương cho hộ nghèo… Bên cạnh đó còn phát động và phối hợp tổ chức tặng quà tết, khám chữa bệnh miễn phí, tặng học bổng, mua thẻ bảo hiểm y tế cho hộ nghèo, trẻ em có hoàn cảnh khó khăn… Từ cuộc vận động không chỉ phát huy tinh thần “tương thân tương ái”, “lá lành đùm lá rách” của các tầng lớp nhân dân, mà còn góp phần động viên, khích lệ hộ nghèo nỗ lực vươn lên ổn định đời sống, chăm lo phát triển sản xuất, thoát nghèo bền vững.");
                listDetailHome4.add("Để phát huy quyền làm chủ của nhân dân, MTTQ các cấp trong huyện đã tăng cường vận động nhân dân tích cực tham gia góp ý xây dựng Đảng, chính quyền; xây dựng hệ thống chính trị ở địa phương, tổng hợp, phản ánh ý kiến, kiến nghị của nhân dân đến cấp ủy đảng, chính quyền các cấp. Đồng thời thường xuyên quan tâm củng cố, nâng cao hiệu quả hoạt động của Ban giám sát đầu tư cộng đồng, góp phần hạn chế lãng phí, tiêu cực, thất thoát, nâng cao chất lượng các công trình XDNTM.");
                listDetailHome4.add("Xuân Thưởng – Báo Bạc Liêu Online");
                break;
            }
            case 5:{
                //
                listDetailHome5.add("Dự họp có đồng chí Dương Thành Trung, Chủ tịch UBND tỉnh và lãnh đạo các sở, ban, ngành, hội, đoàn thể, huyện, thị xã, thành phố.");
                listDetailHome5.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2016-6/QC962016_16125.jpg");
                listDetailHome5.add("Quang cảnh cuộc họp");
                listDetailHome5.add("Phát biểu tại cuộc họp, Bí thư Tỉnh ủy Lê Minh Khái nhấn mạnh: Chương trình xây dựng nông thôn mới là một trong hai chương trình trọng điểm của quốc gia. Chương trình đã được các cấp, các ngành từ Trung ương đến địa phương xây dựng kế hoạch và triển khai thực hiện chặt chẽ. Kết quả Chương trình đã mang lại nhiều ý nghĩa quan trọng đối với cư dân khu vực nông thôn ở các địa phương, nhất là những tỉnh nông nghiệp như Bạc Liêu.");
                listDetailHome5.add("Qua 5 năm triển khai Chương trình xây dựng nông thôn mới, Bạc Liêu đã đạt được những kết quả bước đầu. Bộ mặt một số khu vực nông thôn trong tỉnh cơ bản được cải thiện, đời sống nhân dân có bước chuyển biến tốt cả vật chất lẫn tinh thần. Chương trình xây dựng nông thôn mới đã huy động sự vào cuộc của cả hệ thống chính trị và sự hưởng ứng nhiệt tình của người dân.");
                listDetailHome5.add("Tính đến cuối năm 2015, Bạc Liêu có 8 xã đạt 19 tiêu chí đã được công nhận nông thôn mới và 2 xã đạt 19 tiêu chí chờ xem xét, công nhận; 9 xã đạt 15-18 tiêu chí, 39 xã đạt 5-14 tiêu chí, không còn xã đạt dưới 5 tiêu chí. Tinh thần tự nguyện, tự giác của người dân đã giúp cho việc thực hiện một số tiêu chí mang tính chất nhân dân làm là chính, nhà nước chỉ hỗ trợ một phần như: tiêu chí nhà ở dân cư, thu nhập, tỷ lệ hộ nghèo… đạt kết quả khá tích cực.");
                listDetailHome5.add("Tuy nhiên trong quá trình thực hiện, tỉnh Bạc Liêu còn gặp một số khó khăn, hạn chế nhất định. Việc xây dựng nông thôn mới cần nhu cầu vốn rất lớn, nhưng thực tế Bạc Liêu vẫn là tỉnh nghèo, với quy mô xã lớn, dân cư thưa thớt, sông ngòi chằng chịt, nền địa chất yếu; doanh nghiệp đầu tư vào khu vực nông nghiệp, nông thôn không nhiều, vốn ngân sách ít nên sự hỗ trợ của Nhà nước có giới hạn, dẫn đến một số tiêu chí cần nhiều vốn đầu tư từ sự hỗ trợ của ngân sách đạt thấp. Kinh phí hàng năm phân bổ cho Chương trình chưa đáp ứng yêu cầu; Các xã mặc dù đã được công nhận đạt chuẩn nông thôn mới, nhưng một số tiêu chí quan trọng chỉ đạt ở mức thấp.");
                listDetailHome5.add("Giai đoạn 2016 – 2020, Bạc Liêu đề ra mục tiêu có 25 xã đạt 19/19 tiêu chí; có 2 huyện đạt chuẩn huyện nông thôn mới. Cùng với việc phấn đấu tăng số xã đạt 19 tiêu chí nông thôn mới, Chương trình xây dựng nông thôn mới của tỉnh Bạc Liêu thời gian tới tập trung  xây dựng và nâng cấp cơ bản hoàn thành các công trình thiết yếu đáp ứng nhu cầu phát triển sản xuất và đời sống cư dân nông thôn; Nâng cao chất lượng cuộc sống của cư dân nông thôn");
                listDetailHome5.add("Bí thư Tỉnh ủy Lê Minh Khái đề nghị: Thời gian tới, khi xây dựng Chương trình xây dựng nông thôn mới giai đoạn 2016 – 2020, các địa phương cần tính toán kỹ, bám sát nội dung Nghị quyết Đại hội Đảng lần thứ XII và Nghị quyết Đại hội Đảng bộ tỉnh lần thứ XV đã đề ra. Chương trình kế hoạch hành động cần tập trung vào một số giải pháp như: hoàn thiện bộ máy Ban Chỉ đạo các cấp, đảm bảo năng lực, thực hiện hiệu quả nhiệm vụ; Ưu tiên thực hiện những tiêu chí không cần nhiều nguồn lực kinh phí để hoàn thành trước, tạo động lực cho việc huy động các nguồn lực đầu tư vào các tiêu chí cần nhiều nguồn kinh phí.");
                listDetailHome5.add("Mục tiêu “đến năm 2020 có hơn 50% số xã trong tỉnh đạt 19 tiêu chí nông thôn mới” được xác định là mục tiêu lớn, dự báo gặp nhiều khó khăn trong quá trình thực hiện. Do đó, Bí thư Tỉnh ủy Lê Minh Khái lưu ý: Các địa phương cần quyết tâm, tập trung mọi nguồn lực, tạo phong trào thi đua mạnh mẽ thực hiện hoàn thành mục tiêu trên. Ngoài ra, cần cập nhật kịp thời những điều chỉnh về tiêu chí nông thôn mới của Trung ương để địa phương cơ sở nắm bắt, xây dựng kế hoạch, phân bổ nguồn lực hợp lý.");
                listDetailHome5.add("VT");
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
                View layout2 = LayoutInflater.from(DetailCountryActivityTemp.this).inflate(R.layout.item_image, loBody, false);

                TextView textView = layout2.findViewById(R.id.tvImageText);
                ImageView imgView = layout2.findViewById(R.id.imvImage);
                image = listDetailHome.get(i);
                text = listDetailHome.get(i+1);
                //
                textView.setText(text);
                Picasso.with(DetailCountryActivityTemp.this).load(image).into(imgView);

                loBody.addView(layout2);
                i++;

            } else {
                View layout1 = LayoutInflater.from(DetailCountryActivityTemp.this).inflate(R.layout.item_text, loBody, false);

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