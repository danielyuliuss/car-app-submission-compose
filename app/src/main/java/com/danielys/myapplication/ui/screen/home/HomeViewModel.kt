package com.danielys.myapplication.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielys.myapplication.data.CarRepository
import com.danielys.myapplication.model.Car
import com.danielys.myapplication.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: CarRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Car>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Car>>>
        get() = _uiState

    fun getAllRewards() {
        viewModelScope.launch {
            repository.getAllCars()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = UiState.Success(orderRewards)
                }
        }
    }
}