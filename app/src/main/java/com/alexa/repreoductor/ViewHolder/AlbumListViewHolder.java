package com.alexa.repreoductor.ViewHolder;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.List.ListAlbums;
import com.alexa.repreoductor.R;

import java.util.List;

public class AlbumListViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvArtist;


    public AlbumListViewHolder(View itemView) {
        super(itemView);

        this.ivImage = itemView.findViewById(R.id.ivImageAlbum);
        this.tvTitle = itemView.findViewById(R.id.tvTitleAlbum);
        this.tvArtist = itemView.findViewById(R.id.tvArtistAlbum);
    }

    public void render(final ListAlbums albums) {


        if (albums.getImg() != Uri.EMPTY) {
            ivImage.setImageURI(albums.getImg());
        } else {
            ivImage.setImageResource(R.drawable.album);
        }
        tvTitle.setText(albums.getTitle());
        tvArtist.setText(albums.getArtist());
    }
}
