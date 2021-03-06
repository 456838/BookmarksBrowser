package com.salton123.base;

import android.app.Activity;
import android.app.Fragment;

/**
 * User: newSalton@outlook.com
 * Date: 2019/3/19 10:12
 * ModifyTime: 10:12
 * Description:
 */
public class FragmentDelegate extends LifeDelegate {
    private Activity mHost;

    public FragmentDelegate(IComponentLife componentLife) {
        super(componentLife);
        if (componentLife instanceof Fragment) {
            mHost = ((Fragment) componentLife).getActivity();
        } else {
            throw new RuntimeException("instance must Activity");
        }
    }

    @Override
    Activity activity() {
        return mHost;
    }

}