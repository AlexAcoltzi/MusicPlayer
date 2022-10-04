package com.alexa.repreoductor.Data;

import android.net.Uri;

import com.alexa.repreoductor.List.ListAlbums;
import com.alexa.repreoductor.List.ListSong;

import java.util.ArrayList;
import java.util.List;

public class DataFile {

    public List<ListSong> Song() {
        List<ListSong> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new ListSong(Uri.EMPTY, "Song " + i, "SubTitle: " + i));
        }
        return list;
    }

    public List<ListAlbums> Albums() {
        List<ListAlbums> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new ListAlbums(Uri.EMPTY, "Album " + i, "Artist " + i));
        }
        return list;
    }
}
