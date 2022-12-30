package com.alexa.repreoductor.Fragments;

import android.content.Intent;
import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.Adapters.SongListAdapter;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alexa.repreoductor.Data.DataFile;
import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.MainActivity;
import com.alexa.repreoductor.R;
import com.alexa.repreoductor.ReproductorActivity;

import java.util.ArrayList;
import com.alexa.repreoductor.Adapters.SongListAdapter;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;

    private List<Song> mData;
    private ArrayList<String> listPaths;
    private ArrayList<String> listTitle;
    private Context context =getActivity();

    public HomeFragment(List<Song> tempAudioList) {
        mData = tempAudioList;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        SongListAdapter songLisAdapter = new SongListAdapter(mData);

        songLisAdapter.setOnItemClicked(new SongListAdapter.OnItemClicked() {
            @Override
            public void OnItemClick(int position) {
                List<Song> anyObjectList;
                Bundle bundle = new Bundle();
                anyObjectList = mData;
                bundle.putParcelableArrayList("music_list", (ArrayList<? extends Parcelable>) anyObjectList);
                //Song song = mData.get(position);
                startActivity(new Intent(getContext(), ReproductorActivity.class).putExtra("music_list2", bundle)
                      //  .putExtra("Title", song.getTvTitle())
                      //  .putExtra("Artist", song.getTvSubTitle())
                        //.putExtra("position", song.getPath())


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