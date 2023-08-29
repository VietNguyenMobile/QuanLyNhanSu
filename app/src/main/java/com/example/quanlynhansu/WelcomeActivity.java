package com.example.quanlynhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long l) {
                // trong vòng bao nhiêu giây thì thực hiện một công việc nào đó
            }

            @Override
            public void onFinish() {
                //
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}