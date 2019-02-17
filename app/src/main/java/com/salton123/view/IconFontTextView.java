package com.salton123.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * User: newSalton@outlook.com
 * Date: 2019/2/17 8:45 AM
 * ModifyTime: 8:45 AM
 * Description:
 */
public class IconFontTextView extends TextView {
    public static Typeface mTypeface;

    public IconFontTextView(Context context) {
        this(context, null);
    }

    public IconFontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTypeface() {
        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(getContext().getAssets(), "iconfont.ttf");
        }
        setTypeface(mTypeface);
    }

    public void setColorFilter(int color){
        setTextColor(color);
    }

    public void setIconSize(float size){
        setTextSize(size);
    }

    public void setImageResource(int resId){
        setText(resId);
    }
}
