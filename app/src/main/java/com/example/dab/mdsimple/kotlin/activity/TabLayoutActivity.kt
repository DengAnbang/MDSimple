package com.example.dab.mdsimple.kotlin.activity

import com.example.dab.mdsimple.R

class TabLayoutActivity : BaseActivity() {
    override fun getContentView(): Int {
        return R.layout.activity_tab_layout
    }
    override fun getToolbarResID(): Int {
        return R.layout.toolbar_bese
    }

}
