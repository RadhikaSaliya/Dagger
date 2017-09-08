package com.user.canopas.dagger.mvp.model;


public class Actors {
    public String country;
    public String image;
    public String children;
    public String dob;
    public String name;
    public String description;
    public String spouse;
    public String height;

    public Actors(String name, String image, String country, String children, String dob, String description, String spouse, String height) {
        this.name = name;
        this.image = image;
        this.children = children;
        this.country = country;
        this.dob = dob;
        this.description = description;
        this.spouse = spouse;
        this.height = height;

    }

    public Actors() {

    }

    public String getCountry() {
        return this.country;
    }


    public String getImage() {
        return this.image;
    }


    public String getChildren() {
        return this.children;
    }


    public String getDob() {
        return this.dob;
    }


    public String getName() {
        return this.name;
    }


    public String getDescription() {
        return this.description;
    }


    public String getSpouse() {
        return this.spouse;
    }

    public String getHeight() {
        return this.height;
    }

}
