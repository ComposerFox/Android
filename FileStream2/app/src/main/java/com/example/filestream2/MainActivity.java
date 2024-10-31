package com.example.filestream2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    Button btnWrite;
    EditText edtDiary;
    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.dp);
        btnWrite = findViewById(R.id.btnWrite);
        edtDiary = findViewById(R.id.edtDiary);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                filename = Integer.toString(year) + "_" +
                           Integer.toString(monthOfYear + 1) + "_" +
                           Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(filename);
                edtDiary.setText(str);

            }
        });
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    FileOutputStream outfs = openFileOutput(filename, Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outfs.write(str.getBytes());
                    outfs.close();

                } catch (IOException e) {

                }

            }
        });
    }

    private String readDiary(String fname) {

        String str = null;
        FileInputStream infs = null;

        try {

            infs = openFileInput(fname);
            byte[] txt = new byte[30];
            infs.read(txt);
            infs.close();
            str = new String(txt);

        } catch (IOException e) {

        }

        return str;
    }
}