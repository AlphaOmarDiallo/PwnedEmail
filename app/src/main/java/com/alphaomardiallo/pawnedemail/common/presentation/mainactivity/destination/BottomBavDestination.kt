package com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.destination

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.ui.graphics.vector.ImageVector
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.domain.destination.Destination

sealed class BottomNavDestination(
    val icon: ImageVector,
    @StringRes val resId: Int = 0,
) : Destination(resId.toString()) {

    data object Home : BottomNavDestination(
        icon = Icons.Default.Home,
        resId = R.string.bottom_nav_route_home
    )

    data object Breaches : BottomNavDestination(
        icon = Icons.AutoMirrored.Filled.List,
        resId = R.string.bottom_nav_route_breaches
    )

    data object Secure : BottomNavDestination(
        icon = Icons.Default.Lock,
        resId = R.string.bottom_nav_route_secure
    )
}
