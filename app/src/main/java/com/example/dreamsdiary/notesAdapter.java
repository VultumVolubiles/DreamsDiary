package com.example.dreamsdiary;

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

    private List<Notes> notes;
    private OnNoteListener mOnNoteListener;

    public notesAdapter(List<Notes> notes, OnNoteListener onNoteListener) {
        this.notes = notes;
        this.mOnNoteListener = onNoteListener;
    }

    @Override
    public notesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note, parent, false);
        return new ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(notesAdapter.ViewHolder holder, int position) {

        NoteTheme  theme = new NoteTheme(notes.get(position).color, notes.get(position).favorite, notes.get(position).licuid);
        holder.container.setBackgroundResource(theme.backgroundColor);
        holder.title.setBackgroundResource(theme.backgroundRectangle);
        holder.body.setBackgroundResource(theme.backgroundRectangle);
        holder.date.setBackgroundResource(theme.backgroundRectangle);
        holder.title.setText(notes.get(position).title);
        holder.body.setText(notes.get(position).body);
        holder.date.setText(notes.get(position).date);
        holder.favorite.setImageResource(theme.iconFavorite);
        holder.licuid.setImageResource(theme.iconLicuid);
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ConstraintLayout container;
        public TextView title;
        public TextView body;
        public TextView date;
        public ImageView favorite;
        public ImageView licuid;
        public View divider;
        OnNoteListener onNoteListener;

        public ViewHolder(View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            date = itemView.findViewById(R.id.date);
            favorite = itemView.findViewById(R.id.favorite);
            licuid = itemView.findViewById(R.id.licuid);
            divider = itemView.findViewById(R.id.divider);

            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }
}
