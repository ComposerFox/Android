package com.example.osapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView text2;
    RadioGroup group;
    Button click;
    ImageView img;
    CheckBox chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text2 = findViewById(R.id.text2);
        group = findViewById(R.id.group);
        click = findViewById(R.id.click);
        img = findViewById(R.id.img);
        chk = findViewById(R.id.chk);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chk.isChecked()) {
                    text2.setVisibility(View.VISIBLE);
                    group.setVisibility(View.VISIBLE);
                    click.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }else {
                    text2.setVisibility(View.INVISIBLE);
                    group.setVisibility(View.INVISIBLE);
                    click.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedId = group.getCheckedRadioButtonId();

                if (checkedId == R.id.windows) {
                    img.setImageResource(R.drawable.windows);
                } else if (checkedId == R.id.mac) {
                    img.setImageResource(R.drawable.mac);
                } else if (checkedId == R.id.linux) {
                    img.setImageResource(R.drawable.linux);
                }
            }
        });

    }
}