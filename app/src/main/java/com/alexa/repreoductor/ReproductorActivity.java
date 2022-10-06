package com.alexa.repreoductor;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ReproductorActivity extends AppCompatActivity {

    boolean checkButton = false;

    Toolbar toolbar;
    ImageButton btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        toolbar = findViewById(R.id.mtText);

        btnPlay = findViewById(R.id.ibtnRepControl);

        String name = getIntent().getStringExtra("Title");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkButton == false) {
                    btnPlay.setImageResource(R.drawable.ic_play_button_circled_50);
                    checkButton = true;
                } else {
                    btnPlay.setImageResource(R.drawable.ic_pause_button_50);
                    checkButton = false;
                }
            }
        });

        toolbar.setTitle(name);

    }
}