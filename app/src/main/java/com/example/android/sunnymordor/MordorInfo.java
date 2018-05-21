package com.example.android.sunnymordor;

import java.io.Serializable;

// store Mordor info to be displayed in ListView
public class MordorInfo implements Serializable {
    public String words;        // text part of a ListView entry
    public int pic;             // resource for the image part of a ListView entry
    public int gotoRef;         // Used by ArrayAdapter to tell the fragment code which
                                // navigation TextView to highlight when a category header
                                // is shown on the screen.

    MordorInfo(String w, int p, int gotoR) {
        words = w;
        pic = p;
        gotoRef = gotoR;
    }
}
