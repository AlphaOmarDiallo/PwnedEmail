package com.alphaomardiallo.pawnedemail.feature.breachlist.presentation

import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.pawnedemail.common.presentation.base.BaseViewModel
import com.alphaomardiallo.pawnedemail.feature.breachlist.domain.usecase.GetLastEmailUsed
import com.alphaomardiallo.pawnedemail.feature.breachlist.domain.usecase.GetListOfBreaches
import com.alphaomardiallo.pawnedemail.feature.breachlist.presentation.model.BreachListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class BreachesListViewModel @Inject constructor(
    private val getListOfBreaches: GetListOfBreaches,
    private val getLastEmailUsed: GetLastEmailUsed,
) : BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    private val _uiState = MutableStateFlow(BreachListState())
    val uiState: StateFlow<BreachListState> = _uiState

    ///////////////////////////////////////////////////////////////////////////
    // Init
    ///////////////////////////////////////////////////////////////////////////

    init {
        viewModelScope.launch {
            getListOfBreaches.invoke().collect { breachList ->
                _uiState.update { state ->
                    state.copy(
                        breaches = breachList.sortedByDescending { it.breachDate },
                        lastEmailUsed = getEmail()
                    )
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private functions
    ///////////////////////////////////////////////////////////////////////////

    private suspend fun getEmail() = getLastEmailUsed.invoke()
}
