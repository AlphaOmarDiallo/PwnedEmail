package com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation

import androidx.lifecycle.viewModelScope
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
                    is ResponseD.Error -> _uiState.update { it.copy(isLoading = false) }
                    is ResponseD.Loading -> _uiState.update { it.copy(isLoading = true) }
                    is ResponseD.Success -> _uiState.update {
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
