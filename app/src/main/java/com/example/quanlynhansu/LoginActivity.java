package com.example.quanlynhansu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private String userRegister = "", passRegister = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // ánh sạ
        TextInputEditText edtUser = findViewById(R.id.edtUser);
        TextInputLayout txtUser = findViewById(R.id.txtUser);
        TextInputEditText edtPass = findViewById(R.id.edtPass);
        TextInputLayout txtPass = findViewById(R.id.txtPass);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        CheckBox chkRemember = findViewById(R.id.chkRemember);

        // kiểm tra thông tin đăng nhập, user có save data hay ko?
        SharedPreferences preferences = getSharedPreferences("INFO", MODE_PRIVATE);
        boolean isRemember = preferences.getBoolean("isRemember", false);

        if (isRemember) {
            String userLogin = preferences.getString("userLogin", "");
            String passLogin = preferences.getString("passLogin", "");

            edtUser.setText(userLogin);
            edtPass.setText(passLogin);
            chkRemember.setChecked(isRemember);

            userRegister = userLogin.toString();
            passRegister = passLogin.toString();
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userLogin = edtUser.getText().toString();
                String passLogin = edtPass.getText().toString();

                if (userLogin.length() > 0 && passLogin.length() > 0 && userLogin.equals(userRegister) && passLogin.equals(passRegister)) {
                    // check remember me
                    if (chkRemember.isChecked()) {
                        SharedPreferences preferences = getSharedPreferences("INFO", MODE_PRIVATE); // Gọi file info ra
                        SharedPreferences.Editor editor = preferences.edit(); // edit file INFO
                        editor.putString("userLogin", userLogin);
                        editor.putString("passLogin", passLogin);
                        editor.putBoolean("isRemember", chkRemember.isChecked());
                        editor.apply();
                    } else {
                        SharedPreferences preferences = getSharedPreferences("INFO", MODE_PRIVATE); // Gọi file info ra
                        SharedPreferences.Editor editor = preferences.edit(); // edit file INFO
                        editor.clear();
                        editor.apply();
                    }

                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                myLauncher.launch(intent);
            }
        });
    }

    private ActivityResultLauncher<Intent> myLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // nơi xử lý  dữ liệu trả về từ register
                    if (result.getResultCode() == 1) {
                        Intent intent = result.getData();
                        userRegister = intent.getStringExtra("user");
                        passRegister = intent.getStringExtra("pass");
//                        Toast.makeText(LoginActivity.this, user + " - " + pass, Toast.LENGTH_SHORT).show();
                    }
                }
            });
}