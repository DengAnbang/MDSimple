package com.example.dab.mdsimple.kotlin.activity

import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.dab.mdsimple.R
import com.example.dab.mdsimple.kotlin.AdapterTest

class FloatingActionButtonActivity : BaseActivity() {
    var recyclerView: RecyclerView? = null
    override fun getContentView(): Int {
        return R.layout.activity_floating_action_button
    }

    override fun getToolbarResID(): Int {
        return R.layout.toolbar_bese
    }

    override fun initView(view: View?) {
        super.initView(view)
        if (view == null) return
        FAB?.setOnClickListener { v -> Snackbar.make(v, "hhhh", Snackbar.LENGTH_SHORT).show() }
        recyclerView = findViewById(R.id.rv) as RecyclerView
    }

    override fun initData() {
        super.initData()
        val integers = (0..49).toList()
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val adapterTest = AdapterTest()
        recyclerView?.adapter = adapterTest
        adapterTest.setData(integers)
    }
}