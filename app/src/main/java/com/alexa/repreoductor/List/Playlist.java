package com.alexa.repreoductor.List;

import android.net.Uri;

public class Playlist {

    private Uri img;
    private String Name;

    public Playlist(Uri img, String name) {
        this.img = img;
        Name = name;
    }

    public Uri getImg() {
        return img;
    }

    public void setImg(Uri img) {
        this.img = img;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
