package com.jsonify;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class Parser{

    public static HashMap<String, Object> parse(String jsonString){

        // remove whitespace
        jsonString = jsonString.replaceAll("\\s", "");

        ArrayList<String> tokens = lex(jsonString);

        //remove first and last bracket
        tokens.remove(0);
        tokens.remove(tokens.size() - 1);

        HashMap<String, Object> map = new HashMap<String, Object>();

        while (!tokens.isEmpty()) {
            
        }
    }

    public static ArrayList<String> lex(String jsonString){

        // remove whitespace
        jsonString = jsonString.replaceAll("\\s", "");

        ArrayList<String> tokens = new ArrayList<String>();
        
        StringBuilder json = new StringBuilder(jsonString);

        while (json.length() > 0) {
            char c = json.charAt(0);
            json.deleteCharAt(0);
            if (c == '{' || c == '}' || c == '[' || c == ']' || c == ':' || c == ',') {
                tokens.add(String.valueOf(c));
            } else if (c == '"') {
                StringBuilder sb = new StringBuilder();
                sb.append('"');
                while (json.length() > 0) {
                    char c2 = json.charAt(0);
                    json.deleteCharAt(0);
                    if (c2 == '"') {
                        break;
                    } else {
                        sb.append(c2);
                    }
                }
                sb.append('"');
                tokens.add(sb.toString());
            } else if (c == ' ' || c == '\n' || c == '\t' || c == '\r') {
                // ignore whitespace
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while (json.length() > 0) {
                    char c2 = json.charAt(0);
                    json.deleteCharAt(0);
                    if (c2 == '{' || c2 == '}' || c2 == '[' || c2 == ']' || c2 == ':' || c2 == ',') {
                        json.insert(0, c2);
                        break;
                    } else if (c2 == ' ' || c2 == '\n' || c2 == '\t' || c2 == '\r') {
                        break;
                    } else {
                        sb.append(c2);
                    }
                }
                tokens.add(sb.toString());
            }
        }


        assert String.join("", tokens).equals(jsonString);

        return tokens;




    }
    
}
