package com.example.android.sunnymordor;

import java.io.Serializable;

// store Mordor info to be displayed in ListView
public class MordorInfo implements Serializable {
    public String words;        // text part of a ListView entry
    public int pic;             // resource for the image part of a ListView entry
    public int gotoRef;         // used by category headers to store their position in the ArrayList

    MordorInfo(String w, int p, int gotoR) {
        words = w;
        pic = p;
        gotoRef = gotoR;
    }
}
