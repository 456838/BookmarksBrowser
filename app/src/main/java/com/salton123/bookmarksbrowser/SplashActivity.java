package com.salton123.bookmarksbrowser;

import android.os.Bundle;
import android.view.View;

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
    protected void onCreate(Bundle savedInstanceState) {
        mImmersionFeature = new ImmersionFeature(this);
        addFeature(mImmersionFeature);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.tvHint).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmersionFeature.dardFont();
            }
        });
    }
}
