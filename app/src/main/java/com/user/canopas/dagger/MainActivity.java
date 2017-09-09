package com.user.canopas.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.user.canopas.dagger.Api.ApiService;
import com.user.canopas.dagger.di.Module.ApiModule;
import com.user.canopas.dagger.di.component.DaggerApiComponent;
import com.user.canopas.dagger.mvp.view.ActorView;
import com.user.canopas.dagger.Application.ActorApp;


import com.user.canopas.dagger.mvp.model.ActorRespone;
import com.user.canopas.dagger.mvp.model.Actors;
import com.user.canopas.dagger.mvp.presenter.ActorPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dmax.dialog.SpotsDialog;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements ActorView {
    @Inject
    ActorPresenter mActorPresenter;
    ArrayList<Actors> arrayList;
    Cust_Adptr adptr;
    RecyclerView recyclerView;
    SpotsDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  ((ActorApp) getApplication()).getApiComponent().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        arrayList = new ArrayList<>();
        resolveDaggerDependency();
        LoadData();

    }

    private void resolveDaggerDependency() {
        DaggerApiComponent.builder().networkComponent(((ActorApp) getApplication()).getneworkComponent()).apiModule(new ApiModule(this)).build().inject(this);
    }

    private void LoadData() {
        dialog = new SpotsDialog(MainActivity.this);
        dialog.show();

        mActorPresenter.getActor();
    }


    @Override
    public void compelet() {

        dialog.dismiss();
        Log.e("onComplate", "task Complete");

    }

    @Override
    public void Error(String message) {
        dialog.dismiss();
        Log.e("onError", message);
    }

    @Override
    public void GetActorResponse(ActorRespone actorRespone) {

        List<Actors> listActor = actorRespone.actors;
        Actors actors;
        for (int i = 0; i < listActor.size(); i++) {
            actors = listActor.get(i);
            arrayList.add(new Actors(actors.name, actors.image, actors.country, actors.children, actors.dob, actors.description, actors.spouse, actors.height));
        }

        adptr = new Cust_Adptr(this, arrayList);
        recyclerView.setAdapter(adptr);
    }


}
