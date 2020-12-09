package com.fleetsu.fleetsu.ui.discover


import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.View
import com.fleetsu.fleetsu.R
import com.fleetsu.fleetsu.baseui.BaseFragment
import com.fleetsu.fleetsu.extensions.doOnApplyWindowInsets
import kotlinx.android.synthetic.main.discover_fragment.*

class DiscoverFragment : BaseFragment() {
    override fun layoutId() = R.layout.discover_fragment

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        activity?.window?.apply {
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.systemUiVisibility =
                    decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                decorView.systemUiVisibility =
                    decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }

        initAdapter()

    }

    private fun initAdapter() {
        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = SkiResortAdapter(this)
        viewPager.adapter = pagerAdapter
    }

    override fun setListeners() {

    }

    override fun initViewModel() {
    }

    fun View.addSystemBottomPadding(
        targetView: View = this,
        isConsumed: Boolean = false
    ) {
        doOnApplyWindowInsets { _, insets, initialPadding ->
            targetView.updatePadding(
                bottom = initialPadding.bottom + insets.systemWindowInsetBottom
            )
            if (isConsumed) {
                insets.replaceSystemWindowInsets(
                    Rect(
                        insets.systemWindowInsetLeft,
                        insets.systemWindowInsetTop,
                        insets.systemWindowInsetRight,
                        0
                    )
                )
            } else {
                insets
            }
        }
    }

    fun View.updatePadding(
        left: Int = paddingLeft,
        top: Int = paddingTop,
        right: Int = paddingRight,
        bottom: Int = paddingBottom
    ) {
        setPadding(left, top, right, bottom)
    }

}