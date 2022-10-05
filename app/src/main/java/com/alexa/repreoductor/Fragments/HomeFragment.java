package com.alexa.repreoductor.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.Adapters.SongListAdapter;
import com.alexa.repreoductor.Data.DataFile;
import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.R;

import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    private List<Song> mData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        DataFile dataFile = new DataFile();
        mData = dataFile.Song();

        SongListAdapter songLisAdapter = new SongListAdapter(mData);

        songLisAdapter.setOnItemClicked(new SongListAdapter.OnItemClicked() {
            @Override
            public void OnItemClick(int position) {
                Song song = mData.get(position);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.pager, new ReproduccionFragment(song));
            }
        });

        View view = inflater.inflate(R.layout.songs_list, container, false);
        recyclerView = view.findViewById(R.id.rvSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(songLisAdapter);

        return view;
    }
}