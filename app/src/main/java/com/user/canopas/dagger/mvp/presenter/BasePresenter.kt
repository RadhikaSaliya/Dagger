package com.user.canopas.dagger.mvp.presenter


import javax.inject.Inject

import rx.Observable

import rx.Observer
import rx.Scheduler
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

open class BasePresenter<V> {
    @Inject
    @JvmField var view: V? = null

    protected fun <A> subscribe(observable: Observable<A>, observer: Observer<A>) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer)
    }
}
