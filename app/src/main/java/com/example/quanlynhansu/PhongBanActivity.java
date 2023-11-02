package com.example.quanlynhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.quanlynhansu.adapter.PhongBanAdapter;
import com.example.quanlynhansu.model.PhongBan;

import java.util.ArrayList;

public class PhongBanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban);

        // Giao diện
            // Giao diện chua listview
        ListView lvPhongBan = findViewById(R.id.lvPhongBan);

            // Giao diện cửa từng item hiện thị lên listview

        // data
        ArrayList<PhongBan> listPB =  new ArrayList<>();
        listPB.add(new PhongBan("PB01", "Nhân sự"));
        listPB.add(new PhongBan("PB02", "Tài chính"));
        listPB.add(new PhongBan("PB03", "Kế toán"));
        listPB.add(new PhongBan("PB04", "Kinh doanh"));

        // adapter
        PhongBanAdapter adapter = new PhongBanAdapter(PhongBanActivity.this, listPB);
        lvPhongBan.setAdapter(adapter);
    }
}