package com.example.events_app.ui.home;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.events_app.Model.Event;
import com.example.events_app.Utilities.Constants;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Event>> mEvents;

    public HomeViewModel() {
        mEvents = new MutableLiveData<>();
        mEvents.setValue(getEventsFromFirebase());
    }

    private ArrayList<Event> getEventsFromFirebase() {
        ArrayList<Event> events = new ArrayList<>();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference(Constants.DBKeys.EVENTS);
        if(databaseReference == null)
            databaseReference.setValue(events);

        databaseReference.addChildEventListener(
                new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        Event event = snapshot.getValue(Event.class);
                        events.add(event);
                        mEvents.setValue(events);
                        Log.d("AppApp", "onChildAdded: " + snapshot.getValue(Event.class));
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        Event event = snapshot.getValue(Event.class);
                        Log.d("TAG", "onChildChanged: " + event);
                        for (int i = 0; i < events.size(); i++) {
                            if (events.get(i).getName().equals(event.getName())) {
                                Log.d("TAG3", "onChildChanged: " + i);
                                events.set(i, event);
                            }
                        }
                        Log.d("TAG_All", "onChildChanged: " + events);
                        mEvents.setValue(events);
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
        return events;
    }

    public LiveData<ArrayList<Event>> getEvents() {
        return mEvents;
    }
}