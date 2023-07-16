package com.example.events_app.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.events_app.Model.DataManager;
import com.example.events_app.Model.Event;
import com.example.events_app.Utilities.Constants;
import com.example.events_app.databinding.FragmentGalleryBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Optional;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextInputEditText newEventETKey = binding.newEventETKey;
        final MaterialButton newEvent_ET_join = binding.newEventETJoin;
        newEvent_ET_join.setOnClickListener(view -> {
            Optional<Event> events =
                    DataManager.getEvent()
                    .stream()
                    .filter(event -> event.getUniqueID().equals(newEventETKey.toString()))
                    .findAny();
            Log.d("AppApp", "onCreateView: " + events);
        });
        final TextInputEditText newEventETTitle = binding.newEventETTitle;
        final RadioGroup newEventTXTAddMembers = binding.newEventTXTAddMembers;
        final RadioButton newEventRadioPrivate = binding.newEventRadioPrivate;
        final RadioButton newEventRadioPublic = binding.newEventRadioPublic;
        final TextView newEventTXTMemberPermissions = binding.newEventTXTMemberPermissions;
        newEventTXTAddMembers.setOnClickListener(view -> {
            Log.d("AppApp", "onCreateView: " + view.isSelected());
        });
        newEventRadioPrivate.setOnClickListener(view -> {
            Log.d("AppApp", "onCreateView: newEventRadioPrivate" + view.isSelected());
        });
        newEventRadioPublic.setOnClickListener(view -> {
            Log.d("AppApp", "onCreateView: newEventRadioPublic" + view.isSelected());
        });
        final CheckBox checkboxCreateNewTask = binding.checkboxCreateNewTask;
        final CheckBox checkboxDeleteTask = binding.checkboxDeleteTask;
        final CheckBox checkboxEditTask = binding.checkboxEditTask;
        final CheckBox checkboxMarkAsDone = binding.checkboxMarkAsDone;
        final DatePicker datePicker = binding.datePicker;
        final TimePicker timePicker = binding.timePicker;
        final Button newEventBTNSet = binding.newEventBTNSet;
        newEventBTNSet.setOnClickListener(view -> {
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference titleRef = db.getReference(Constants.DBKeys.EVENTS);
            ArrayList<Event> arrayList = DataManager.getEvent();
            arrayList.add(new Event()
                    .setName(newEventETTitle.getText().toString())
                    .setLocation("")
                    .setPublicEvent(!newEventRadioPublic.isChecked())
                    .setDate(datePicker +timePicker.toString()));
            titleRef.setValue(arrayList);
            Snackbar.make(view, "Event Created!!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

            Log.d("AppApp", "onCreateView: newEventBTNSet");
        });

        //        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}