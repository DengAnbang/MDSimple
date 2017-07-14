package com.example.dab.mdsimple.kotlin.activity.coordinator

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.dab.mdsimple.R
import com.example.dab.mdsimple.kotlin.AdapterTest
import com.example.dab.mdsimple.kotlin.activity.BaseActivity

class CoordinatorActivity : BaseActivity() {
    override fun getContentView(): Int {
        return R.layout.activity_coordinator
    }
//    override fun getToolbarResID(): Int {
//        return R.layout.toolbar_bese
//    }

    override fun initView(view: View?) {
        super.initView(view)
        val recyclerView = findViewById(R.id.rv) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapterTest = AdapterTest()
        recyclerView.adapter = adapterTest
        adapterTest.setData((0..49).toList())
    }
}
