package com.example.events_app.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.events_app.Model.DataManager;
import com.example.events_app.Model.Event;
import com.example.events_app.Model.EventItem;

import java.util.ArrayList;

public class SlideshowViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<EventItem>> mEvents;

    public SlideshowViewModel() {
        mEvents = new MutableLiveData<>();
        mEvents.setValue(DataManager.getEvent().get(0).getEventItems());
    }

    public LiveData<ArrayList<EventItem>> getEvents() {
        return mEvents;
    }
}