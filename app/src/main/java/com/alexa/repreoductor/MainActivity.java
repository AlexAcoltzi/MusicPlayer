package com.alexa.repreoductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alexa.repreoductor.Data.DataFile;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        init();

    }

    void init(){
        DataFile dataFile = new DataFile();
        List<ListElement> lista = dataFile.Song();
        SongLisAdapter songLisAdapter = new SongLisAdapter(lista, this);
        RecyclerView recyclerView = findViewById(R.id.rvSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(songLisAdapter);
    }



}