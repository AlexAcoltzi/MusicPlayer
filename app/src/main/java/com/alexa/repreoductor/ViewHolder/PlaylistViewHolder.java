package com.alexa.repreoductor.ViewHolder;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.List.ListPlaylist;
import com.alexa.repreoductor.R;

public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView tvName;

    public PlaylistViewHolder(View itemView) {
        super(itemView);

        this.imageView = itemView.findViewById(R.id.ivImagePlaylist);
        this.tvName = itemView.findViewById(R.id.tvPlaylistName);
    }

    public void render(final ListPlaylist listPlaylist) {
        if (listPlaylist.getImg() != Uri.EMPTY) {
            imageView.setImageURI(listPlaylist.getImg());
        } else {
            imageView.setImageResource(R.drawable.playlist);
        }

        tvName.setText(listPlaylist.getName());
    }

}
