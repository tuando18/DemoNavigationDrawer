package com.example.demonavigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout layout_chinh_drawer;
    Toolbar mToolbar;
    NavigationView main_navigation_view;
    Frag01 frag01;
    Frag02 frag02;

    FragmentManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_chinh_drawer = findViewById(R.id.layout_chinh_drawer001);
        mToolbar = findViewById(R.id.mToolbar);
        main_navigation_view = findViewById(R.id.main_navigation_view001);

        setSupportActionBar(mToolbar);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, layout_chinh_drawer, mToolbar,R.string.open, R.string.close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        layout_chinh_drawer.addDrawerListener( drawerToggle );

        frag01 = new Frag01();
        frag02 = new Frag02();

        sm  =getSupportFragmentManager();
        sm.beginTransaction().add(R.id.frag_container001,frag01).commit();

        main_navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home){
                    sm.beginTransaction().replace(R.id.frag_container001,frag01).commit();

                }else if(item.getItemId() == R.id.mnu_help){
                    sm.beginTransaction().replace(R.id.frag_container001,frag02).commit();
                }
                getSupportActionBar().setTitle(item.getTitle());
                layout_chinh_drawer.close();
                return true;
            }
        });

    }
}