package com.alexa.repreoductor.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.Adapters.AlbumListAdapter;
import com.alexa.repreoductor.List.Albums;
import com.alexa.repreoductor.R;

public class AlbumListViewHolder extends RecyclerView.ViewHolder {
    private final ImageView ivImage;
    private final TextView tvTitle;
    private final TextView tvArtist;
    private final LinearLayout linearLayout;


    public AlbumListViewHolder(View itemView, AlbumListAdapter.setItemClickedLister setItemClickedLister) {
        super(itemView);

        this.ivImage = itemView.findViewById(R.id.ivImageAlbum);
        this.tvTitle = itemView.findViewById(R.id.tvTitleAlbum);
        this.tvArtist = itemView.findViewById(R.id.tvArtistAlbum);
        this.linearLayout = itemView.findViewById(R.id.albumItem);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setItemClickedLister.changeView(getAdapterPosition());
            }
        });
    }

    public void render(final Albums albums) {

        ivImage.setImageResource(R.drawable.ic_album_icon);
        tvTitle.setText(albums.getTitle());
        tvArtist.setText(albums.getArtist());
    }
}
