package com.alphaomardiallo.pawnedemail.screens.home

import androidx.annotation.StringRes
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.domain.destination.Destination

sealed class HomeScreenDestination(
    @StringRes val resId: Int = 0,
) : Destination(resId.toString()) {

    data object Home : HomeScreenDestination(
        resId = R.string.destination_home_screen
    )
}
