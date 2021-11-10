package com.regram.ai.baseui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.regram.ai.extensions.hideKeyboard

abstract class BaseFragment : Fragment(), Injectable {

    /*Using for getting layout id to be inflated*/
    @LayoutRes
    abstract fun layoutId(): Int

    /*Using for triggering inflating finished event*/
    abstract fun onViewReady(inflatedView: View, args: Bundle?)

    abstract fun setListeners()

    /*Using for initializing view models with viewModelProvider*/
    abstract fun initViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(layoutId(), container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
        setListeners()
    }

    override fun onDestroy() {
        hideKeyboard()
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewReady(view, savedInstanceState)
    }
}