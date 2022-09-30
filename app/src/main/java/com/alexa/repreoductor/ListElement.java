package com.alexa.repreoductor;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListElement {

    public ListElement(Uri img, String tvTitle, String tvSubTitle) {
        this.ivPortada = ivPortada;
        this.tvTitle = tvTitle;
        this.tvSubTitle = tvSubTitle;
    }

    public Uri ivPortada;
    public String tvTitle;
    public String tvSubTitle;

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
