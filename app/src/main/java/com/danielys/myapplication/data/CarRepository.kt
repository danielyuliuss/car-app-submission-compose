package com.danielys.myapplication.data

import com.danielys.myapplication.model.Car
import com.danielys.myapplication.model.CarDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CarRepository {

    fun getAllCars(): Flow<List<Car>> {
        return flowOf(CarDataSource.dummyCar)
    }

    fun getCarsById(carId: Long): Car {
        return CarDataSource.dummyCar.first {
            it.id == carId
        }
    }

    companion object {
        @Volatile
        private var instance: CarRepository? = null

        fun getInstance(): CarRepository =
            instance ?: synchronized(this) {
                CarRepository().apply {
                    instance = this
                }
            }
    }
}