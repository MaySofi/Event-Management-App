package com.example.events_app.Model;

import java.util.ArrayList;

public class DataManager {
    public static ArrayList<Event> getEvent() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event()
                .setName("Shavuot Eve")
                .setDate("25/05/2023")
                .setLocation("Home")
                .addEventItem(new EventItem()
                        .setTitle("Cake")
                        .setDate()
                        .setEditorName("Yarden")
                )
                .addEventItem(new EventItem()
                        .setTitle("Pasta")
                        .setDate()
                        .setEditorName("May")
                )
                .addEventItem(new EventItem()
                        .setTitle("Lasagna")
                        .setDate()
                        .setEditorName("Liron")
                )
        );
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
        events.add(new Event()
                .setName("Birthday Party")
                .setDate("17/10/2023")
                .setLocation("HaYarkon Park, Tel Aviv")
                .addEventItem(new EventItem()
                        .setTitle("Birthday Cake")
                        .setDate()
                        .setEditorName("Yarden")
                )
                .addEventItem(new EventItem()
                        .setTitle("Balloons")
                        .setDate()
                        .setEditorName("May")
                )
                .addEventItem(new EventItem()
                        .setTitle("Ice Cream")
                        .setDate()
                        .setEditorName("Liron")
                )
        );
        return events;
    }
    // add and save to DB
    //

}
