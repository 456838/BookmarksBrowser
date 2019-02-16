package com.salton123.base;

import android.app.Activity;
import android.os.Bundle;


import com.salton123.base.feature.IFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * User: newSalton@outlook.com
 * Date: 2019/2/16 19:01
 * ModifyTime: 19:01
 * Description:
 */
public abstract class BaseActivity extends Activity {

    private List<IFeature> mFeatures = new ArrayList<>();

    public void addFeature(IFeature feature) {
        this.mFeatures.add(feature);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (IFeature item : mFeatures) {
            item.onBind();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (IFeature item : mFeatures) {
            item.onUnBind();
        }
    }
}
