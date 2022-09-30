package com.alexa.repreoductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.alexa.repreoductor.Data.DataFile;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 pager = findViewById(R.id.pager);

        pager.setAdapter(new AdapterFragment(getSupportFragmentManager(), getLifecycle()));

    }

    void init(){
        DataFile dataFile = new DataFile();
        List<ListElement> lista = dataFile.Song();
        SongListAdapter songLisAdapter = new SongListAdapter(lista, this);
        RecyclerView recyclerView = findViewById(R.id.rvSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(songLisAdapter);
    }



}