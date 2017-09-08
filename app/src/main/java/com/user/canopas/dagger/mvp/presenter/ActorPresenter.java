package com.user.canopas.dagger.mvp.presenter;


import android.util.Log;

import com.user.canopas.dagger.mvp.view.ActorView;
import com.user.canopas.dagger.Api.ApiService;
import com.user.canopas.dagger.mvp.model.ActorRespone;


import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

public class ActorPresenter extends BasePresenter implements Observer<ActorRespone> {

    @Inject
    ApiService mApiService;

    public ActorView mActorview;

    public void getActor() {
        Observable<ActorRespone> observable = mApiService.getActors();
        subscribe(observable, this);
    }


    @Inject
    public ActorPresenter(ActorView view) {
        this.mActorview = view;
    }

    @Override
    public void onCompleted() {
        mActorview.compelet();
    }

    @Override
    public void onError(Throwable e) {

        Log.e("error", e.getMessage());
        mActorview.Error(e.getMessage());
    }

    @Override
    public void onNext(ActorRespone actorRespone) {
        mActorview.GetActorResponse(actorRespone);
    }

}
