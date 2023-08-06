package com.jsonify;

import java.util.ArrayList;

import com.jsonify.utils.JsonUtils;

public class JsonArrayBuilder {

    private ArrayList<Object> list = new ArrayList<Object>();

    public JsonArrayBuilder() {
        this.list = new ArrayList<>();
    }

    public void add(String value){
        this.list.add(value);
    }

    public void add(char value){
        Character c = Character.valueOf(value);
        this.list.add(c);
    }

    public void add(boolean value){
        Boolean b = Boolean.valueOf(value);
        this.list.add(b);
    }
    
    // numbers
    public void add(int value){
        Integer i = Integer.valueOf(value);
        this.list.add(i);
    }

    public void add(double value){
        Double d = Double.valueOf(value);
        this.list.add(d);
    }

    public void add(float value){
        Float f = Float.valueOf(value);
        this.list.add(f);
    }

    public void add(long value){
        Long l = Long.valueOf(value);
        this.list.add(l);
    }

    public void add(short value){
        Short s = Short.valueOf(value);
        this.list.add(s);
    }

    public void add(Object value){
        this.list.add(value);
    }

    public JsonArray build(){

        StringBuilder sb = new StringBuilder();


        sb.append("[");
        sb.append("\n");

        for(Object value : this.list){
            sb.append(JsonUtils.JsonifyValue(value));
            sb.append(",");
            sb.append("\n");
        }

        // gets rid of the last comma and trailing newline
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("\n");
        sb.append("]");

        return new JsonArray(sb.toString(), this.list);

        

    }

    
   

 




    
}
