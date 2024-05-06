package com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.viewmodel

import com.alphaomardiallo.pawnedemail.common.domain.navigator.AppNavigator
import com.alphaomardiallo.pawnedemail.common.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    appNavigator: AppNavigator
) : BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    val navigationChannel = appNavigator.navigationChannel

}
