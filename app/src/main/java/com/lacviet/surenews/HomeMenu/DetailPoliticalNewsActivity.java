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

import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailPoliticalNewsActivity extends AppCompatActivity {
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
        for (int i = 0; i < listDetailHome.size(); i++) {
            if (listDetailHome.get(i).startsWith("http://")) {
                View layout2 = LayoutInflater.from(DetailPoliticalNewsActivity.this).inflate(R.layout.item_image, loBody, false);

                TextView textView = layout2.findViewById(R.id.tvImageText);
                ImageView imgView = layout2.findViewById(R.id.imvImage);
                image = listDetailHome.get(i);
                text = listDetailHome.get(i + 1);
                //
                textView.setText(text);
                Picasso.with(DetailPoliticalNewsActivity.this).load(image).into(imgView);

                loBody.addView(layout2);
                i++;

            } else {
                View layout1 = LayoutInflater.from(DetailPoliticalNewsActivity.this).inflate(R.layout.item_text, loBody, false);

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