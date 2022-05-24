package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutUsZakat extends AppCompatActivity {

    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_zakat);

        link = findViewById(R.id.linkgithub);
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }
}