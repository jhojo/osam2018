package com.example.user.testapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ReportActivity_manager extends AppCompatActivity {


    ArrayList<DataModel> dataModels;
    ListView listView;
    private static DataAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_manager);

        listView=(ListView)findViewById(R.id.list_view);

        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("홍길동", "010-11-111", "19시30분","이상무"));
    }
}
