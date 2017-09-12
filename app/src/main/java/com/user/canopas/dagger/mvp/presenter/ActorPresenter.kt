package com.user.canopas.dagger.mvp.presenter


import android.util.Log

import com.user.canopas.dagger.mvp.view.ActorView
import com.user.canopas.dagger.Api.ApiService
import com.user.canopas.dagger.mvp.model.ActorRespone


import javax.inject.Inject

import rx.Observable
import rx.Observer

class ActorPresenter @Inject
constructor() : BasePresenter<ActorView>(), Observer<ActorRespone> {

    @Inject
    @JvmField var mApiService: ApiService? = null


    fun getActor() {
        val observable = mApiService!!.actors
        subscribe(observable, this)
    }


    override fun onCompleted() {
        view?.compelet()
    }

    override fun onError(e: Throwable) {

        view?.Error(e.message)
    }

    override fun onNext(actorRespone: ActorRespone) {
        view?.GetActorResponse(actorRespone)
    }

}
