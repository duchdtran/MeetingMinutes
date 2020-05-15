package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.meetingminutes.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout textInputEmail, textInputPassword;
    private Button btnLogin;
    private Toolbar toolbar;
    private CheckBox cbRememberPassword;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setEvent();
    }
    private void initView(){
        textInputEmail = findViewById(R.id.text_input_email);
        textInputPassword = findViewById(R.id.text_input_password);
        btnLogin = findViewById(R.id.btn_login);
        cbRememberPassword = findViewById(R.id.cb_remember_password);
        toolbar = findViewById(R.id.toolbar);
    }
    private void setEvent(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comfirmInput();
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        sharedPreferences=getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        editor=sharedPreferences.edit();
        /////////////////To get Stored Data/////////////////////////////////
        String mail=sharedPreferences.getString("email","");
        String passwords=sharedPreferences.getString("passowrd","");
        ////////////////////////////////////////////////////////////////////
        textInputEmail.getEditText().setText(mail);
        textInputPassword.getEditText().setText(passwords);
    }

    private boolean validateEmail(){
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if(TextUtils.isEmpty(emailInput)){
            textInputEmail.setError("Vui lòng nhập thông tin email.");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            textInputEmail.setError("Email sai cú pháp.");
            return false;
        }else if(!emailInput.contains("test@gmail.com")){
            textInputEmail.setError("Sai thông tin email.");
            return false;
        }else{
            textInputEmail.setError(null);
            return true;
        }
    }
    private boolean validatePassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if(TextUtils.isEmpty(passwordInput)){
            textInputPassword.setError("Vui lòng nhập thông tin password.");
            return false;
        }else if(!passwordInput.contains("123456")){
            textInputPassword.setError("Sai thông tin password.");
            return false;
        }else{
            textInputPassword.setError(null);
            return true;
        }
    }
    private void comfirmInput(){
        if(!validateEmail() || !validatePassword()){
            return;
        }

        if(cbRememberPassword.isChecked()){
            editor.putString("email",textInputEmail.getEditText().getText().toString());
            editor.putString("passowrd",textInputPassword.getEditText().getText().toString());
            editor.commit();
        }else{
            editor.putString("email","");
            editor.putString("passowrd","");
            editor.commit();
        }
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
