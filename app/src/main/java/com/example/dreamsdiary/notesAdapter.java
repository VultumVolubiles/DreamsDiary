package com.example.dreamsdiary;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

        switch(notes.get(position).color) {
            case "#F75B50": {
                holder.container.setBackgroundResource(R.color.colorNoteBackgroundTheme1);
                holder.title.setBackgroundResource(R.drawable.rectangle_theme1);
                holder.body.setBackgroundResource(R.drawable.rectangle_theme1);
                holder.date.setBackgroundResource(R.drawable.rectangle_theme1);
                break;
            }
            case "#4D944A": {
                holder.container.setBackgroundResource(R.color.colorNoteBackgroundTheme2);
                holder.title.setBackgroundResource(R.drawable.rectangle_theme2);
                holder.body.setBackgroundResource(R.drawable.rectangle_theme2);
                holder.date.setBackgroundResource(R.drawable.rectangle_theme2);
                break;
            }
//            case "#4D944A": {
//                holder.container.setBackgroundResource(R.color.colorNoteBackgroundTheme2);
//                holder.title.setBackgroundResource(R.drawable.rectangle_theme2);
//                holder.body.setBackgroundResource(R.drawable.rectangle_theme2);
//                break;
//            }
        }
        holder.title.setText(notes.get(position).title);
        holder.body.setText(notes.get(position).body);
        holder.date.setText(notes.get(position).date);
        if (notes.get(position).favorite == 1) {
            holder.favorite.setImageResource(R.drawable.ic_favorite_enabled);
        }
        if (notes.get(position).licuid == 1) {
            holder.licuid.setImageResource(R.drawable.ic_licuid_enabled);
        }
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout container;
        public TextView title;
        public TextView body;
        public TextView date;
        public ImageView favorite;
        public ImageView licuid;
        public View divider;

        public ViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            date = itemView.findViewById(R.id.date);
            favorite = itemView.findViewById(R.id.favorite);
            licuid = itemView.findViewById(R.id.licuid);
            divider = itemView.findViewById(R.id.divider);
        }

    }
}
