package com.alexa.repreoductor.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.MainActivity;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.ViewHolder.PlaylistViewHolder;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {

    public final List<Playlist> mData;


    public PlaylistAdapter(List<Playlist> mData) {
        this.mData = mData;
    }


    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_item, parent, false);
        return new PlaylistViewHolder(view).linkAdapter(this);

    }

    @Override
    public void onBindViewHolder(PlaylistViewHolder holder, int position) {
        holder.render(mData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
