package com.example.dialogcustom;

import android.content.DialogInterface;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView tvname, tvemail, toastmsg;
    View dialogv, toastv;
    EditText edtName, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        tvname = findViewById(R.id.tvName);
        tvemail = findViewById(R.id.tvEmail);
        dialogv = View.inflate(MainActivity.this, R.layout.dialog, null);
        toastv = View.inflate(MainActivity.this, R.layout.toast, null);
        edtName = dialogv.findViewById(R.id.edtName);
        edtEmail = dialogv.findViewById(R.id.edtEmail);
        toastmsg = toastmsg.findViewById(R.id.toastmsg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setView(dialogv);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvname.setText(edtName.getText().toString());
                        tvemail.setText(edtEmail.getText().toString());
                    }
                });
                dlg.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        toast.setView(toastv);
                        toast.setText("취소성공");
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }
}