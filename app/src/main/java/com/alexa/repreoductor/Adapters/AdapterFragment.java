package com.alexa.repreoductor.Adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.alexa.repreoductor.Fragments.HomeFragment;
import com.alexa.repreoductor.Fragments.AlbumFragment;
import com.alexa.repreoductor.Fragments.PlayListsFragment;

public class AdapterFragment extends FragmentStateAdapter {


    public AdapterFragment(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
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
