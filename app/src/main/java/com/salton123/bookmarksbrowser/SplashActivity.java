package com.salton123.bookmarksbrowser;

import android.os.Bundle;
import android.view.View;

import com.salton123.base.BaseActivity;
import com.salton123.base.feature.ImmersionFeature;
import com.salton123.view.IconFontTextView;

/**
 * User: newSalton@outlook.com
 * Date: 2019/2/16 18:18
 * ModifyTime: 18:18
 * Description:
 */
public class SplashActivity extends BaseActivity implements View.OnClickListener {
    private ImmersionFeature mImmersionFeature;
    private IconFontTextView tvActionLeft, tvActionRight, tvActionHome, tvActionWindows, tvActionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mImmersionFeature = new ImmersionFeature(this);
        addFeature(mImmersionFeature);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initViewAndData();
    }

    private void initViewAndData() {
        tvActionLeft = findViewById(R.id.tvActionLeft);
        tvActionRight = findViewById(R.id.tvActionRight);
        tvActionHome = findViewById(R.id.tvActionHome);
        tvActionWindows = findViewById(R.id.tvActionWindows);
        tvActionMenu = findViewById(R.id.tvActionMenu);
        tvActionLeft.setOnClickListener(this);
        tvActionRight.setOnClickListener(this);
        tvActionHome.setOnClickListener(this);
        tvActionWindows.setOnClickListener(this);
        tvActionMenu.setOnClickListener(this);
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
                break;
            default:
                break;
        }
    }
}
