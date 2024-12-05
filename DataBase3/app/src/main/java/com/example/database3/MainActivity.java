package com.example.database3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

    EditText edtname, edtnumber, edtteam, edtmember;
    Button init, input, select;
    SQLiteDatabase sdb;
    MyDBHelper mydb;
    InputMethodManager imm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtname = findViewById(R.id.edtname);
        edtnumber = findViewById(R.id.edtnumber);
        edtteam = findViewById(R.id.edtteam);
        edtmember = findViewById(R.id.edtmember);
        init = findViewById(R.id.input);
        input = findViewById(R.id.input);
        select = findViewById(R.id.select);
        mydb = new MyDBHelper(this);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // db 쓰는 타입 지정
                sdb = mydb.getWritableDatabase();

                mydb.onUpgrade(sdb, 1, 2);
                sdb.close();
            }
        });

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // db 쓰는 타입 지정
                sdb = mydb.getWritableDatabase();

                String tname = edtname.getText().toString();
                String tsu = edtnumber.getText().toString();

                sdb.execSQL("insert into grouptable values('" + tname + "');");
            }
        });
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // db 쓰는 타입 지정
                sdb = mydb.getWritableDatabase();

                String tname = edtname.getText().toString();
                String tsu = edtnumber.getText().toString();
                sdb.execSQL("insert into grouptable " +
                        "values('" + tname +"', '"+ tsu +"')");
                edtname.setText(" ");
                edtnumber.setText(" ");
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // db 읽는 타입 지정
                sdb = mydb.getReadableDatabase();

                // data 가 있는 주소값이 담겨있는 테이블
                Cursor cursor = sdb.rawQuery("select * from grouptable", null);
                String strname = "팀이름 \n" + "---------------\n";
                String strno = "인원수 \n" + "---------------\n";

                // 다음 데이터가 있을때까지 반복
                while (cursor.moveToNext()) {
                    strname += cursor.getString(0) + "\n";
                    strno += cursor.getString(1) + "\n";
                }

                edtteam.setText(strname);
                edtmember.setText(strno);

                cursor.close();
                sdb.close();

                // 안드로이드 키보드 내림
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });
    } // onCreate

    // 내부클래스
    public class MyDBHelper extends SQLiteOpenHelper {
        public MyDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        // database table 생성
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table grouptable(" +
                    "gname char(20) primary key," +
                    "gnumber char(2));");
        }

        // database data 업데이트
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists grouptable");
            onCreate(db);
        }
    }
}