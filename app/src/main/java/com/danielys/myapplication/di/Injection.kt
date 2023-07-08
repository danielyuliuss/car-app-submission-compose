package com.danielys.myapplication.di

import com.danielys.myapplication.data.CarRepository


object Injection {
    fun provideRepository(): CarRepository {
        return CarRepository.getInstance()
    }
}