package com.example.database2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtdb, edttb, result;
    Button btndb, btntb;
    String dbname, tbname;
    SQLiteDatabase sdb;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtdb = findViewById(R.id.edtdb);
        edttb = findViewById(R.id.edttb);
        btndb = findViewById(R.id.btndb);
        btntb = findViewById(R.id.btntb);
        result = findViewById(R.id.result);

        btndb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbname = edtdb.getText().toString();
                sdb = openOrCreateDatabase(dbname, MODE_PRIVATE, null);
                result.append("[ " + dbname + " ]생성완료\n");

                imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                hidekey(imm);
            }
        });
        btntb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tbname = edttb.getText().toString();
                sdb.execSQL("create table " + tbname + "(" +
                        "no integer primary key," +
                        "name char(10)," +
                        "addr char(20));");
                result.append("[ " + tbname + " ]테이블 생성성공");

                // 안드로이드 자판을 밑으로 내려줌
                imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                hidekey(imm);
                // imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });
    } // onCreate
    // 안드로이드 자판을 밑으로 내려주는 함수
    public void hidekey(InputMethodManager imm) {
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}