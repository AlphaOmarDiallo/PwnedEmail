package com.alphaomardiallo.pawnedemail.feature.allbreaches.presentation

import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.pawnedemail.common.presentation.base.BaseViewModel
import com.alphaomardiallo.pawnedemail.feature.allbreaches.domain.usecase.GetAllBreachesRegisteredUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class AllBreachesViewModel @Inject constructor(
    private val allBreachesRegisteredUseCase: GetAllBreachesRegisteredUseCase,
) : BaseViewModel() {

    init {
        viewModelScope.launch {
            val result = allBreachesRegisteredUseCase.invoke()
            Timber.e("BREACHES ${result.data?.size}")
        }
    }
}
