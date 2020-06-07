package com.itstudio.framework.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.itstudio.framework.example.databinding.FragmentMainBinding;

import fragments.CommonFragment;

public class MainFragment extends CommonFragment {
    @Override
    public Object setLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceStatew) {
        ((FragmentMainBinding) binding).tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "哈哈哈", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected Class getViewBinding() {
        return FragmentMainBinding.class;
    }
}
