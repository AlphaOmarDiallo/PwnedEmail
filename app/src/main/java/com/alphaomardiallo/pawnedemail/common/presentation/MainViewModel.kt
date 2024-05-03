package com.alphaomardiallo.pawnedemail.common.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.pawnedemail.common.domain.util.ResponseD
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase.GetAllBreachesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllBreachesUseCase: GetAllBreachesUseCase,
) : ViewModel() {

    fun getBreaches() {
        getAllBreachesUseCase.invoke("alphaomar.diallo@gmail.com").onEach { result ->
            when (result) {
                is ResponseD.Error -> Timber.i("Error")
                is ResponseD.Loading -> Timber.i("Loading")
                is ResponseD.Success -> Timber.i("Success")
            }
        }.launchIn(viewModelScope)
    }
}
