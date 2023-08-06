package com.jsonify.classes;

import java.util.ArrayList;
import java.util.List;

public class Country {

    public String name;
    public String capital;
    public int population;
    public String language;

    // relations
    public List<Person> citizens = new ArrayList<Person>();

    // constructor
    public Country(String name, String capital, int population, String language){
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.language = language;
    }

    // methods
    public void addCitizen(Person p){
        if (citizens.contains(p)) return;
        citizens.add(p);
        p.moveToCountry(this);
    }

    public void expelCitizen(Person p){
        if (!citizens.contains(p)) return;
        citizens.remove(p);
        p.moveToCountry(null);
    }
    
    
}
