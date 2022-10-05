package com.alexa.repreoductor.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexa.repreoductor.Adapters.PlaylistAdapter;
import com.alexa.repreoductor.Data.DataFile;
import com.alexa.repreoductor.List.ListPlaylist;
import com.alexa.repreoductor.List.ListSong;
import com.alexa.repreoductor.MainActivity;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.Adapters.SongListAdapter;

import java.util.ArrayList;
import java.util.List;

public class PlayListsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<ListPlaylist> list;
    private Context context;

    public PlayListsFragment(List<ListPlaylist> arraySongs) {
        list = new ArrayList<>();
        convertirDatosCancion(arraySongs);
    }

    public void convertirDatosCancion(List<ListPlaylist> arraySongs)
    {
        for (ListPlaylist song : arraySongs){
            list.add(song);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        DataFile dataFile = new DataFile();
        list = dataFile.PlayList();
        PlaylistAdapter playlistAdapter = new PlaylistAdapter(list, getContext());


        View view = inflater.inflate(R.layout.songs_list, container, false);
        recyclerView = view.findViewById(R.id.rvSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(playlistAdapter);


        return view;
    }
}