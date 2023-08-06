package com.jsonify.classes;

import java.util.ArrayList;
import java.util.List;

public class World {
    
    private static World instance = null;
    private List<Country> countries = new ArrayList<Country>();


    private World() {
    }

    public static World getWorld() {
        if (instance == null) instance = new World();
        return instance;
    }

    public void addCountry(Country c){
        if (countries.contains(c)) return;
        countries.add(c);
    }

    public void removeCountry(Country c){
        if (!countries.contains(c)) return;
        countries.remove(c);
    }

    public List<Country> getCountries(){
        return countries;
    }



    
}
