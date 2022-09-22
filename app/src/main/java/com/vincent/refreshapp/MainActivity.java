package com.vincent.refreshapp;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.scwang.smart.refresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private RefreshLayout mRefreshLayout;


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    private enum Item {
        默认主题(R.string.item_style_theme_default_abstract),
        橙色主题(R.string.item_style_theme_orange_abstract),
        红色主题(R.string.item_style_theme_red_abstract),
        绿色主题(R.string.item_style_theme_green_abstract),
        蓝色主题(R.string.item_style_theme_blue_abstract),
        ;
        public int nameId;
        Item(@StringRes int nameId) {
            this.nameId = nameId;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRefreshLayout = findViewById(R.id.refreshLayout);

        mRefreshLayout.autoRefresh();//第一次进入触发自动刷新，演示效果

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Item> items = new ArrayList<>();
        items.addAll(Arrays.asList(Item.values()));
        items.addAll(Arrays.asList(Item.values()));
        recyclerView.setAdapter(new BaseRecyclerAdapter<Item>(items, R.layout.item_style_delivery,this) {
            @Override
            protected void onBindViewHolder(SmartViewHolder holder, Item model, int position) {
            }
        });

    }
}