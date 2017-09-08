package com.user.canopas.dagger.mvp.view;


import com.user.canopas.dagger.mvp.model.ActorRespone;

import rx.Observable;

public interface ActorView {


    void compelet();

    void Error(String message);

    void GetActorResponse(ActorRespone actorRespone);



}
