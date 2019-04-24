package com.salton123.bookmarksbrowser.manager;

import com.salton123.bookmarksbrowser.ui.fm.BrowserFragment;

/**
 * User: newSalton@outlook.com
 * Date: 2019/4/24 15:10
 * ModifyTime: 15:10
 * Description:
 */
public class BrowserEntity {
    public BrowserFragment fragment;
    public String tag;
    public String previewPicPath;

    public static BrowserEntity newInstance() {
        BrowserEntity entity = new BrowserEntity();
        entity.fragment = new BrowserFragment();
        entity.tag = "BrowserFragment_" + System.currentTimeMillis();
        return entity;
    }
}
