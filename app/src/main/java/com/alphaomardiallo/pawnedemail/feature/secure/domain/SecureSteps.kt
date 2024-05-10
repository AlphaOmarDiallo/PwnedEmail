package com.alphaomardiallo.pawnedemail.feature.secure.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alphaomardiallo.pawnedemail.R

sealed class SecureSteps(
    @DrawableRes val image: Int,
    @StringRes val contentDescription: Int,
    @StringRes val title: Int,
    @StringRes val text: Int,
    @StringRes val link: Int?,
) {

    data object Password : SecureSteps(
        image = R.drawable.password_data_img,
        contentDescription = R.string.step_password_content_description,
        title = R.string.step_password_title,
        text = R.string.step_password_text,
        link = null
    )

    data object TwoFactorAuth : SecureSteps(
        image = R.drawable.two_factor_auth_data_img,
        contentDescription = R.string.step_two_factor_auth_content_description,
        title = R.string.step_two_factor_auth_title,
        text = R.string.step_two_factor_auth_text,
        link = null
    )
}
