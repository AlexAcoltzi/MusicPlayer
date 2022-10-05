package com.alexa.repreoductor.Data;

import android.net.Uri;

import com.alexa.repreoductor.List.Albums;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.List.Song;

import java.util.ArrayList;
import java.util.List;

public class DataFile {

    public List<Song> Song() {
        List<Song> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Song(Uri.EMPTY, "Song " + i, "SubTitle: " + i));
        }
        return list;
    }

    public List<Albums> Albums() {
        List<Albums> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new Albums(Uri.EMPTY, "Album " + i, "Artist " + i));
        }
        return list;
    }

    public List<Playlist> PlayList() {
        List<Playlist> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Playlist(Uri.EMPTY, "PlayList " + i));
        }
        return list;
    }

    public List<Playlist> DeletePlayList(List<Playlist> list, int position) {
        list.remove(position);

        return list;
    }
}
