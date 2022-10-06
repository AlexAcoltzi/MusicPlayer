package com.alexa.repreoductor.Data;

import android.net.Uri;

import com.alexa.repreoductor.List.Albums;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.List.Song;

import java.util.ArrayList;

public class DataFile {

    public ArrayList<Song> Song() {
        ArrayList<Song> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Song(Uri.EMPTY, "Song " + i, "SubTitle: " + i));
        }
        return list;
    }

    public ArrayList<Albums> Albums() {
        ArrayList<Albums> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new Albums(Uri.EMPTY, "Album " + i, "Artist " + i));
        }
        return list;
    }

    public ArrayList<Playlist> PlayList() {
        ArrayList<Playlist> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Playlist(Uri.EMPTY, "PlayList " + i));
        }
        return list;
    }

    public ArrayList<Playlist> DeletePlayList(ArrayList<Playlist> list, int position) {
        list.remove(position);

        return list;
    }
}
