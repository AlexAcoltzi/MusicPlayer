package com.alexa.repreoductor.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.alexa.repreoductor.Adapters.PlaylistAdapter;
import com.alexa.repreoductor.Data.DataFile;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.R;

import java.util.List;

public class PlayListsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Playlist> list;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        DataFile dataFile = new DataFile();
        list = dataFile.PlayList();


        PlaylistAdapter playlistAdapter = new PlaylistAdapter(list);


        View view = inflater.inflate(R.layout.songs_list, container, false);
        recyclerView = view.findViewById(R.id.rvSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(playlistAdapter);


        return view;
    }
}