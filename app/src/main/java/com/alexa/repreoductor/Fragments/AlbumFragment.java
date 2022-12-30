package com.alexa.repreoductor.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.Adapters.AlbumListAdapter;
import com.alexa.repreoductor.Data.DataFile;
import com.alexa.repreoductor.List.Albums;
import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.ListPlaylistView;
import com.alexa.repreoductor.R;

import java.util.ArrayList;
import java.util.List;

public class AlbumFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Albums> mData;
    private List<Song> songs;
    private Context context;

    public AlbumFragment(List<Albums> albums, List<Song> tempAudioList) {
       this.mData = albums;
       songs = tempAudioList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        AlbumListAdapter albumListAdapter = new AlbumListAdapter(mData, getContext());

        albumListAdapter.setItemClickedListenerAlbum(new AlbumListAdapter.setItemClickedLister() {
            @Override
            public void changeView(int position) {
                Albums albums = mData.get(position);
                ArrayList<Song> songList = new DataFile().Song();
                /*ArrayList<Song> songList = new ArrayList<>();
                for (Song song: songs) {
                    if(song.getAlbum() == "Off The Wall"){
                        songList.add(song);
                    }
                }*/

                Bundle bundle = new Bundle();
                //bundle.putString("Titulo", albums.getTitle());
                //bundle.putParcelableArrayList("Songs", (ArrayList<? extends Parcelable>) songList);
                ArrayList<Song> anyObjectList = new ArrayList<>();
                anyObjectList = songList;
                bundle.putParcelableArrayList("music_list", anyObjectList);
                //intent.putExtra("KEY_BUNDLE_VALUE", bundle);
                startActivity(new Intent(getContext(), ListPlaylistView.class).putExtras(bundle));
            }
        });

        View view = inflater.inflate(R.layout.songs_list, container, false);
        recyclerView = view.findViewById(R.id.rvSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(albumListAdapter);
        return view;
    }
}