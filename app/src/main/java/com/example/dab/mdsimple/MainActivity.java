package com.example.dab.mdsimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dab.mdsimple.kotlin.FloatingActionButtonActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void floatingActionButton(View view) {
        startActivity(new Intent(this, FloatingActionButtonActivity.class));
    }
}
