package com.example.dreamsdiary;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dreamsdiary.entities.Notes;

import java.util.List;

public class notesAdapter extends RecyclerView.Adapter<notesAdapter.ViewHolder> {

    List<Notes> notes;

    public notesAdapter(List<Notes> notes) {
        this.notes = notes;
    }

    @Override
    public notesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(notesAdapter.ViewHolder holder, int position) {
        holder.title.setText(notes.get(position).title);
        holder.body.setText(notes.get(position).body);
        holder.date.setText(notes.get(position).date);
        if (notes.get(position).favorite == 1) {
            holder.favorite.setTextColor(Color.rgb(255,193,7));
        }
        if (notes.get(position).licuid == 1) {
            holder.licuid.setTextColor(Color.rgb(156,39,176));
        }

    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView body;
        public TextView date;
        public TextView favorite;
        public TextView licuid;
        public View divider;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            date = itemView.findViewById(R.id.date);
            favorite = itemView.findViewById(R.id.favorite);
            licuid = itemView.findViewById(R.id.licuid);
            divider = itemView.findViewById(R.id.divider);
        }

    }
}
