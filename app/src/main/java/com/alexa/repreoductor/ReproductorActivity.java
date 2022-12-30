package com.alexa.repreoductor;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.alexa.repreoductor.List.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReproductorActivity extends AppCompatActivity {

    boolean checkButton = false;

    Toolbar toolbar;
    ImageButton btnPlay;
    ImageButton btnNext;
    ImageButton btnPrevious;
    MediaPlayer mediaPlayer = MyMediaPlayer.getInstance();
    Song currentSong;
    ArrayList<Song> songList;
    ArrayList<String> listPaths;
    ArrayList<String> listTitle;
    private ArrayList<Parcelable> listaMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        toolbar = findViewById(R.id.mtText);

        btnPlay = findViewById(R.id.ibtnRepControl);
        btnNext = findViewById(R.id.ibtnNext);
        btnPrevious = findViewById(R.id.ibtnPrevius);


        //String name = getIntent().getStringExtra("Title");
        //Uri uri = Uri.parse(getIntent().getStringExtra("position"));
        //linea nueva para poder extraer el array list
        songList = getIntent().getExtras().getParcelableArrayList("music_list");

        listaMusica = (ArrayList<Song>) getIntent().getExtras().getParcelableArrayList("music_list");
        //songList = getIntent().getPa  rcelableArrayListExtra("songList");
        //listPaths = getIntent().getStringArrayListExtra("paths");
        //listTitle = getIntent().getStringArrayListExtra("titles");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });






        /*btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkButton == false) {
                    btnPlay.setImageResource(R.drawable.ic_play_button_circled_50);
                    pausePlay();
                    checkButton = true;
                } else {
                    btnPlay.setImageResource(R.drawable.ic_pause_button_50);
                    pausePlay();
                    checkButton = false;
                }
            }
        });*/

        /*btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNextSong();
            }
        });*/

       // toolbar.setTitle(name);
        //setResourcesWithMusic(getIntent().getStringExtra("position"));
        setResourcesWithCurrentMusic();
    }
    void setResourcesWithMusic(String position){

        playMusic(position);
    }
    private void playMusic(String position){

        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(position);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void pausePlay(){
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        else
            mediaPlayer.start();
    }
    private void playNextSong(){

        if(MyMediaPlayer.currentIndex == songList.size()-1)
            return;
        MyMediaPlayer.currentIndex +=1;
        mediaPlayer.reset();
        setResourcesWithCurrentMusic();

    }

    private void playPreviousSong(){
       if(MyMediaPlayer.currentIndex== 0)
            return;
        MyMediaPlayer.currentIndex -=1;
        mediaPlayer.reset();
        setResourcesWithCurrentMusic();
    }

    void setResourcesWithCurrentMusic(){
        currentSong = songList.get(MyMediaPlayer.currentIndex);

        toolbar.setTitle(currentSong.getTvTitle());

        //totalTimeTv.setText(convertToMMSS(currentSong.getDuration()));

        btnPlay.setOnClickListener(v-> pausePlay());
        btnNext.setOnClickListener(v-> playNextSong());
        btnPrevious.setOnClickListener(v-> playPreviousSong());

        playMusic2();


    }
    private void playMusic2(){
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(currentSong.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}