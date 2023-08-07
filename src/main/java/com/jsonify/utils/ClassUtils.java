package com.jsonify.utils;

public class ClassUtils {

    // for our purposes, a class is a relation if it has a field that is not a build in java or a primitive type
    // there are some exceptions to this rule, but for now we will keep it simple
    public static boolean isRelation(Class<?> clazz){

        // if it starts with java, it is a built in java class
        String className = clazz.getName();

        if(className.startsWith("java.")){
            return false;
        }

        return true;
    }

    public static boolean isRelation(Object object){
        return isRelation(object.getClass());
    }
    
}
