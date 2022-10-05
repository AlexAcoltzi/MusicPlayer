package com.alexa.repreoductor.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.ViewHolder.SongListViewHolder;

import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListViewHolder> {

    private final List<Song> mData; //---------
    private OnItemClicked onItemClicked;

    public interface OnItemClicked {
        void OnItemClick(int position);
    }

    public void setOnItemClicked(OnItemClicked onItemClicked) {
        this.onItemClicked = onItemClicked;
    }

    public SongListAdapter(List<Song> mData) {
        this.mData = mData;
    }

    @Override
    public SongListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item, parent, false);
        return new SongListViewHolder(view, onItemClicked);
    }

    @Override
    public void onBindViewHolder(SongListViewHolder holder, int position) {
        holder.render(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return  mData.size();
    }
}
