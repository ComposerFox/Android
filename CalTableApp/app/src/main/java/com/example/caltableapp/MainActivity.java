package com.example.caltableapp;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button add, sub, mul, div;
    Button[] btnNums = new Button[10];
    Integer[] numBtnIds = { R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4,
                            R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9 };
    String num1, num2;
    Integer result;
    int i;
    TextView txResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        txResult = findViewById(R.id.txResult);

        for(i = 0; i < numBtnIds.length; i++) {
            btnNums[i] = findViewById(numBtnIds[i]);
        }

        add.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                txResult.setText("계산결과" + result);

                return false;
            }
        });
        sub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                txResult.setText("계산결과" + result);

                return false;
            }
        });
        mul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                txResult.setText("계산결과" + result);

                return false;
            }
        });
//        div.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                num1 = edit1.getText().toString();
//                num2 = edit2.getText().toString();
//                result = Integer.parseInt(num1) / Integer.parseInt(num2);
//                txResult.setText("계산결과" + result);
//
//                return false;
//            }
//        });

        for(i = 0; i < numBtnIds.length; i++) {
            final int index = 1;

            btnNums[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edit1.isFocused()) {
                        num1 = edit1.getText().toString() + btnNums[index].getText().toString();
                        edit1.setText(num1);
                    } else if(edit2.isFocused()) {
                        num2 = edit1.getText().toString() + btnNums[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplication(), "다시 확인바랍니다.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}