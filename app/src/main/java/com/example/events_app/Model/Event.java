package com.example.events_app.Model;

import java.util.ArrayList;
import java.util.UUID;

public class Event {
    private String  uniqueID = UUID.randomUUID().toString();

    private String name = "";

    private String date = ""; // TODO: localDate or string?
    private String location = "";
    private boolean isPublicEvent = false;

    public String getUniqueID() {
        return uniqueID;
    }

    public Event setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
        return this;
    }

    public boolean isPublicEvent() {
        return isPublicEvent;
    }

    public Event setPublicEvent(boolean publicEvent) {
        isPublicEvent = publicEvent;
        return this;
    }

    private ArrayList<EventItem> items = new ArrayList<EventItem>();

    public ArrayList<EventItem> getEventItems() {
        return items;
    }

    public Event addEventItem(EventItem item) {
        this.items.add(item);
        return this;
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Event setDate(String date) {
        this.date = date;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Event setLocation(String location) {
        this.location = location;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "uniqueID='" + uniqueID + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", isPublicEvent=" + isPublicEvent +
                ", items=" + items +
                '}';
    }
}
