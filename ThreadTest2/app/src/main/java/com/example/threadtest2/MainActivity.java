package com.example.threadtest2;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ProgressBar seek1, seek2;
    Button btnStart;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seek1 = (ProgressBar) findViewById(R.id.seek1);
        seek2 = (ProgressBar) findViewById(R.id.seek2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {  // Thread 생성
                    public void run() { // Thread 실행 메소드
                        for (int i = 0; i < 100; i++) { // Thread 수행 내용
                            seek1.setProgress(seek1.getProgress() + 2);
                            tv1.setText("1번 진행률" + seek1.getProgress() + "%");
                            SystemClock.sleep(100);
                        }
                    }
                }.start();  // Thread 실행

                new Thread() {  // Thread 생성
                    public void run() { // Thread 실행 메소드
                        for (int i = 0; i < 100; i++) { // Thread 수행 내용
                            seek2.setProgress(seek2.getProgress() + 1);
                            tv2.setText("2번 진행률" + seek2.getProgress() + "%");
                            SystemClock.sleep(100);
                        }
                    }
                }.start();  // Thread 실행
            }
        });
    }
}