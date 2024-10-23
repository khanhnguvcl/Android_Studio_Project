package com.example.nvk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private Button save,cancel;
private EditText say, id, name;
SharedPreferences sharedPreferences;
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
        save=findViewById(R.id.button);
        say=findViewById(R.id.saying);
        id=findViewById(R.id.maSV);
        name=findViewById(R.id.tenSV);
        cancel=findViewById(R.id.button2);

        sharedPreferences=getSharedPreferences("luuThongTin", MODE_PRIVATE);
        name.setText(sharedPreferences.getString("tensinhvien",""));
        id.setText(sharedPreferences.getString("masinhvien",""));
        say.setText(sharedPreferences.getString("dieugido",""));

//        String namee =sharedPreferences.getString("tensinhvien",null);
//        if(name!=null){
//            Intent intent = new Intent(MainActivity.this, Home.class);
//            startActivity(intent);
//        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("tensinhvien", name.getText().toString().trim());
                editor.putString("masinhvien", id.getText().toString().trim());
                editor.putString("dieugido", say.getText().toString().trim());
                editor.apply();

//                Intent intent = new Intent(MainActivity.this, Home.class);
//                startActivity(intent);
                Toast.makeText(MainActivity.this, "Lưu thành công!!",Toast.LENGTH_SHORT).show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("tensinhvien");
                editor.remove("masinhvien");
                editor.remove("dieugido");
                editor.apply();
                Toast.makeText(MainActivity.this, "Hủy lưu thành công!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}