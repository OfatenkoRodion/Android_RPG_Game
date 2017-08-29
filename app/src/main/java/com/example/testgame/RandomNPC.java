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
        classes.add(com.example.testgame.NPC_Orc_Archer.class.getName());
        classes.add(com.example.testgame.NPC_Imp.class.getName());
    }
    public Class nextNPC(){
        int classesCount=classes.size();
        //Random r = new Random(System.currentTimeMillis()); Marking for future: WHY this work wrong in cycle?
        //int numberOfClass=r.nextInt(classesCount);         currentTimeMillis() not enough changed?
        int numberOfClass=(int) (Math.random() * classesCount);
        String nameOfClass= classes.get(numberOfClass);

        try {
        Class temp=  Class.forName(nameOfClass);
            return temp;
        }
        catch (ClassNotFoundException e) { return null; }
    }
    public String nextNPC2(){
        int classesCount=classes.size();
        //Random r = new Random(System.currentTimeMillis()); Marking for future: WHY this work wrong in cycle?
        //int numberOfClass=r.nextInt(classesCount);         currentTimeMillis() not enough changed?
        int numberOfClass=(int) (Math.random() * classesCount);
        String nameOfClass= classes.get(numberOfClass);
        return  nameOfClass;
    }
}
