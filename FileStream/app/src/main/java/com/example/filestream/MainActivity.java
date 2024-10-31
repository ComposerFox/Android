package com.example.filestream;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnWrite, btnRead;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);
        text = findViewById(R.id.text);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outfs = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = "android file save";
                    outfs.write(str.getBytes());
                    outfs.close();
                    Toast.makeText(getApplicationContext(), "succes", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                  e.printStackTrace();
                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream infs = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    infs.read(txt);
                    String str = new String(txt);
                    infs.close();
                    text.setText("읽음" + str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}