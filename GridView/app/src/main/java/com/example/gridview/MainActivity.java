package com.example.gridview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.grid);
        // 사용자가 정한 어댑터 선언과 설정
        MyGridAdapter myGridAdapter = new MyGridAdapter(MainActivity.this);
        grid.setAdapter(myGridAdapter);

    }   // oncreate
    // 내부 클래스
    public class MyGridAdapter extends BaseAdapter {
        // 멤버 변수
        Context context;
        Integer[] postid = {R.drawable.linux, R.drawable.mac, R.drawable.windows};

        // 생성자
        public MyGridAdapter(Context c) {
            context = c;
        }

        // 메소드
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(140, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setImageResource(postid[i]);
            final int pos = i;

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogv = View.inflate(MainActivity.this,
                                                R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView poster = dialogv.findViewById(R.id.ivposter);
                    poster.setImageResource(postid[pos]);
                    dlg.setTitle("큰이미지");
                    dlg.setView(dialogv);
                    dlg.setNegativeButton("close", null);
                    dlg.show();
                }
            });

            return imageView;
        }
        @Override
        public int getCount() {
            return postid.length;
        }
        @Override
        public Object getItem(int i) {
            return 0;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
    }
}