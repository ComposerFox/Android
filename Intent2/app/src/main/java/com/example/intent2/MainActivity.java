package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup group;
    Button btnmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = findViewById(R.id.group);
        btnmain = findViewById(R.id.btnmain);

        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.rdosecond:
                        Intent intent2 = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.rdothird:
                        Intent intent3 = new Intent(getApplicationContext(), ThirdActivity.class);
                        startActivity(intent3);
                        break;
                }
            }
        });
    }
}