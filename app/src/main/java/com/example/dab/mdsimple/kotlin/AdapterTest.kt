package com.example.dab.mdsimple.kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dab.mdsimple.R

/**
 * Created by dab on 2017/7/12.
 */
class AdapterTest : RecyclerView.Adapter<AdapterTest.ViewHolder>() {
    var integers: List<Int>? = null
    fun setData(integers: List<Int>) {
        this.integers = integers
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val get = integers?.get(position)
        holder?.tv?.text = get.toString()
    }

    override fun getItemCount(): Int {
        return if (integers == null) 0 else integers!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_test, parent, false))
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView = itemView?.findViewById(R.id.tv_item) as TextView
    }
}