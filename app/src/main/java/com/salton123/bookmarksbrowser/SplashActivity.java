package com.salton123.bookmarksbrowser;

import android.os.Bundle;

import com.salton123.base.BaseActivity;
import com.salton123.base.feature.ImmersionFeature;

/**
 * User: newSalton@outlook.com
 * Date: 2019/2/16 18:18
 * ModifyTime: 18:18
 * Description:
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        addFeature(new ImmersionFeature(this));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
