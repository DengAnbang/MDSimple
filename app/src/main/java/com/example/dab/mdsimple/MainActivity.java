package com.example.dab.mdsimple;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.dab.mdsimple.kotlin.FloatingActionButtonActivity;
import com.example.dab.mdsimple.kotlin.activity.BaseActivity;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    public void floatingActionButton(View view) {
        startActivity(new Intent(this, FloatingActionButtonActivity.class));
    }

    @Override
    public void initToolbarEvent(@Nullable View view, @Nullable Toolbar toolbar) {
        super.initToolbarEvent(view, toolbar);
        if (toolbar != null) {
            toolbar.setTitle("标题");
            toolbar.setSubtitle("小标题");
        }

    }
}
