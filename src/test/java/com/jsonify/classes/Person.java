package com.jsonify.classes;

 

import java.util.Date;

public class Person{

    // attributes
    public String name;
    public int age;
    public Date birthday;
    public boolean alive;
    
    //relations
    public Person father;
    public Person mother;
    public Country residence;

    // constructor
    public Person(String name, int age, Date birthday, boolean alive){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.alive = alive;
    }

    // methods
    public void moveToCountry(Country c){
        if (residence == c) return;

        this.residence = c;
        if (this.residence != null) residence.addCitizen(this);
    }
    
    





}