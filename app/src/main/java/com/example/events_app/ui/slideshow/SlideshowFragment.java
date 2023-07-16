package com.example.events_app.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.events_app.Adapters.EventAdapter;
import com.example.events_app.Adapters.EventItemAdapter;
import com.example.events_app.Model.Event;
import com.example.events_app.Model.EventItem;
import com.example.events_app.databinding.FragmentSlideshowBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private EventItemAdapter eventItemAdapter;
    private RecyclerView eventLSTEvents;
    private final Observer<ArrayList<EventItem>> observer = new Observer<ArrayList<EventItem>>() {
        @Override
        public void onChanged(ArrayList<EventItem> eventItems) {
            eventItemAdapter.updateEvents(eventItems);
        }
    };


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextInputLayout eventTXTLayout = binding.eventTXTLayout;
        final TextInputEditText eventTXTName = binding.eventTXTName;
        final MaterialTextView eventTXTMyEvents = binding.eventTXTMyEvents;
        final TextView eventLLDate = binding.eventLLDate;
        // event_LST_events

        eventLSTEvents = binding.eventLSTEvents;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        eventLSTEvents.setLayoutManager(linearLayoutManager);
        eventItemAdapter = new EventItemAdapter(getContext(), slideshowViewModel.getEvents().getValue());
        eventLSTEvents.setAdapter(eventItemAdapter);

        slideshowViewModel.getEvents().observe(getViewLifecycleOwner(), observer);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}