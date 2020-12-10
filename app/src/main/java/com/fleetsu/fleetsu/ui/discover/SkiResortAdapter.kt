package com.fleetsu.fleetsu.ui.discover

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SkiResortAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val skiResortsList = listOf(
        Resort(
            "Bukovel",
            "https://i.pinimg.com/originals/69/42/ff/6942ff78be6edddbd5905123da4c2067.jpg",
            48.36438209643884, 24.393337684450938
        ),
        Resort(
            "Plai",
            "https://lviv-tourist.info/wp-content/uploads/2015/10/0_21c617_4a61afc7_XXL.jpg",
            48.89655251097618, 23.331178159263253
        ),
        Resort(
            "Zahar Berkut",
            "https://zaharberkut.ua/wp-content/uploads/ZB-230.jpg",
            48.79876866336603, 23.44701746930819
        ),
        Resort(
            "Dragobrat",
            "https://travels-ukraine.com/wp-content/uploads/2019/01/drag-800x445.jpg",
            48.24430061264858, 24.240278894897493
        ),
        Resort(
            "Pylypets",
            "https://yellowbus.com.ua/images-content/404fa4bc90e9b43f6e8b9a950c70a3ec.jpg",
            48.64084167037589, 23.338612015312574
        )
    )

    override fun getItemCount() = skiResortsList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = ResortFragment()
        fragment.setResort(skiResortsList[position])
        return fragment
    }
}