package com.alexa.repreoductor.Adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.alexa.repreoductor.Fragments.HomeFragment;
import com.alexa.repreoductor.Fragments.AlbumFragment;
import com.alexa.repreoductor.Fragments.PlayListsFragment;
import com.alexa.repreoductor.List.Playlist;

import java.util.ArrayList;
import java.util.List;

public class AdapterFragment extends FragmentStateAdapter {

    List<Playlist> arraySongs = null;

    public AdapterFragment(FragmentManager fragmentManager, Lifecycle lifecycle, List<Playlist> arraySongs) {
        super(fragmentManager, lifecycle);
        this.arraySongs = arraySongs;
    }

    //Función para crear el fragmento en la posición necesaria

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new PlayListsFragment(arraySongs);
            default:
                return new AlbumFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
