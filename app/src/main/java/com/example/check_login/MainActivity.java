package com.example.check_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edEmail,edPass;
    TextView tvThongBao;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        tvThongBao = findViewById(R.id.tvThongBao);
        btnCheck = findViewById(R.id.btnCheck);

        tvThongBao.setVisibility(View.GONE);//đầu tiên mình sẽ cho ẩn textview thông báo đi
        //khi nào check mới hiện thông báo

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });
    }

    private void checkLogin() {

        String email = edEmail.getText().toString().trim();
        String pass = edPass.getText().toString().trim();

        User user = new User(email,pass);

        tvThongBao.setVisibility(View.VISIBLE);//tới khúc này thì cho textview thông báo hiện lên
        //để thông báo được kết quả

        if (user.KiemtraEmail()&&user.KiemtraPassword()){
            //nếu kiểm tra email và password của user đúng với điều kiện
            //thì thực hiện công việc trong này
            tvThongBao.setText("Email và password đúng định dạng");
            tvThongBao.setTextColor(getResources().getColor(R.color.teal_700));
        }else{
            //nếu sai điều kiện thì thực hiện công việc ở đây
            //mình sẽ chạy chương trình nhé
            tvThongBao.setText("Email và password không đúng định dạng");
            tvThongBao.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    }
}