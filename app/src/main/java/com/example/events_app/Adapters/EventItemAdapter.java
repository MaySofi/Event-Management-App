package com.example.events_app.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.events_app.Model.EventItem;
import com.example.events_app.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class EventItemAdapter extends RecyclerView.Adapter<EventItemAdapter.EventItemViewHolder> {
    private Context context;
    private ArrayList<EventItem> eventItems;

    public EventItemAdapter(Context context, ArrayList<EventItem> eventItems) {
        this.context = context;
        this.eventItems = eventItems;
    }

    @NonNull
    @Override
    public EventItemAdapter.EventItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("passed VT:", "" + viewType);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);
        EventItemAdapter.EventItemViewHolder eventItemViewHolder = new EventItemAdapter.EventItemViewHolder(view);
        return eventItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventItemAdapter.EventItemViewHolder holder, int position) {
        EventItem eventItem = getItem(position);
        holder.event_LBL_title.setText(eventItem.getTitle());

        if (eventItem.isDone()) {
            holder.event_IMG_lock.setImageResource(R.drawable.icons_check);
            holder.event_IMG_lock.setVisibility(View.VISIBLE);
        }
        else
            holder.event_IMG_lock.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return this.eventItems == null ? 0 : eventItems.size();
    }

    private EventItem getItem(int position) {
        return this.eventItems.get(position);
    }

    public void updateEvents(ArrayList<EventItem> eventItems) {
        this.eventItems = eventItems;
        notifyDataSetChanged();
    }

    public class EventItemViewHolder extends RecyclerView.ViewHolder {
        private ShapeableImageView event_IMG_lock;
        private MaterialTextView event_LBL_title;
        private MaterialTextView event_LBL_byName;

        public EventItemViewHolder(@NonNull View itemView) {
            super(itemView);
            event_IMG_lock = itemView.findViewById(R.id.event_IMG_lock);
            event_LBL_title = itemView.findViewById(R.id.event_LBL_title);
            event_LBL_byName = itemView.findViewById(R.id.event_LBL_byName);
        }
    }
}
