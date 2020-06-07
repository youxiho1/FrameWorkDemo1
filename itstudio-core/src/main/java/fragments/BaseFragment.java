package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public abstract class BaseFragment extends SwipeBackFragment {
    //继承自Fragmentation的SwipeBackFragment
    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState, View rootView);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        if(setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if(setLayout() instanceof View) {
            rootView = (View) setLayout();
        }
        if(rootView != null) {
            //这里需要使用ViewBind绑定this和rootView，待研究
            onBindView(savedInstanceState, rootView);           //要求子类去绑定内部的控件
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //这里需要使用ViewBind取消绑定，待研究
    }
}
