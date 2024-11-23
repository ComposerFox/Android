package com.example.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        final String[] mid = {"aaa", "bbb", "ccc", "ddd"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mid);
        listview.setAdapter(adapter);
    }
}