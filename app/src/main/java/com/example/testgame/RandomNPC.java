package com.example.testgame;

import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

public class RandomNPC {

    ArrayList<String> classes ;
    public RandomNPC(){
        classes = new ArrayList<String>();
        classes.add(com.example.testgame.CharacterGolem.class.toString());
        classes.add(com.example.testgame.CharacterVampire.class.toString());
        classes.add(com.example.testgame.CharacterReptilian.class.toString());
    }
    public Character nextCharacter(){

        int classesCount=classes.size();
        Random r = new Random(System.currentTimeMillis());

        String temp=classes.get( r.nextInt(classesCount));

        String clsName = "Ex";  // use fully qualified name
        Class cls = Class.forName(com.example.testgame.);
        Object clsInstance = (Object) cls.newInstance();

        return  (classes.get( r.nextInt(classesCount)).).class;
    }

}
