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

import com.alexa.repreoductor.Adapters.PlaylistAdapter;
import com.alexa.repreoductor.Data.DataFile;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.List.Song;
import com.alexa.repreoductor.ListPlaylistView;
import com.alexa.repreoductor.R;

import java.util.ArrayList;
import java.util.List;

public class PlayListsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Playlist> list;
    private Context context;

    public PlayListsFragment(List<Playlist> arraySongs) {
        list = arraySongs;
        /*convertirDatosCancion(arraySongs);*/
    }

    public void convertirDatosCancion(ArrayList<Playlist> arraySongs) {
        for (Playlist song : arraySongs) {
            list.add(song);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        PlaylistAdapter playlistAdapter = new PlaylistAdapter(list);

        playlistAdapter.setOnItemClickListener(new PlaylistAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                list.remove(position);
                playlistAdapter.notifyItemRemoved(position);
            }

            @Override
            public void ClickItem(int position) {
                Playlist playlist = list.get(position);
                ArrayList<Song> songList = new DataFile().Song();
                Song songNew = new Song(Uri.EMPTY, "Hola", "Mundo");
                songList.add(songNew);
                Bundle bundle = new Bundle();
                bundle.putString("Titulo", playlist.getName());
                bundle.putParcelableArrayList("Songs", (ArrayList<? extends Parcelable>) songList);
                startActivity(new Intent(getContext(), ListPlaylistView.class).putExtras(bundle));
            }
        });

        View view = inflater.inflate(R.layout.songs_list, container, false);
        recyclerView = view.findViewById(R.id.rvSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(playlistAdapter);


        return view;
    }
}