package com.itstudio.framework.example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import app.Main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Main.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}