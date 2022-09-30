package com.alexa.repreoductor;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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

    void render(final ListElement item){
        tvTitle.setText(item.getTvTitle());
        tvSubTitle.setText(item.getTvSubTitle());
        ivFoto.setImageURI(item.getIvPortada());
    }

}
