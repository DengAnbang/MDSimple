package com.example.dab.mdsimple.kotlin.behavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.view.View


/**
 * Created by dab on 2017/7/12.
 */
class FABBehavior(context: Context?, attrs: AttributeSet?) : FloatingActionButton.Behavior(context, attrs) {
    // 动画插值器，可以控制动画的变化率
    private val INTERPOLATOR = FastOutSlowInInterpolator()

    // 是否正在执行隐藏的动画
    var mIsAnimatingOut = false


    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                     directTargetChild: View, target: View, nestedScrollAxes: Int): Boolean {
        // 如果是上下滑动的，则返回true
        val b = nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
        return b || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                target: View, dxConsumed: Int, dyConsumed: Int,
                                dxUnconsumed: Int, dyUnconsumed: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
        if (dyConsumed > 0 && !this.mIsAnimatingOut && child.visibility == View.VISIBLE) {
            // 用户向下滑动时判断是否正在执行隐藏动画，如果不是，而且FAB当前是可见的，则执行隐藏动画隐藏FAB
            animateOut(child)
            return
        }
        if (dyConsumed < 0 && child.visibility == View.INVISIBLE) {
            // 用户向上滑动时判断FAB是否可见，如果不可见则执行显示动画显示FAB
            animateIn(child)
            return
        }
    }

    private fun animateOut(button: FloatingActionButton) {
            ViewCompat.animate(button).scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setInterpolator(INTERPOLATOR).withLayer()
                    .setListener(object : ViewPropertyAnimatorListener {
                        override fun onAnimationStart(view: View) {
                            mIsAnimatingOut = true
                        }

                        override fun onAnimationCancel(view: View) {
                           mIsAnimatingOut = false
                        }

                        override fun onAnimationEnd(view: View) {
                            mIsAnimatingOut = false
                            view.visibility = View.INVISIBLE
                        }
                    }).start()
    }

    private fun animateIn(button: FloatingActionButton) {
        button.visibility = View.VISIBLE
            ViewCompat.animate(button).scaleX(1.0f).scaleY(1.0f).alpha(1.0f)
                    .setInterpolator(INTERPOLATOR).withLayer().setListener(null)
                    .start()

    }
}