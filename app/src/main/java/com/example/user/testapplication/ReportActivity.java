package com.example.user.testapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class ReportActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_report, container, false);

        /* 테스트용
        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                set_Date("test");
                Toast.makeText(v.getContext(), get_Time(), Toast.LENGTH_SHORT).show();
                Toast.makeText(v.getContext(), get_Text(), Toast.LENGTH_LONG).show();
            }
        });
    */
        return v;
    }

    public void set_Date(String text) {
        TextView textview = (TextView) getView().findViewById(R.id.text_index1_date);  //UPDATE
        textview.setText(text);
    }

    public String get_Time() {
        TimePicker timepicker = (TimePicker)getView().findViewById(R.id.timePicker);
        TextView t = (TextView) getView().findViewById(R.id.text_index1_date);
        int hour = timepicker.getCurrentHour();
        int min = timepicker.getCurrentMinute();
        return hour+":"+min;
    }

    public String get_Text() {
        EditText editText = (EditText) getView().findViewById(R.id.editText4);  //UPDATE
        return editText.getText().toString();
    }
}