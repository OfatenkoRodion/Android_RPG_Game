package com.example.testgame;

public class NPC_wolf extends NPC{
    public NPC_wolf(){
         HP=100;
         DMG=5;
         At_SPD=2;
         ExperienceCost=33;
    }

    @Override
    public void  giveDmg(Adam adam){
        adam.takeDmg(this,DMG);
    }
    @Override
    public void takeDmg(Adam adam,int dmg){
        HP=HP-dmg;
    }
}
