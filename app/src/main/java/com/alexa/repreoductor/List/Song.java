package com.alexa.repreoductor.List;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Song {
    private Uri ivPortada;
    private String tvTitle;
    private String tvSubTitle;


    public Song(Uri img, String tvTitle, String tvSubTitle) {
        this.ivPortada = ivPortada;
        this.tvTitle = tvTitle;
        this.tvSubTitle = tvSubTitle;
    }

    public Uri getIvPortada() {
        return ivPortada;
    }

    public void setIvPortada(Uri ivPortada) {
        this.ivPortada = ivPortada;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }

    public String getTvSubTitle() {
        return tvSubTitle;
    }

    public void setTvSubTitle(String tvSubTitle) {
        this.tvSubTitle = tvSubTitle;
    }
}
