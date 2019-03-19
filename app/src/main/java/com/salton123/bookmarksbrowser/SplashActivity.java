package com.salton123.bookmarksbrowser;

import android.os.Bundle;
import android.view.View;

import com.gyf.barlibrary.BarHide;
import com.salton123.MenuPopupFragment;
import com.salton123.TitleMorePopupWindow;
import com.salton123.base.BaseActivity;
import com.salton123.base.feature.ImmersionFeature;

/**
 * User: newSalton@outlook.com
 * Date: 2019/2/16 18:18
 * ModifyTime: 18:18
 * Description:
 */
public class SplashActivity extends BaseActivity {
    private ImmersionFeature mImmersionFeature;

    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public View getTitleBar() {
        return inflater().inflate(R.layout.default_search_title, null);
    }

    @Override
    public void initVariable(Bundle savedInstanceState) {
        mImmersionFeature = new ImmersionFeature(this);
        // mImmersionFeature.getImmersionBar().hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR);
        addFeature(mImmersionFeature);
    }

    @Override
    public void initViewAndData() {
        setListener(R.id.tvActionLeft, R.id.tvActionRight, R.id.tvActionHome,
                R.id.tvActionWindows, R.id.tvActionMenu, R.id.tvTitleMore);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvActionLeft:
                break;
            case R.id.tvActionRight:
                break;
            case R.id.tvActionHome:

                break;
            case R.id.tvActionWindows:
                break;
            case R.id.tvActionMenu:
                new MenuPopupFragment().show(getFragmentManager(), "MenuPopupFragment");
                break;
            case R.id.tvTitleMore:
                new TitleMorePopupWindow().show(getFragmentManager(), "TitleMorePopupWindow");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mImmersionFeature.onBind();
    }

    // @Override
    // public void onWindowFocusChanged(boolean hasFocus) {
    //     super.onWindowFocusChanged(hasFocus);
    //     if (hasFocus) {
    //         getWindow().getDecorView().setSystemUiVisibility(
    //                 View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    //                         | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    //                         | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    //     }
    // }
}
