package com.example.autocomplete;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView auto;
    MultiAutoCompleteTextView multi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auto = findViewById(R.id.auto);
        multi = findViewById(R.id.multi);

        String[] items = {"CSI-라스베가스", "CSI-뉴욕", "CSI-마이애미", "Friends", "Frienge"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView.CommaTokenizer tokenizer = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(tokenizer);
        multi.setAdapter(adapter);
    }
}