package com.example.testgame;

import android.os.Parcelable;
import android.os.Parcel;

public abstract class Character extends  Adam implements Parcelable {
    int LVL;
    int Current_experience;
    int Next_lvl_experience;

    abstract void Lvl_up();
    public void Get_exp(int exp){
        Current_experience+=exp;

        if (Current_experience>=Next_lvl_experience)
            Lvl_up();
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] { Integer.toString(HP), Integer.toString(DMG), Double.toString(At_SPD), Integer.toString(LVL) ,Integer.toString(Current_experience),Integer.toString(Next_lvl_experience)});
    }
    @Override
    public String toString(){
        return new StringBuilder().append("LVL: ").append(LVL).append("\nHP: ").append(HP).append("\nDMG: ").append(DMG).append("\nОпыт: ").append(Current_experience).append("/").append(Next_lvl_experience).toString();
    }


}
