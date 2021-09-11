package com.fleetsu.fleetsu.ui.main

import android.os.Build
import android.os.Bundle
import android.view.View
import com.fleetsu.fleetsu.R
import com.fleetsu.fleetsu.baseui.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(), View.OnClickListener {
    override fun layoutId() = R.layout.fragment_main
    var standardBottomSheetBehavior: BottomSheetBehavior<View>? = null

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        standardBottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)
        standardBottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED

    }

    override fun setListeners() {
        addProfile.setOnClickListener(this)
    }

    override fun initViewModel() {

    }

    private fun setTransparentStatusBar() {
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
    }

    override fun onClick(v: View?) {
        when (v) {
            addProfile -> {
                standardBottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }
}