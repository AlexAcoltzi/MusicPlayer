package com.alexa.repreoductor.Adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.alexa.repreoductor.Fragments.HomeFragment;
import com.alexa.repreoductor.Fragments.AlbumFragment;
import com.alexa.repreoductor.Fragments.PlayListsFragment;
import com.alexa.repreoductor.List.Albums;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.List.Song;


import java.util.ArrayList;
import java.util.List;

public class AdapterFragment extends FragmentStateAdapter {


    private List<Song>tempAudioList;
    private List<Playlist> tempPlayList;
    private List<Albums> tempAlbums;

    public AdapterFragment(FragmentManager fragmentManager, Lifecycle lifecycle, ArrayList<Playlist> listPlaylist, List<Song> tempAudioList, List<Albums> albums) {
        super(fragmentManager, lifecycle);
        this.tempAudioList = tempAudioList;
        this.tempPlayList = listPlaylist;
        this.tempAlbums = albums;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment(this.tempAudioList);
            case 1:
                return new PlayListsFragment(tempPlayList);
            default:
                return new AlbumFragment(tempAlbums,tempAudioList);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
