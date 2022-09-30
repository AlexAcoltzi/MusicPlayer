package com.alexa.repreoductor;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexa.repreoductor.Data.DataFile;

import java.util.List;

public class LibaryFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<ListElement> mData;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DataFile dataFile = new DataFile();
        mData = dataFile.Song();
        SongListAdapter songListAdapter = new SongListAdapter(mData, getContext());
        View view = inflater.inflate(R.layout.songs_list, container, false);
        recyclerView = view.findViewById(R.id.rvSong);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(songListAdapter);


        return view;
    }
}