package com.user.canopas.dagger.mvp.model


class Actors {
   lateinit var country: String
    lateinit var image: String
    lateinit var children: String
    lateinit var dob: String
    lateinit var name: String
    lateinit var description: String
    lateinit var spouse: String
    lateinit var height: String

    constructor(name: String, image: String, country: String, children: String, dob: String, description: String, spouse: String, height: String) {
        this.name = name
        this.image = image
        this.children = children
        this.country = country
        this.dob = dob
        this.description = description
        this.spouse = spouse
        this.height = height

    }

    constructor() {

    }

}
