package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.RunnableFuture;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public abstract class BaseFragment<T extends ViewBinding> extends SwipeBackFragment {
    //继承自Fragmentation的SwipeBackFragment
    protected T binding;
    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState);

    protected abstract Class<T> getViewBinding();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            Method inflateMethod = getViewBinding().getDeclaredMethod("inflate", new Class[] {LayoutInflater.class});
            binding = (T) inflateMethod.invoke(getViewBinding(), new Object[] {inflater});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        onBindView(savedInstanceState);           //要求子类去绑定内部的控件
        View rootView = null;
        if(binding != null) {
            rootView = binding.getRoot();
        } else {
            throw new RuntimeException("Create BaseFragment Error");
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //这里需要使用ViewBind取消绑定
        binding = null;
    }

}
