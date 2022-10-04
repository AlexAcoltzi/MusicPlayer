package com.alexa.repreoductor.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.List.ListPlaylist;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.ViewHolder.PlaylistViewHolder;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {

    private final LayoutInflater liView;
    private final List<ListPlaylist> mData;
    private final Context context;

    public PlaylistAdapter(List<ListPlaylist> mData, Context context) {
        this.liView = LayoutInflater.from(context);
        this.mData = mData;
        this.context = context;
    }


    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlaylistViewHolder(liView.inflate(R.layout.playlist_item, parent, false));
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
