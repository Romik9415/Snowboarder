package com.fleetsu.fleetsu.ui.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnBoardingPage(
    @StringRes
    val title: Int,
    @DrawableRes
    val imgUrl: Int,
    @StringRes
    val description: Int
)
