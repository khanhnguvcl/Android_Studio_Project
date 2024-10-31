package com.example.cp_readsms;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_SMS_PERMISSION = 100;
    private TextView tvStudentInfo;
    private Button btnShowSms;
    private RecyclerView recyclerViewMessages;
    private MessageAdapter messageAdapter;
    private List<Message> messageList;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_SMS_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadMessages();
            } else {
                Toast.makeText(this, "Quyền đọc SMS bị từ chối!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void loadMessages() {
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(Telephony.Sms.CONTENT_URI, null, null, null, null);

        if (cursor != null) {
            int indexAddress = cursor.getColumnIndex(Telephony.Sms.ADDRESS);
            int indexBody = cursor.getColumnIndex(Telephony.Sms.BODY);
            messageList.clear(); // Xóa danh sách cũ trước khi tải lại
            while (cursor.moveToNext()) {
                String sender = cursor.getString(indexAddress); // Lấy người gửi
                String content = cursor.getString(indexBody); // Lấy nội dung tin nhắn
                messageList.add(new Message(sender, content)); // Thêm tin nhắn vào danh sách
            }
            cursor.close();
            messageAdapter.notifyDataSetChanged(); // Cập nhật giao diện với danh sách mới
        }
    }

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
//        tvStudentInfo = findViewById(R.id.tv_student_info);
//        tvStudentInfo.setText("Tên: [Tên Sinh Viên] - MSV: [Mã Số Sinh Viên]");

        btnShowSms = findViewById(R.id.btn_show_sms);
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);
        recyclerViewMessages.setAdapter(messageAdapter);

        btnShowSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, REQUEST_SMS_PERMISSION);
                } else {
                    loadMessages();
                }
            }
        });



    }
}