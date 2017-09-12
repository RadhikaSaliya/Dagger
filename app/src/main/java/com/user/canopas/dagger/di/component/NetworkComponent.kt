package com.user.canopas.dagger.di.component


import com.user.canopas.dagger.di.Module.NetworkModule

import javax.inject.Singleton

import dagger.Component
import retrofit2.Retrofit

@Singleton
@Component(modules = arrayOf(NetworkModule::class))
interface NetworkComponent {

    fun retrofit(): Retrofit
}
