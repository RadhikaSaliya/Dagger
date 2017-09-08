package com.user.canopas.dagger.mvp.presenter;


import rx.Observable;

import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BasePresenter {

    protected <A> void subscribe(Observable<A> observable, Observer<A> observer) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe();
    }
}
