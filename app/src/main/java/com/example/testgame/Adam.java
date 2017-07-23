package com.example.testgame;

public abstract class Adam {
    int HP;
    int DMG;
    double At_SPD;
    public boolean isDead(){
        if (HP<0){
            return true;}
        else
            return false;
    }
    abstract void giveDmg(Adam adam);

    abstract void takeDmg(Adam adam,int dmg);


}
