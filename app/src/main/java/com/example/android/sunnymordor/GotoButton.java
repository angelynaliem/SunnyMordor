package com.example.android.sunnymordor;


import java.io.Serializable;

// stores info used by text buttons to jump to category headers in ListViews
public class GotoButton implements Serializable {
    public int textViewRes;
    public String name;
    public int position;

    GotoButton(int tvR, String n, int p) {
        textViewRes = tvR;
        name = n;
        position = p;
    }
}
