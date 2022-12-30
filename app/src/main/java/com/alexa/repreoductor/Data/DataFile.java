package com.alexa.repreoductor.Data;

import android.net.Uri;

import com.alexa.repreoductor.List.Albums;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.List.Song;

import java.util.ArrayList;

public class DataFile {

    public ArrayList<Song> Song() {
        ArrayList<Song> list = new ArrayList<>();
        //for (int i = 0; i < 20; i++) {
         /*   list.add(new Song(Uri.EMPTY, "01 Don_t Stop _Til You Get Enough " , "Michael Jackson: " ));
        list.add(new Song(Uri.EMPTY, "02_Rock_With_You " , "Michael Jackson: " ));
        list.add(new Song(Uri.EMPTY, "03 Workin_ Day And Night " , "Michael Jackson: " ));
        list.add(new Song(Uri.EMPTY, "Get On The Floor " , "Michael Jackson: " ));
        list.add(new Song(Uri.EMPTY, "Off The Wall " , "Michael Jackson: " ));
        list.add(new Song(Uri.EMPTY, "Girlfriend " , "Michael Jackson: " ));*/
       // }

        list.add(new Song(Uri.EMPTY, "Papercut" , "Linkin Park" ));
        list.add(new Song(Uri.EMPTY, "In The End" , "L_P: " ));
        list.add(new Song(Uri.EMPTY, "03 Workin_ Day And Night " , "Michael Jackson: " ));
        list.add(new Song(Uri.EMPTY, "Crazy" , "AeroSmith " ));
        list.add(new Song(Uri.EMPTY, "Luna " , "Zoe: " ));
        list.add(new Song(Uri.EMPTY, "Pájaros" , "Porter " ));
        return list;
    }

    public ArrayList<Albums> Albums() {
        ArrayList<Albums> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new Albums(Uri.EMPTY, "Album " + i, "Artist " + i));
        }
        list.add(new Albums(Uri.EMPTY, "Of The Wall " , "Michael Jackson " ));
        return list;
    }

    public ArrayList<Playlist> PlayList() {
        ArrayList<Playlist> list = new ArrayList<>();

        list.add(new Playlist(Uri.EMPTY, "Musica para bailar "));
        list.add(new Playlist(Uri.EMPTY, "GYM"));
        list.add(new Playlist(Uri.EMPTY, "Alex Songs"));
        return list;
    }

    public ArrayList<Playlist> DeletePlayList(ArrayList<Playlist> list, int position) {
        list.remove(position);

        return list;
    }
}
