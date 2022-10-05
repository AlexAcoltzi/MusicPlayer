package com.alexa.repreoductor.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.R;

public class SongListViewHolder extends RecyclerView.ViewHolder {

    ImageView ivFoto;
    TextView tvTitle;
    TextView tvSubTitle;

    public SongListViewHolder(View view) {
        super(view);
        ivFoto = view.findViewById(R.id.ivSongItem);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvSubTitle = view.findViewById(R.id.tvSubTitle);
    }

    public void render(final Song item) {
        ivFoto.setImageResource(R.drawable.ic_music);
        tvTitle.setText(item.getTvTitle());
        tvSubTitle.setText(item.getTvSubTitle());
    }

}
