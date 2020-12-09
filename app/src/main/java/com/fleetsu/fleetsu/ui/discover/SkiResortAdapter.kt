package com.fleetsu.fleetsu.ui.discover

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SkiResortAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val skiResortsList = listOf<Resort>()

    //override fun getItemCount() = skiResortsList.size
    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment {
        return ResortFragment()
    }
}