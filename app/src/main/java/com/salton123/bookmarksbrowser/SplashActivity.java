package com.salton123.bookmarksbrowser;

import android.os.Bundle;
import android.view.View;


/**
 * User: newSalton@outlook.com
 * Date: 2019/2/16 18:18
 * ModifyTime: 18:18
 * Description:
 */
public class SplashActivity extends BookBaseActivity {

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

    }

    @Override
    public void initViewAndData() {
        setListener(R.id.tvActionLeft, R.id.tvActionRight, R.id.tvActionHome,
                R.id.tvActionWindows, R.id.tvActionMenu, R.id.tvTitleMore,
                R.id.ivManguoTvShow
        );
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
                new MenuPopupComp().show(getFragmentManager(), "MenuPopupComp");
                break;
            case R.id.tvTitleMore:
                new TitleMorePopupComp().show(getFragmentManager(), "TitleMorePopupWindow");
                break;
            case R.id.ivManguoTvShow:
                break;
            default:
                break;
        }
    }
}
