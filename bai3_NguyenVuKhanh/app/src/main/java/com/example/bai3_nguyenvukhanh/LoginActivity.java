package com.example.bai3_nguyenvukhanh;

import android.content.Intent;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity {
    TextView changetoRegister;
    EditText usernameShow, passwordShow;
    Button btnLogin;
    EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        changetoRegister=(TextView) findViewById(R.id.register);
        usernameShow=(EditText) findViewById(R.id.inputUsername);
        passwordShow=(EditText) findViewById(R.id.password);
        btnLogin=(Button) findViewById(R.id.button);
        et1=(EditText) findViewById(R.id.editTextText);
        et2=(EditText) findViewById(R.id.editTextText2);

        changetoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernametext = usernameShow.getText().toString();
                String passwordtext = passwordShow.getText().toString();

                if (usernametext.isEmpty()||passwordtext.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Chưa nhập đủ thông tin!!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!!!", Toast.LENGTH_SHORT).show();

                    et1.setText(usernameShow.getText().toString());
                    et2.setText(passwordShow.getText().toString());

                }

            }
        });
    }
}