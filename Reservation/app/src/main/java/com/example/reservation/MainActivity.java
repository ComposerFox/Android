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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.reservation.R;

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
                calendar.setVisibility(View.VISIBLE);
                timepicker.setVisibility(View.INVISIBLE);
            }
        });

        rdotime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.INVISIBLE);
                timepicker.setVisibility(View.VISIBLE);
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

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                year1 = year;
                month1 = month + 1;
                day = dayOfMonth;
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chro.stop();
                chro.setTextColor(Color.BLUE);
                tvYear.setText(Integer.toString(year1));
                tvMonth.setText(Integer.toString(month1));
                tvDay.setText(Integer.toString(day));

                // API 레벨에 따른 시간 설정
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    tvHour.setText(Integer.toString(timepicker.getHour()));   // API 23 이상
                    tvMinute.setText(Integer.toString(timepicker.getMinute())); // API 23 이상
                } else {
                    tvHour.setText(Integer.toString(timepicker.getCurrentHour())); // API 23 미만
                    tvMinute.setText(Integer.toString(timepicker.getCurrentMinute())); // API 23 미만
                }
            }
        });
    }
}