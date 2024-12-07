package com.example.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    Switch switch1;
    MediaPlayer mplay;
    ImageView img;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);
        switch1 = findViewById(R.id.switch1);
        img = findViewById(R.id.img);
        text = findViewById(R.id.text);

        mplay = MediaPlayer.create(this, R.raw.angel);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch1.isChecked() == true) {
                    mplay.start();
                } else {
                    mplay.stop();
                }
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mplay.isPlaying() == false) {
                    mplay.start();
                    mplay.setLooping(true);
                    img.setImageResource(R.drawable.mac);
                    text.setVisibility(View.VISIBLE);
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mplay.isLooping() == true) {
                    mplay.stop();
                    img.setImageResource(R.drawable.linux);
                    text.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}