package com.example.events_app.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.events_app.Model.Event;
import com.example.events_app.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private Context context;
    private ArrayList<Event> events;

    public EventAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("passed VT:", "" + viewType);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        EventViewHolder eventViewHolder = new EventViewHolder(view);
        return eventViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = getItem(position);
        holder.event_LBL_title.setText(event.getName());

        if (event.isPublicEvent())
            holder.event_IMG_lock.setImageResource(R.drawable.lock_open);
        else
            holder.event_IMG_lock.setImageResource(R.drawable.lock_closed);
    }

    @Override
    public int getItemCount() {
        return this.events == null ? 0 : events.size();
    }

    private Event getItem(int position) {
        return this.events.get(position);
    }

    public void updateEvents(ArrayList<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView event_LBL_title;
        private ShapeableImageView event_IMG_lock;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            event_LBL_title = itemView.findViewById(R.id.event_LBL_title);
            event_IMG_lock = itemView.findViewById(R.id.event_IMG_lock);
        }
    }
}
