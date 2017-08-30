
package com.example.testgame;

        import android.os.Parcel;
        import android.os.Parcelable;

public class NPC_Rat extends NPC{
    public NPC_Rat(){
        HP=50;
        DMG=3;
        At_SPD=1;
        ExperienceCost=12;
    }
    public NPC_Rat(Parcel in) {
        String[] data = new String[4];
        in.readStringArray(data);
        HP = Integer.parseInt(data[0]);
        DMG = Integer.parseInt(data[1]);
        At_SPD = Double.parseDouble(data[2]);
        ExperienceCost = Integer.parseInt(data[3]);
    }
    @Override
    public String toString(){
        return new StringBuilder().append("Rat ").append(super.toString()).toString();
    }

    public static final Parcelable.Creator<NPC> CREATOR = new Parcelable.Creator<NPC>() {

        @Override
        public NPC createFromParcel(Parcel source) {
            return new NPC_wolf (source);
        }

        @Override
        public NPC[] newArray(int size) {
            return new NPC_wolf[size];
        }
    };
}
