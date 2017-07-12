package com.example.dab.mdsimple.kotlin.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewStub
import com.example.dab.mdsimple.R

/**
 * Created by dab on 2017/7/10.
 */
abstract class BaseActivity : AppCompatActivity() {
    var FAB: FloatingActionButton? = null
    @LayoutRes
    protected abstract fun getContentView(): Int

    open fun initView(view: View?) {}
    open fun initData() {}
    open fun initEvent() {}

    @LayoutRes
    open fun getToolbarResID(): Int = 0

    open fun initToolbarEvent(view: View?, toolbar: Toolbar?) {
        view?.findViewById(R.id.toolbar_back)?.setOnClickListener { finish() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflate = LayoutInflater.from(this).inflate(R.layout.activity_base, null)
        val viewStub = inflate.findViewById(R.id.vs_content) as ViewStub?
        val inflateView = inflateView(viewStub!!, getContentView())

        val toolbar = inflate.findViewById(R.id.toolbar) as Toolbar?
        val toolbarViewStub = toolbar?.findViewById(R.id.toolbar_layout) as ViewStub?
        val toolbarView = inflateView(toolbarViewStub!!, getToolbarResID())
        if (toolbarView == null) {
            setContentView(getContentView())
        } else {
            setContentView(inflate)
            FAB = findViewById(R.id.fab) as FloatingActionButton
        }
        supportActionBar?.setDisplayShowTitleEnabled(false)
        initData()
        initView(inflateView)
        initToolbarEvent(toolbarView, toolbar)
        initEvent()

    }

    fun inflateView(viewStub: ViewStub, @LayoutRes layoutResource: Int): View? {
        if (layoutResource == 0) return null
        viewStub.layoutResource = layoutResource
        return viewStub.inflate()
    }


}