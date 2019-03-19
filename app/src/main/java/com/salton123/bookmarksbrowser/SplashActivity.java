package com.salton123.bookmarksbrowser;

import android.os.Bundle;
import android.view.View;

import com.salton123.MenuPopupFragment;
import com.salton123.TitleMorePopupWindow;
import com.salton123.base.BaseActivity;
import com.salton123.base.feature.ImmersionFeature;
import com.salton123.video.VideoPlayActivity;
import com.salton123.view.IconFontTextView;

/**
 * User: newSalton@outlook.com
 * Date: 2019/2/16 18:18
 * ModifyTime: 18:18
 * Description:
 */
public class SplashActivity extends BaseActivity {
    private ImmersionFeature mImmersionFeature;

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
        mImmersionFeature = new ImmersionFeature(this);
        addFeature(mImmersionFeature);
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
                new MenuPopupFragment().show(getFragmentManager(), "MenuPopupFragment");
                break;
            case R.id.tvTitleMore:
                new TitleMorePopupWindow().show(getFragmentManager(), "TitleMorePopupWindow");
                break;
            case R.id.ivManguoTvShow:
                openActivity(VideoPlayActivity.class, null);
                break;
            default:
                break;
        }
    }
}
