package com.user.canopas.dagger.di.Module;


import com.user.canopas.dagger.di.Scope.CustomScope;
import com.user.canopas.dagger.mvp.view.ActorView;
import com.user.canopas.dagger.Api.ApiService;


import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @CustomScope
    ApiService provideService(Retrofit retrofit)
    {
        return retrofit.create(ApiService.class);
    }


}
