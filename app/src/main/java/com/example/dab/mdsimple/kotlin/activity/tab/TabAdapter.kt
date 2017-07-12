package com.example.dab.mdsimple.kotlin.activity.tab

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by dab on 2017/7/12.
 */
class TabAdapter(fm: FragmentManager?, val list_fragment: List<Fragment>, val list_Title: List<String>) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return list_fragment[position]
    }

    override fun getCount(): Int {
        return list_fragment.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return list_Title[position]
    }
}