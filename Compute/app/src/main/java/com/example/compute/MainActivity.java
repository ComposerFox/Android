package com.example.compute;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button add, sub, mul, div;
    TextView result;
    String su1, su2;
    Integer n1, n2, value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        result = findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                su1 = num1.getText().toString();
                su2 = num2.getText().toString();
                n1 = Integer.parseInt(su1);
                n2 = Integer.parseInt(su2);
                value = n1 + n2;
                result.setText("result : " + value);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                su1 = num1.getText().toString();
                su2 = num2.getText().toString();
                n1 = Integer.parseInt(su1);
                n2 = Integer.parseInt(su2);
                value = n1 - n2;
                result.setText("result : " + value);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1 = Integer.parseInt( num1.getText().toString() );
                n2 = Integer.parseInt( num2.getText().toString() );
                value = n1 * n2;
                result.setText("result : " + value);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1 = Integer.parseInt( num1.getText().toString() );
                n2 = Integer.parseInt( num2.getText().toString() );
                value = n1 / n2;
                result.setText("result : " + value);
            }
        });
    }
}