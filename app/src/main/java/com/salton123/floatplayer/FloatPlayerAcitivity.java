package com.salton123.floatplayer;

import android.os.Bundle;

import com.salton123.base.BaseActivity;
import com.salton123.base.feature.PermissionFeature;
import com.salton123.bookmarksbrowser.R;

/**
 * User: newSalton@outlook.com
 * Date: 2019/3/4 9:53
 * ModifyTime: 9:53
 * Description:
 */
public class FloatPlayerAcitivity extends BaseActivity {
    // private FloatPlayer videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        addFeature(new PermissionFeature(this));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_float_player);
    }
}
