package com.alexa.repreoductor.ViewHolder;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.List.ListSong;
import com.alexa.repreoductor.R;

public class SongListViewHolder extends RecyclerView.ViewHolder {

    ImageView ivFoto;
    TextView tvTitle;
    TextView tvSubTitle;

    public SongListViewHolder(View view) {
        super(view);
        ivFoto = view.findViewById(R.id.image);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvSubTitle = view.findViewById(R.id.tvSubTitle);
    }

    public void render(final ListSong item) {
        if (item.getIvPortada() != Uri.EMPTY) {
            ivFoto.setImageURI(item.getIvPortada());
        } else {
            ivFoto.setImageResource(R.drawable.sound_waves);
        }
        tvTitle.setText(item.getTvTitle());
        tvSubTitle.setText(item.getTvSubTitle());
    }

}
