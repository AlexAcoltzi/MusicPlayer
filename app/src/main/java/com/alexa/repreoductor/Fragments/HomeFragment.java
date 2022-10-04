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

import com.alexa.repreoductor.Data.DataFile;
import com.alexa.repreoductor.List.ListSong;
import com.alexa.repreoductor.MainActivity;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.Adapters.SongListAdapter;

import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    private List<ListSong> mData;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        DataFile dataFile = new DataFile();
        mData = dataFile.Song();


        View view = inflater.inflate(R.layout.songs_list, container, false);
        recyclerView = view.findViewById(R.id.rvSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        SongListAdapter songLisAdapter = new SongListAdapter(mData, getContext());
        recyclerView.setAdapter(songLisAdapter);

        return view;
    }
}