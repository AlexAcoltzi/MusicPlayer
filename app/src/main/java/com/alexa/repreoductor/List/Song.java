package com.alexa.repreoductor.List;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    private final Uri uri = null;
    private Uri ivPortada;
    private String tvTitle;
    private String tvSubTitle;


    public Song(Uri img, String tvTitle, String tvSubTitle) {
        this.ivPortada = ivPortada;
        this.tvTitle = tvTitle;
        this.tvSubTitle = tvSubTitle;
    }
    public Song(){}

    public Song(Parcel parcel) {
        ivPortada = Uri.parse(parcel.readString());
        tvTitle = parcel.readString();
        tvSubTitle = parcel.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(String.valueOf(ivPortada));
        parcel.writeString(tvTitle);
        parcel.writeString(tvSubTitle);
    }

    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {

        @Override
        public Song createFromParcel(Parcel parcel) {
            return new Song(parcel);
        }

        @Override
        public Song[] newArray(int i) {
            return new Song[i];
        }
    };

}
