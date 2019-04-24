package com.salton123.bookmarksbrowser;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.salton123.base.feature.EventBusFeature;
import com.salton123.bookmarksbrowser.bean.GridBookmarkItem;
import com.salton123.bookmarksbrowser.ui.fm.BookMarkGridFragment;
import com.salton123.bookmarksbrowser.ui.fm.MenuPopupComp;
import com.salton123.bookmarksbrowser.ui.fm.TitleMorePopupComp;
import com.salton123.utils.FragmentUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * User: newSalton@outlook.com
 * Date: 2019/2/16 18:18
 * ModifyTime: 18:18
 * Description:
 */
public class SplashActivity extends BookBaseActivity {
    private String url;
    private WebView mWebView;
    private FrameLayout flContainer;

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
        mWebView = f(R.id.webView);
        flContainer = f(R.id.flContainer);
        setListener(R.id.tvActionLeft, R.id.tvActionRight, R.id.tvActionHome,
                R.id.tvActionWindows, R.id.tvActionMenu, R.id.tvTitleMore);
        FragmentUtil.add(getFragmentManager(), new BookMarkGridFragment(), R.id.flContainer, "BookMarkGridFragment");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvActionLeft:
                if (mWebView.canGoBack() && mWebView.getVisibility() == View.VISIBLE) {
                    mWebView.goBack();
                } else {
                    showBookmarkView();
                }
                break;
            case R.id.tvActionRight:
                if (mWebView.canGoForward() && mWebView.getVisibility() == View.VISIBLE) {
                    mWebView.goForward();
                } else {
                    showWebView();
                }
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
        url = item.subTitle;
        mWebView.loadUrl(item.subTitle);
        showWebView();
    }

    public void showWebView() {
        show(mWebView);
        hide(flContainer);
    }

    public void showBookmarkView() {
        hide(mWebView);
        show(flContainer);
    }
}
