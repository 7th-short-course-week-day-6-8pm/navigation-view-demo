package com.rathana.materialdesign;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.rathana.materialdesign.fragment.DoneFragment;
import com.rathana.materialdesign.fragment.HomeFragment;
import com.rathana.materialdesign.fragment.SnoozedFragment;

public class BottomNavigationViewActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botton_navigation_view);

        bottomNavigationView=findViewById(R.id.bottom_nav);

        replaceFragment(R.id.container,new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.btnHome:
                        replaceFragment(R.id.container,new HomeFragment());
                        return true;
                    case R.id.btnSub :
                        replaceFragment(R.id.container,new SnoozedFragment());
                        return true;
                    case R.id.btnmail:
                        replaceFragment(R.id.container,new DoneFragment());
                        return true;
                }

                return true;
            }
        });
    }

    private void replaceFragment(@IdRes int container, Fragment fragment){
        if(fragment!=null){
            FragmentTransaction t= getSupportFragmentManager().beginTransaction();
            t.replace(container,fragment);
            t.commit();
        }


    }
}
