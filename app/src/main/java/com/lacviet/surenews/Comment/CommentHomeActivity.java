package com.lacviet.surenews.Comment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lacviet.surenews.Adapter.HomeTabRCVAdapterTemp;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.Model.CommentModel;
import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.NewsModel;

import java.util.ArrayList;

public class CommentHomeActivity extends AppCompatActivity{
    private Toolbar toolbar;
    private TextView tvTitleToolbar;
    String title = "";
    RecyclerView rcvCmt;
    ProgressBar pbCmt;
    //
    CommentRCVAdapter mAdapter;
    ArrayList<CommentModel> ListCmt;
    //
    LinearLayout loWrite;
    //
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        addControl();
        getDatafromPreviousActivity();
        actionBar();
        setMarginRCV();
        showDataToRecyclerView();
        showData();

    }

    private void setMarginRCV() {
        loWrite = findViewById(R.id.loWriteCmt);
        ViewTreeObserver vto = toolbar.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightLoWrite = loWrite.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams =
                        (ViewGroup.MarginLayoutParams) rcvCmt.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, heightLoWrite);
                rcvCmt.setLayoutParams(marginLayoutParams);
            }
        });


    }

    private void showData() {
        ListCmt = new ArrayList<>();
        ListCmt.add(new CommentModel("1","Alan","28/1/2018","Bài viết hết sức bổ ích, đáng khen cho đội ngũ thực hiện ứng dụng này!"));
        ListCmt.add(new CommentModel("1","Sir. Alex","28/1/2018","Bài viết hết sức bổ ích, đáng khen cho đội ngũ thực hiện ứng dụng này!"));
        ListCmt.add(new CommentModel("1","Young Buffalo","28/1/2018","Bài viết hết sức bổ ích, đáng khen cho đội ngũ thực hiện ứng dụng này!"));
        ListCmt.add(new CommentModel("1","David Alaxander","28/1/2018","Tiếp và làm việc với Đoàn có đồng chí Phan Như Nguyện, Phó Chủ tịch UBND tỉnh; Ngô Hữu Dũng, Giám đốc Sở Giao thông vận tải"));
        ListCmt.add(new CommentModel("1","Kevin Cọt","28/1/2018","Bài viết hết sức bổ ích, đáng khen cho đội ngũ thực hiện ứng dụng này!"));
        ListCmt.add(new CommentModel("1","Young Buffalo","28/1/2018","Bài viết hết sức bổ ích, đáng khen cho đội ngũ thực hiện ứng dụng này!"));
        ListCmt.add(new CommentModel("1","Viettel","28/1/2018","Trưởng đoàn đã có buổi làm việc với tỉnh Bạc Liêu về việc kiểm tra, đôn đốc công tác bảo đảm trật tự ATGT trên địa bàn tỉnh."));
        mAdapter.updateAnswers(ListCmt);
        pbCmt.setVisibility(View.GONE);

    }

    private void showDataToRecyclerView() {
        mAdapter = new CommentRCVAdapter(CommentHomeActivity.this, new ArrayList<CommentModel>(0), new CommentRCVAdapter.PostItemListener() {


            @Override
            public void onPostClick() {

            }


        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rcvCmt.setLayoutManager(layoutManager);
        rcvCmt.setAdapter(mAdapter);
        rcvCmt.setHasFixedSize(true);


    }
    private void getDatafromPreviousActivity() {
        Bundle extras = this.getIntent().getExtras();
        KeyString key = new KeyString();
        title = extras.getString(key.TITLE);
    }
    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        rcvCmt = findViewById(R.id.rcvComment);
        pbCmt = findViewById(R.id.pbComment);


    }
    private void actionBar() {
        setSupportActionBar(toolbar);
        tvTitleToolbar.setText(title);
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
