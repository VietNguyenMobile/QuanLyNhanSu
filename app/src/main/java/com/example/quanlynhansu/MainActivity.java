package com.example.quanlynhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPhongBan = findViewById(R.id.btnPhongBan);
        Button btnNhanSu = findViewById(R.id.btnNhanSu);
        Button btnThoat = findViewById(R.id.btnThoat);

        btnPhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PhongBanActivity.class));
            }
        });
    }
}