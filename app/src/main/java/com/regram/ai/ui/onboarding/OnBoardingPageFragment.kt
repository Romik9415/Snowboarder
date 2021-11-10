package com.regram.ai.ui.onboarding

import android.os.Bundle
import android.view.View
import com.regram.ai.R
import com.regram.ai.baseui.BaseFragment
import kotlinx.android.synthetic.main.fragment_on_boarding_page.*

class OnBoardingPageFragment : BaseFragment() {
//    @Inject
//    lateinit var vmFactory: AppViewModelsFactory
//    private lateinit var viewModel: LoginViewModel

    var onBoardingPageItem: OnBoardingPage? = null

    override fun layoutId() = R.layout.fragment_on_boarding_page

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        onBoardingPageItem?.let {
            ivOnBoardingPage.setImageDrawable(context?.getDrawable(it.imgUrl))
            tvTitle.text = context?.getString(it.title)
            tvDetails.text = context?.getString(it.description)

        }
    }

    override fun setListeners() {

    }

    override fun initViewModel() {
//        viewModel = ViewModelProviders
//            .of(this, vmFactory)
//            .get(LoginViewModel::class.java)
//
//        viewModel.getUser(resortItem!!.lon, resortItem!!.lat).observe(this, Observer { t ->
//            t?.let {
//                val celsius = (it.main.temp - 273.15F).toInt()
//                textView4.text = it.weather.first().main + " " + celsius
//
//            }
//        })
    }

    fun setResort(onBoardingPage: OnBoardingPage) {
        onBoardingPageItem = onBoardingPage
    }
}