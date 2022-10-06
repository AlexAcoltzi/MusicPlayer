package com.alexa.repreoductor.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.Adapters.SongListAdapter;
import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.ReproductorActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Song> mData;

    public HomeFragment(ArrayList<Song> songs) {
        this.mData = songs;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        SongListAdapter songLisAdapter = new SongListAdapter(mData);

        songLisAdapter.setOnItemClicked(new SongListAdapter.OnItemClicked() {
            @Override
            public void OnItemClick(int position) {
                Song song = mData.get(position);
                startActivity(new Intent(getContext(), ReproductorActivity.class)
                        .putExtra("Title", song.getTvTitle())
                        .putExtra("Artist", song.getTvSubTitle())
                        .putExtra("position", position)
                );
            }
        });

        View view = inflater.inflate(R.layout.songs_list, container, false);
        recyclerView = view.findViewById(R.id.rvSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(songLisAdapter);

        return view;
    }
}