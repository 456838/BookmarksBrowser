package com.salton123;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
public class TitleMorePopupWindow extends DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setStyle(STYLE_NORMAL, R.style.MyDialog);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.comp_title_more_popup, null);
    }

    private boolean isPlay = false;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final VoiceIntroAniView imageView = view.findViewById(R.id.ivAni);
        imageView.start();
        isPlay = true;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlay) {
                    imageView.pause();
                } else {
                    imageView.start();
                }
                isPlay = !isPlay;
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.TOP;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.y = (int) getResources().getDimension(R.dimen.immersionBarHeight);
        window.setAttributes(params);
        window.setWindowAnimations(R.style.slide_popup_ani);
        window.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
        window.setDimAmount(0f);
    }
}
