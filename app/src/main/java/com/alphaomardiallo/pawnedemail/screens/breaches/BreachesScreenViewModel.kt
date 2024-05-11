package com.alphaomardiallo.pawnedemail.screens.breaches

import com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics.LogScreenViewUseCase
import com.alphaomardiallo.pawnedemail.common.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BreachesScreenViewModel @Inject constructor(
    private val logScreenViewUseCase: LogScreenViewUseCase,
) : BaseViewModel() {

    fun logScreenView() = logScreenViewUseCase.invoke("BREACHES SCREEN")
}
