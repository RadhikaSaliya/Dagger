package com.user.canopas.dagger.di.Module


import com.user.canopas.dagger.MainActivity
import com.user.canopas.dagger.di.Scope.CustomScope
import com.user.canopas.dagger.mvp.view.ActorView
import com.user.canopas.dagger.Api.ApiService


import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule(internal var actorView: ActorView) {

    @Provides
    @CustomScope
     fun provideService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @CustomScope
     fun provideView(): ActorView {
        return actorView
    }


}
