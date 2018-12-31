package com.example.a9011_20.aba_ep1_trial;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a9011_20.aba_ep1_trial.sql.SQLiteHelper;

public class MainActivity extends AppCompatActivity {

    Button btnStart,btnScore,btnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btn_start);
        btnScore = findViewById(R.id.btn_score);
        btnSetting = findViewById(R.id.btn_setting);

        btnStart.setOnClickListener(clickListener);
        btnScore.setOnClickListener(clickListener);
        btnSetting.setOnClickListener(clickListener);

      SQLiteHelper helper = new SQLiteHelper(this);
      helper.addData();

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn_start:
                    startActivity(new Intent(MainActivity.this, WordListActivity.class));
                    break;
            }

        }
    };
}
