package com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation

import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.pawnedemail.common.domain.model.Breach
import com.alphaomardiallo.pawnedemail.common.domain.model.Email
import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics.LogErrorSearchEventUseCase
import com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics.LogSearchEventUseCase
import com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics.LogSuccessfulSearchEventUseCase
import com.alphaomardiallo.pawnedemail.common.domain.util.ResponseD
import com.alphaomardiallo.pawnedemail.common.domain.util.getErrorMessage
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
    private val logSearchEventUseCase: LogSearchEventUseCase,
    private val logSuccessfulSearchEventUseCase: LogSuccessfulSearchEventUseCase,
    private val logErrorSearchEventUseCase: LogErrorSearchEventUseCase,
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

    fun updateEmailInUiState(email: String) {
        _uiState.update { state -> state.copy(email = email) }
    }

    fun getBreaches(email: String) {
        logSearchEventUseCase.invoke()

        getAllBreachesUseCase.invoke(email = email).onEach { result ->
            when (result) {
                is ResponseD.Error -> _uiState.update { state ->
                    if (result.error == ErrorEntity.NotFound) {
                        withContext(Dispatchers.IO) {
                            emptyBreachesUseCase.invoke()
                            saveEmail(Email(email = email))
                        }

                        logSuccessfulSearchEventUseCase.invoke(0)

                        state.copy(
                            isLoading = false,
                            isError = false,
                            errorMessage = null,
                            isNotBreached = true
                        )
                    } else {
                        logErrorSearchEventUseCase.invoke(result.error ?: ErrorEntity.Unknown)

                        state.copy(
                            isLoading = false,
                            isError = true,
                            errorMessage = getErrorMessage(result.error),
                            isNotBreached = false
                        )
                    }
                }

                is ResponseD.Loading -> _uiState.update { state ->
                    state.copy(
                        isLoading = true,
                        isError = false,
                        errorMessage = null,
                        isNotBreached = false
                    )
                }

                is ResponseD.Success -> _uiState.update { state ->
                    withContext(Dispatchers.IO) {
                        emptyBreachesUseCase.invoke()
                        saveEmail(Email(email = email))

                        val breachList = result.data ?: emptyList()
                        breachList.map { breach ->
                            saveBreach(breach.toBreach())
                        }

                        logSuccessfulSearchEventUseCase.invoke(breachList.size)

                        state.copy(
                            breaches = breachList,
                            isLoading = false,
                            isError = false,
                            errorMessage = null,
                            isNotBreached = false
                        )
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
