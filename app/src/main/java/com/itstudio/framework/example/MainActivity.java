package com.itstudio.framework.example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import activities.ContainerActivity;
import app.Main;
import fragments.CommonFragment;

public class MainActivity extends ContainerActivity {

    @Override
    public CommonFragment setRootFragment() {
        return new MainFragment();
    }
}