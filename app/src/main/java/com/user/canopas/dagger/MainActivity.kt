package com.user.canopas.dagger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

import com.user.canopas.dagger.di.Module.ApiModule
import com.user.canopas.dagger.mvp.view.ActorView
import com.user.canopas.dagger.Application.ActorApp
import com.user.canopas.dagger.di.component.DaggerApiComponent


import com.user.canopas.dagger.mvp.model.ActorRespone
import com.user.canopas.dagger.mvp.model.Actors
import com.user.canopas.dagger.mvp.presenter.ActorPresenter
import java.util.ArrayList
import javax.inject.Inject
import dmax.dialog.SpotsDialog


class MainActivity : AppCompatActivity(), ActorView {
    @Inject lateinit var mActorPresenter: ActorPresenter
   lateinit var arrayList: ArrayList<Actors>
    lateinit internal var adptr: Cust_Adptr
    lateinit var recyclerView: RecyclerView
    lateinit var dialog: SpotsDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  ((ActorApp) getApplication()).getApiComponent().inject(this);

        recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        arrayList = ArrayList()
        resolveDaggerDependency()
        LoadData()

    }

    private fun resolveDaggerDependency() {
        DaggerApiComponent.builder().networkComponent((application as ActorApp).getneworkComponent()).apiModule(ApiModule(this)).build().inject(this)
    }

    private fun LoadData() {
        dialog = SpotsDialog(this@MainActivity)
        dialog.show()

        mActorPresenter.getActor()
    }


    override fun compelet() {

        dialog.dismiss()
        Log.e("onComplate", "task Complete")

    }

    override fun Error(message: String?) {
        dialog.dismiss()
        Log.e("onError", message)
    }

    override fun GetActorResponse(actorRespone: ActorRespone) {

        val listActor = actorRespone.actors
        var actors: Actors
        for (i in listActor!!.indices) {
            actors = listActor[i]
            arrayList.add(Actors(actors.name, actors.image, actors.country, actors.children, actors.dob, actors.description, actors.spouse, actors.height))
        }

        adptr = Cust_Adptr(this, arrayList)
        recyclerView.adapter = adptr
    }


}
