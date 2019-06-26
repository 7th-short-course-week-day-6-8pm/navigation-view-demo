package com.rathana.materialdesign;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rathana.materialdesign.fragment.DoneFragment;
import com.rathana.materialdesign.fragment.HomeFragment;
import com.rathana.materialdesign.fragment.SnoozedFragment;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar_main);
        navigationView=findViewById(R.id.nav);

        //setup toolbar
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toggle=new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.nav_toggle_open,
                R.string.nav_toggle_close
        );
        drawerLayout.addDrawerListener(toggle);

        //add event listener to navigation view
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.btnInbox:
                replaceFragment(R.id.container,new HomeFragment());

                setToolbarTittle("Home");
                return true;
            case R.id.btnSnoozed:
                replaceFragment(R.id.container,new SnoozedFragment());
                setToolbarTittle("Snoozed");
                return true;
            case R.id.btnDone:
                replaceFragment(R.id.container,new DoneFragment());
                setToolbarTittle("Done");
                return true;
        }

        return false;
    }

    private void setToolbarTittle(String title){
        getSupportActionBar().setTitle(title);
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void replaceFragment(@IdRes int container, Fragment fragment){
        if(fragment!=null){
            FragmentTransaction t= getSupportFragmentManager().beginTransaction();
            t.replace(container,fragment);
            t.commit();
        }
    }
}
