package com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation

import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.pawnedemail.common.domain.util.ResponseD
import com.alphaomardiallo.pawnedemail.common.presentation.base.BaseViewModel
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase.GetAllBreachesUseCase
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation.model.GetAlBreachesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

@HiltViewModel
class GetAllBreachesViewModel @Inject constructor(
    private val getAllBreachesUseCase: GetAllBreachesUseCase,
) : BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    private val _uiState = MutableStateFlow(GetAlBreachesUiState())
    val uiState: StateFlow<GetAlBreachesUiState> = _uiState

    ///////////////////////////////////////////////////////////////////////////
    // Public functions
    ///////////////////////////////////////////////////////////////////////////

    fun getBreaches(email: String) {
        getAllBreachesUseCase.invoke(email = email).onEach { result ->
            when (result) {
                is ResponseD.Error -> _uiState.update { state -> state.copy(isLoading = false) }
                is ResponseD.Loading -> _uiState.update { state -> state.copy(isLoading = true) }
                is ResponseD.Success -> _uiState.update { state ->
                    val breachList = result.data ?: emptyList()
                    state.copy(breaches = breachList, isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
