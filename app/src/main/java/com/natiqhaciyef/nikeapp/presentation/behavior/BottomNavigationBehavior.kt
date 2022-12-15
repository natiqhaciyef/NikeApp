package com.natiqhaciyef.nikeapp.presentation.behavior

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationBehavior : CoordinatorLayout.Behavior<BottomNavigationView>() {

    private var height: Float = 0f

    override fun onLayoutChild(
        parent: CoordinatorLayout,
        child: BottomNavigationView,
        layoutDirection: Int
    ): Boolean {
        height = child.height.toFloat()
        return super.onLayoutChild(parent, child, layoutDirection)
    }

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: BottomNavigationView,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: BottomNavigationView,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        if (dyConsumed > 0)
            slideDown(child)
        else if (dyConsumed < 0)
            slideUp(child)
    }

    fun slideDown(child: BottomNavigationView){
        child.clearAnimation()
        child.animate().translationY(0f).duration = 200
    }

    fun slideUp(child: BottomNavigationView){
        child.clearAnimation()
        child.animate().translationY(height).duration = 200
    }
}