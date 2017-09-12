package com.user.canopas.dagger.di.Module


import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Singleton
@Module
class NetworkModule(internal var Base_URL: String) {

    @Provides
    @Singleton
     fun providegsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
     fun provideadapterFactory(): RxJavaCallAdapterFactory {
        return RxJavaCallAdapterFactory.create()
    }

    @Provides
    @Singleton
     fun provieRetrofit(gsonConverterFactory: GsonConverterFactory, adapterFactory: RxJavaCallAdapterFactory): Retrofit {
        return Retrofit.Builder().baseUrl(Base_URL)
                .addCallAdapterFactory(adapterFactory)
                .addConverterFactory(gsonConverterFactory).build()
    }


}
