package com.example.testgame;
import android.os.Parcel;
import android.os.Parcelable;

public class CharacterGolem extends Character {

    public CharacterGolem(){
        HP=140;
        DMG=13;
        At_SPD=1;
        LVL=0;
        Current_experience=0;
        Next_lvl_experience=100;
    }
    public CharacterGolem(Parcel in) {
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
    }
    @Override
    public void takeDmg(Adam adam,int dmg){
        HP=HP-dmg;
    }

    @Override
    protected void Lvl_up(){
        HP+=7;
        DMG+=1 ;
        At_SPD=2;
        LVL++;
        Next_lvl_experience= Next_lvl_experience+45*LVL;
    }

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {

        @Override
        public Character createFromParcel(Parcel source) {
            return new CharacterGolem (source);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

}
