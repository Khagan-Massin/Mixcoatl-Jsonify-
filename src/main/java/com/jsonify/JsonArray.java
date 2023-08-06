package com.jsonify;

import java.util.ArrayList;

public class JsonArray {

    private final String json;
    private final ArrayList<Object> list;

    public JsonArray(String json, ArrayList<Object> list) {
        this.json = json;
        this.list = list;
    }

    @Override
    public String toString() {
        return this.json;
    }

    public ArrayList<Object> getList() {
        // return a clone of the list
        return new ArrayList<>(this.list);
    }
    
    public Object get(int index){
        return this.list.get(index);
    }
    public int size(){
        return this.list.size();
    }
    public boolean isEmpty(){
        return this.list.isEmpty();
    }
     
}
