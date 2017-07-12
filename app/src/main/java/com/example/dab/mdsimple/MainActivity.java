package com.example.dab.mdsimple;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.dab.mdsimple.kotlin.activity.BaseActivity;
import com.example.dab.mdsimple.kotlin.activity.coordinator.CoordinatorActivity;
import com.example.dab.mdsimple.kotlin.activity.fab.FloatingActionButtonActivity;
import com.example.dab.mdsimple.kotlin.activity.tab.TabLayoutActivity;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }



    @Override
    public void initToolbarEvent(@Nullable View view, @Nullable Toolbar toolbar) {
        super.initToolbarEvent(view, toolbar);
        if (toolbar != null) {
            toolbar.setTitle("标题");
            toolbar.setSubtitle("小标题");
        }

    }
    public void floatingActionButton(View view) {
        startActivity(new Intent(this, FloatingActionButtonActivity.class));
    }
    public void tabLayout(View view) {
        startActivity(new Intent(this, TabLayoutActivity.class));
    }
    public void coordinator(View view) {
        startActivity(new Intent(this, CoordinatorActivity.class));
    }
}
