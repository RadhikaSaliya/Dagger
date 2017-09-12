package com.user.canopas.dagger.Api


import com.user.canopas.dagger.mvp.model.ActorRespone


import retrofit2.http.GET
import rx.Observable

interface ApiService {

    @get:GET("/JSONParsingTutorial/jsonActors")
    val actors: Observable<ActorRespone>
}
