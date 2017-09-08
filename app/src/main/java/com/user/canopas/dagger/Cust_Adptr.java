package com.user.canopas.dagger;


import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.user.canopas.dagger.mvp.model.Actors;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

class Cust_Adptr extends RecyclerView.Adapter<Cust_Adptr.ViewHolder> {

    Context c;
    ArrayList<Actors> arrayList;

    public Cust_Adptr(Context c, ArrayList<Actors> arrayList) {
        this.c = c;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.rowdesign, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        Glide.with(c).load(arrayList.get(position).getImage()).into(holder.img);
        holder.bind(arrayList.get(position), c);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.actor_img)
        ImageView img;
        @Bind(R.id.actor_name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(final Actors actors, final Context c) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  //  showDialog(actors, c);
                   FragmentManager fm =((Activity)c).getFragmentManager();
                    CustomDialog dialog=new CustomDialog();
                    dialog.addList(actors);
                    dialog.show(fm,"dialog");

                }
            });
        }
    }

    private void showDialog(Actors actors, Context c) {


        Dialog dialog = new Dialog(c);
        dialog.setContentView(R.layout.actor_details);

        CircleImageView img = dialog.findViewById(R.id.photo);

        TextView name = dialog.findViewById(R.id.name_txt);

        TextView country = dialog.findViewById(R.id.country_txt);

        TextView child = dialog.findViewById(R.id.child_txt);

        TextView dob = dialog.findViewById(R.id.dob_txt);

        TextView description = dialog.findViewById(R.id.description_txt);

        TextView spouse = dialog.findViewById(R.id.spouse_txt);

        TextView height = dialog.findViewById(R.id.height_txt);

        Glide.with(c).load(actors.getImage()).into(img);
        name.setText(actors.getName());
        country.setText(actors.getCountry());
        child.setText(actors.getChildren());
        dob.setText(actors.getDob());
        description.setText(actors.getDescription());
        spouse.setText(actors.getSpouse());
        height.setText(actors.getHeight());
        dialog.show();
    }
}