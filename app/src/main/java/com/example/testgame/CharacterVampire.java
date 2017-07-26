package com.example.testgame;
import android.os.Parcel;
import android.os.Parcelable;

public class CharacterVampire extends Character {

    public CharacterVampire(){
        HP=80;
        DMG=7;
        At_SPD=3;
        LVL=0;
        Current_experience=0;
        Next_lvl_experience=100;
    }
    public CharacterVampire(Parcel in) {
        String[] data = new String[6];
        in.readStringArray(data);
        HP = Integer.parseInt(data[0]);
        DMG = Integer.parseInt(data[1]);
        At_SPD = Double.parseDouble(data[2]);
        LVL = Integer.parseInt(data[3]);
        Current_experience= Integer.parseInt(data[4]);
        Next_lvl_experience= Integer.parseInt(data[5]);
    }

    @Override
    public void  giveDmg(Adam adam){
        adam.takeDmg(this,DMG);
        vampirism(adam);
    }
    private void vampirism (Adam adam){
        adam.takeDmg(this,2);
        HP=HP+2;
    }
    @Override
    public void takeDmg(Adam adam,int dmg){
        HP=HP-dmg;
    }
    @Override
    protected void Lvl_up(){
        HP+=5;
        DMG+=1 ;
        At_SPD=2;
        LVL++;
        Next_lvl_experience= Next_lvl_experience+45*LVL;
    }

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {

        @Override
        public Character createFromParcel(Parcel source) {
            return new CharacterVampire (source);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

}
