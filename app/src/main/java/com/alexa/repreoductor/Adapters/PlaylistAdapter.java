package com.alexa.repreoductor.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.ViewHolder.PlaylistViewHolder;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {

    private OnItemClickListener listener;
    private final List<Playlist> mData;

    public interface OnItemClickListener {
        void OnItemClick(int position);

        void ClickItem(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        listener = clickListener;
    }


    public PlaylistAdapter(List<Playlist> mData) {
        this.mData = mData;
    }


    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_item, parent, false);
        return new PlaylistViewHolder(view, listener);

    }

    @Override
    public void onBindViewHolder(PlaylistViewHolder holder, int position) {
        holder.render(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
