
package com.example.testgame;

        import android.os.Parcel;
        import android.os.Parcelable;

public class NPC_Orc_Archer  extends NPC{
    public NPC_Orc_Archer(){
        HP=197;
        DMG=41;
        At_SPD=4;
        ExperienceCost=62;
    }
    public NPC_Orc_Archer(Parcel in) {
        String[] data = new String[4];
        in.readStringArray(data);
        HP = Integer.parseInt(data[0]);
        DMG = Integer.parseInt(data[1]);
        At_SPD = Double.parseDouble(data[2]);
        ExperienceCost = Integer.parseInt(data[3]);
    }
    @Override
    public String toString(){
        return new StringBuilder().append("Orc_Archer").append(super.toString()).toString();
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

