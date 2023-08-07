package com.jsonify.utils;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.jsonify.Jsonifer;

public class JsonUtils {

   public static String JsonifyValue(Object value){

      // put quotes around the value if its a string or char
      if (value instanceof String || value instanceof Character) {
         return "\"" + value.toString() + "\"";
      } else if (value instanceof Number || value instanceof Boolean || value instanceof Byte) {
         return value.toString();
      } else {
         return Jsonifer.Jsonify(value).toString();
      }
   }

    
    


  

}
