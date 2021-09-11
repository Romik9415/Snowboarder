package com.fleetsu.fleetsu.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fleetsu.fleetsu.R

class OnBoardingAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val skiResortsList = listOf(
        OnBoardingPage(
            R.string.app_name,
            R.drawable.eastwood_done,
            R.string.app_name
        ),
        OnBoardingPage(
            R.string.app_name,
            R.drawable.payment_processed,
            R.string.app_name
        ),
        OnBoardingPage(
            R.string.app_name,
            R.drawable.eastwood_done,
            R.string.app_name
        ),
        OnBoardingPage(
            R.string.app_name,
            R.drawable.payment_processed,
            R.string.app_name
        )

    )

    override fun getItemCount() = skiResortsList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = OnBoardingPageFragment()
        fragment.setResort(skiResortsList[position])
        return fragment
    }
}