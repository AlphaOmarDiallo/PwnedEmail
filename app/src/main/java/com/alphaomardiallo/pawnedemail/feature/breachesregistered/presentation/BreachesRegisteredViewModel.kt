package com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation

import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics.LogEndLoadingBreachesErrorEventUseCase
import com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics.LogEndLoadingBreachesSuccessfullyEventUseCase
import com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics.LogStartLoadingAllBreachesEventUseCase
import com.alphaomardiallo.pawnedemail.common.domain.util.ResponseD
import com.alphaomardiallo.pawnedemail.common.presentation.base.BaseViewModel
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.domain.usecase.GetAllBreachesRegisteredUseCase
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation.model.BreachesRegisteredState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class BreachesRegisteredViewModel @Inject constructor(
    private val allBreachesRegisteredUseCase: GetAllBreachesRegisteredUseCase,
    private val logStartLoadingAllBreachesEventUseCase: LogStartLoadingAllBreachesEventUseCase,
    private val logEndLoadingBreachesErrorEventUseCase: LogEndLoadingBreachesErrorEventUseCase,
    private val logEndLoadingBreachesSuccessfullyEventUseCase: LogEndLoadingBreachesSuccessfullyEventUseCase,
) : BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    private val _uiState = MutableStateFlow(BreachesRegisteredState())
    val uiState: StateFlow<BreachesRegisteredState> = _uiState

    ///////////////////////////////////////////////////////////////////////////
    // Init
    ///////////////////////////////////////////////////////////////////////////

    init {
        viewModelScope.launch {
            allBreachesRegisteredUseCase.invoke().collect { result ->
                when (result) {
                    is ResponseD.Error -> {
                        logEndLoadingBreachesErrorEventUseCase.invoke(
                            result.error ?: ErrorEntity.Unknown
                        )
                        _uiState.update { it.copy(isLoading = false) }
                    }

                    is ResponseD.Loading -> {
                        logStartLoadingAllBreachesEventUseCase.invoke()
                        _uiState.update { it.copy(isLoading = true) }
                    }

                    is ResponseD.Success -> {
                        logEndLoadingBreachesSuccessfullyEventUseCase.invoke(result.data?.size ?: 0)
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                breaches = result.data ?: emptyList()
                            )
                        }
                    }
                }
            }
        }
    }
}
