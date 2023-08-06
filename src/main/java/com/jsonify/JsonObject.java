package com.jsonify;

import java.util.HashMap;

public class JsonObject {

    public final String json;
    public final HashMap<String, Object> map;


    public JsonObject(String json, HashMap<String, Object> map) {
        this.json = json;
        this.map = map;
    }

    @Override
    public String toString() {
        return this.json;
    }

    public HashMap<String, Object> getMap() {
        // return a clone of the map
        return new HashMap<>(this.map);
    }

    public Object get(String key) {
        return this.map.get(key);
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    

     
    
}
