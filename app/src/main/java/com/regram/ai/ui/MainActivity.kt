package com.regram.ai.ui

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.regram.ai.R
import com.regram.ai.baseui.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        setTranslucentStatusAndNavigationBar()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setTranslucentStatusAndNavigationBar() {
        window.apply {
            statusBarColor = ContextCompat.getColor(context, R.color.translucent)
            navigationBarColor = ContextCompat.getColor(context, R.color.translucent)
        }
        setTransparentStatusBar()
    }

    private fun setTransparentStatusBar() {
//        this.window?.apply {
//            decorView.systemUiVisibility =
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//        }
    }
}
