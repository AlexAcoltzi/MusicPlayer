package com.alexa.repreoductor.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.List.Albums;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.ViewHolder.AlbumListViewHolder;

import java.util.ArrayList;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListViewHolder> {
    private final ArrayList<Albums> mData;
    private final LayoutInflater liView;
    private final Context context;
    private setItemClickedLister setItemClickedLister;

    public interface setItemClickedLister {
        void changeView(int position);
    }

    public void setItemClickedListenerAlbum(setItemClickedLister setItemClickedLister) {
        this.setItemClickedLister = setItemClickedLister;
    }


    public AlbumListAdapter(ArrayList<Albums> mData, Context context) {
        this.mData = mData;
        this.liView = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public AlbumListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item, parent, false);
        return new AlbumListViewHolder(view, setItemClickedLister);
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
