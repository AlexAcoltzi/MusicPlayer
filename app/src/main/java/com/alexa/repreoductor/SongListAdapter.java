package com.alexa.repreoductor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListViewHolder> {

    private final LayoutInflater liView;
    private List<ListElement> mData;
    private Context context;

    SongListAdapter(List<ListElement> mData, Context context) {
        this.liView = LayoutInflater.from(context);
        this.mData = mData;
        this.context = context;
    }

    @Override
    public SongListViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new SongListViewHolder(liView.inflate(R.layout.song_item, parent, false));
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
