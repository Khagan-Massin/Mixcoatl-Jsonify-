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

   public static Object parseValue(String value){

      // if its surroned by quotes, and its 1 character, its a char
      if (value.startsWith("\"") && value.endsWith("\"") && value.length() == 3) {
         return value.charAt(1);
      }
      // if its surroned by quotes, its a string
      else if (value.startsWith("\"") && value.endsWith("\"")) {
         return value.substring(1, value.length() - 1);
      }

      // if its a number with a decimal, its a double
      else if (value.contains(".")) {
         return Double.parseDouble(value);
      }

      // if its a number, its an int
      else if (value.matches("-?\\d+")) {
         return Integer.parseInt(value);
      }

      // if its a boolean, its a boolean
      else if (value.equals("true") || value.equals("false")) {
         return Boolean.parseBoolean(value);
      }

      // if its a null, its a null
      else if (value.equals("null")) {
         return null;
      }

      // // if its a json object, its a json object
      // else if (value.startsWith("{") && value.endsWith("}")) {
      //    return JsonToHashMap(value);
      // }

      throw new RuntimeException("Could not parse value: " + value);
   }

    


  

}
