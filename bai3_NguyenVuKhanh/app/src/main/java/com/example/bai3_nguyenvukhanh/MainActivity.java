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

public class MainActivity extends AppCompatActivity {
    TextView changetoLogin;
    EditText usernameShow, passwordShow, masvShow, passwordconfirmShow;
    Button btnRegister;
    EditText et1, et2, et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        changetoLogin=(TextView) findViewById(R.id.login);
        usernameShow=(EditText) findViewById(R.id.inputUsername);
        passwordShow=(EditText) findViewById(R.id.password);
        masvShow=(EditText) findViewById(R.id.inputMSV);
        passwordconfirmShow=(EditText) findViewById(R.id.confirmPassword);
        btnRegister=(Button) findViewById(R.id.button);
        et1=(EditText) findViewById(R.id.editTextText);
        et2=(EditText) findViewById(R.id.editTextText2);
        et3=(EditText) findViewById(R.id.editTextText3);

        changetoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernametext = usernameShow.getText().toString();
                String masvtext = masvShow.getText().toString();
                String passwordtext = passwordShow.getText().toString();
                String passwordconfirmtext = passwordconfirmShow.getText().toString();
                if (usernametext.isEmpty()||masvtext.isEmpty()||passwordtext.isEmpty()||passwordconfirmtext.isEmpty()){
                    Toast.makeText(MainActivity.this, "Chưa nhập đủ thông tin!!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Đăng ký thành công!!!", Toast.LENGTH_SHORT).show();
//                usernameShow.setText("Nguyễn Vũ Khanh");
//                masvShow.setText("22115053122118");
//                passwordShow.setText("nvk09112004");
//                passwordconfirmShow.setText("nvk09112004");
                    et1.setText(usernameShow.getText().toString());
                    et2.setText(masvShow.getText().toString());
                    et3.setText(passwordShow.getText().toString());
                }

            }
        });

    }
}