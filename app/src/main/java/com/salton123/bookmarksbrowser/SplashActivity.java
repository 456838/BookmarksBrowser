package com.salton123.bookmarksbrowser;

import android.os.Bundle;
import android.view.View;

import com.salton123.MenuPopupFragment;
import com.salton123.TitleMorePopupWindow;
import com.salton123.base.BaseActivity;
import com.salton123.base.feature.ImmersionFeature;
import com.salton123.view.IconFontTextView;

/**
 * User: newSalton@outlook.com
 * Date: 2019/2/16 18:18
 * ModifyTime: 18:18
 * Description:
 */
public class SplashActivity extends BaseActivity {
    private ImmersionFeature mImmersionFeature;
    private IconFontTextView tvActionLeft, tvActionRight, tvActionHome, tvActionWindows, tvActionMenu;
    private IconFontTextView tvTitleMore;

    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initVariable(Bundle savedInstanceState) {
        mImmersionFeature = new ImmersionFeature(this);
        addFeature(mImmersionFeature);
    }

    @Override
    public void initViewAndData() {
        tvActionLeft = findViewById(R.id.tvActionLeft);
        tvActionRight = findViewById(R.id.tvActionRight);
        tvActionHome = findViewById(R.id.tvActionHome);
        tvActionWindows = findViewById(R.id.tvActionWindows);
        tvActionMenu = findViewById(R.id.tvActionMenu);
        tvTitleMore = findViewById(R.id.tvTitleMore);
        tvActionLeft.setOnClickListener(this);
        tvActionRight.setOnClickListener(this);
        tvActionHome.setOnClickListener(this);
        tvActionWindows.setOnClickListener(this);
        tvActionMenu.setOnClickListener(this);
        tvTitleMore.setOnClickListener(this);
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
}
