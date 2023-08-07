package com.jsonify;

import java.util.HashMap;

import com.jsonify.utils.JsonUtils;

public class JsonObjectBuilder {

    private HashMap<String, Object> map = new HashMap<String, Object>();

    public JsonObjectBuilder() {
        this.map = new HashMap<>();
    }

    public JsonObjectBuilder(JsonObject jsonObject) {
        this.map = jsonObject.getMap();
    }

    public JsonObjectBuilder(String jsonString) {
        
    }

    public JsonObjectBuilder add(String key, String value) {
        this.map.put(key, value);
        return this;
    }

    public JsonObjectBuilder add(String key, char value) {
        Character c = Character.valueOf(value);
        this.map.put(key, c);
        return this;
    }

    public JsonObjectBuilder add(String key, boolean value) {
        Boolean b = Boolean.valueOf(value);
        this.map.put(key, b);
        return this;
    }

    // numbers
    public JsonObjectBuilder add(String key, int value) {
        Integer i = Integer.valueOf(value);
        this.map.put(key, i);
        return this;
    }

    public JsonObjectBuilder add(String key, double value) {
        Double d = Double.valueOf(value);
        this.map.put(key, d);
        return this;
    }

    public JsonObjectBuilder add(String key, float value) {
        Float f = Float.valueOf(value);
        this.map.put(key, f);
        return this;
    }

    public JsonObjectBuilder add(String key, long value) {
        Long l = Long.valueOf(value);
        this.map.put(key, l);
        return this;
    }

    public JsonObjectBuilder add(String key, short value) {
        Short s = Short.valueOf(value);
        this.map.put(key, s);
        return this;
    }

    public JsonObjectBuilder add(String key, JsonArray value) {
        this.map.put(key, value);
        return this;
    }

    public JsonObjectBuilder add(String key, JsonObject value){
        this.map.put(key, value);
        return this;
    }

    public void add(String key, Object object){
        this.map.put(key, object);
    }

    public JsonObject build() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append("\n");


        for (String key : this.map.keySet()) {

            Object value = this.map.get(key);
            
            sb.append("\"" + key + "\" : ");
            sb.append(JsonUtils.JsonifyValue(value));

            sb.append(",");
            sb.append("\n");
        }

        // gets rid of the trailing whitespace and comma
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("\n");
        sb.append("}");

        // ths  fixed a weird bug where the map was empty but the string was just a "}" character
        if (this.map.isEmpty() || this.map == null) {
            sb = new StringBuilder("{}");
        }

        return new JsonObject(sb.toString(), this.map);

    }

}
