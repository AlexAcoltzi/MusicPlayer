package com.alexa.repreoductor;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.ArraySet;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.alexa.repreoductor.Adapters.AdapterFragment;
import com.alexa.repreoductor.Data.DataFile;
import com.alexa.repreoductor.List.Albums;
import com.alexa.repreoductor.List.Playlist;

import com.alexa.repreoductor.List.Song;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;

import com.alexa.repreoductor.Adapters.PlaylistAdapter;
import com.alexa.repreoductor.Fragments.PlayListsFragment;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.ViewHolder.PlaylistViewHolder;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final int MY_PERMISSION_REQUEST = 1;
    ArrayList<String> arrayList = null;
    ListView listView;
    ArrayList<Playlist> listPlaylist;
    ArrayList<Song> Songs;
    List<Albums> Albums;
    final List<Song> tempAudioList = new ArrayList<>();
    private String[] items;
    private ArraySet<HashMap<String, String>> albumList;
    //private static final String TAG = "MyActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //Log.i(TAG, "MyClass.getView() — get item number ");
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        ViewPager2 pager = findViewById(R.id.pager);

        Toolbar toolbar = findViewById(R.id.mtText);
        //Accedemos con permisos a los archivos del telefono

        DataFile dataFile = new DataFile();
        listPlaylist = dataFile.PlayList();
        Songs = dataFile.Song();
        Albums = dataFile.Albums();



        requestPermissions();
        pager.setAdapter(new AdapterFragment(getSupportFragmentManager(), getLifecycle(), listPlaylist, tempAudioList, Albums));

        //Agregamos el array con las canciones


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

    private void requestPermissions() {
        // below line is use to request permission in the current activity.
        // this method is use to handle error in runtime permissions
        Dexter.withActivity(this)
                // below line is use to request the number of permissions which are required in our app.
                .withPermissions(
                        // below is the list of permissions
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.READ_EXTERNAL_STORAGE

                        )
                // after adding permissions we are calling an with listener method.
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        // this method is called when all permissions are granted
                        if (multiplePermissionsReport.areAllPermissionsGranted()) {
                            // do you work now
                            Toast.makeText(MainActivity.this, "All the permissions are granted..", Toast.LENGTH_SHORT).show();
                            getAllAudioFromDevice(getApplicationContext());
                        }
                        // check for permanent denial of any permission
                        if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied()) {
                            // permission is denied permanently, we will show user a dialog message.
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        // this method is called when user grants some permission and denies some of them.
                        permissionToken.continuePermissionRequest();
                    }
                }).withErrorListener(error -> {
                    // we are displaying a toast message for error message.
                    Toast.makeText(getApplicationContext(), "Error occurred! ", Toast.LENGTH_SHORT).show();
                })
                // below line is use to run the permissions on same thread and to check the permissions
                .onSameThread().check();
    }

    private void showSettingsDialog() {
        // we are displaying an alert dialog for permissions
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // below line is the title for our alert dialog.
        builder.setTitle("Need Permissions");

        // below line is our message for our dialog
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", (dialog, which) -> {
            // this method is called on click on positive button and on clicking shit button
            // we are redirecting our user from our app to the settings page of our app.
            dialog.cancel();
            // below is the intent from which we are redirecting our user.
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            intent.setData(uri);
            startActivityForResult(intent, 101);
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> {
            // this method is called when user click on negative button.
            dialog.cancel();
        });
        // below line is used to display our dialog
        builder.show();
    }

    // Method to read all the audio/MP3 files.
    public void getAllAudioFromDevice(final Context context) {
        //final List<AudioModel> tempAudioList = new ArrayList<>();


        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {
                MediaStore.Audio.AudioColumns.DATA,
                MediaStore.Audio.AudioColumns.TITLE,
                MediaStore.Audio.AudioColumns.ALBUM,
                MediaStore.Audio.ArtistColumns.ARTIST,};

        Cursor c = context.getContentResolver().query(uri,
                projection,
                null,
                null,
                null);
        if (c != null) {
            while (c.moveToNext()) {
                // Create a model object.
                //AudioModel audioModel = new AudioModel();
                Song audioModel = new Song();

                String path = c.getString(0);   // Retrieve path.
                String name = c.getString(1);   // Retrieve name.
                String album = c.getString(2);  // Retrieve album name.
                String artist = c.getString(3); // Retrieve artist name.

                // Set data to the model object.
                audioModel.setTvTitle(name);
                audioModel.setTvSubTitle(artist);
                audioModel.setPath(path);
                audioModel.setAlbum(album);

                Log.e("Name :" + name, " Album :" + album);
                Log.e("Path :" + path, " Artist :" + artist);

                // Add the model object to the list .
                tempAudioList.add(audioModel);
            }
            c.close();
        }
    }

    public List<Song> getAlbums(){

        List<Song> Album = new ArrayList<>();
        for (Song song:tempAudioList) {
          if(song.getAlbum()=="Off The Wall"){
              Album.add(song);
          }
        }
        return Album;
    }
}
