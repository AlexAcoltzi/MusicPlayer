package com.alexa.repreoductor.Adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.alexa.repreoductor.Fragments.AlbumFragment;
import com.alexa.repreoductor.Fragments.HomeFragment;
import com.alexa.repreoductor.Fragments.PlayListsFragment;
import com.alexa.repreoductor.List.Albums;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.List.Song;

import java.util.ArrayList;

public class AdapterFragment extends FragmentStateAdapter {

    ArrayList<Playlist> arraySongs;
    ArrayList<Song> songs;
    ArrayList<Albums> albums;

    public AdapterFragment(FragmentManager fragmentManager, Lifecycle lifecycle, ArrayList<Playlist> arraySongs, ArrayList<Song> songs, ArrayList<Albums> albums) {
        super(fragmentManager, lifecycle);
        this.arraySongs = arraySongs;
        this.songs = songs;
        this.albums = albums;
    }

    //Función para crear el fragmento en la posición necesaria

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment(songs);
            case 1:
                return new PlayListsFragment(arraySongs);
            default:
                return new AlbumFragment(albums);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
