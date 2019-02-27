package com.salton123;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.salton123.bookmarksbrowser.R;

/**
 * User: newSalton@outlook.com
 * Date: 2019/2/21 17:27
 * ModifyTime: 17:27
 * Description:
 */
public class VoiceIntroAniView extends ImageView {
    public VoiceIntroAniView(Context context) {
        this(context, null);
    }

    public VoiceIntroAniView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VoiceIntroAniView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    AnimationDrawable animationDrawable;

    private void initView() {
        animationDrawable = (AnimationDrawable) getContext().getResources().getDrawable(R.drawable.chat_voice_playing_anim);
        setImageDrawable(animationDrawable);
    }

    public void start() {
        animationDrawable.start();
    }

    public void pause() {
        animationDrawable.stop();
    }
}
