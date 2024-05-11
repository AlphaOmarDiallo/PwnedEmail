package com.alphaomardiallo.pawnedemail.screens.home

import com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics.LogScreenViewUseCase
import com.alphaomardiallo.pawnedemail.common.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val logScreenViewUseCase: LogScreenViewUseCase,
) : BaseViewModel() {

    fun logScreenView() = logScreenViewUseCase.invoke("HOME SCREEN")
}