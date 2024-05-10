package com.alphaomardiallo.pawnedemail.feature.secure.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class SecureSteps(
    @DrawableRes val image: Int,
    @StringRes val contentDescription: Int,
    @StringRes val text: Int,
    @StringRes val link: Int,
) {

    data object PassWord : SecureSteps(
        image = 0,
        contentDescription = 0,
        text = 0,
        link = 0
    )

    data object TwoFactorAuth : SecureSteps(
        image = 0,
        contentDescription = 0,
        text = 0,
        link = 0
    )
}
