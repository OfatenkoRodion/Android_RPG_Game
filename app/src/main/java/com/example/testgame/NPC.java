package com.example.testgame;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class NPC  extends Adam implements Parcelable {
    int ExperienceCost;
    @Override
    public String toString(){
        return new StringBuilder().append("HP: ").append(HP).toString();
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
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] { Integer.toString(HP), Integer.toString(DMG), Double.toString(At_SPD), Integer.toString(ExperienceCost) });
    }
}
