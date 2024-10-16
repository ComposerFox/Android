package com.example.reservation;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnEnd;
    RadioButton rdocal, rdotime;
    CalendarView calendar;
    TimePicker timepicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    Chronometer chro;
    int year1, month1, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        calendar = findViewById(R.id.calendar);
        timepicker = findViewById(R.id.timepicker);
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvMinute = findViewById(R.id.tvMinute);
        rdocal = findViewById(R.id.rdocal);
        rdotime = findViewById(R.id.rdotime);
        chro = findViewById(R.id.chro);
        calendar.setVisibility(View.INVISIBLE);

        rdocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.INVISIBLE);
                timepicker.setVisibility(View.INVISIBLE);
            }
        });

        rdotime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.INVISIBLE);
                timepicker.setVisibility(View.INVISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chro.setBase(SystemClock.elapsedRealtime());
                chro.start();
                chro.setTextColor(Color.RED);
            }
        });
    }
}