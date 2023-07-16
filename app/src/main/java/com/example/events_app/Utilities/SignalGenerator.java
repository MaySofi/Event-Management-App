package com.example.events_app.Utilities;

import android.content.Context;
import android.widget.Toast;

public class SignalGenerator {
    public static SignalGenerator instance;
    private final Context context;
    private SignalGenerator(Context context) {
        this.context = context;
    }
    public static void init(Context context) {
        if (instance == null) {
            instance = new SignalGenerator(context);
        }
    }

    public static SignalGenerator getInstance() {
        return instance;
    }

    public void toast(String text, int length) {
        Toast
                .makeText(context, text, length)
                .show();
    }
}
