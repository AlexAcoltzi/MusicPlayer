package com.alexa.repreoductor.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.Adapters.SongListAdapter;
import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.R;

public class SongListViewHolder extends RecyclerView.ViewHolder {

    ImageView ivFoto;
    TextView tvTitle;
    TextView tvSubTitle;
    LinearLayout linearLayout;

    public SongListViewHolder(View view, SongListAdapter.OnItemClicked onItemClicked) {
        super(view);
        ivFoto = view.findViewById(R.id.ivSongItem);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvSubTitle = view.findViewById(R.id.tvSubTitle);
        linearLayout = view.findViewById(R.id.SongItemLa);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClicked.OnItemClick(getAdapterPosition());
            }
        });
    }

    public void render(final Song item) {
        ivFoto.setImageResource(R.drawable.ic_music);
        tvTitle.setText(item.getTvTitle());
        tvSubTitle.setText(item.getTvSubTitle());
    }

}
