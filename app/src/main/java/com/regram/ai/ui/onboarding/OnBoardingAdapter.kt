package com.regram.ai.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.regram.ai.R

class OnBoardingAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val skiResortsList = listOf(
        OnBoardingPage(
            R.string.on_brd_title_1,
            R.drawable.eastwood_done,
            R.string.on_brd_subtitle_1
        ),
        OnBoardingPage(
            R.string.on_brd_title_2,
            R.drawable.payment_processed,
            R.string.on_brd_subtitle_1
        ),
        OnBoardingPage(
            R.string.on_brd_title_3,
            R.drawable.eastwood_success,
            R.string.on_brd_subtitle_1
        )
    )

    override fun getItemCount() = skiResortsList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = OnBoardingPageFragment()
        fragment.setResort(skiResortsList[position])
        return fragment
    }
}