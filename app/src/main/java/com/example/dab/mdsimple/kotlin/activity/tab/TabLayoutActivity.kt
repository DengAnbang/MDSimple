package com.example.dab.mdsimple.kotlin.activity.tab

import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import com.example.dab.mdsimple.R
import com.example.dab.mdsimple.kotlin.activity.BaseActivity

class TabLayoutActivity : BaseActivity() {
    override fun getContentView(): Int {
        return R.layout.activity_tab_layout
    }

    override fun getToolbarResID(): Int {
        return R.layout.toolbar_bese
    }

    var ListOfFragment: ArrayList<FragmentJust> = ArrayList(4)
    var ListOfName: ArrayList<String> = ArrayList(4)


    override fun initData() {
        super.initData()
        arrayListOf("第一个", "第二个", "第三个", "第四个")
                .forEach { s: String ->
                    run {
                        ListOfFragment.add(FragmentJust.getFragment(s))
                        ListOfName.add(s)
                    }
                }
    }

    override fun initView(view: View?) {
        super.initView(view)
        if (view == null) return
        val tableLayout = view.findViewById(R.id.tab_FindFragment_title) as TabLayout
        val viewPager = view.findViewById(R.id.vp_FindFragment_pager) as ViewPager
        tableLayout.tabMode = TabLayout.MODE_FIXED
        ListOfName.forEach { s: String ->
            run {
                tableLayout.addTab(tableLayout.newTab().setText(s))
            }
        }
        viewPager.adapter=TabAdapter(supportFragmentManager,ListOfFragment,ListOfName)
        tableLayout.setupWithViewPager(viewPager)
    }
}


