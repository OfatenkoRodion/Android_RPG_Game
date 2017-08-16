package com.example.testgame;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

public class RandomNPC {
    ArrayList<String> classes ;
    public RandomNPC(){
        classes = new ArrayList<String>();
        classes.add(com.example.testgame.NPC_wolf.class.getName());
    }
    public Class nextCharacter(){
        int classesCount=classes.size();
        Random r = new Random(System.currentTimeMillis());

        int numberOfClass=r.nextInt(classesCount);
        String nameOfClass= classes.get(numberOfClass);

        try {
        Class temp=  Class.forName(nameOfClass);
            return temp;
        }
        catch (ClassNotFoundException e) { return null; }
    }

}
