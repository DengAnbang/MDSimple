package com.example.dab.mdsimple.kotlin

import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dab.mdsimple.R
import com.example.dab.mdsimple.kotlin.activity.BaseActivity

class FloatingActionButtonActivity : BaseActivity() {
    var recyclerView:RecyclerView?=null
    override fun getContentView(): Int {
        return R.layout.activity_floating_action_button
    }

    override fun getToolbarResID(): Int {
        return R.layout.toolbar_bese
    }

    override fun initView(view: View?) {
        super.initView(view)
        if (view==null)return
        FAB?.setOnClickListener { v -> Snackbar.make(v,"hhhh",Snackbar.LENGTH_SHORT).show() }
        recyclerView = findViewById(R.id.rv) as RecyclerView
    }

    override fun initData() {
        super.initData()
        val integers = (0..49).toList()
        recyclerView?.layoutManager=LinearLayoutManager(this)
        val adapterTest=AdapterTest()
        recyclerView?.adapter = adapterTest
        adapterTest.setData(integers)
    }
}

class AdapterTest : RecyclerView.Adapter<AdapterTest.ViewHolder>() {
   var integers :List<Int>?=null
    fun setData(integers: List<Int>) {
        this.integers=integers
        notifyDataSetChanged()

    }
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val get = integers?.get(position)
        holder?.tv?.text=get.toString()
    }

    override fun getItemCount(): Int {
        return if (integers==null) 0 else integers!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_test,parent,false))
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val tv:TextView= itemView?.findViewById(R.id.tv_item) as TextView
    }




}