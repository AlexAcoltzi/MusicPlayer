package com.alexa.repreoductor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        ViewPager2 pager = findViewById(R.id.pager);

        pager.setAdapter(new AdapterFragment(getSupportFragmentManager(), getLifecycle()));

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
            }
        });

    }

}
