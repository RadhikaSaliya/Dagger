package com.user.canopas.dagger


import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.user.canopas.dagger.mvp.model.Actors

import java.util.ArrayList


import butterknife.BindView
import butterknife.ButterKnife
import de.hdodenhof.circleimageview.CircleImageView

internal class Cust_Adptr(var c: Context, var arrayList: ArrayList<Actors>?) : RecyclerView.Adapter<Cust_Adptr.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(c).inflate(R.layout.rowdesign, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name!!.text = arrayList!![position].name
        Glide.with(c).load(arrayList!![position].image).into(holder.img!!)
        holder.bind(arrayList!![position], c)
    }


    override fun getItemCount(): Int {
        return arrayList!!.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.actor_img)
         @JvmField var img: ImageView? = null
        @BindView(R.id.actor_name)
         @JvmField var name: TextView? = null

        init {
            ButterKnife.bind(this, itemView)

        }

        fun bind(actors: Actors, c: Context) {

            itemView.setOnClickListener {
                 //showDialog(actors, c);
                val fm = (c as Activity).fragmentManager
                val dialog = CustomDialog()
                dialog.addList(actors)
                dialog.show(fm, "dialog")
            }
        }
    }

    private fun showDialog(actors: Actors, c: Context) {


        val dialog = Dialog(c)
        dialog.setContentView(R.layout.actor_details)

        val img = dialog.findViewById<CircleImageView>(R.id.photo)

        val name = dialog.findViewById<TextView>(R.id.name_txt)

        val country = dialog.findViewById<TextView>(R.id.country_txt)

        val child = dialog.findViewById<TextView>(R.id.child_txt)

        val dob = dialog.findViewById<TextView>(R.id.dob_txt)

        val description = dialog.findViewById<TextView>(R.id.description_txt)

        val spouse = dialog.findViewById<TextView>(R.id.spouse_txt)

        val height = dialog.findViewById<TextView>(R.id.height_txt)

        Glide.with(c).load(actors.image).into(img)
        name.text = actors.name
        country.text = actors.country
        child.text = actors.children
        dob.text = actors.dob
        description.text = actors.description
        spouse.text = actors.spouse
        height.text = actors.height
        dialog.show()
    }
}