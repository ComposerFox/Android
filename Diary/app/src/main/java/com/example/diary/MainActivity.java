package com.example.diary;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Gallery gallery;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = findViewById(R.id.gallery);
        MyGallery mygallery = new MyGallery(MainActivity.this);

        gallery.setAdapter(mygallery);
    }   // oncreate
    public class MyGallery extends BaseAdapter {
        Context context;
        Integer[] postid = {R.drawable.linux, R.drawable.mac, R.drawable.windows};

        public MyGallery(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return postid.length;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public Object getItem(int i) {
            return null;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView img = new ImageView(MainActivity.this);
            img.setLayoutParams(new Gallery.LayoutParams(200, 300));
            img.setScaleType(ImageView.ScaleType.CENTER);
            img.setPadding(5, 5, 5, 5);
            img.setImageResource(postid[i]);
            final int pos = i;

            img.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView ivPost = findViewById(R.id.ivposter);
                    ivPost.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPost.setImageResource(postid[pos]);

                    return false;
                }
            });

            return img;
        }
    }   // 내부 클래스
}