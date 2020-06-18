package com.example.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int V_CHILDREN_COUNT = 3;
    private static final int H_CHILDREN_COUNT = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ListView listView = findViewById(R.id.list);
        List<String> itemList = new ArrayList<>();
        itemList.add("复杂布局展示");
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, itemList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, SecondActivity.class));
                        break;
                }
            }
        });
    }
}

