package com.user.canopas.dagger.di.Module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
@Module
public class NetworkModule {

    String Base_URL ;

    public NetworkModule(String base_URL) {
        this.Base_URL = base_URL;
    }

    @Provides
    @Singleton
    GsonConverterFactory providegsonConverterFactory(){return GsonConverterFactory.create();}
    @Provides
    @Singleton
    RxJavaCallAdapterFactory provideadapterFactory(){return RxJavaCallAdapterFactory.create();}

    @Provides
    @Singleton
    Retrofit provieRetrofit(GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory adapterFactory) {
        return new Retrofit.Builder().baseUrl(Base_URL)
                .addCallAdapterFactory(adapterFactory)
                .addConverterFactory(gsonConverterFactory).build();
    }


}
