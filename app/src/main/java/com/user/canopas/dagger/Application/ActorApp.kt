package com.user.canopas.dagger.Application


import android.app.Application


import com.user.canopas.dagger.di.Module.NetworkModule
import com.user.canopas.dagger.di.component.DaggerNetworkComponent
import com.user.canopas.dagger.di.component.NetworkComponent





class ActorApp : Application() {
     var Base_URL = "http://microblogging.wingnity.com/"
     @JvmField var networkComponent: NetworkComponent?=null


    override fun onCreate() {
        super.onCreate()
        resolveDependency()
    }

    private fun resolveDependency() {
        networkComponent = DaggerNetworkComponent.builder().networkModule(NetworkModule(Base_URL)).build()
        // apiComponent = DaggerApiComponent.builder().networkComponent(networkComponent).apiModule(new ApiModule()).build();
    }

    fun getneworkComponent(): NetworkComponent? {
        return networkComponent
    }
}
