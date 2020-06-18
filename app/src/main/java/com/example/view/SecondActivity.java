package com.example.view;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final int V_CHILDREN_COUNT = 3;
    private static final int H_CHILDREN_COUNT = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        long start = SystemClock.currentThreadTimeMillis();
        LinearLayout layout = findViewById(R.id.v_scroll_layout);
        for (int i = 0; i < V_CHILDREN_COUNT; i++) {
            HorizontalScrollView subview = new HorizontalScrollView(this);
            LinearLayout scrollLayout = new LinearLayout(this);
            scrollLayout.setOrientation(LinearLayout.HORIZONTAL);
            subview.addView(scrollLayout);
            for (int j = 0; j < H_CHILDREN_COUNT; j++) {
                scrollLayout.addView(new CustomView(this));
            }
            layout.addView(subview);
        }
        Log.i("SecondActivity", "time " + (SystemClock.currentThreadTimeMillis() - start));
    }
}

