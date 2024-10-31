package com.example.resraw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnRead;
    EditText edtRaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = findViewById(R.id.btnRead);
        edtRaw = findViewById(R.id.edtRaw);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputStream infs = getResources().openRawResource(R.raw.text);
                byte[] txt;

                try {

                    txt = new byte[infs.available()];
                    infs.read(txt);
                    edtRaw.setText(new String(txt));
                    infs.close();
                } catch(IOException e) {

                }
            }
        });
    }
}