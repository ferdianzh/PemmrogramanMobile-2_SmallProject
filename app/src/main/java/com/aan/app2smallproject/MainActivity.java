package com.aan.app2smallproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pindah(View v){
        int btnId = v.getId();
        switch(btnId) {
            case R.id.btn_beratbadan:
                Intent activity1 = new Intent(this, Activity1Beratbadan.class);
                startActivity(activity1);
                break;
            case R.id.btn_nilaiakhir:
                Intent activity2 = new Intent(this, Activity2Nilaiakhir.class);
                startActivity(activity2);
                break;
            case R.id.btn_bangundatar:
                Intent activity3 = new Intent(this, Activity3Bangundatar.class);
                startActivity(activity3);
                break;
            case R.id.btn_bangunruang:
                Intent activity4 = new Intent(this, Activity4Bangunruang.class);
                startActivity(activity4);
                break;
            case R.id.btn_konversisuhu:
                Intent activity5 = new Intent(this, Activity5Konversisuhu.class);
                startActivity(activity5);
                break;
            case R.id.btn_exit:
                finish();
                System.exit(0);
        }
    }
}