package com.example.android.sunnymordor;

import android.widget.TextView;

public class GotoButton {
    public int textViewRes;
    public String name;
    public int position;
    public TextView text;

    GotoButton(int tvR, String n, int p) {
        textViewRes = tvR;
        name = n;
        position = p;
    }
}
