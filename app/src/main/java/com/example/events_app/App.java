package com.example.events_app;

import android.app.Application;
import android.util.Log;

import com.example.events_app.Model.DataManager;
import com.example.events_app.Model.Event;
import com.example.events_app.Model.EventItem;
import com.example.events_app.Utilities.Constants;
import com.example.events_app.Utilities.SignalGenerator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.jakewharton.threetenabp.AndroidThreeTen;

import java.util.ArrayList;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        SignalGenerator.init(this);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference titleRef = db.getReference(Constants.DBKeys.EVENTS);
        Log.d("AppApp", "onCreateApp: " + titleRef);
        titleRef.setValue(DataManager.getEvent());

        ArrayList<Event> events = new ArrayList<>();

        events.add(new Event()
                .setName("picnic ")
                .setDate("01/09/2023")
                .setLocation("HaYarkon Park, Tel Aviv")
                .addEventItem(new EventItem()
                        .setTitle("Blanket")
                        .setDate()
                        .setEditorName("May")
                )
                .addEventItem(new EventItem()
                        .setTitle("Snacks")
                        .setDate()
                        .setEditorName("Yarden")
                )
                .addEventItem(new EventItem()
                        .setTitle("Ice Pack")
                        .setDate()
                        .setEditorName("Liron")
                )
        );
    }
}
