package com.example.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgroup;
    Button play, stop;
    ProgressBar prog;
    TextView text;
    MediaPlayer mplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgroup = findViewById(R.id.rgroup);
        play = findViewById(R.id.play);
        stop = findViewById(R.id.stop);
        prog = findViewById(R.id.prog);
        text = findViewById(R.id.text);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rgroup.getCheckedRadioButtonId()) {
                    case R.id.song1:
                        mplay = MediaPlayer.create(MainActivity.this, R.raw.angel);
                        mplay.start();
                        prog.setVisibility(View.VISIBLE);
                        text.setText("angel 음악이 실행중");
                        break;
                    case R.id.song2:
                        mplay = MediaPlayer.create(MainActivity.this, R.raw.mysong);
                        mplay.start();
                        prog.setVisibility(View.VISIBLE);
                        text.setText("mysong 음악이 실행중");
                        break;
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rgroup.getCheckedRadioButtonId()) {
                    case R.id.song1:
                        mplay.stop();
                        prog.setVisibility(View.INVISIBLE);
                        text.setText("angel 음악 재생 중지");
                        break;
                    case R.id.song2:
                        mplay.stop();
                        prog.setVisibility(View.INVISIBLE);
                        text.setText("mysong 음악 재생 중지");
                        break;
                }
            }
        });
    }
}