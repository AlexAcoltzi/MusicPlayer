package com.alexa.repreoductor.List;

import android.net.Uri;

public class ListAlbums {
    private Uri img;
    private String title;
    private String artist;


    public ListAlbums(Uri img, String title, String artist) {
        this.img = img;
        this.title = title;
        this.artist = artist;
    }

    public Uri getImg() {
        return img;
    }

    public void setImg(Uri img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
