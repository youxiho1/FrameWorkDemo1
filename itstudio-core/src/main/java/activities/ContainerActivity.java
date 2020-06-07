package activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.ContentFrameLayout;

import com.itstudio.framework.itstudio_core.R;

import fragments.CommonFragment;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class ContainerActivity extends SupportActivity {
    //继承自fragmentation的SupportActivity
    public abstract CommonFragment setRootFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    @SuppressLint("RestrictedApi")
    private void initContainer(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.fragment_container);
        setContentView(container);
        if(savedInstanceState == null) {
            //第一次加载
            loadRootFragment(R.id.fragment_container, setRootFragment());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //人工调用垃圾回收机制（有可能不执行）
        System.gc();
        System.runFinalization();
    }
}
