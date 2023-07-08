package com.danielys.myapplication.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielys.myapplication.data.CarRepository
import com.danielys.myapplication.model.Car
import com.danielys.myapplication.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
private val repository: CarRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Car>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Car>>
    get() = _uiState

    fun getCarById(carId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getCarsById(carId))
        }
    }
}