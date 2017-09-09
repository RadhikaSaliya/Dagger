package com.user.canopas.dagger.mvp.presenter;


import android.util.Log;

import com.user.canopas.dagger.mvp.view.ActorView;
import com.user.canopas.dagger.Api.ApiService;
import com.user.canopas.dagger.mvp.model.ActorRespone;


import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

public class ActorPresenter extends BasePresenter<ActorView> implements Observer<ActorRespone> {

    @Inject
    ApiService mApiService;


    public void getActor() {
        Observable<ActorRespone> observable = mApiService.getActors();
        subscribe(observable, this);
    }

    @Inject
    public ActorPresenter() {
    }




    @Override
    public void onCompleted() {
        getView().compelet();
    }

    @Override
    public void onError(Throwable e) {

        getView().Error(e.getMessage());
    }

    @Override
    public void onNext(ActorRespone actorRespone) {
        getView().GetActorResponse(actorRespone);
    }

}
