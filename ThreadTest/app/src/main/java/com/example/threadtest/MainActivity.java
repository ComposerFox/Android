package com.example.threadtest;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1;
    Button btninc, btndes;
    TextView text;
    SeekBar seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.pb1);
        btninc = findViewById(R.id.btninc);
        btndes = findViewById(R.id.btndes);
        text = findViewById(R.id.text);
        seek = findViewById(R.id.seek);

        btninc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb1.incrementProgressBy(10);
                seek.setProgress(seek.getProgress() + 10);
            }
        });
        btndes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb1.incrementProgressBy(-10);
                seek.setProgress(seek.getProgress() - 10);
            }
        });

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                text.setText("진행률" + i + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}