package com.alphaomardiallo.pawnedemail.feature.appintroduction.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.pawnedemail.feature.appintroduction.domain.GetNumberBreachesUseCase
import com.alphaomardiallo.pawnedemail.feature.appintroduction.presentation.model.AppIntroUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class AppIntroViewModel @Inject constructor(
    private val getNumberBreachesUseCase: GetNumberBreachesUseCase,
) : ViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    private val _uiState = MutableStateFlow(AppIntroUiState())
    val uiState: StateFlow<AppIntroUiState> = _uiState

    ///////////////////////////////////////////////////////////////////////////
    // init
    ///////////////////////////////////////////////////////////////////////////

    init {
        viewModelScope.launch {
            getNumberBreachesUseCase.invoke().collect { numberOfBreach ->
                _uiState.update { it.copy(breachNumber = numberOfBreach) }
            }
        }
    }
}