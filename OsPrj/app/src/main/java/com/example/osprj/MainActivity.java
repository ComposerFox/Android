package com.example.osprj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int count[] = new int[3];
        for (int i =0; i < count.length; i++) {
            count[i] = 0;
        }
        ImageView image[] = new ImageView[3];
        Integer imageid[] = {R.id.iv1, R.id.iv2, R.id.iv3};

        final String imgname[] = {"windows", "mac", "linux"};

        for (int i = 0; i < image.length; i++) {
            final int index = i;
            image[index] = findViewById(imageid[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[index]++;
                    Toast.makeText(getApplication(), "총" + count[index], Toast.LENGTH_LONG).show();
                }
            });
        }

        btnresult = findViewById(R.id.btnresult);
        btnresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                                SecondActivity.class);
                intent.putExtra("votecount", count);
                intent.putExtra("imagename", imgname);
                startActivity(intent);
            }
        });
    }
}