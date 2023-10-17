package com.example.quanlynhansu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // ánh sạ
        TextInputEditText edtUser = findViewById(R.id.edtUser);
        TextInputLayout txtUser = findViewById(R.id.txtUser);
        TextInputEditText edtPass = findViewById(R.id.edtPass);
        TextInputLayout txtPass = findViewById(R.id.txtPass);
        TextInputEditText edtRePass = findViewById(R.id.edtRePass);
        TextInputLayout txtRePass = findViewById(R.id.txtRePass);
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnBack = findViewById(R.id.btnBack);

        edtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    txtUser.setError("Vui lòng nhập username");
                } else {
                    txtUser.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    txtPass.setError("Vui lòng nhập password");
                } else {
                    txtPass.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtRePass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    txtRePass.setError("Vui lòng nhập lại password");
                } else {
                    txtRePass.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                String rePass = edtRePass.getText().toString();

                // validate
                if (user.equals("") || pass.equals("") || rePass.equals("")) {
//                    Toast.makeText(RegisterActivity.this, "Nhập đầy đủ thông tin đi ba", Toast.LENGTH_SHORT).show();
                    if (user.equals("")){
                        txtUser.setError("Vui lòng nhập username");
                    }else {
                        txtUser.setError(null);
                    }
                    if (pass.equals("")){
                        txtPass.setError("Vui lòng nhập password");
                    }else {
                        txtPass.setError(null);
                    }
                    if (rePass.equals("")){
                        txtRePass.setError("Vui lòng nhập lại password");
                    }else {
                        txtRePass.setError(null);
                    }
                } else if (!pass.equals(rePass)) {
                    Toast.makeText(RegisterActivity.this, "Nhập mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("user", user);
                    intent.putExtra("pass", pass);
//                    Toast.makeText(RegisterActivity.this, user + " - " + pass, Toast.LENGTH_SHORT).show();
//                    startActivity(intent);
                    setResult(1, intent);
                    finish();
                }
            }
        });
    }


}