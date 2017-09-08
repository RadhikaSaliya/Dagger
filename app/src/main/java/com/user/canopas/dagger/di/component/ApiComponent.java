package com.user.canopas.dagger.di.component;

import com.user.canopas.dagger.MainActivity;
;
import com.user.canopas.dagger.di.Module.ApiModule;
import com.user.canopas.dagger.di.Scope.CustomScope;

import dagger.Component;

@CustomScope
@Component(modules = ApiModule.class,dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity mainActivity);
}
