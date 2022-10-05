package com.alexa.repreoductor;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.alexa.repreoductor.Adapters.AdapterFragment;
import com.alexa.repreoductor.List.Playlist;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final int MY_PERMISSION_REQUEST = 1;
    ArrayList<String> arrayList = null;
    ListView listView;
    List<Playlist> listPlaylist;
    private String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        ViewPager2 pager = findViewById(R.id.pager);

        Toolbar toolbar = findViewById(R.id.mtText);
        //Accedemos con permisos a los archivos del telefono
        runtimePermission();

        pager.setAdapter(new AdapterFragment(getSupportFragmentManager(), getLifecycle(), listPlaylist));

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigationView.getMenu().getItem(0).setChecked(true);
                        toolbar.setTitle("Inicio");
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
    public void runtimePermission(){
        Dexter.withContext(this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(
                new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        displaySong();
                        //doStuff();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                            permissionToken.continuePermissionRequest();
                    }
                }
        ).check();
    }

    public ArrayList<File> findSong(File file){
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();
        for (File singleFile: files){

            if (singleFile.isDirectory() && !singleFile.isHidden()){
                arrayList.addAll(findSong(singleFile));
            }else{
                if (singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav")){
                    arrayList.add(singleFile);
                }
            }
        }
        return arrayList;
    }

    public void displaySong(){
        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
        items = new String[mySongs.size()];
        for (int i = 0; i<mySongs.size(); i++){
            items[i]=mySongs.get(i).getName().toString().replace(".mp3","").replace(".wav","");

        }

    }


}
