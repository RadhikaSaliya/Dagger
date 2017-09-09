package com.user.canopas.dagger;


import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.user.canopas.dagger.mvp.model.Actors;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomDialog extends DialogFragment {
    String name, img, child, spouse, height, desc, country, dob;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.actor_details,container,false);

        CircleImageView photo = view.findViewById(R.id.photo);

        TextView name_txt = view.findViewById(R.id.name_txt);

        TextView country_txt = view.findViewById(R.id.country_txt);

        TextView child_txt = view.findViewById(R.id.child_txt);

        TextView dob_txt = view.findViewById(R.id.dob_txt);

        TextView description_txt = view.findViewById(R.id.description_txt);

        TextView spouse_txt = view.findViewById(R.id.spouse_txt);

        TextView height_txt = view.findViewById(R.id.height_txt);

        Glide.with(getActivity()).load(img).into(photo);
        name_txt.setText(name);
        country_txt.setText("Country: "+country);
        child_txt.setText("Children: "+child);
        dob_txt.setText("Dob: "+dob);

        description_txt.setText(desc);
        spouse_txt.setText("Spouse: "+spouse);
        height_txt.setText("Height: "+height);
        return view;
    }



    public CustomDialog() {

    }

    public void addList(Actors actors) {
        name = actors.getName();
        img = actors.getImage();
        child = actors.getChildren();
        spouse = actors.getSpouse();
        height = actors.getHeight();
        desc = actors.getDescription();
        country = actors.getCountry();
        dob = actors.getDob();


    }
}
