package com.fleetsu.fleetsu.ui.discover

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fleetsu.fleetsu.AppViewModelsFactory
import com.fleetsu.fleetsu.R
import com.fleetsu.fleetsu.baseui.BaseFragment
import com.fleetsu.fleetsu.extensions.loadWithGlide
import com.fleetsu.fleetsu.extensions.toastSh
import com.fleetsu.fleetsu.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_resort.*
import javax.inject.Inject

class ResortFragment : BaseFragment() {
    @Inject
    lateinit var vmFactory: AppViewModelsFactory
    private lateinit var viewModel: LoginViewModel

    var resortItem: Resort? = null

    override fun layoutId() = R.layout.fragment_resort

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        resortItem?.let {
            textView5.text = it.name
            imageView3.loadWithGlide(it.imgUrl)
        }
    }

    override fun setListeners() {

    }

    override fun initViewModel() {
        viewModel = ViewModelProviders
            .of(this, vmFactory)
            .get(LoginViewModel::class.java)

        viewModel.getUser(resortItem!!.lon, resortItem!!.lat).observe(this, Observer { t ->
            t?.let {
                val celsius = (it.main.temp - 273.15F).toInt()
                textView4.text = it.weather.first().main + " " + celsius

            }
        })
    }

    fun setResort(resort: Resort) {
        resortItem = resort
    }
}