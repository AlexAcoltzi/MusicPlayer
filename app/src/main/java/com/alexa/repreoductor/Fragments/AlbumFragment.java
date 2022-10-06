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

public class AlbumFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Albums> mData;
    private Context context;

    public AlbumFragment(ArrayList<Albums> albums) {
        this.mData = albums;
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
                Song songNew = new Song(Uri.EMPTY, "Hola", "Mundo");
                songList.add(songNew);
                Bundle bundle = new Bundle();
                bundle.putString("Titulo", albums.getTitle());
                bundle.putParcelableArrayList("Songs", (ArrayList<? extends Parcelable>) songList);
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