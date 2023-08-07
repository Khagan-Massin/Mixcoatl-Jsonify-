package com.jsonify;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import com.jsonify.classes.Bar;
import com.jsonify.classes.Foo;
import com.jsonify.utils.ClassUtils;
import com.jsonify.utils.JsonUtils;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        boolean expected = true;

        boolean actual = true;

        Boolean b = Boolean.valueOf(actual);

        System.out.println(b.toString());	
    }

    @Test
    public void JsonObjectTest(){

        JsonObjectBuilder builder = new JsonObjectBuilder();

        // try all the datatypes
        builder.add("name", "John");
        builder.add("age", 30);
        builder.add("married", false);
        builder.add("height", 1.80);
        builder.add("weight", 80.5);

       

        JsonObject obj = builder.build();

        System.out.println(obj.toString());
    }


    @Test
    public void JsonArrayTest(){

        JsonArrayBuilder jab = new JsonArrayBuilder();

        jab.add("John");
        jab.add(30);
        jab.add(false);
        jab.add(1.80);
        jab.add(80.5);

        JsonArray arr = jab.build();

        System.out.println(arr.toString());


    }

    @Test 
    public void nestedJson(){
        JsonObjectBuilder builder = new JsonObjectBuilder();

        builder.add("name", "Homer");
        builder.add("age", 30);
        builder.add("married", false);
        builder.add("height", 1.80);
        builder.add("weight", 80.5);

        JsonObjectBuilder builder2 = new JsonObjectBuilder();

        builder2.add("Name", "Marge");
        builder2.add("Age", 30);
        builder2.add("Married", true);
        builder2.add("Height", 1.80);

        builder.add("Wife", builder2.build());

        JsonObject homer = builder.build();
        JsonObject marge = builder2.build();

        System.out.println(homer.toString());


    }

    @Test 
    public void getFields(){
    
        Foo foo = new Foo();

        Class<?> clazz = foo.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for(Field field: fields){
            field.setAccessible(true);

            String key = field.getName();

            Object value = null;

            try {
                value = field.get(foo);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }
            
            System.out.println(key + " " + value.toString());
        }
        }


    @Test
    public void JsoniferTest(){

        Foo foo = new Foo();

        JsonObject obj = Jsonifer.Jsonify(foo);

        System.out.println(obj.toString());
    }

    @Test
    public void JsoniferTestRelation(){
            
        Bar bar = new Bar();
    
        JsonObject obj = Jsonifer.Jsonify(bar);
    
        System.out.println(obj.toString());
    }



    @Test
    public void ArrayJson(){
        Foo[] foo = new Foo[2];

        foo[0] = new Foo();
        foo[1] = new Foo();

        JsonArray arr = Jsonifer.Jsonify(foo);

        System.out.println(arr.toString());



    }

    @Test
    public void ArrayListJson(){
        ArrayList<Foo> list = new ArrayList<>();

        list.add(new Foo());
        list.add(new Foo());
        

        JsonArray arr = Jsonifer.Jsonify(list);

        System.out.println(arr.toString());
    
    }


    @Test
    public void testGetClass(){

        Foo foo = new Foo();

        Class<?> clazz = foo.getClass();

        System.out.println(clazz.getSimpleName());
    }

    @Test 
    public void ParseJson(){
        Bar bar = new Bar();
    
        JsonObject barJ = Jsonifer.Jsonify(bar);

        String json = barJ.toString();

        JsonObject obj = Jsonifer.Jsonify(json);

        System.out.println(obj);
    }

    @Test
    public void parseValue(){

        String stringy = "\"Hello world\"";
        String inty = "123";
        String booly = "true";
        String doubley = "1.23";
        String nully = "null";

        Object obj = JsonUtils.parseValue(stringy);
        assertTrue(obj instanceof String);
        assertEquals(obj, "Hello world");

        obj = JsonUtils.parseValue(inty);
        assertTrue(obj instanceof Integer);
        assertEquals(obj, 123);

        obj = JsonUtils.parseValue(booly);
        assertTrue(obj instanceof Boolean);
        assertEquals(obj, true);

        obj = JsonUtils.parseValue(doubley);
        assertTrue(obj instanceof Double);
        assertEquals(obj, 1.23);

        obj = JsonUtils.parseValue(nully);
        assertTrue(obj == null);







    }

    @Test
    public void lexJson(){

        String json = "{\"name\":\"John\",\"age\":30,\"married\":false,\"height\":1.8,\"weight\":80.5,\"wife\":{\"Name\":\"Marge\",\"Age\":30,\"Married\":true,\"Height\":1.8}}";

        System.out.println(json);

        for(String token: Parser.lex(json)){
            System.out.println(token.toString());
        }

     
        
    }
    
    @Test
    public void trygetClassname(){
        
        Integer i = 0;

        Class<?> clazz = i.getClass();

        System.out.println(clazz.getName());

    }

    @Test
    public void testDate(){
        Date date = new Date(0);
        Foo foo = new Foo();


        assertFalse(ClassUtils.isRelation(date));
        assertTrue(ClassUtils.isRelation(foo));

    }

}
