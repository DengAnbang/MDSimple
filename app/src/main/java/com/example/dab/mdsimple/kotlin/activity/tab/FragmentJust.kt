package com.example.dab.mdsimple.kotlin.activity.tab

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by dab on 2017/7/12.
 */
class FragmentJust(val name: String) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textView = TextView(context)
        textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        textView.gravity = Gravity.CENTER
        textView.text = name
        return textView
    }

    companion object {
        fun getFragment(name: String): FragmentJust {
            return FragmentJust(name)
        }
    }

}