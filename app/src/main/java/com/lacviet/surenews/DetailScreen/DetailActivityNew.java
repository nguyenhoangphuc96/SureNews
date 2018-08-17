package com.lacviet.surenews.DetailScreen;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import android.widget.Toast;

import com.lacviet.surenews.Adapter.SamenewsRCVAdapter;
import com.lacviet.surenews.Comment.CommentHomeActivity;
import com.lacviet.surenews.Comment.CommentRCVAdapter;
import com.lacviet.surenews.Feedback.FeedbackActivity;
import com.lacviet.surenews.KeyString;
import com.lacviet.surenews.MainActivity;
import com.lacviet.surenews.Model.CommentModel;
import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.AllNewsJsonResponse;
import com.lacviet.surenews.WebAPI.ModelAPI.ContentModel;
import com.lacviet.surenews.WebAPI.ModelAPI.DetailJsonResponse;
import com.lacviet.surenews.WebAPI.ModelAPI.NewsModel;
import com.lacviet.surenews.WebAPI.Remote.ApiService;
import com.lacviet.surenews.WebAPI.Remote.ApiUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailActivityNew extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar pbDetail;
    LinearLayout loBody;
    TextView tvTitle, tvTime, tvSubTitle, textView;

    //
    String id;
    String title = "";
    String time = "";
    String subtitle = "";
    String image = "";
    String text = "";
    String author = "";
    String categoryId = "";
    String subCategoryId = "";
    //change size
    float sizeTitleDefault, sizeContentDefault, sizeTimeDefault, sizeTitle, sizeContent, sizeTime, sizecaptionImage;

    //
    View layoutImage, layoutText, layoutAuthor;
    //same news
    View layoutSameNews;
    SamenewsRCVAdapter mAdapter;
    RecyclerView recyclerView;
    ProgressBar pbSameNew;
    //
    TextToSpeech textToSpeech;
    Boolean isClickSpeak = false;
    //api
    ApiService mService;
    List<ContentModel> listContent;
    List<NewsModel> listSameNews;
    //
    TextView textCartItemCount;
    int countComment = 7;
    //
    View layoutComment;
    CommentRCVAdapter commentRCVAdapter;
    RecyclerView rcvComment;
    ProgressBar pbComment;
    ArrayList<CommentModel> ListCmt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        addControl();
        actionBar();
        textSize();
        getDatafromPreviousActivity();
        loadListContentById(id);
        //showTTSSetting();


    }

    private void showTTSSetting() {
        Intent intent = new Intent();
        intent.setAction("com.android.settings.TTS_SETTINGS");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    private void addSamenews() {
        layoutSameNews = LayoutInflater.from(DetailActivityNew.this).inflate(R.layout.view_same_news, loBody, false);
        recyclerView = layoutSameNews.findViewById(R.id.rcvSameNews);
        pbSameNew = layoutSameNews.findViewById(R.id.pbSameNews);
        showDataToRecyclerView();

        loBody.addView(layoutSameNews);


    }

    private void getListSameNews(String categoryId) {
        mService.getAllNewsByPage(categoryId, 1, 10).enqueue(new Callback<AllNewsJsonResponse>() {
            @Override
            public void onResponse(Call<AllNewsJsonResponse> call, Response<AllNewsJsonResponse> response) {

                if (response.isSuccessful()) {

                    listSameNews = response.body().getNewsModels();
                    mAdapter.updateAnswers(listSameNews);
                    pbSameNew.setVisibility(View.GONE);
                    Log.d("AnswersPresenter", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Toast.makeText(DetailActivityNew.this, "Error" + statusCode + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllNewsJsonResponse> call, Throwable t) {
                Toast.makeText(DetailActivityNew.this, "Vui lòng kiểm tra kết nối!", Toast.LENGTH_SHORT).show();
                Log.d("AnswersPresenter", "error loading from API");

            }
        });

    }

    private void showDataToRecyclerView() {
        mAdapter = new SamenewsRCVAdapter(this, new ArrayList<NewsModel>(0), new SamenewsRCVAdapter.PostItemListener() {


            @Override
            public void onPostClick(String id, String title, String time, String subTitle, String categoryId) {
                startDetailActivity(id);
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
    private void showDataToRecyclerViewComment() {
        commentRCVAdapter = new CommentRCVAdapter(this, new ArrayList<CommentModel>(0), new CommentRCVAdapter.PostItemListener() {
            @Override
            public void onPostClick() {

            }
        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rcvComment.setLayoutManager(layoutManager);
        rcvComment.setAdapter(commentRCVAdapter);
        rcvComment.setHasFixedSize(true);

    }

    private void startDetailActivity(String id) {
        Intent intent = new Intent(DetailActivityNew.this, DetailActivityNew.class);
        KeyString key = new KeyString();
        intent.putExtra(key.ID, id);
        startActivity(intent);
    }


    private void textSize() {
        TypedValue varSizeTitle = new TypedValue();
        getResources().getValue(R.dimen.textsize_title_default, varSizeTitle, true);
        sizeTitleDefault = varSizeTitle.getFloat();
        sizeTitle = varSizeTitle.getFloat();
        //
        TypedValue varSizeContent = new TypedValue();
        getResources().getValue(R.dimen.textsize_content_default, varSizeContent, true);
        sizeContentDefault = varSizeContent.getFloat();
        sizeContent = varSizeContent.getFloat();
        //
        TypedValue varSizeTime = new TypedValue();
        getResources().getValue(R.dimen.textsize_time_default, varSizeTime, true);
        sizeTimeDefault = varSizeTime.getFloat();
        sizeTime = varSizeTime.getFloat();
        //
        sizecaptionImage = 15;
    }

    private void loadListContentById(String id) {
        mService.getDetailbyId(id).enqueue(new Callback<DetailJsonResponse>() {
            @Override
            public void onResponse(Call<DetailJsonResponse> call, Response<DetailJsonResponse> response) {

                if (response.isSuccessful()) {
                    //
                    title = response.body().getTitle();
                    time = response.body().getPublishedDate();
                    subtitle = response.body().getDescription();
                    author = response.body().getAuthor();

                    //
                    tvTitle.setText(title);
                    tvTime.setText(time);
                    tvSubTitle.setText(subtitle);
                    //
                    listContent = new ArrayList<>();
                    listContent = response.body().getContent();
                    if (listContent != null) {
                        loadContent(listContent);
                        addComment();
                        addSamenews();
                    }
                    //same news
                    categoryId = response.body().getCategoryId();
                    String temp = categoryId.substring(categoryId.indexOf(";"));
                    subCategoryId = categoryId.replace(temp, "");
                    subCategoryId.trim();
                    getListSameNews(subCategoryId);
                    //Comment
                    getListComment();
                    Log.d("AnswersPresenter", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Toast.makeText(DetailActivityNew.this, "Error" + statusCode + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DetailJsonResponse> call, Throwable t) {
                Toast.makeText(DetailActivityNew.this, "Vui lòng kiểm tra kết nối", Toast.LENGTH_SHORT).show();
                Log.d("AnswersPresenter", "error loading from API");

            }
        });

    }

    private void getListComment() {
        ListCmt = new ArrayList<>();
        ListCmt.add(new CommentModel("1","Alan","28/1/2018","Bài viết hết sức bổ ích, đáng khen cho đội ngũ thực hiện ứng dụng này!"));
        ListCmt.add(new CommentModel("1","Sir. Alex","28/1/2018","Bài viết hết sức bổ ích, đáng khen cho đội ngũ thực hiện ứng dụng này!"));
        ListCmt.add(new CommentModel("1","Young Buffalo","28/1/2018","Bài viết hết sức bổ ích, đáng khen cho đội ngũ thực hiện ứng dụng này!"));
        ListCmt.add(new CommentModel("1","David Alaxander","28/1/2018","Tiếp và làm việc với Đoàn có đồng chí Phan Như Nguyện, Phó Chủ tịch UBND tỉnh; Ngô Hữu Dũng, Giám đốc Sở Giao thông vận tải"));
        ListCmt.add(new CommentModel("1","Kevin Cọt","28/1/2018","Bài viết hết sức bổ ích, đáng khen cho đội ngũ thực hiện ứng dụng này!"));
        ListCmt.add(new CommentModel("1","Young Buffalo","28/1/2018","Bài viết hết sức bổ ích, đáng khen cho đội ngũ thực hiện ứng dụng này!"));
        ListCmt.add(new CommentModel("1","Viettel","28/1/2018","Trưởng đoàn đã có buổi làm việc với tỉnh Bạc Liêu về việc kiểm tra, đôn đốc công tác bảo đảm trật tự ATGT trên địa bàn tỉnh."));
        commentRCVAdapter.updateAnswers(ListCmt);
        pbComment.setVisibility(View.GONE);
    }

    private void addComment() {
        layoutComment = LayoutInflater.from(DetailActivityNew.this).inflate(R.layout.view_comment, loBody, false);
        rcvComment = layoutComment.findViewById(R.id.rcvComment);
        pbComment = layoutComment.findViewById(R.id.pbComment);
        showDataToRecyclerViewComment();
        loBody.addView(layoutComment);

    }

    private void loadContent(List<ContentModel> list) {
        //body
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType() == 2) {
                layoutImage = LayoutInflater.from(DetailActivityNew.this).inflate(R.layout.item_image, loBody, false);

                textView = layoutImage.findViewById(R.id.tvImageText);
                ImageView imgView = layoutImage.findViewById(R.id.imvImage);
                image = list.get(i).getValue();


                if (i < list.size() - 1) {
                    text = list.get(i + 1).getValue();
                    textView.setText(text);
                } else {
                    textView.setText("");
                }

                //

                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizecaptionImage);
                Picasso.with(DetailActivityNew.this).load(image).into(imgView);

                loBody.addView(layoutImage);
                i++;

            } else {
                layoutText = LayoutInflater.from(DetailActivityNew.this).inflate(R.layout.item_text, loBody, false);

                textView = (TextView) layoutText.findViewById(R.id.tvText);

                textView.setText(list.get(i).getValue());
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeContent);

                loBody.addView(layoutText);
            }
        }
        //author
        layoutAuthor = LayoutInflater.from(DetailActivityNew.this).inflate(R.layout.item_text, loBody, false);

        textView = (TextView) layoutAuthor.findViewById(R.id.tvText);

        textView.setText(author);
        textView.setTypeface(null, Typeface.ITALIC);
        textView.setGravity(Gravity.END);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeContent);
        loBody.addView(layoutAuthor);
        pbDetail.setVisibility(View.GONE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        final MenuItem menuItem = menu.findItem(R.id.menu_comment);

        View actionView = MenuItemCompat.getActionView(menuItem);
        textCartItemCount = actionView.findViewById(R.id.cart_badge);

        setupBadge();

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });

        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    private void setupBadge() {
        if (textCartItemCount != null) {
            if (countComment == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(countComment, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_decrease_size: {
                sizeContent = sizeContent - 1;
                tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, --sizeTitle);
                tvSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeContent);
                tvTime.setTextSize(TypedValue.COMPLEX_UNIT_SP, --sizeTime);
                //

                loBody.removeViews(3, loBody.getChildCount() - 3);
                loadListContentById(id);
                //addSamenews();
                return true;
            }
            case R.id.menu_default_size: {
                sizeContent = sizeContentDefault;
                sizeTime = sizeTimeDefault;
                sizeTitle = sizeTitleDefault;
                tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeTitleDefault);
                tvSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeContentDefault);
                tvTime.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeTimeDefault);
                //
                loBody.removeViews(3, loBody.getChildCount() - 3);
                loadListContentById(id);
                //addSamenews();
                return true;
            }
            case R.id.menu_increase_size: {
                sizeContent = sizeContent + 1;
                tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, ++sizeTitle);
                tvSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeContent);
                tvTime.setTextSize(TypedValue.COMPLEX_UNIT_SP, ++sizeTime);
                //

                loBody.removeViews(3, loBody.getChildCount() - 3);
                loadListContentById(id);
                //addSamenews();
                return true;
            }
            case R.id.menu_speak: {

                if (!isClickSpeak) {

                    Intent ttsIntent = new Intent();
                    ttsIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
                    startActivityForResult(ttsIntent, 0);

                } else {
                    textToSpeech.stop();
                    isClickSpeak = false;
                }
                return true;
            }
            case R.id.menu_comment:{
                startCommentActivity();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startCommentActivity() {
        Intent intent = new Intent(DetailActivityNew.this, CommentHomeActivity.class);
        KeyString key = new KeyString();
        intent.putExtra(key.TITLE, title);
        startActivity(intent);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == 0) {
            if (resultCode ==
                    TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // Data exists, so we instantiate the TTS engine
                textToSpeech = new TextToSpeech(DetailActivityNew.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            if (textToSpeech != null) {
                                int result = textToSpeech.setLanguage(new Locale("vi"));
                                if (result == TextToSpeech.LANG_MISSING_DATA || result ==
                                        TextToSpeech.LANG_NOT_SUPPORTED) {
                                    Toast.makeText(DetailActivityNew.this, "TTS language is not supported",
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    speakData(listContent);
                                }
                            }
                        } else {
                            Toast.makeText(DetailActivityNew.this, "TTS initialization failed",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
                //
                if (!textToSpeech.isSpeaking()) {
                    isClickSpeak = false;
                } else {
                    isClickSpeak = true;
                }

            } else {
                // Data is missing, so we start the TTS installation
                // process
                Intent installIntent = new Intent();
                installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
                Toast.makeText(getApplicationContext(), "Installed Now", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void speakData(List<ContentModel> list) {
        String stringToSpeech;
        //
        stringToSpeech = title + "." + subtitle;
        //body
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType() == 2) {
                i++;
            } else {
                stringToSpeech = stringToSpeech + list.get(i).getValue();
            }
        }
        textToSpeech.speak(stringToSpeech, TextToSpeech.QUEUE_FLUSH, null);
        isClickSpeak = true;

    }

    @Override
    protected void onPause() {
        super.onPause();
        //shut down speech when close app
        if (textToSpeech != null) {
            textToSpeech.shutdown();
            isClickSpeak = false;
        }
    }

    private void getDatafromPreviousActivity() {
        Bundle extras = this.getIntent().getExtras();
        KeyString key = new KeyString();
        id = extras.getString(key.ID);
    }


    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        pbDetail = findViewById(R.id.pbDetail);
        loBody = findViewById(R.id.loBody);
        tvTitle = findViewById(R.id.tvTitle);
        tvTime = findViewById(R.id.tvTime);
        tvSubTitle = findViewById(R.id.tvSubTitle);
        //
        mService = ApiUtils.getSOService();
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