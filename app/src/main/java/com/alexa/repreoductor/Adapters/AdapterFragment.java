package com.alexa.repreoductor.Adapters;


import android.Manifest;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.alexa.repreoductor.Fragments.HomeFragment;
import com.alexa.repreoductor.Fragments.AlbumFragment;
import com.alexa.repreoductor.Fragments.PlayListsFragment;
import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.MainActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


import java.util.ArrayList;
import java.util.List;

public class AdapterFragment extends FragmentStateAdapter {


    private List<Song>tempAudioList;

    public AdapterFragment(FragmentManager fragmentManager, Lifecycle lifecycle, List<Song> tempAudioList) {
        super(fragmentManager, lifecycle);
        this.tempAudioList = tempAudioList;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment(this.tempAudioList);
            case 1:
                return new PlayListsFragment();
            default:
                return new AlbumFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
