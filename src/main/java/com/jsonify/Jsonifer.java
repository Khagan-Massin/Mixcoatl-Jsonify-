package com.jsonify;

import java.lang.reflect.Field;

public class Jsonifer {

    public static JsonArray Jsonify(Iterable<?> iterable) {

        JsonArrayBuilder jab = new JsonArrayBuilder();

        for (Object object : iterable) {
            jab.add(object);
        }

        return jab.build();
    }

    public static JsonArray Jsonify(Object[] array) {

        JsonArrayBuilder jab = new JsonArrayBuilder();

        for (Object object : array) {
            jab.add(object);
        }

        return jab.build();
    }

    public static JsonObject Jsonify(String jsonString) {
        return new JsonObjectBuilder(jsonString).build();
    }

    public static JsonObject Jsonify(Object object) {

        if (object instanceof JsonObject) {
            return (JsonObject) object;
        }

        JsonObjectBuilder jab = new JsonObjectBuilder();

        Class<?> clazz = object.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            String key = field.getName();

            Object value = null;

            try {
                value = field.get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }

            jab.add(key, value);
        }

        jab.add("type", object.getClass().getSimpleName());
        return jab.build();

    }

}
