package com.example.events_app.Model;


import org.threeten.bp.LocalDate;

public class EventItem {
    private String title = "";
    private String editorName = "";
    private LocalDate date = LocalDate.now();
    private boolean isDone = false;

    public EventItem() {
    }

    public String getTitle() {
        return title;
    }

    public EventItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getEditorName() {
        return editorName;
    }

    public EventItem setEditorName(String editorName) {
        this.editorName = editorName;
        return this;
    }

    public String getDate() {
        return date.toString();
    }

    public EventItem setDate() {
        this.date = LocalDate.now();
        return this;
    }

    public boolean isDone() {
        return isDone;
    }

    public EventItem setDone(boolean done) {
        isDone = done;
        return this;
    }

    @Override
    public String toString() {
        return "EventItem{" +
                "title='" + title + '\'' +
                ", editorName='" + editorName + '\'' +
                ", date=" + date +
                ", isDone=" + isDone +
                '}';
    }
}
