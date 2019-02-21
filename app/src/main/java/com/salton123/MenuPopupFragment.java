package com.salton123;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.salton123.bookmarksbrowser.R;


/**
 * User: newSalton@outlook.com
 * Date: 2019/2/19 14:20
 * ModifyTime: 14:20
 * Description:
 */
public class MenuPopupFragment extends DialogFragment {

    private static final String TAG = "MenuPopupFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // setStyle(STYLE_NORMAL,R.style.salton_full_screen_dialog_dim);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.comp_menu_popup, null);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"[onStart]");
        Window window = getDialog().getWindow();
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
        Log.i(TAG,"[onStart]");
    }
}
