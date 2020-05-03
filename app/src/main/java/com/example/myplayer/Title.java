package com.example.myplayer;

import android.widget.TextView;

public class Title {
    TextView textView;

    public Title(TextView textView) {
        this.textView = textView;
    }

    public int getType() {
        return 1;
    }
}
