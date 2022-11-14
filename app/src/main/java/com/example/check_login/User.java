package com.example.check_login;

import android.text.TextUtils;
import android.util.Patterns;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean KiemtraEmail(){
        return !TextUtils.isEmpty(email)&& Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean KiemtraPassword(){
        return !TextUtils.isEmpty(password)&&password.length()>=6;
    }
}
