package com.salton123.bookmarksbrowser.feature;


import android.app.Activity;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/25 4:51 PM
 * ModifyTime: 4:51 PM
 * Description:
 */
public class ImmersionFeature implements IFeature {
    private Activity mActivity;

    public ImmersionFeature(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void onBind() {

    }

    @Override
    public void onUnBind() {

    }

}
