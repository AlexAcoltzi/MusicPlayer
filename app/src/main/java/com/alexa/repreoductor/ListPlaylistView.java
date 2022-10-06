package com.alexa.repreoductor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.alexa.repreoductor.Adapters.AdapterFragment;
import com.alexa.repreoductor.Data.DataFile;
import com.alexa.repreoductor.List.Albums;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.List.Song;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ListPlaylistView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_playlist_view);

        ArrayList<Playlist> listPlaylist;
        ArrayList<Song> Songs;
        ArrayList<Albums> Albums;

        Toolbar toolbar = findViewById(R.id.mtTextPl);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        ViewPager2 pager = findViewById(R.id.pagerPl);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        DataFile dataFile = new DataFile();
        listPlaylist = dataFile.PlayList();
        Songs = bundle.getParcelableArrayList("Songs");
        String name = bundle.getString("Titulo");
        Albums = dataFile.Albums();

        pager.setAdapter(new AdapterFragment(getSupportFragmentManager(), getLifecycle(), listPlaylist, Songs, Albums));

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigationView.getMenu().getItem(0).setChecked(true);
                        toolbar.setTitle(name);
                        break;
                    case 1:
                        navigationView.getMenu().getItem(1).setChecked(true);
                        toolbar.setTitle("Listas de reproducción");
                        break;
                    case 2:
                        navigationView.getMenu().getItem(2).setChecked(true);
                        toolbar.setTitle("Biblioteca");
                        break;
                }
            }
        });


        navigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_1:
                    pager.setCurrentItem(0, false);
                    return true;
                case R.id.page_2:
                    pager.setCurrentItem(1, false);
                    return true;
                case R.id.page_3:
                    pager.setCurrentItem(2, false);
                    return true;
            }
            return false;
        });

    }

}