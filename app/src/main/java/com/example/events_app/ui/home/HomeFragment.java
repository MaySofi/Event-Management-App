package com.example.events_app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.events_app.Adapters.EventAdapter;
import com.example.events_app.Model.Event;
import com.example.events_app.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView mainLSTEvents;
    private EventAdapter eventAdapter;

    private final Observer<ArrayList<Event>> observer = new Observer<ArrayList<Event>>() {
        @Override
        public void onChanged(ArrayList<Event> events) {
            eventAdapter.updateEvents(events);
        }
    };


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mainLSTEvents = binding.mainLSTEvents;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mainLSTEvents.setLayoutManager(linearLayoutManager);
        eventAdapter = new EventAdapter(getContext(),homeViewModel.getEvents().getValue());
        mainLSTEvents.setAdapter(eventAdapter);

        homeViewModel.getEvents().observe(getViewLifecycleOwner(), observer);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}