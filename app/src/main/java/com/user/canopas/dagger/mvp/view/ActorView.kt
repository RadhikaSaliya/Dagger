package com.user.canopas.dagger.mvp.view


import com.user.canopas.dagger.mvp.model.ActorRespone

import rx.Observable

interface ActorView {


    fun compelet()

    fun Error(message: String?)

    fun GetActorResponse(actorRespone: ActorRespone)


}
