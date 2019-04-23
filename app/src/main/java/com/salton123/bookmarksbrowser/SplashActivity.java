package com.salton123.bookmarksbrowser;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.salton123.base.feature.EventBusFeature;
import com.salton123.bookmarksbrowser.bean.GridBookmarkItem;
import com.salton123.bookmarksbrowser.ui.fm.BookMarkGridFragment;
import com.salton123.bookmarksbrowser.ui.fm.BrowserFragment;
import com.salton123.bookmarksbrowser.ui.fm.MenuPopupComp;
import com.salton123.bookmarksbrowser.ui.fm.TitleMorePopupComp;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


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
        addFeature(new EventBusFeature(this));
    }

    @Override
    public void initViewAndData() {
        setListener(R.id.tvActionLeft, R.id.tvActionRight, R.id.tvActionHome,
                R.id.tvActionWindows, R.id.tvActionMenu, R.id.tvTitleMore);
        getFragmentManager().beginTransaction().add(R.id.flContainer, new BookMarkGridFragment()).commitAllowingStateLoss();
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
            default:
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void onEvent(GridBookmarkItem item) {
        Fragment fragment = new BrowserFragment();
        Bundle bundle = new Bundle();
        bundle.putString("URL", item.subTitle);
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().add(R.id.flContainer, fragment).show(fragment).commitAllowingStateLoss();
    }
}
