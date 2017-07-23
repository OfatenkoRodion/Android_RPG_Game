package com.example.testgame;

public abstract class NPC  extends Adam{
    int ExperienceCost;
    @Override
    public String toString(){
        return new StringBuilder().append("\nHP: ").append(HP).toString();
    }
}
