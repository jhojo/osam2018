package com.example.user.testapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMyPage, btnGetOut, btnCommunity;
    private FragmentManager fm;
    private FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMyPage = findViewById(R.id.btn_mypage);
        btnGetOut = findViewById(R.id.btn_getout);
        btnCommunity = findViewById(R.id.btn_community);
        fm = getSupportFragmentManager();

        btnMyPage.setOnClickListener(this);
        btnGetOut.setOnClickListener(this);
        btnCommunity.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        ft = fm.beginTransaction();

        btnMyPage.setSelected(false);
        btnCommunity.setSelected(false);
        btnGetOut.setSelected(false);
        switch(v.getId()) {
            case R.id.btn_mypage:
                btnMyPage.setSelected(true);
                ft.replace(R.id.fragment_area, new ReportActivity());
                break;
            case R.id.btn_getout:
                btnGetOut.setSelected(true);
                ft.replace(R.id.fragment_area, new ReportActivity_manager());
                break;
            case R.id.btn_community:
                btnCommunity.setSelected(true);
                ft.replace(R.id.fragment_area, new MypageActivity());
                break;
        }
        ft.commit();
    }
}
