package com.example.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * Created by jiangchao on 2020/6/11.
 */
public class CustomView extends LinearLayout {
    private static final int ViewDepth = 30;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        ViewGroup currentView = this;
        for (int i = 0; i < ViewDepth; i++) {
            View subview = LayoutInflater.from(getContext()).inflate(R.layout.item_view, this, false);
            LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i != 0) {
                layoutParam.leftMargin = 8;
                layoutParam.rightMargin = 8;
                layoutParam.topMargin = 8;
            }
            currentView.addView(subview, 0, layoutParam);
            currentView = (ViewGroup) subview;
        }
    }
}
