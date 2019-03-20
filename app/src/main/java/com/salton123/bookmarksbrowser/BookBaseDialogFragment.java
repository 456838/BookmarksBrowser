package com.salton123.bookmarksbrowser;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.salton123.base.BaseActivity;
import com.salton123.base.BaseDialogFragment;
import com.salton123.base.feature.ImmersionFeature;

/**
 * User: newSalton@outlook.com
 * Date: 2019/3/20 15:57
 * ModifyTime: 15:57
 * Description:
 */
public abstract class BookBaseDialogFragment extends BaseDialogFragment {

    private ImmersionBar mImmersionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // mImmersionBar = getImmersionBar();
        // mImmersionBar.init();
    }

    public ImmersionBar getImmersionBar() {
        if (mImmersionBar == null) {
            mImmersionBar = ImmersionBar.with(this)
                    .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
            ;

        }
        return mImmersionBar;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = this.getDialog().getWindow();
        //Window window = getDialog().getWindow();如果是在activity中则用这段代码
        // window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //window.requestWindowFeature(Window.FEATURE_NO_TITLE); 用在activity中，去标题
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE;

        window.getDecorView().setSystemUiVisibility(uiOptions);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }
}
