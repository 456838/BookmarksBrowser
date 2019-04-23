package com.salton123.bookmarksbrowser.ui.fm;

import android.os.Bundle;
import android.webkit.WebView;

import com.salton123.base.BaseFragment;
import com.salton123.bookmarksbrowser.R;

/**
 * User: newSalton@outlook.com
 * Date: 2019/4/23 18:01
 * ModifyTime: 18:01
 * Description:
 */
public class BrowserFragment extends BaseFragment {
    private String url;
    private WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getArguments().getString("URL", "");
    }

    @Override
    public int getLayout() {
        return R.layout.comp_browser;
    }

    @Override
    public void initVariable(Bundle savedInstanceState) {

    }

    @Override
    public void initViewAndData() {
        mWebView = f(R.id.webView);
        mWebView.loadUrl(url);
    }
}
