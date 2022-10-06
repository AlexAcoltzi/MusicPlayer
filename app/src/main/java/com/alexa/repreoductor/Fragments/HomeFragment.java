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
import com.alexa.repreoductor.Data.DataFile;
import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.ReproductorActivity;

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