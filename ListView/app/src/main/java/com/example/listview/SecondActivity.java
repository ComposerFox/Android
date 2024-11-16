package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        back = findViewById(R.id.back);

        // 데이터를 가져옴
        Intent intent = getIntent();
        final int hap = intent.getIntExtra("num1", 100)
                      + intent.getIntExtra("num2", 200);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 데이터를 다시 넘겨줌
                Intent outIntent = new Intent(SecondActivity.this,
                                                MainActivity.class);
                outIntent.putExtra("Hap", hap);
                setResult(RESULT_OK, outIntent);

                finish();
            }
        });
    }
}