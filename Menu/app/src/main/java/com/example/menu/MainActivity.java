package com.example.menu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear = findViewById(R.id.linear);
        button = findViewById(R.id.button);

    }
    // onCreate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

//        MenuInflater inflate = getMenuInflater();
//        inflate.inflate(R.menu.menu1, menu);
        menu.add(0, 1, 0, "배경색(Red)");
        menu.add(0, 1, 0, "배경색(Blue)");
        menu.add(0, 1, 0, "배경색(Green)");
        SubMenu sub = menu.addSubMenu("Etc>>");
        sub.add(0, 4, 0, "Rotate");
        sub.add(0, 5, 0, "size");

        return true;
    }
    // onCreateOptionsMenu
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        super.onOptionsItemSelected(item);
//
//        switch (item.getItemId()) {
//            case R.id.itemRed:
//                linear.setBackgroundColor(Color.RED);
//                break;
//            case R.id.itemBlue:
//                linear.setBackgroundColor(Color.BLUE);
//                break;
//            case R.id.itemGreen:
//                linear.setBackgroundColor(Color.GREEN);
//                break;
//            case R.id.subRotate:
//                linear.setRotation(20);
//                break;
//            case R.id.subSize:
//                linear.setScaleX(2);
//                break;
//        }

//        return false;
//    }
}