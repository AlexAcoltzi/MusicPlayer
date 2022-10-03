package com.alexa.repreoductor.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.List.ListAlbums;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.ViewHolder.AlbumListViewHolder;

import java.util.List;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListViewHolder> {
    private final List<ListAlbums> mData;
    private final LayoutInflater liView;
    private final Context context;

    public AlbumListAdapter(List<ListAlbums> mData, Context context) {
        this.mData = mData;
        this.liView = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public AlbumListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AlbumListViewHolder(liView.inflate(R.layout.album_item, parent, false));
    }

    @Override
    public void onBindViewHolder(AlbumListViewHolder holder, int position) {
        holder.render(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
