package com.itstudio.framework.example;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import fragments.CommonFragment;

public class MainFragment extends CommonFragment {
    @Override
    public Object setLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
