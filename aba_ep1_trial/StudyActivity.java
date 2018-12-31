package com.example.a9011_20.aba_ep1_trial;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StudyActivity extends AppCompatActivity {

    ViewPager vpStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        vpStudy = findViewById(R.id.vp_study);



    }
}
