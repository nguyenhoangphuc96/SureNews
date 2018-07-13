package com.lacviet.surenews.Chart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.lacviet.surenews.R;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView tvTitleToolbar;
    //Chart
    LinearLayout loBodyChart;
    View layoutPieChart,layoutLineChart;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        addControl();
        actionBar();
        setupPieChart();
        setupLineChart();

    }

    private void setupLineChart() {
        layoutLineChart = LayoutInflater.from(ChartActivity.this).inflate(R.layout.view_line_chart, loBodyChart, false);
        LineChart lineChart = layoutLineChart.findViewById(R.id.linechart);
        TextView tvTitle = layoutLineChart.findViewById(R.id.tvTitleChart);
        tvTitle.setText("Thống kê số lượng phản ánh theo tháng");
        //thanh y trái
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.setAxisMaximum(100f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.enableGridDashedLine(10f,10f,0);
        leftAxis.setDrawLimitLinesBehindData(true);
        //ẩn thanh y phải
        lineChart.getAxisRight().setEnabled(false);
        //
        List<Entry> values = new ArrayList<>();
        values.add(new Entry(0,30));
        values.add(new Entry(1,89));
        values.add(new Entry(2,12));
        values.add(new Entry(3,76));
        values.add(new Entry(4,12));
        values.add(new Entry(5,2));
        values.add(new Entry(6,23));
        values.add(new Entry(7,12));
        values.add(new Entry(8,45));
        values.add(new Entry(9,11));
        values.add(new Entry(10,13));
        values.add(new Entry(11,7));

        LineDataSet lineDataSet = new LineDataSet(values,"");
        lineDataSet.setFillAlpha(110);
        lineDataSet.setColor(Color.RED);
        lineDataSet.setValueTextColor(Color.RED);
        lineDataSet.setValueTextSize(15f);
        lineDataSet.setLineWidth(2);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);

        LineData lineData = new LineData(dataSets);

        lineChart.setData(lineData);
        lineChart.invalidate();
        lineChart.animateXY(1000,1000);
        //thanh x
        String month[] = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4","Tháng 5", "Tháng 6",
                "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10","Tháng 11", "Tháng 12"};
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(month));


        loBodyChart.addView(layoutLineChart);

    }

    private void setupPieChart() {
        layoutPieChart = LayoutInflater.from(ChartActivity.this).inflate(R.layout.view_pie_chart, loBodyChart, false);
        //pie chart
        PieChart pieChart = layoutPieChart.findViewById(R.id.piechart);
        TextView tvTitle = layoutPieChart.findViewById(R.id.tvTitleChart);
        tvTitle.setText("Thống kê số lượng phản ánh theo lĩnh vực");
        float categories[] = {10, 27.5f, 40.5f,22};
        String categorynames[] = {"An ninh - Trật tự", "An toàn giao thông", "An toàn thực phẩm", "Khác"};
        //
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i = 0; i <categories.length; i++){
            pieEntries.add(new PieEntry(categories[i],categorynames[i]));
        }
        PieDataSet pieDataSet = new PieDataSet(pieEntries,"");
        pieDataSet.setColors(new int[] {R.color.colorBlueLight,R.color.colorAccent, R.color.colorOrange,R.color.colorBackgroundToolbarBlue},ChartActivity.this );
        pieDataSet.setValueTextSize(20);
        PieData pieData = new PieData(pieDataSet);
        //Formatter
        pieData.setValueFormatter(new PercentFormatter());
        pieDataSet.setValueFormatter(new PercentFormatter());
        //
        //Get chart

        pieChart.setData(pieData);
        pieChart.setEntryLabelColor(R.color.colorBlack);//color label
        pieChart.setDrawEntryLabels(true);
        pieChart.setEntryLabelTextSize(0);
        pieChart.animateXY(1000,1000);
        pieChart.invalidate();

        //legend
        Legend legend = pieChart.getLegend();
        legend.setTextSize(15);
        legend.setWordWrapEnabled(true);
        legend.setForm(Legend.LegendForm.CIRCLE); // set what type of form/shape should be used
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        //
        loBodyChart.addView(layoutPieChart);
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        tvTitleToolbar.setText(toolbar.getTitle());
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
    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        loBodyChart = findViewById(R.id.loBodyChart);
    }
}
