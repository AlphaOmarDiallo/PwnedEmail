package com.alphaomardiallo.pawnedemail.common.domain.destination

import androidx.navigation.NamedNavArgument

open class Destination(
    val route: String,
    val args: List<NamedNavArgument> = emptyList(),
)
