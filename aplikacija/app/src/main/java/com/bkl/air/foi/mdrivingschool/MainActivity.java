package com.bkl.air.foi.mdrivingschool;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.bkl.air.foi.database.Kontakt;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Optional;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        FlowManager.init(new FlowConfig.Builder(this).build());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        System.out.println("Prvi ulaz");
        if (id==R.id.kontakt_navigation){
            Intent intent = new Intent(this, KontaktActivity.class);
            startActivity(intent);
            System.out.println("Drugi ulaz");
        }
        else if(id==R.id.vozila_navigation){
            Intent intent = new Intent(this, VozilaActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.prijava_navigation){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /*
    @Optional
    @OnClick(R.id.button_vozila)
    public void buttonVozilaClicked(){
        Intent intent = new Intent(this, VozilaActivity.class);
        startActivity(intent);
    }
    @Optional
    @OnClick(R.id.button_kontakt)
    public void buttonKontaktClicked(){


        Intent intent = new Intent(this, KontaktActivity.class);
        startActivity(intent);
    }
    @Optional
    @OnClick(R.id.button_login)
    public void buttonLoginClicked(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
*/
}
