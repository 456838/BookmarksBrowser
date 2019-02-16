package com.salton123.base.feature;


import android.app.Activity;
import android.graphics.Color;

import com.gyf.barlibrary.ImmersionBar;
import com.salton123.bookmarksbrowser.R;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/25 4:51 PM
 * ModifyTime: 4:51 PM
 * Description:
 */
public class ImmersionFeature implements IFeature {
    private ImmersionBar mImmersionBar;
    private Activity mActivity;

    public ImmersionFeature(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void onBind() {
        mImmersionBar = getImmersionBar();
        mImmersionBar.init();
    }

    public ImmersionBar getImmersionBar() {
        return ImmersionBar.with(mActivity)
                .statusBarColor(R.color.color_ff728ac6)
                .statusBarDarkFont(false);
    }

    @Override
    public void onUnBind() {
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }

}
