package com.example.osprj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button btnback;
    TextView[] tv;
    RatingBar[] rbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnback = findViewById(R.id.btnback);
        tv = new TextView[3];

        Integer[] tvid = {R.id.iv1, R.id.iv2, R.id.iv3};
        Integer[] rbarid = {R.id.rbar1, R.id.rbar2, R.id.rbar3};

        for (int i = 0; i < 3; i++) {
            tv[i] = findViewById(tvid[i]);
            rbar[i] = findViewById(rbarid[i]);
        }

        int[] votecount = new int[3];
        String[] imgname = new String[3];
        Intent intent = getIntent();

        votecount = intent.getIntArrayExtra("votecount");
        imgname = intent.getStringArrayExtra("imagename");

        for (int i = 0; i < 3; i++) {
            tv[i].setText(imgname[i]);
            rbar[i].setRating((float) votecount[i]);
        }

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}