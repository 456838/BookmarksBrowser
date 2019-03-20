package com.salton123;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

import com.salton123.base.BaseDialogFragment;
import com.salton123.bookmarksbrowser.BookBaseDialogFragment;
import com.salton123.bookmarksbrowser.R;
import com.salton123.bookmarksbrowser.bean.GridMenuItem;
import com.salton123.util.ScreenUtils;
import com.salton123.view.MenuGridAdapter;


/**
 * User: newSalton@outlook.com
 * Date: 2019/2/19 14:20
 * ModifyTime: 14:20
 * Description:
 */
public class MenuPopupFragment extends BaseDialogFragment {

    private static final String TAG = "MenuPopupFragment";
    private GridView gvMenu;
    private MenuGridAdapter mMenuGridAdapter;

    @Override
    public int getLayout() {
        return R.layout.comp_menu_popup;
    }

    @Override
    public void initVariable(Bundle savedInstanceState) {
        setStyle(STYLE_NORMAL, R.style.GeneralDialog);
    }

    @Override
    public void initViewAndData() {
        gvMenu = f(R.id.gvMenu);
        mMenuGridAdapter = new MenuGridAdapter(activity());
        gvMenu.setAdapter(mMenuGridAdapter);
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.add(new GridMenuItem("历史", getString(R.string.if_retangel)));
        mMenuGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "[onStart]");
        Window window = getDialog().getWindow();
        ScreenUtils.hideNavigationBar(window);
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
        window.setWindowAnimations(R.style.slide_popup_ani);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "[onResume]");
    }
}
