package com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation

import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.pawnedemail.common.domain.model.Breach
import com.alphaomardiallo.pawnedemail.common.domain.model.Email
import com.alphaomardiallo.pawnedemail.common.domain.util.ResponseD
import com.alphaomardiallo.pawnedemail.common.presentation.base.BaseViewModel
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase.EmptyBreachesUseCase
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase.GetAllBreachesUseCase
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase.GetUserEmailUseCase
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase.SaveBreachesUseCase
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase.SaveEmailUseCase
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation.model.GetAlBreachesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class GetAllBreachesViewModel @Inject constructor(
    private val getAllBreachesUseCase: GetAllBreachesUseCase,
    private val saveBreachesUseCase: SaveBreachesUseCase,
    private val saveEmailUseCase: SaveEmailUseCase,
    private val getEmailUseCase: GetUserEmailUseCase,
    private val emptyBreachesUseCase: EmptyBreachesUseCase,
) : BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    private val _uiState = MutableStateFlow(GetAlBreachesUiState())
    val uiState: StateFlow<GetAlBreachesUiState> = _uiState

    ///////////////////////////////////////////////////////////////////////////
    // Public functions
    ///////////////////////////////////////////////////////////////////////////

    init {
        viewModelScope.launch {
            _uiState.update { state -> state.copy(email = getEmailUseCase.invoke()) }
        }
    }

    fun getBreaches(email: String) {
        getAllBreachesUseCase.invoke(email = email).onEach { result ->
            when (result) {
                is ResponseD.Error -> _uiState.update { state -> state.copy(isLoading = false) }
                is ResponseD.Loading -> _uiState.update { state -> state.copy(isLoading = true) }
                is ResponseD.Success -> _uiState.update { state ->
                    withContext(Dispatchers.IO) {

                        emptyBreachesUseCase.invoke()

                        saveEmail(Email(email = email))

                        val breachList = result.data ?: emptyList()
                        breachList.map { breach ->
                            saveBreach(breach.toBreach())
                        }

                        state.copy(breaches = breachList, isLoading = false)
                    }
                }
                }
        }.launchIn(viewModelScope)
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private functions
    ///////////////////////////////////////////////////////////////////////////

    private fun saveBreach(breach: Breach) {
        viewModelScope.launch {
            saveBreachesUseCase.invoke(breach)
        }
    }

    private fun saveEmail(email: Email) {
        viewModelScope.launch {
            saveEmailUseCase.invoke(email)
        }
    }
}
