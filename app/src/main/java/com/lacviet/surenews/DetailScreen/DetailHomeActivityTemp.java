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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.Model.DetailModel;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class DetailHomeActivityTemp extends AppCompatActivity {
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
    ArrayList<String> listDetailHome8 = new ArrayList<>();
    ArrayList<String> listDetailHome9 = new ArrayList<>();
    ArrayList<String> listDetailHome10 = new ArrayList<>();
    ArrayList<String> listDetailHome11 = new ArrayList<>();
    ArrayList<String> listDetailHome12 = new ArrayList<>();
    ArrayList<String> listDetailHome13 = new ArrayList<>();
    ArrayList<String> listDetailHome14 = new ArrayList<>();
    ArrayList<String> listDetailHome15 = new ArrayList<>();
    ArrayList<String> listDetailHome16 = new ArrayList<>();
    ArrayList<String> listDetailHome17 = new ArrayList<>();
    ArrayList<String> listDetailHome18 = new ArrayList<>();
    ArrayList<String> listDetailHome19 = new ArrayList<>();
    ArrayList<String> listDetailHome20 = new ArrayList<>();
    ArrayList<String> listDetailHome21 = new ArrayList<>();
    ArrayList<String> listDetailHome22 = new ArrayList<>();
    ArrayList<String> listDetailHome23 = new ArrayList<>();
    ArrayList<String> listDetailHome24 = new ArrayList<>();
    ArrayList<String> listDetailHome25 = new ArrayList<>();
    ArrayList<String> listDetailHome26 = new ArrayList<>();
    //
    String baseSrcUrl = "http://baclieu.gov.vn";
    String baseUrlSoNgoaiVu = "http://songoaivu.baclieu.gov.vn";
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
                listDetailHome1.add("Trong 6 tháng đầu năm 2018, toàn Ngành LĐTB&XH triển khai thực hiện có hiệu quả các lĩnh vực, cụ thể: Trên 14.300 lao động trong và ngoài tỉnh được giải quyết việc làm; 140 người được xuất khẩu lao động; đào tạo nghề cho hơn 4.700 người; chi trả đầy đủ chế độ trợ cấp ưu đãi người có công với cách mạng cho gần 11.000 người; trên 27.000 người được cấp thẻ BHYT; duy trì tốt việc hỗ trợ, giúp đỡ trên 170 thương binh 1/4, 2/4  có mức sống trung bình gặp khó khăn; phụng dưỡng hơn 140 Mẹ Việt Nam anh hùng... Bên cạnh đó, công tác giảm nghèo và bảo trợ xã hội; công tác bảo vệ, chăm sóc trẻ em và bình đẳng giới cũng được thực hiện tốt.");
                listDetailHome1.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/28-62862018_8816.jpg");
                listDetailHome1.add("Quang cảnh Hội nghị");
                listDetailHome1.add("Trong 6 tháng cuối năm 2018, Ngành LĐTB&XH tiếp tục thực hiện các nội dung: Đẩy mạnh các giải pháp về giải quyết việc làm; đôn đốc, chỉ đạo công tác tuyển sinh và đào tạo nghề; triển khai thực hiện chính sách hỗ trợ người có công có khó khăn về nhà ở; phối hợp với các đơn vị truyền thông thực hiện tuyên truyền các nội dung, hoạt động về giảm nghèo và bảo trợ xã hội; thực hiện tốt chế độ trợ giúp cho các đối tượng bảo trợ xã hội, chủ động thực hiện tốt công tác cứu trợ đột xuất trên địa bàn, phòng chống tệ nạn xã hội…");
                listDetailHome1.add("Phát biểu kết luận Hội nghị, Giám đốc Sở LĐTB&XH Trần Hồng Chiến đã biểu dương sự nỗ lực, cố gắng của Ngành LĐTB&XH thời gian qua, đồng thời chỉ đạo các đơn vị triển khai thực hiện tốt các hoạt động kỷ niệm 71 năm ngày Thương binh Liệt sĩ (27/7/1947 - 27/7/2018) cũng như các chỉ tiêu, nhiệm vụ đã đề ra.");
                listDetailHome1.add("Sự Nghiệp");
                break;
            }
            case 2:{
                //
                listDetailHome2.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/khoi%20cong%20bv%20da%20khoa2562018_164113.jpg");
                listDetailHome2.add("Đồng chí Vương Phương Nam - Phó Chủ tịch UBND tỉnh (người thứ 3, từ phải qua) thực hiện nghi thức khởi công xây dựng dự án");
                listDetailHome2.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/khoi%20cong%20bv%20da%20khoa%2012562018_163640.jpg");
                listDetailHome2.add("Phối cảnh Bệnh viện Đa khoa Bạc Liêu – Sài Gòn");
                listDetailHome2.add("Dự án tọa lạc tại khóm 10, phường 1, thành phố Bạc Liêu với tổng diện tích trên 37.000m2, diện tích xây dựng 8.424 m2, diện tích sàn xây dựng lên đến 55.671 m2. Quy mô xây dựng 10 tầng, công suất 400 giường bệnh ngoại trú/ngày, 436 giường bệnh nội trú, khu khách sạn 21 phòng với 112 giường... Tổng mức đầu tư toàn dự án trên 1.369 tỷ đồng. Dự kiến dự án sẽ hoàn thành đưa vào khai thác vào cuối năm 2020./.");
                listDetailHome2.add("Châu Khánh");
                break;
            }
            case 3:{
                //
                listDetailHome3.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/dinh%20huong%20thanh%20lap%20htx2562018_104544.jpg");
                listDetailHome3.add("Chủ tịch UBND tỉnh Dương Thành Trung phát biểu tại buổi họp mặt");
                listDetailHome3.add("Tại buổi họp mặt, nguyên Thứ trưởng Bộ Kế hoạch và Đầu tư, Đặng Huy Đông cho biết: Việc thực hiện mô hình HTX công nghệ cao phát triển tôm sẽ giúp bà con được liên kết với các nhà cung ứng vật tư đầu vào (thức ăn, thuốc, chế phẩm sinh học, giống, bạt lót...); sử dụng vật tư với giá thấp hơn so với giá mua ở các đại lý bên ngoài, kiểm soát tốt hơn chất lượng tôm nguyên liệu nhằm hạn chế rủi ro, thiệt hại cho người nuôi.");
                listDetailHome3.add("Ông Dương Thành Trung, Chủ tịch UBND tỉnh nhận định: Việc thành lập HTX công nghệ cao phát triển tôm Bạc Liêu là việc làm cần thiết để bảo vệ lợi ích chính đáng của các doanh nghiệp, hộ nuôi tôm. Vì vậy, các doanh nghiệp và các hộ nôi tôm nhỏ lẻ cần liên kết lại với nhau, thống nhất về quy trình nuôi tôm sạch, nhằm tạo ra sản phẩm có chất lượng, đem lại lợi nhuận cao hơn cho người nuôi. Từ đó khẳng định được thương hiệu con tôm Bạc Liêu, đồng thời, ông khẳng định tỉnh sẽ hỗ trợ tích cực để Hợp tác xã công nghệ cao phát triển tôm Bạc Liêu được thành lập và đi vào hoạt động trong thời gian tới./.");
                listDetailHome3.add("Sự Nghiệp");
                break;
            }
            case 4:{
                //
                listDetailHome4.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/tap%20huan%20cap%20giay%20phep2262018_13461.jpg");
                listDetailHome4.add("Quang cảnh buổi tập huấn");
                listDetailHome4.add("Tại buổi tập huấn, các doanh nghiệp đã được Sở LĐ-TB&XH hệ thống lại một số quy định về sử dụng lao động nước ngoài, xác nhận lao động nước ngoài không thuộc diện cấp giấy phép lao động, cấp lại giấy phép lao động theo Thông tư số 23/2017/TT-BLĐTBXH ngày 15/8/2017 của Bộ LĐTB&XH về việc hướng dẫn thực hiện cấp giấy phép lao động cho người lao động nước ngoài làm việc tại Việt Nam qua mạng điện tử; hướng dẫn sử dụng phần mềm trong việc nộp hồ sơ đề nghị cấp giấy phép lao động cho lao động nước ngoài làm việc tại tỉnh qua mạng điện tử. Tại buổi tập huấn, các doanh nghiệp cũng đã được giải đáp một số khó khăn, vướng mắc trong việc thực hiện cấp giấy phép lao động cho lao động nước ngoài làm việc tại tỉnh.");
                listDetailHome4.add("Thực hiện việc cấp giấy phép lao động qua mạng điện tử cho người lao động nước ngoài sẽ giảm thời gian thực hiện các trình tự, thủ tục liên quan việc cấp giấy phép lao động, cũng như tạo điều kiện thận lợi cho doanh nghiệp, tổ chức và nâng cao tiện ích trong công tác quản lý lao động nước ngoài trên địa bàn tỉnh./.");
                listDetailHome4.add("Đức Hình");
                break;
            }
            case 5:{
                //
                listDetailHome5.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/dai%20hoi%20cong%20doan2562018_103755.jpg");
                listDetailHome5.add("Lãnh đạo Tổng LĐLĐ Việt Nam và Lãnh đạo Tỉnh ủy tặng hoa chúc mừng Ban Chấp hành Công đoàn tỉnh Bạc Liêu khóa X, nhiệm kỳ 2018 - 2023");
                listDetailHome5.add("Trong nhiệm kỳ qua, dưới sự lãnh đạo, chỉ đạo của Tổng LĐLĐ Việt Nam, Ban Chấp hành Đảng bộ tỉnh, phong trào CNVCLĐ tỉnh nhà có sự phát triển. Nội dung, phương thức hoạt động có nhiều đổi mới, chức năng đại diện bảo vệ quyền lợi hợp pháp, chính đáng và chăm lo lợi ích của đoàn viên, người lao động ngày càng được đẩy mạnh, mang lại lợi ích thiết thực, động viên CNVCLĐ hăng hái thi đua lao động, sản xuất.");
                listDetailHome5.add("Công tác xây dựng tổ chức Công đoàn và phát triển đoàn viên được chú trọng, tỷ lệ công đoàn cơ sở đạt tiêu chuẩn vững mạnh ngày càng tăng. Nhiệm kỳ qua đã thành lập mới 47 công đoàn cơ sở và kết nạp gần 6.700 đoàn viên mới. Công đoàn các cấp đã xây dựng quỹ Mái ấm công đoàn và trợ vốn cho CNVCLĐ nghèo gần 13,4 tỷ đồng. Từ nguồn quỹ này đã xây dựng mới và sửa chữa gần 200 căn Mái ấm công đoàn và hỗ trợ cho trên 7.000 lượt CNVCLĐ nghèo phát triển kinh tế gia đình.");
                listDetailHome5.add("Phát biểu chỉ đạo tại Đại hội, Phó Bí thư Thường trực Tỉnh ủy, Chủ tịch HĐND tỉnh - Lê Thị Ái Nam thay mặt Tỉnh ủy ghi nhận và nhiệt liệt biểu dương những thành tích mà tổ chức Công đoàn và phong trào CNVCLĐ tỉnh nhà đạt được trong nhiệm kỳ qua. Đồng thời chỉ đạo tổ chức Công đoàn tỉnh nhà cần tăng cường hơn nữa công tác tuyên truyền về đường lối, chủ trương của Đảng, chính sách, pháp luật của nhà nước, giáo dục nâng cao bản lĩnh chính trị, giác ngộ giai cấp, ý thức kỷ luật, tác phong công nghiệp, kỹ năng nghề nghiệp cho đoàn viên, CNVCLĐ. Công đoàn các cấp cần phải làm tốt vai trò là người đại diện và bảo vệ quyền lợi hợp pháp, chính đáng của giai cấp công nhân và người lao động. Bên cạnh đó, tiếp tục đẩy mạnh, nâng cao chất lượng các phong trào thi đua yêu nước trong CNVCLĐ gắn với việc thực hiện các chương trình phát triển kinh tế - xã hội của tỉnh");
                listDetailHome5.add("Đại hội đã bầu ra Ban Chấp hành Công đoàn tỉnh Bạc Liêu khóa X, nhiệm kỳ 2018 - 2023 gồm 34 đồng chí. Ông Nguyễn Văn Khanh được bầu làm Chủ tịch./.");
                listDetailHome5.add("HLam");
                break;
            }
            case 6:{
                //
                listDetailHome6.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/phien%20hop%20ubnd%20th6%20l22262018_13386.jpg");
                listDetailHome6.add("Quang cảnh phiên họp");
                listDetailHome6.add("Tại phiên họp, thành viên UBND tỉnh đã thống nhất thông qua nội dung dự thảo Tờ trình của UBND tỉnh và Nghị quyết của HĐND tỉnh phân bổ định mức chi bảo đảm cho công tác xây dựng văn bản quy phạm pháp luật trên địa bàn tỉnh để trình kỳ họp HĐND sắp tới.");
                listDetailHome6.add("Thành viên UBND tỉnh đã thảo luận, đóng góp ý kiến sửa đổi, bổ sung nội dung của các dự thảo: Tờ trình của UBND tỉnh và Nghị quyết của HĐND tỉnh về sửa đổi, bổ sung Nghị quyết 11/2017/NQ-HĐND ngày 07/12/2017 của HĐND tỉnh về nhiệm vụ phát triển kinh tế - xã hội năm 2018, Tờ trình của UBND tỉnh và Nghị quyết của HĐND tỉnh ban hành Quy định về phân cấp quản lý, sử dụng tài sản công thuộc phạm vi quản lý của tỉnh Bạc Liêu, Tờ trình của UBND tỉnh và Nghị quyết của HĐND tỉnh quy định mức đóng góp, chế độ miễn, giảm và hỗ trợ cho học viên cai nghiện ma túy bắt buộc tại cơ sở cai nghiện ma túy và tại cộng đồng; chế độ miễn cho hoc viên cai nghiện tự nguyện tại cơ sở cai nghiện ma túy công lập trên địa bàn tỉnh.");
                listDetailHome6.add("Chủ tịch UBND tỉnh đề nghị các cơ quan soạn thảo tiếp thu ý kiến đóng góp của các đại biểu, hoàn chỉnh các nội dung theo quy định để trình kỳ họp HĐND tỉnh sắp tới./.");
                listDetailHome6.add("Đức Hình");
                break;
            }
            case 7:{
                //
                listDetailHome7.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/so%20lao%20dong2262018_104830.jpg");
                listDetailHome7.add("Quang cảnh Hội nghị");
                listDetailHome7.add("Tham dự Hội nghị có đại diện Lãnh đạo các Sở, Ban, Ngành, UBND và Phòng LĐTB&XH các huyện, thị xã, thành phố.");
                listDetailHome7.add("Hội nghị đã triển khai Quyết định số 178/QĐ-UBND ngày 02/5/2018 của Chủ tịch UBND tỉnh về việc ban hành Quy chế phối hợp cai nghiện ma túy tại gia đình, cộng đồng trên địa bàn tỉnh Bạc Liêu và Quyết định số 736/QĐ-UBND ngày 29/01/2018 của Chủ tịch UBND tỉnh về ban hành Quy chế phối hợp hỗ trợ, giúp đỡ người sau cai nghiện ma túy, người mại dâm hoàn lương, người bị mua bán trở về.");
                listDetailHome7.add("Tại Hội nghị, các đại biểu tham dự đã được hướng dẫn thực hiện các hoạt động hỗ trợ cho người sau cai nghiện ma túy, người bán dân hoàn lương và nạn nhân bị mua bán trở về như: Công tác tiếp nhận, hỗ trợ, quản lý, giáo dục, vận động và tuyên truyền, phổ biến các chính sách, pháp luật... Nhằm triển khai có hiệu quả các Quyết định trên./.");
                listDetailHome7.add("Sự Nghiệp");
                break;
            }
            case 8:{
                listDetailHome8.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/xa%20hung%20hoi%2011262018_144430.jpg");
                listDetailHome8.add("Đường liên ấp của xã Hưng Hội được bê-tông hóa.");
                listDetailHome8.add("/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/xa%20hung%20hoi%2021262018_14452.jpg");
                listDetailHome8.add("Xã Hưng Hội làm lộ giao thông nông thôn. Ảnh: C.L");
                listDetailHome8.add("Là xã có khá đông đồng bào Khmer sinh sống, đời sống kinh tế của người dân còn gặp nhiều khó khăn, vì vậy khi thực hiện phong trào xây dựng nông thôn mới (XDNTM) xã Hưng Hội có xuất phát điểm khá thấp. Song, nhờ sự nỗ lực của địa phương và sự đồng tình hưởng ứng của người dân, đến cuối tháng 5/2018, xã Hưng Hội đã đạt 14/19 tiêu chí XDNTM. Còn 5 tiêu chí chưa đạt là: Quy hoạch, thủy lợi, điện, bưu điện, nhà ở dân cư và thu nhập. Tuy nhiên, các tiêu chí này đã thực hiện được nhiều tiểu mục.");
                listDetailHome8.add("Từ đầu năm đến nay, xã Hưng Hội đã thi công 3 tuyến lộ bê-tông với chiều dài 610m, sửa chữa một tuyến lộ nhựa dài 1.900m. Tổng kinh phí thực hiện các công trình hơn 232 triệu đồng, trong đó, người dân đóng góp hơn một nửa. Ông Hứa Sa Thi (ấp Cái Giá, xã Hưng Hội) bày tỏ: “Trước đây, con lộ trước nhà tôi sình lầy, khó đi lắm. Khi chính quyền đến vận động làm lộ bê-tông, bà con rất phấn khởi và đóng góp tiền, ngày công cùng với chính quyền xây dựng hoàn thành công trình”. Ngoài ra, từ nguồn vốn hỗ trợ gần 2 tỷ đồng (theo Nghị định 35/NĐ-CP của Thủ tướng Chính phủ), xã đã sên vét 26 tuyến kênh nội đồng, 4 tuyến kênh cấp 3 và làm 6 tuyến lộ bê-tông với chiều dài gần 3km.");
                listDetailHome8.add("Để đạt mục tiêu xã nông thôn mới vào cuối năm 2018, cấp ủy, chính quyền xã Hưng Hội đã xây dựng lộ trình cụ thể, xác định nội dung công việc cần thực hiện cũng như giải pháp huy động các nguồn lực. Trong đó, nhiệm vụ trọng tâm là tiếp tục hoàn thiện hệ thống giao thông nông thôn, giao thông nội đồng và kênh mương phục vụ sản xuất nông nghiệp. Triển khai xây nhà văn hóa xã, khu xử lý rác thải tập trung và xây trường học đạt chuẩn, góp phần nâng cao dân trí cho người dân");
                listDetailHome8.add("Ông Trương Thuôl (ấp Cái Giá, xã Hưng Hội) chia sẻ: “Từ khi thực hiện chương trình XDNTM, đời sống người dân trong xã được nâng lên rất nhiều. Trường học được xây dựng khang trang; lưới điện được kéo về mang ánh sáng đến mọi nhà; đường làng, ngõ xóm xanh - sạch - đẹp, được bê-tông hóa, giúp người dân thuận tiện đi lại, giao thương hàng hóa”.");
                listDetailHome8.add("Song song với việc tập trung hoàn thiện cơ sở hạ tầng nông thôn mới, thời gian qua, cấp ủy, chính quyền xã còn tập trung lãnh đạo phát triển kinh tế, nâng cao thu nhập cho người dân. Trong sản xuất nông nghiệp, xã tập trung chỉ đạo nông dân áp dụng các tiến bộ khoa học - kỹ thuật vào sản xuất, luân canh tăng vụ, chuyển đổi cơ cấu giống cây trồng, chuyển giao nhiều mô hình mới như trồng rau trong nhà lưới, sản xuất rau an toàn… Một số hộ chuyển sang trồng màu cho thu nhập gấp 2 - 3 lần trồng lúa");
                listDetailHome8.add("Bên cạnh những kết quả đạt được trong sản xuất nông nghiệp và xây dựng cơ sở hạ tầng, đời sống văn hóa của người dân xã Hưng Hội cũng không ngừng được nâng cao. Chính quyền xã thường xuyên tuyên truyền, vận động bà con thực hiện tốt hương ước, quy ước xây dựng nếp sống văn hóa tại khu dân cư; việc cưới, việc tang và lễ hội được tổ chức tiết kiệm, tránh lãng phí; ý thức, trách nhiệm cộng đồng của người dân ngày càng được nâng cao.");
                listDetailHome8.add("Theo ông Lâm Anh Tuấn, Chủ tịch UBND xã Hưng Hội: “Để hoàn thành 19/19 tiêu chí XDNTM trong năm 2018, nguồn kinh phí thực hiện các công trình, phần việc còn lại khá lớn. Vì vậy, xã sẽ tranh thủ sự hỗ trợ của tỉnh, huyện, đồng thời huy động nguồn vốn xã hội hóa cùng với ngân sách xã để thực hiện hoàn thành các tiêu chí XDNTM”.");
                listDetailHome8.add("Chí Linh-BBL");
                listDetailHome8.add("Nguồn: baobaclieu.vn");
                break;
            }
            case 9:{
                //
                listDetailHome9.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/chu%20tich2632018_92056.jpg");
                listDetailHome9.add("Chủ tịch UBND tỉnh - Dương Thành Trung (bìa trái) trao bằng công nhận xã Định Thành đạt chuẩn NTM. Ảnh: C.L");
                listDetailHome9.add("Từ năm 2011 đến nay, tổng kinh phí triển khai thực hiện chương trình xây dựng NTM đạt trên 150 tỷ đồng, trong đó: vốn ngân sách Trung ương hơn 4,1 tỷ đồng, vốn ngân sách tỉnh, huyện trên 67 tỷ đồng, vốn ngân sách xã là 0,7 tỷ đồng, vốn tín dụng hơn 1 tỷ đồng, vốn nhân dân đóng góp gần 66,5 tỷ đồng, nguồn vốn vận động doanh nghiệp gần 2 tỷ đồng và vốn lồng ghép trên 8,7 tỷ đồng. Báo cáo tại buổi lễ, ông Nguyễn Hoàng Ly - Bí thư Đảng ủy, Chủ tịch UBND xã Định Thành cho biết, nhiều năm qua Đảng bộ, chính quyền và nhân dân luôn tích cực tập trung tuyên truyền, vận động người dân thực hiện phong trào xây dựng NTM. Trong đó, việc đầu tư phát triển, hoàn thiện cơ sở hạ tầng thiết yếu nhằm phục vụ phát triển sản xuất, nâng cao đời sống của người dân cũng là lĩnh vực được địa phương chú trọng quan tâm trong quá trình xây dựng NTM");
                listDetailHome9.add("Phát biểu tại buổi lễ, ông Dương Thành Trung - Chủ tịch UBND tỉnh, chúc mừng kết quả mà Đảng bộ, chính quyền và nhân dân xã Định Thành đã đạt được trong phong trào xây dựng NTM. Đồng thời, đề nghị địa phương tiếp tục giữ vững các tiêu chí và phấn đấu đạt chuẩn xã NTM kiểu mẫu trong thời gian tới, nhất là đề ra các chủ trương, giải pháp để ngày càng nâng cao mức sống cho người dân; tạo điều kiện phát triển các mô hình kinh tế hiệu quả giúp người dân nâng cao thu nhập; đặc biệt là cần làm rõ vai trò, nhiệm vụ và lợi ích của người dân trong xây dựng NTM.");
                listDetailHome9.add("Nhân dịp này, UBND tỉnh đã trao bằng khen cho 1 tập thể và 7 cá nhân có thành tích xuất sắc trong phong trào xây dựng NTM của địa phương. Ủy ban MTTQ Việt Nam tỉnh tặng 1 căn nhà đại đoàn kết trị giá 25 triệu đồng.");
                listDetailHome9.add("Nguồn: Báo Bạc Liêu");
                break;
            }
            case 10:{
                //
                listDetailHome10.add("Trong Tháng Thanh niên, các cấp bộ Đoàn tích cực tuyên truyền và vận động nhân dân tham gia xây dựng nông thôn mới theo các tiêu chí cụ thể, đồng thời tổ chức ra quân phát quang các tuyến đường liên xã dài hơn 23 km; cắt tỉa hàng rào cây xanh; tu sửa hơn 22 km đường giao thông nông thôn; đắp 10 móng cầu bê tông; xây dựng 03 cây cầu giao thông nông thôn; sửa chữa 36 cây cầu gỗ và bê tông. Bên cạnh đó, phối hợp với các ngành chức năng tổ chức hơn 130 cuộc ra quân lập lại trật tự đô thị, tuyên truyền nhắc nhở các hộ dân trên địa bàn đô thị không buôn bán, đậu xe lấn chiếm vỉa hè với hơn 4.300 lực lượng đoàn viên thanh niên (ĐVTN) tham gia.");
                listDetailHome10.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/20-4-2017Untitled-12042017_92227.jpg");
                listDetailHome10.add("Tuổi trẻ Bạc Liêu thực hiện những công trình, phần việc thiết thực (ảnh KV)");
                listDetailHome10.add("Phát huy tinh thần xung kích, tình nguyện của tuổi trẻ tham gia bảo vệ môi trường, trong Tháng Thanh niên, các cấp bộ Đoàn tổ chức nhiều buổi ra quân dọn vệ sinh và tuyên truyền về nước sạch, vệ sinh môi trường, trồng 4.500 cây xanh các loại; vận động nhân dân tháo dỡ hơn 300 nhà vệ sinh trên sông, ao đìa; thu gom xử lý 16 tấn rác thải; xây dựng 18 nhà tiêu hợp vệ sinh. Ngoài ra, các cấp bộ Đoàn cũng triển khai thực hiện quyết liệt những hoạt động chăm lo, hỗ trợ thanh thiếu nhi và an sinh xã hội: Tổ chức 05 buổi tư vấn hướng nghiệp và giới thiệu việc làm cho hơn 1.200 ĐVTN; tặng hơn 400 suất quà cho gia đình chính sách và hộ nghèo; tặng quà và học bổng cho các em học sinh có hoàn cảnh khó khăn với tổng trị giá 430 triệu đồng; khám chữa bệnh và cấp phát thuốc miễn phí cho 950 gia đình chính sách, hộ nghèo, người già neo đơn, gia đình có hoàn cảnh khó khăn.");
                listDetailHome10.add("Đồng chí Trương Hồng Trang, nguyên Bí Thư Tỉnh Đoàn khẳng định: Tổ chức các phong trào hành động, các công trình, phần việc cụ thể, thiết thực trong Tháng Thanh niên đã giúp tuổi trẻ Bạc Liêu phát huy vai trò, khả năng, tinh thần tình nguyện, sức sáng tạo của tuổi trẻ trong xây dựng nông thôn mới và văn minh đô thị. Qua đó, tạo được hình ảnh đẹp về thế hệ thanh niên thời kỳ mới, dám dấn thân vào những việc mới, việc khó để thực hiện nhiệm vụ xây dựng và bảo vệ quê hương, đất nước.");
                listDetailHome10.add("Khánh Vy");
                break;
            }
            case 11:{
                //
                listDetailHome11.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2017-4/NTM2042017_7429.jpg");
                listDetailHome11.add("Một trong những khu dân cư tiêu biểu của xã Vĩnh Bình (huyện Hòa Bình) nhờ thực hiện cuộc vận động xây dựng nông thôn mới, đô thị văn minh. Ảnh: X.T");
                listDetailHome11.add("Với tinh thần chủ động, hàng năm MTTQ Việt Nam huyện Hòa Bình đều đề ra kế hoạch và phát động nhiều phong trào thi đua yêu nước: “Toàn dân đoàn kết xây dựng đời sống văn hóa ở khu dân cư gắn với XDNTM”, thi đua thực hiện các nhiệm vụ trọng tâm của huyện về phát triển kinh tế, giảm nghèo, vệ sinh môi trường, đảm bảo an ninh trật tự, tham gia hưởng ứng “Ngày Vì người nghèo”…");
                listDetailHome11.add("Ông Hứa Ngọc Thoanh, Chủ tịch Ủy ban MTTQ Việt Nam huyện Hòa Bình, cho biết: Qua các phong trào thi đua do MTTQ huyện phát động đã phát huy được sức mạnh và tinh thần đoàn kết, tự quản của nhân dân, tạo động lực cho phát triển kinh tế, góp phần thực hiện chính sách giảm nghèo, đền ơn đáp nghĩa, nâng cao ý thức tự giác của nhân dân trong thực hiện chủ trương, chính sách, pháp luật của Đảng và Nhà nước, phát huy các giá trị truyền thống tốt đẹp của dân tộc, giữ vững an ninh chính trị, trật tự an toàn xã hội, xây dựng hệ thống chính trị vững mạnh...");
                listDetailHome11.add("Để triển khai thực hiện có hiệu quả Đề án số 04/ĐA-MTTW-BTT ngày 28/12/2015 của Ban Thường trực Ủy ban Trung ương MTTQ Việt Nam về tổ chức thực hiện cuộc vận động “Toàn dân đoàn kết XDNTM, đô thị văn minh”; từ năm 2016 đến nay, MTTQ các cấp trong huyện đã tích cực tham mưu với cấp ủy đảng, chính quyền và các tổ chức thành viên triển khai thực hiện nhiều biện pháp, đa dạng các hình thức tuyên truyền, nhằm tiếp tục đạt hiệu quả, chất lượng cao trong thực hiện cuộc vận động. Đồng thời phát động nhiều phong trào thi đua để vận động nông dân tham gia XDNTM, như: tăng cường ứng dụng khoa học - kỹ thuật trong sản xuất nông nghiệp, nâng cao thu nhập, giải quyết việc làm; chủ động tham gia góp phần tích cực thực hiện các tiêu chí về môi trường, giao thông nông thôn, giữ gìn an ninh trật tự… Đồng thời, quan tâm phát hiện, xây dựng các nhân tố điển hình tiên tiến trong các phong trào, kịp thời nhân rộng gương người tốt - việc tốt, làm cho phong trào thi đua ngày càng lan tỏa trong từng cộng đồng dân cư, góp phần để đạt các tiêu chí cơ bản về nông thôn mới, làm thay đổi bộ mặt nông thôn của huyện.");
                listDetailHome11.add("Theo đó, thời gian qua Ủy ban MTTQ Việt Nam huyện Hòa Bình đã thu được những kết quả tích cực như: từ việc làm tốt công tác tuyên truyền, nâng cao nhận thức, các tổ chức, cá nhân đã ủng hộ nhiều tỷ đồng vào quỹ “Vì người nghèo - An sinh xã hội” của địa phương; xây dựng hàng trăm căn nhà đại đoàn kết, nhà tình thương cho hộ nghèo… Bên cạnh đó còn phát động và phối hợp tổ chức tặng quà tết, khám chữa bệnh miễn phí, tặng học bổng, mua thẻ bảo hiểm y tế cho hộ nghèo, trẻ em có hoàn cảnh khó khăn… Từ cuộc vận động không chỉ phát huy tinh thần “tương thân tương ái”, “lá lành đùm lá rách” của các tầng lớp nhân dân, mà còn góp phần động viên, khích lệ hộ nghèo nỗ lực vươn lên ổn định đời sống, chăm lo phát triển sản xuất, thoát nghèo bền vững.");
                listDetailHome11.add("Để phát huy quyền làm chủ của nhân dân, MTTQ các cấp trong huyện đã tăng cường vận động nhân dân tích cực tham gia góp ý xây dựng Đảng, chính quyền; xây dựng hệ thống chính trị ở địa phương, tổng hợp, phản ánh ý kiến, kiến nghị của nhân dân đến cấp ủy đảng, chính quyền các cấp. Đồng thời thường xuyên quan tâm củng cố, nâng cao hiệu quả hoạt động của Ban giám sát đầu tư cộng đồng, góp phần hạn chế lãng phí, tiêu cực, thất thoát, nâng cao chất lượng các công trình XDNTM.");
                listDetailHome11.add("Xuân Thưởng – Báo Bạc Liêu Online");
                break;
            }
            case 12:{
                //
                listDetailHome12.add("Dự họp có đồng chí Dương Thành Trung, Chủ tịch UBND tỉnh và lãnh đạo các sở, ban, ngành, hội, đoàn thể, huyện, thị xã, thành phố.");
                listDetailHome12.add(baseSrcUrl+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2016-6/QC962016_16125.jpg");
                listDetailHome12.add("Quang cảnh cuộc họp");
                listDetailHome12.add("Phát biểu tại cuộc họp, Bí thư Tỉnh ủy Lê Minh Khái nhấn mạnh: Chương trình xây dựng nông thôn mới là một trong hai chương trình trọng điểm của quốc gia. Chương trình đã được các cấp, các ngành từ Trung ương đến địa phương xây dựng kế hoạch và triển khai thực hiện chặt chẽ. Kết quả Chương trình đã mang lại nhiều ý nghĩa quan trọng đối với cư dân khu vực nông thôn ở các địa phương, nhất là những tỉnh nông nghiệp như Bạc Liêu.");
                listDetailHome12.add("Qua 5 năm triển khai Chương trình xây dựng nông thôn mới, Bạc Liêu đã đạt được những kết quả bước đầu. Bộ mặt một số khu vực nông thôn trong tỉnh cơ bản được cải thiện, đời sống nhân dân có bước chuyển biến tốt cả vật chất lẫn tinh thần. Chương trình xây dựng nông thôn mới đã huy động sự vào cuộc của cả hệ thống chính trị và sự hưởng ứng nhiệt tình của người dân.");
                listDetailHome12.add("Tính đến cuối năm 2015, Bạc Liêu có 8 xã đạt 19 tiêu chí đã được công nhận nông thôn mới và 2 xã đạt 19 tiêu chí chờ xem xét, công nhận; 9 xã đạt 15-18 tiêu chí, 39 xã đạt 5-14 tiêu chí, không còn xã đạt dưới 5 tiêu chí. Tinh thần tự nguyện, tự giác của người dân đã giúp cho việc thực hiện một số tiêu chí mang tính chất nhân dân làm là chính, nhà nước chỉ hỗ trợ một phần như: tiêu chí nhà ở dân cư, thu nhập, tỷ lệ hộ nghèo… đạt kết quả khá tích cực.");
                listDetailHome12.add("Tuy nhiên trong quá trình thực hiện, tỉnh Bạc Liêu còn gặp một số khó khăn, hạn chế nhất định. Việc xây dựng nông thôn mới cần nhu cầu vốn rất lớn, nhưng thực tế Bạc Liêu vẫn là tỉnh nghèo, với quy mô xã lớn, dân cư thưa thớt, sông ngòi chằng chịt, nền địa chất yếu; doanh nghiệp đầu tư vào khu vực nông nghiệp, nông thôn không nhiều, vốn ngân sách ít nên sự hỗ trợ của Nhà nước có giới hạn, dẫn đến một số tiêu chí cần nhiều vốn đầu tư từ sự hỗ trợ của ngân sách đạt thấp. Kinh phí hàng năm phân bổ cho Chương trình chưa đáp ứng yêu cầu; Các xã mặc dù đã được công nhận đạt chuẩn nông thôn mới, nhưng một số tiêu chí quan trọng chỉ đạt ở mức thấp.");
                listDetailHome12.add("Giai đoạn 2016 – 2020, Bạc Liêu đề ra mục tiêu có 25 xã đạt 19/19 tiêu chí; có 2 huyện đạt chuẩn huyện nông thôn mới. Cùng với việc phấn đấu tăng số xã đạt 19 tiêu chí nông thôn mới, Chương trình xây dựng nông thôn mới của tỉnh Bạc Liêu thời gian tới tập trung  xây dựng và nâng cấp cơ bản hoàn thành các công trình thiết yếu đáp ứng nhu cầu phát triển sản xuất và đời sống cư dân nông thôn; Nâng cao chất lượng cuộc sống của cư dân nông thôn");
                listDetailHome12.add("Bí thư Tỉnh ủy Lê Minh Khái đề nghị: Thời gian tới, khi xây dựng Chương trình xây dựng nông thôn mới giai đoạn 2016 – 2020, các địa phương cần tính toán kỹ, bám sát nội dung Nghị quyết Đại hội Đảng lần thứ XII và Nghị quyết Đại hội Đảng bộ tỉnh lần thứ XV đã đề ra. Chương trình kế hoạch hành động cần tập trung vào một số giải pháp như: hoàn thiện bộ máy Ban Chỉ đạo các cấp, đảm bảo năng lực, thực hiện hiệu quả nhiệm vụ; Ưu tiên thực hiện những tiêu chí không cần nhiều nguồn lực kinh phí để hoàn thành trước, tạo động lực cho việc huy động các nguồn lực đầu tư vào các tiêu chí cần nhiều nguồn kinh phí.");
                listDetailHome12.add("Mục tiêu “đến năm 2020 có hơn 50% số xã trong tỉnh đạt 19 tiêu chí nông thôn mới” được xác định là mục tiêu lớn, dự báo gặp nhiều khó khăn trong quá trình thực hiện. Do đó, Bí thư Tỉnh ủy Lê Minh Khái lưu ý: Các địa phương cần quyết tâm, tập trung mọi nguồn lực, tạo phong trào thi đua mạnh mẽ thực hiện hoàn thành mục tiêu trên. Ngoài ra, cần cập nhật kịp thời những điều chỉnh về tiêu chí nông thôn mới của Trung ương để địa phương cơ sở nắm bắt, xây dựng kế hoạch, phân bổ nguồn lực hợp lý.");
                listDetailHome12.add("VT");
                break;
            }
            case 13: {
                listDetailHome13.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/trien%20khai%20ke%20hoach%20nn%206%20thang%20cuoi%20nam1562018_153449.jpg");
                listDetailHome13.add("Ông Lương Ngọc Lân, Giám đốc Sở NN&PTNT phát biểu tại Hội nghị");
                listDetailHome13.add("Trong 6 tháng đầu năm, tổng sản lượng nuôi trồng và khai thác thủy sản trên địa bàn tỉnh ước đạt hơn 153 ngàn tấn; diện tích nuôi trồng thủy sản hơn 123.000 ha. Về nông nghiệp, ngành đã thông báo hướng dẫn thời vụ sản xuất lúa, rau, màu năm 2018; tiếp tục triển khai thực hiện Đề án “Tái cơ cấu ngành trồng trọt tỉnh Bạc Liêu đến năm 2020, định hướng đến năm 2030 theo hướng nâng cao giá trị gia tăng và phát triển bền vững”. Đồng thời, tiếp tục quản lý, bảo vệ, sử dụng và phát triển rừng hiện có; chăm sóc diện tích rừng trồng. Bên cạnh đó, kiểm tra, cấp lại và cấp mới giấy chứng nhận đủ điều kiện an toàn thực phẩm cho 81 cơ sở chế biến, kinh doanh, bảo quản nông sản; kiểm tra thủ tục hành chính và điều kiện an toàn thực phẩm tại 30 cơ sở thu mua, sơ chế nguyên liệu thủy sản trên địa bàn.\n" +
                        "\n" +
                        "Hoạt động sản xuất, kinh doanh giống thủy sản đảm bảo nhu cầu thả nuôi của người dân nhưng chất lượng không đều; tình hình bệnh vàng lùn, lùn xoắn lá còn phức tạp, sẽ có nguy cơ phát sinh mạnh trong thời gian tới, lượng mưa thấp và không đều nên việc xuống giống lúa Hè Thu bị ảnh hưởng…\n" +
                        "\n" +
                        "Trong 6 tháng cuối năm, ngành Nông nghiệp tiếp tục thực hiện chỉ đạo của Trung ương, UBND tỉnh về nuôi trồng, phòng chống dịch bệnh thủy sản, bảo vệ môi trường trong nuôi trồng thủy sản; tiếp tục tuyên truyền vận động ngư dân an tâm bám biển bảo vệ chủ quyền tổ quốc, tuyên truyền về ranh giới biển và vùng khai thác cho các tàu khai thác xa bờ; thường xuyên theo dõi diễn biến bất thường của thời tiết và phối hợp chặt chẽ với các lực lượng chức năng có liên quan để kịp thời chỉ đạo và đề xuất các giải pháp phù hợp hỗ trợ ngư dân yên tâm sản xuất trên biển; chỉ đạo nông dân xuống giống lúa theo lịch thời vụ; chăm sóc, bảo vệ trà lúa hiện có…");
                listDetailHome13.add("Khánh Vy");

                break;
            }
            case 14: {
                listDetailHome14.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/cac%20giai%20phap%20trong%20tam562018_85247.jpg");
                listDetailHome14.add("Bộ trưởng Bộ NN&PTNT Nguyễn Xuân Cường phát biểu tại Hội nghị");
                listDetailHome14.add("Theo báo cáo của Tổng cục Thủy sản, diện tích thả nuôi tôm nước lợ 5 tháng đầu năm trên địa bàn cả nước gần 637.000 ha, sản lượng thu hoạch gần 195.000 tấn. Giá tôm nguyên liệu đầu năm vẫn giữ ở mức cao. Tuy nhiên, từ tháng 3 đến nay, giá tôm nguyên liệu liên tục sụt giảm.\n" +
                        "\n" +
                        "Theo Hiệp hội chế biến và xuất khẩu thủy sản Việt Nam thì giá tôm nguyên liệu liên tục giảm là do: Nhu cầu tại các thị trường lớn sụt giảm; Trung Quốc tăng cường kiểm soát tình trạng buôn lậu tôm dẫn đến lượng tôm tiêu thụ qua đường tiểu ngạch giảm; sản lượng thu hoạch tôm thẻ chân trắng ở một số nước tăng… Do đó, các nhà nhập khẩu đã nhân cơ hội này để gây sức ép giảm giá. Chỉ tính trong quý II/2018, giá tôm nguyên liệu giảm từ 10.000 - 30.000 đồng/kg.\n" +
                        "\n" +
                        "Tại Hội nghị các chuyên gia cũng đưa ra một số nguyên nhân khác dẫn đến việc giá tôm liên tục giảm và đề ra một số giải pháp nhằm ổn định sản xuất giúp bà con nuôi tôm yên tâm sản xuất.\n" +
                        "\n" +
                        "Phát biểu chỉ đạo tại Hội nghị, Bộ trưởng Bộ NN&PTNT Nguyễn Xuân Cường mong muốn người dân nuôi tôm phải bình tĩnh trước tình hình hiện nay; không bán tôm cỡ nhỏ và cần điều chỉnh quy trình nuôi hợp lí nhằm giảm bớt chi phí sản xuất. Bên cạnh đó, các doanh nghiệp cần đồng hành cùng người nuôi tôm trong giai đoạn khó khăn này, xem đây là cơ hội để nuôi dưỡng thị trường lâu dài theo hướng bền vững./.");
                listDetailHome14.add("Sự Nghiệp");
                break;
            }
            case 15: {
                listDetailHome15.add(baseSrcUrl+"/PublishingImages/dinh%20huong%20thanh%20lap%20htx2562018_104544.jpg");
                listDetailHome15.add("Chủ tịch UBND tỉnh Dương Thành Trung phát biểu tại buổi họp mặt");
                listDetailHome15.add("Tại buổi họp mặt, nguyên Thứ trưởng Bộ Kế hoạch và Đầu tư, Đặng Huy Đông cho biết: Việc thực hiện mô hình HTX công nghệ cao phát triển tôm sẽ giúp bà con được liên kết với các nhà cung ứng vật tư đầu vào (thức ăn, thuốc, chế phẩm sinh học, giống, bạt lót...); sử dụng vật tư với giá thấp hơn so với giá mua ở các đại lý bên ngoài, kiểm soát tốt hơn chất lượng tôm nguyên liệu nhằm hạn chế rủi ro, thiệt hại cho người nuôi.\n" +
                        "\n" +
                        "Ông Dương Thành Trung, Chủ tịch UBND tỉnh nhận định: Việc thành lập HTX công nghệ cao phát triển tôm Bạc Liêu là việc làm cần thiết để bảo vệ lợi ích chính đáng của các doanh nghiệp, hộ nuôi tôm. Vì vậy, các doanh nghiệp và các hộ nôi tôm nhỏ lẻ cần liên kết lại với nhau, thống nhất về quy trình nuôi tôm sạch, nhằm tạo ra sản phẩm có chất lượng, đem lại lợi nhuận cao hơn cho người nuôi. Từ đó khẳng định được thương hiệu con tôm Bạc Liêu, đồng thời, ông khẳng định tỉnh sẽ hỗ trợ tích cực để Hợp tác xã công nghệ cao phát triển tôm Bạc Liêu được thành lập và đi vào hoạt động trong thời gian tới./.");
                listDetailHome15.add("Sự Nghiệp");
                break;
            }
            case 16: {
                listDetailHome16.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/302962018_82446.jpg");
                listDetailHome16.add("Ảnh: Bà Lê Thanh Giang - Chủ tịch HND tỉnh, Trưởng BTC Hội thi trao cờ lưu niệm cho các trưởng đoàn.");
                listDetailHome16.add("Đến dự Hội thi có các đ/c trong Ban tổ chức, Ban Giám khảo, đại diện lãnh đạo các Sở ngành liên quan, Hội nông dân các địa phương, đông đảo cổ động viên. Với sự tranh tài của 22 thí sinh dự thi 21 tiết mục gồm: cổ nhạc, tân nhạc và ca tài tử. Kết quả, Ban tổ chức đã trao 2 giải nhất, 4 giải nhì, 5 giải ba và 10 giải khuyến khích; giải nhất thể loại tân nhạc thuộc về thí sinh Phạm Văn Sâm (huyện Vĩnh Lợi), giải Nhất thể loại cổ nhạc thuộc về đôi song ca Huỳnh Văn Em - Đỗ Thị Ngọc Huyền (huyện Hồng Dân).\n" +
                        "Nhằm duy trì và phát triển phong trào văn hóa, văn nghệ trong cán bộ, hội viên Hội Nông dân các cấp trong tỉnh; góp phần bảo tồn và phát huy giá trị nghệ thuật đờn ca tài tử Nam bộ, bản Dạ cổ hoài lang và bài ca vọng cổ tiêu biểu của Bạc Liêu.");
                listDetailHome16.add("Văn Công Diệp");
                break;
            }
            case 17: {
                listDetailHome17.add("Đối tượng tham dự Lớp bồi dưỡng là cán bộ, công chức, viên chức làm công tác hội nhập quốc tế thuộc các cơ quan Đảng của tỉnh; các Sở, ban, ngành, đơn vị; Mặt trận Tổ quốc và các đoàn thể cấp tỉnh; các hội đặc thù; các cơ quan, đơn vị cấp huyện; các trường Đại học, Cao đẳng trên địa bàn tỉnh. Các giảng viên, báo cáo viên trình bày các chuyên đề gồm: PGS.TS Trần Việt Thái, Phó Viện trưởng Viện Nghiên cứu chiến lược Bộ Ngoại giao; ông Phạm Thành Nam, Phó Vụ trưởng Vụ Kinh tế đa phương và ông Vũ Xuân Trường, nguyên Đại sứ Việt Nam tại Philippin, chuyên gia kinh tế, Bộ Ngoại giao.");
                listDetailHome17.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/1%20NHỎ2762018_132823.jpg");
                listDetailHome17.add("Ông Vưu Nghị Bình, Giám đốc Sở Ngoại vụ phát biểu khai giảng lớp bồi dưỡng");
                listDetailHome17.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/1.2%20nhỏ2762018_132918.jpg");
                listDetailHome17.add("Quang cảnh lớp bồi dưỡng");
                listDetailHome17.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/2%20NHỎ2762018_133025.jpg");
                listDetailHome17.add("PGS.TS Trần Việt Thái, Phó Viện trưởng Viện Nghiên cứu Chiến lược, Bộ Ngoại giao trình bày chuyên đề đường lối đối ngoại của Đảng và Nhà nước về Hội nhập quốc tế");
                listDetailHome17.add("Phát biểu tại lớp bồi dưỡng, ông Vưu Nghị Bình, Giám đốc Sở Ngoại vụ cho rằng việc tổ chức lớp học này là hết sức quan trọng, thiết thực và bổ ích, nhằm giúp cho học viên nắm rõ về cục diện quan hệ quốc tế và chiến lược hội nhập quốc tế; về đường lối đối ngoại của Đảng và Nhà nước, các định hướng lớn trong quan hệ đa phương đến năm 2030, vai trò nòng cốt của Việt Nam trong ASEAN; về công tác Ngoại giao kinh tế và kỹ năng xúc tiến đầu tư, thương mại; về các hiệp định thương mại và đầu tư của Việt Nam với các đối tác lớn, cơ hội, thách thức của Việt Nam khi tham gia. Để lớp bồi dưỡng đạt kết quả cao, Giám đốc Sở Ngoại vụ đề nghị các đồng chí tham dự lớp học phải có mặt đầy đủ, tập trung theo dõi, lắng nghe và tiếp thu các nội dung mà các giảng viên trình bày; đồng thời, cũng mong rằng từ những thông tin, kiến thức được lĩnh hội, cập nhật qua lớp bồi dưỡng này, các đồng chí sẽ nghiên cứu, vận dụng sáng tạo trong quá trình triển khai thực hiện các nhiệm vụ liên quan đến lĩnh vực công tác đối ngoại và hội nhập quốc tế nhằm đạt được kết quả cao nhất, góp phần đẩy mạnh phát triển kinh tế - xã hội, giữ vững ổn định an ninh – chính trị của tỉnh.\n" +
                        "\n" +
                        "Sau 02 ngày học tập, Ban Tổ chức lớp đã trao Giấy chứng nhận cho các học viên hoàn thành lớp bồi dưỡng.");
                listDetailHome17.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/3-nhỏ2762018_133233.jpg");
                listDetailHome17.add("Đại diện các đoàn, đơn vị nhận giấy chứng nhận và chụp hình với ông Vưu Nghị Bình, Giám đốc Sở Ngoại vụ");
                listDetailHome17.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/3--nhỏ2762018_133420.jpg");
                listDetailHome17.add("Đại diện các đoàn, đơn vị nhận giấy chứng nhận và chụp hình với ông Phạm Thành Nam, Phó Vụ trưởng Vụ Hợp tác kinh tế đa phương, Bộ Ngoại giao");
                listDetailHome17.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-6/3---2762018_133611.jpg");
                listDetailHome17.add("Đại diện các đoàn, đơn vị nhận giấy chứng nhận và chụp hình với ông Nguyễn Quốc Liêm, Phó Giám đốc Sở Ngoại vụ");
                listDetailHome17.add("Theo kế hoạch, từ nay đến cuối năm 2018, Sở Ngoại vụ sẽ tham mưu Ủy ban nhân dân tỉnh mở thêm 02 lớp dành cho cán bộ, công chức, viên chức và doanh nghiệp làm công tác hội nhập quốc tế./.");
                listDetailHome17.add("Bá Thép");
                break;
            }
            case 18: {
                listDetailHome18.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/11752018_95250.png");
                listDetailHome18.add("Quang cảnh hội nghị");
                listDetailHome18.add("Tham dự buổi tọa đàm có đại diện Lãnh đạo 13 cơ quan ngoại vụ các tỉnh và 50 cán bộ, công chức thuộc Cụm thi đua số 5. Về phía Hàn Quốc, có ông Jeong Woo Jin, Phó Tổng Lãnh sự quán Hàn Quốc; ông Lee Bok Hang, Lãnh sự phụ trách visa; ông Ahn Seong Ho, Lãnh sự phụ trách thương mại - đầu tư cùng các cán bộ khác của Lãnh sự quán Hàn Quốc.\n" +
                        "\n" +
                        "Tại buổi tọa đàm ông Nguyễn Thanh Điền, Giám đốc Sở Ngoại vụ tỉnh Cà Mau và ông Phạm Thế Vinh, Giám đốc Sở Ngoại vụ thành phố Cần Thơ đồng chủ trì đã nêu lên tình hình thực hiện nhiệm vụ trên các lĩnh vực trong thời gian qua, những thuận lợi, khó khăn, vướng mắc thường gặp và đây là dịp để các cơ quan ngoại vụ của địa phương cùng trao đổi học tập kinh nghiệm.\n" +
                        "\n" +
                        "Phát biểu về hoạt động lãnh sự ông Nguyễn Hữu Xuân, Giám đốc Sở Ngoại vụ tỉnh Đồng Tháp đã nêu lên một số nội dung về công tác lãnh sự và lễ tân đối ngoại, chia sẻ về quy trình đón tiếp đoàn, quản lý đoàn ra nước ngoài,… Ông Nguyễn Việt Thông, Phó Giám đốc Sở Ngoại vụ tỉnh Kiên Giang phát biểu về công tác ngoại giao kinh tế. Kết thúc phiên thứ nhất, ông Nguyễn Thanh Điền, Giám đốc Sở Ngoại vụ tỉnh Cà Mau - Cụm trưởng đã phát biểu và đánh giá cao ý kiến thảo luận của các đại biểu, đồng thời đề nghị trong thời gian tới cụm cần tổ chức nhiều hơn các hoạt động giao lưu, hội thảo theo chuyên đề để các địa phương có điều kiện học tập, trao đổi kinh nghiệm.");
                listDetailHome18.add(baseUrlSoNgoaiVu+"/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/21752018_95413.png");
                listDetailHome18.add("Đoàn Sở Ngoại vụ tỉnh Bạc Liêu chụp ảnh lưu niệm với Đoàn Lãnh sự quán Hàn Quốc tại thành phố Hồ Chí Minh");
                listDetailHome18.add("Tại phiên 2, đã tổ chức giao lưu, trao đổi kinh nghiệm giữa các cơ quan ngoại vụ khu vực Tây Nam Bộ với Tổng Lãnh sự quán Hàn Quốc tại Thành phố Hồ Chí Minh, các tỉnh đã nêu lên những khó khăn vướng mắc về công tác kêu gọi đầu tư, hợp tác, thủ tục xin visa đối với Hàn Quốc… và những kiến nghị nhằm tăng cường sự phối hợp chặt chẽ từ các bên, thúc đẩy hơn nữa quan hệ hợp tác giữa Việt Nam – Hàn Quốc với các tỉnh, thành khu vực đồng bằng sông Cửu Long và Hàn Quốc trong thời gian tới.\n" +
                        "\n" +
                        "Qua trao đổi Phó Tổng lãnh sự Hàn Quốc và các viên chức lãnh sự, thương mại, hợp tác quốc tế đã trả lời những câu hỏi làm rõ hơn những khó khăn, thuận lợi trong việc làm thủ tục xin cấp visa, mở rộng hợp tác thu hút đầu tư giữa Việt Nam - Hàn Quốc. Đồng thời trong thời gian tới sẽ tăng cường kết nối, giao lưu với các cơ quan ngoại vụ của địa phương để thắt chặt hơn nữa mối quan hệ hợp tác, hữu nghị./.");
                listDetailHome18.add("Bài và ảnh: Ngọc Hân");
                break;
            }
            case 19: {
                listDetailHome19.add("Kế hoạch đề ra một số chỉ tiêu như: Phấn đấu đến năm 2020, có trên 50% lực lượng lao động tham gia bảo hiểm xã hội; trên 35% lực lượng lao động tham gia bảo hiểm thất nghiệp và trên 80% dân số tham gia bảo hiểm y tế.\n" +
                        "\n" +
                        "Về chính sách ưu đãi người có công, phấn đấu đến năm 2020 hoàn thành dứt điểm công tác rà soát công nhận bổ sung các đối tượng chính sách người có công trong tỉnh; Tiếp tục phụng dưỡng Bà Mẹ Việt Nam anh hùng; phấn đấu 100% hộ gia đình chính sách có mức sống bằng hoặc cao hơn mức sống trung bình khu dân cư; cơ bản hoàn thành việc hỗ trợ nhà ở cho các đối tượng chính sách, người có công gặp khó khăn về nhà ở");
                listDetailHome19.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-7/trao-nha2972013_91022.jpg");
                listDetailHome19.add("Trao tặng nhà tình nghĩa cho gia đình thương binh Lê Văn Thính ngụ ấp Bà Ai II, xã Lộc Ninh, huyện Hồng Dân.\n" +
                        "Ảnh: www.baclieu.gov.vn");
                listDetailHome19.add("Ngoài ra, đầu tư sửa chữa nâng cấp, xây dựng mới các công trình ghi công liệt sĩ, nghĩa trang liệt sĩ các huyện để trở thành những công trình văn hóa lịch sử của tỉnh; thực hiện tốt chủ trương tham gia tìm kiếm, quy tập hài cốt lịch sử\n" +
                        "\n" +
                        "Với các chỉ tiêu trên, nhiệm vụ, giải pháp được xác định là: Tăng cường công tác quản lý nhà nước, đẩy mạnh công tác tuyên truyền, phổ biến quan điểm, chính sách pháp luật, tăng cường công tác thanh tra, kiểm tra về cải cách chính sách tiền lương, bảo hiểm xã hội, trợ cấp ưu đãi người có công. Trong đó: tổ chức rà soát, đánh giá chất lượng đội ngũ cán bộ, công chức, viên chức để thực hiện chính sách tinh giảm biên chế; đẩy mạnh xã hội hóa dịch vụ BHXH, chuyển các loại hình trợ giúp xã hội sang cung cấp dịch vụ bảo trợ xã hội dựa vào cộng đồng, bảo đảm các đối tượng bảo trợ xã hội có cuộc sống ổn định; Triển khai thực hiện tốt Pháp lệnh ưu đãi người có công với cách mạng; giải quyết kịp thời các chính sách ưu đãi, hỗ trợ với người có công và thân nhân về điều kiện phát triển , sản xuất, ưu tiên sắp xếp việc làm và tiếp cận các dịch vụ xã hội cơ bản, nhất là y tế, giáo dục, đào tạo.");
                listDetailHome19.add("V.T");
                break;
            }
            case 20: {
                listDetailHome20.add("Chương trình dự trữ hàng hóa bình ổn giá vào dịp Tết Nguyên đán Giáp Ngọ năm 2014 trên địa bàn tỉnh Bạc Liêu được thực hiện từ ngày 17/12/2013 đến ngày 03/3/2014, nhằm bình ổn thị trường nhân dịp Tết Nguyên đán Giáp Ngọ năm 2014, góp phần cân đối cung cầu hàng hóa, đáp ứng nhu cầu của nhân dân, nhất là các mặt hàng thiết yếu, từ đó hạn chế tốc độ tăng giá, kiềm chế lạm phát, thúc đẩy sản xuất – kinh doanh phát triển, bảo đảm an sinh xã hội trên địa bàn tỉnh trong dịp Tết Nguyên đán Giáp Ngọ năm 2014.");
                listDetailHome20.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2013-12/hang_binh_on_120122013_143459.jpg");
                listDetailHome20.add("Ảnh minh họa.");
                listDetailHome20.add("Theo Kế hoạch, các hàng hóa trong danh mục của Chương trình gồm: Lương thực (gạo tẻ, gạo nếp); Thực phẩm (dầu ăn, nước chấm, gia vị, thịt gia súc, gia cầm, trứng gia cầm, các sản phẩm chế biến từ sản phẩm gia súc, gia cầm, bánh, kẹo, mứt, nước giải khát, đường ăn, bột ngọt, sữa, rau, củ, quả; thực phẩm đông lạnh, trữ mát, đóng hộp, hàng công nghệ; mì gói, mì ly, cháo gói, phở, hủ tiếu, bún gói)…\n" +
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
                listDetailHome20.add("TT");
                break;
            }
            case 21: {
                listDetailHome21.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2014-1/trongrung1012014_134836.jpg");
                listDetailHome21.add("Các đồng chí lãnh đạo tỉnh tham gia trồng rừng phòng hộ ở xã Vĩnh Hậu A, huyện Hòa Bình, tại lễ phát động trồng rừng nhân kỷ niệm 40 năm Ngày thành lập lực lượng Kiểm lâm Việt Nam (21/5/1973 - 21/5/2013)");
                listDetailHome21.add("Theo Quy hoạch, mục tiêu kinh tế là quản lý, bảo vệ và phát triển rừng của tỉnh đến năm 2020 đạt diện tích 8.938,7 ha đất lâm nghiệp (trong đó đất có rừng là 6.244,2 ha); sử dụng tài nguyên rừng và quỹ đất được quy hoạch cho lâm nghiệp có hiệu quả và bền vững; tập trung đầu tư, phát triển rừng phòng hộ, phòng hộ môi trường và trồng cây phân tán; bảo vệ hệ thống đê biển và các công trình ven biển, cửa sông; phát triển bền vững các mô hình lâm – ngư và ngư – lâm kết hợp, góp phần nâng cao thu nhập, cải thiện đời sống người làm nghề rừng; góp phần phát triển kinh tế - xã hội, ổn định đời sống của cộng đồng dân cư trên địa bàn vùng ven biển và củng cố an ninh, quốc phòng.\n" +
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
                listDetailHome21.add("L.Đ");
                break;
            }
            case 22:{
                //
                listDetailHome22.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-3/uy%20ban%20an%20toan%20gt2232018_9574.jpg");
                listDetailHome22.add("Ông Khuất Việt Hùng, Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia phát biểu tại buổi làm việc");
                listDetailHome22.add("Tiếp và làm việc với Đoàn có đồng chí Phan Như Nguyện, Phó Chủ tịch UBND tỉnh; Ngô Hữu Dũng, Giám đốc Sở Giao thông vận tải, Phó Trưởng Ban  Thường trực Ban ATGT tỉnh và đại diện Lãnh đạo các sở, ngành liên quan.");
                listDetailHome22.add("Theo báo cáo của Ban ATGT tỉnh, trong 02 tháng đầu năm 2018, toàn tỉnh xảy ra 11 vụ tai nạn giao thông (TNGT) làm chết 08 người, bị thương 08 người, tổng thiệt hại tài sản ước tính 36 triệu đồng. Riêng trong 07 ngày nghỉ Tết Nguyên đán Mậu Tuất 2018, toàn tỉnh xảy ra 01 vụ TNGT, làm bị thương 01 người, giảm cả 03 tiêu chí so với 07 ngày nghỉ Tết Nguyên đán Đinh Dậu 2017. Tại các Lễ hội Xuân năm 2018 không xảy ra ùn tắc giao thông và TNGT.");
                listDetailHome22.add("Bên cạnh đó, công tác đảm bảo trật tự ATGT trên địa bàn tỉnh vẫn còn gặp nhiều khó khăn, trở ngại như: Hiệu lực, hiệu quả của công tác tuần tra, kiểm soát, xử lý vi phạm của các lực lượng thực thi công vụ tuy đã được nâng cao nhưng chưa đáp ứng được yêu cầu nhiệm vụ; công tác quản lý phương tiện và người lái phương tiện đường thủy nội địa còn gặp nhiều khó khăn; trên tuyến Quốc lộ 1, tại khu vực Nhà thờ Tắc Sậy, lưu lượng khách đến đây hàng ngày rất đông, thường xảy ra ùn tắc giao thông cục bộ…");
                listDetailHome22.add("Phó Chủ tịch chuyên trách Ủy ban ATGT Quốc gia - Khuất Việt Hùng đánh giá cao nỗ lực của tỉnh trong việc thực hiện nhiệm vụ đảm bảo trật tự ATGT trong thời gian qua. Tuy nhiên, ông cũng lưu ý để giảm số vụ TNGT và số người chết do TNGT, Bạc Liêu cần rà soát lại những “Điểm đen” thường xảy ra TNGT để có hướng xử lý, khắc phục kịp thời; tăng cường công tác tuyên truyền về Luật Giao thông đường bộ cho mọi tầng lớp nhân dân. Nghiên cứu và có thể cho lắp hệ thống camera trên các trục đường chính để giám sát việc chấp hành Luật Giao thông đường bộ… Ông cũng nhắc nhở trong dịp Lễ hội Nghinh Ông sắp tới tại  huyện Đông Hải, Ban Tổ chức Lễ hội cần có kế hoạch tổ chức thật an toàn để bảo đảm trật tự ATGT./.");
                listDetailHome22.add("Nghiệp - Hình");
                break;
            }
            case 23:{
                //
                listDetailHome23.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-5/hoi%20nghi%20chuyen%20de2452018_83311.jpg");
                listDetailHome23.add("Bí thư Tỉnh ủy Nguyễn Quang Dương phát biểu chỉ đạo Hội nghị");
                listDetailHome23.add("Phát biểu khai mạc Hội nghị, Chủ tịch UBND tỉnh Dương Thành Trung nhấn mạnh vai trò quan trọng của công tác tiếp công dân, giải quyết khiếu nại, tố cáo nhằm đảm bảo quyền và lợi ích chính đáng của công dân, củng cố niềm tin của nhân dân đối với chính quyền và góp phần nâng cao hiệu lực, hiệu quả quản lý nhà nước.");
                listDetailHome23.add("Trong những năm qua, công tác tiếp dân, giải quyết đơn thư khiếu nại, tố cáo luôn được tỉnh quan tâm, chỉ đạo và đạt được nhiều kết quả quan trọng. Từ năm 2015 đến Quý I năm 2018, các ngành, các cấp đã tích cực tham mưu giải quyết 1.818/1.883 vụ thuộc thẩm quyền, đạt tỷ lệ 96,5%.");
                listDetailHome23.add("Tại Hội nghị, các tham luận tập trung đề cập tới những khó khăn, bất cập cũng như kiến nghị giải quyết liên quan tới thủ tục cấp đổi, cấp lần đầu giấy chứng nhận quyền sử dụng đất, đền bù, giải phóng mặt bằng. Đồng thời, các tham luận cũng đưa ra nhiều giải pháp tăng cường lãnh đạo, chỉ đạo công tác tiếp công dân, giải quyết khiếu nại, tố cáo và phòng, chống tham nhũng; tăng cường phối hợp giữa các phòng, ban chuyên môn với các phường, xã để giải quyết dứt điểm các vụ việc tại cấp cơ sở; thực hiện công khai, minh bạch, khách quan và dân chủ trong giải quyết công việc và công tác cán bộ; tăng cường đối thoại giữa lãnh đạo tỉnh với công dân; phát huy vai trò của các cơ quan thông tin đại chúng trong phòng, chống tham nhũng, lãng phí...");
                listDetailHome23.add("Phát biểu chỉ đạo Hội nghị, đồng chí Nguyễn Quang Dương, Ủy viên BCH Trung ương Đảng, Bí thư Tỉnh ủy đã ghi nhận những kết quả mà các cấp, các ngành đã đạt được trong công tác giải quyết khiếu nại tố cáo trên địa bàn tỉnh. Đồng chí đề nghị, trong thời gian tới, các cấp, các ngành trong quá trình giải quyết khiếu nại, tố cáo cần tập trung tìm nguyên nhân để có hướng giải quyết cho phù hợp; xử lý nghiêm các cán bộ có sai phạm dẫn đến khiếu nại, tố cáo của người dân; đối với các vụ khiếu nại, tố cáo phức tạp kéo dài, phải có phương pháp và kế hoạch giải quyết từng vụ; cố gắng giải quyết các vụ khiếu nại, tố cáo ngay tại cơ sở./.");
                listDetailHome23.add("Đức Hình");
                break;
            }
            case 24:{
                listDetailHome24.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20nghi%20trien%20khai%20VBPL1342018_84612.jpg");
                listDetailHome24.add("Đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp phát biểu khai mạc Hội nghị");
                listDetailHome24.add("Phát biểu khai mạc Hội nghị, đồng chí Nguyễn Bá Ân, Giám đốc Sở Tư pháp cho biết Hội nghị sẽ triển khai nội dung về hướng dẫn trình tự, thủ tục trong xử lý vi phạm hành chính; một số nội dung cơ bản của Luật Đấu giá tài sản và Nghị định số 62/2017/NĐ-CP ngày 16/5/2014 của Chính phủ quy định chi tiết một số điều và biện pháp thi hành Luật Đấu giá tài sản; nội dung cơ bản của Luật Hộ tịch, công tác chứng thực, lý lịch tư pháp....");
                listDetailHome24.add("Hội nghị triển khai các văn bản pháp luật nhằm nâng cao nhận thức, tinh thần trách nhiệm, tính chủ động của Lãnh đạo các cơ quan, đơn vị, cán bộ, công chức trong công tác quản lý nhà nước về hộ tịch, công tác thi hành Luật Đấu giá, xử lý vi phạm hành chính. Hội nghị tập huấn lần này diễn ra trong 1,5 ngày, từ ngày 10/4 đến hết buổi sáng ngày 11/4./.");
                listDetailHome24.add("Đức Hình");
                break;
            }
            case 25:{
                listDetailHome25.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2018-4/hoi%20dong%20nhan%20dan242018_103857.jpg");
                listDetailHome25.add("Ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh phát biểu tại buổi làm việc");
                listDetailHome25.add("Nhìn chung, người dân địa phương khá hài lòng về công tác CCHC của địa phương, đa số các thủ tục được giải quyết kịp thời, đúng thời hạn. Tuy nhiên, vẫn có ý kiến đóng góp về sự chậm trễ ở lĩnh vực đất đai, xác nhận hồ sơ người có công… Để khắc phục sự chậm trễ như đã qua, UBND xã Ninh Hòa kiến nghị với Đoàn một số nội dung như: Có cơ chế hỗ trợ về cơ sở vật chất, trang thiết bị đối với bộ phận một cửa; tổ chức các lớp tập huấn nâng cao nghiệp vụ cho cán bộ, công chức phụ trách Bộ phận tiếp nhận và trả kết quả; hỗ trợ để xã được cập nhật và triển khai các văn bản mới…");
                listDetailHome25.add("Buổi chiều cùng ngày, Đoàn giám sát làm việc với UBND huyện Hồng Dân về công tác cải cách hành chính của huyện, giai đoạn 2015 - 2017. Theo báo cáo đánh giá cho thấy, huyện Hồng Dân đã nghiêm túc thực hiện các quy định về kỷ luật, kỷ cương hành chính tại cơ quan, đơn vị; giải quyết nhanh chóng, đúng quy định các thủ tục hành chính cho tổ chức, công dân; tổ chức tiếp nhận, xử lý phản ánh, kiến nghị của cá nhân, tổ chức theo quy định; công khai minh bạch các thủ tục hành chính trên tất cả các lĩnh vực tại trụ sở cơ quan, bộ phận tiếp nhận và trả kết quả theo cơ chế một cửa của huyện; hầu hết các đơn vị xã, thị trấn đều đạt điểm hài lòng của người dân về dân chủ cơ sở từ 56 - 60/60 điểm; mức độ hài lòng của người dân về tính công khai, minh bạch của các đơn vị đạt 69/70 điểm…");
                listDetailHome25.add("Ông Hồ Thanh Thủy, Phó Chủ tịch HĐND tỉnh ghi nhận kết quả cải cách hành chính của huyện trong thời gian qua, đồng thời, đề nghị UBND huyện lưu ý việc tăng cường trách nhiệm của cấp ủy, người đứng đầu trong thực hiện công tác cải cách hành chính; cần có kế hoạch thu gọn một số thủ tục rườm rà; chấn chỉnh việc niêm yết, công bố các thủ tục hành chính mới theo hướng công khai, đơn giản và thuận tiện cho người dân; huyện cần quan tâm hơn nữa công tác giáo dục, tuyên truyền cho cán bộ, công chức về tinh thần, trách nhiệm, chấp hành kỷ cương, kỷ luật trong thực hiện công vụ; đặc biệt, huyện phải quan tâm, phát huy tốt hiệu quả Trung tâm hành chính công của huyện./.");
                listDetailHome25.add("Ngọc Hiền");
                break;
            }
            case 26:{
                listDetailHome26.add("Thực hiện chủ đề Năm an toàn giao thông 2015 “Siết chặt quản lý kinh doanh vận tải và kiểm soát tải trọng phương tiện” với mục tiêu “Tính mạng con người là trên hết”, Kế hoạch đề ra một số nhiệm vụ trọng tâm như: Tăng cường sự lãnh đạo, chỉ đạo thường xuyên của cấp ủy đảng, chính quyền, các ngành, các tổ chức đoàn thể từ tỉnh đến cơ sở đối với công tác bảo đảm TTATGT, chống ùn tắc giao thông.");
                listDetailHome26.add("http://baclieu.gov.vn/_layouts/LacVietBIO/fckUpload_BL/SiteChinh/2015-3/NamATGT2632015_16515.jpg");
                listDetailHome26.add("Lực lượng ĐVTN ra quân hưởng ứng Năm ATGT 2015");
                listDetailHome26.add("Ngoài ra, tập trung tuyên truyền, phổ biến quy định pháp luật về quản lý hoạt động vận tải khách và hàng hóa ở các lĩnh vực đường bộ, đường thủy nội địa đến các cơ quan, đơn vị, doanh nghiệp vận tải, người điều khiển phương tiện. Đổi mới công tác tuyên truyền, phổ biến, giáo dục pháp luật về TTATGT tới mọi tầng lớp nhân dân để nâng cao ý thức tự giác chấp hành pháp luật khi tham gia giao thông, đẩy mạnh xây dựng văn hóa giao thông.\n" +
                        "\n" +
                        "Tiếp tục nâng cao năng lực hiệu quả quản lý nhà nước trong lĩnh vực bảo đảm TTATGT. Trong đó, chú trọng công tác quản lý hoạt động vận tải, quản lý việc đào tạo, sát hạch cấp giấy phép lái xe, đăng ký, đăng kiểm phương tiện giao thông. Đẩy mạnh tiến độ, siết chặt quản lý chất lượng các công trình kết cấu hạ tầng giao thông; xây dựng và tổ chức thực hiện có hiệu quả kế hoạch bảo trì, bảo dưỡng kết cấu hạ tầng giao thông; nghiên cứu, tổ chức giao thông khoa học, hợp lý; đẩy nhanh rà soát, lắp đặt hệ thống biển báo phù hợp với quy chuẩn kỹ thuật quốc gia về báo hiệu đường bộ; thường xuyên rà soát và khắc phục kịp thời các điểm đen, vị trí mất ATGT.\n" +
                        "\n" +
                        "Đẩy mạnh hoạt động tuần tra, kiểm soát và xử lý các hành vi vi phạm TTATGT. Tăng cường kiểm tra, xử lý nghiêm các hành vi vi phạm của xe chở khách, hành vi chở quá tải trọng phương tiện trong vận tải hàng hóa. Tăng cường thanh tra, kiểm tra, xử lý nghiêm các hành vi sai phạm của người thực thi công vụ trong khi làm nhiệm vụ.\n" +
                        "\n" +
                        "Ngoài ra, tiếp tục nhân rộng các mô hình an toàn giao thông; đầu tư camera quan sát giao thông, nhận dạng biển số đen, xử lý vi phạm tốc độ, vượt đèn đỏ; nâng cao hiệu quả quản lý trật tự lòng đường, vỉa hè, hành lang an toàn giao thông đường bộ, hành lang an toàn giao thông đường thủy");
                listDetailHome26.add("NL");
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
            case 15:{
                loadDataById(listDetailHome15);
                break;
            }
            case 16:{
                loadDataById(listDetailHome16);
                break;
            }
            case 17:{
                loadDataById(listDetailHome17);
                break;
            }
            case 18:{
                loadDataById(listDetailHome18);
                break;
            }
            case 19:{
                loadDataById(listDetailHome19);
                break;
            }
            case 20:{
                loadDataById(listDetailHome20);
                break;
            }
            case 21:{
                loadDataById(listDetailHome21);
                break;
            }
            case 22:{
                loadDataById(listDetailHome22);
                break;
            }
            case 23:{
                loadDataById(listDetailHome23);
                break;
            }
            case 24:{
                loadDataById(listDetailHome24);
                break;
            }
            case 25:{
                loadDataById(listDetailHome25);
                break;
            }
            case 26:{
                loadDataById(listDetailHome26);
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
                View layout2 = LayoutInflater.from(DetailHomeActivityTemp.this).inflate(R.layout.item_image, loBody, false);

                TextView textView = layout2.findViewById(R.id.tvImageText);
                ImageView imgView = layout2.findViewById(R.id.imvImage);
                image = listDetailHome.get(i);
                text = listDetailHome.get(i+1);
                //
                textView.setText(text);
                Picasso.with(DetailHomeActivityTemp.this).load(image).into(imgView);

                loBody.addView(layout2);
                i++;

            } else {
                View layout1 = LayoutInflater.from(DetailHomeActivityTemp.this).inflate(R.layout.item_text, loBody, false);

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