package com.user.canopas.dagger.Application;


import android.app.Application;

import com.user.canopas.dagger.di.Module.ApiModule;
import com.user.canopas.dagger.di.Module.NetworkModule;
import com.user.canopas.dagger.di.component.ApiComponent;

import com.user.canopas.dagger.di.component.DaggerApiComponent;
import com.user.canopas.dagger.di.component.DaggerNetworkComponent;
import com.user.canopas.dagger.di.component.NetworkComponent;


public class ActorApp extends Application {
    String Base_URL = "http://microblogging.wingnity.com/";
    NetworkComponent networkComponent;
    ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        resolveDependency();
    }

    private void resolveDependency() {
        networkComponent = DaggerNetworkComponent.builder().networkModule(new NetworkModule(Base_URL)).build();
        apiComponent = DaggerApiComponent.builder().networkComponent(networkComponent).apiModule(new ApiModule()).build();
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
