package com.user.canopas.dagger.Api;


import com.user.canopas.dagger.mvp.model.ActorRespone;


import retrofit2.http.GET;
import rx.Observable;

public interface ApiService {

    @GET("/JSONParsingTutorial/jsonActors")
     Observable<ActorRespone> getActors();
}
