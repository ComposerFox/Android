package com.example.intent22;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button call, search, sms, map, start, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = findViewById(R.id.call);
        search = findViewById(R.id.search);
        sms = findViewById(R.id.sms);
        map = findViewById(R.id.map);

        Log.i("mainactivity", "onCreate 메소드 호출됨");
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:010-1111-2222");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"안드로이드");
                startActivity(intent);
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("smsto", "안녕하세요");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1111-2222")));
                startActivity(intent);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://maps.google.com/maps?q=" + 37.55 + "," + 126.91);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("mainactivity", "onCreate 메소드 호출됨");

            }
        });
    }

    @Override
    protected void onStart() {
        Log.i("mainactivity", "onCreate 메소드 호출됨");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i("mainactivity", "onRestart 메소드 호출됨");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("mainactivity", "onResume 메소드 호출됨");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.i("mainactivity", "onDestroy 메소드 호출됨");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i("mainactivity", "onPause 메소드 호출됨");
        super.onPause();
    }
}