package com.lacviet.surenews.Feedback;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.lacviet.surenews.MainActivity;
import com.lacviet.surenews.R;

public class SDTConfirmActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView tvTitleToolbar,tvConfirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdt_confirm);
        addControl();
        actionBar();
        addEvent();
    }

    private void addEvent() {
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogSuccess();
            }
        });

    }

    private void showDialogSuccess() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Gửi phản ánh thành công!");
        alertDialogBuilder
                .setMessage("Bạn có muốn tiếp tục gửi phản ánh khác?")
                .setCancelable(false)
                .setPositiveButton("Có",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })

                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startMainActivity();
                        //dialog.cancel();
                    }
                })
        .setIcon(R.drawable.ic_success);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void startMainActivity() {
        Intent intent = new Intent(SDTConfirmActivity.this, MainActivity.class);
        startActivity(intent);
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
        tvConfirm = findViewById(R.id.tvConfirm);


    }
}
