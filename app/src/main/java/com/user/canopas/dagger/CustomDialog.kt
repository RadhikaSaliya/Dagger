package com.user.canopas.dagger


import android.app.DialogFragment
import android.app.FragmentManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView

import butterknife.ButterKnife

import com.bumptech.glide.Glide
import com.user.canopas.dagger.mvp.model.Actors


import de.hdodenhof.circleimageview.CircleImageView


class CustomDialog : DialogFragment() {
    lateinit var name: String
    lateinit var img: String
    lateinit var child: String
    lateinit var spouse: String
    lateinit var height: String
    lateinit var desc: String
    lateinit var country: String
    lateinit var dob: String
    @BindView(R.id.photo) lateinit var photo: ImageView
    @BindView(R.id.name_txt) lateinit var name_txt: TextView
    @BindView(R.id.country_txt) lateinit var country_txt: TextView
    @BindView(R.id.child_txt) lateinit var child_txt: TextView
    @BindView(R.id.dob_txt) lateinit var dob_txt: TextView
    @BindView(R.id.description_txt) lateinit var description_txt: TextView
    @BindView(R.id.spouse_txt) lateinit var spouse_txt: TextView
    @BindView(R.id.height_txt) lateinit var height_txt: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater.inflate(R.layout.actor_details, container, false)
        ButterKnife.bind(this, view)
        Glide.with(activity).load(img).into(photo)
        name_txt.text = name
        country_txt.text = "Country: " + country
        child_txt.text = "Children: " + child
        dob_txt.text = "Dob: " + dob

        description_txt.text = desc
        spouse_txt.text = "Spouse: " + spouse
        height_txt.text = "Height: " + height
        return view
    }

    private fun BindView(view: View) {
//        val photo = view.findViewById<CircleImageView>(R.id.photo)

//        val name_txt = view.findViewById<TextView>(R.id.name_txt)
//
//        val country_txt = view.findViewById<TextView>(R.id.country_txt)
//
//        val child_txt = view.findViewById<TextView>(R.id.child_txt)
//
//        val dob_txt = view.findViewById<TextView>(R.id.dob_txt)
//
//        val description_txt = view.findViewById<TextView>(R.id.description_txt)
//
//        val spouse_txt = view.findViewById<TextView>(R.id.spouse_txt)
//
//        val height_txt = view.findViewById<TextView>(R.id.height_txt)

    }

    fun addList(actors: Actors) {

        name = actors.name
        img = actors.image
        child = actors.children
        spouse = actors.spouse
        height = actors.height
        desc = actors.description
        country = actors.country
        dob = actors.dob


    }
}
