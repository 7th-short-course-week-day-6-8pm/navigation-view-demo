package com.rathana.materialdesign;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.rathana.materialdesign.adapter.ViewPagerAdapter;
import com.rathana.materialdesign.fragment.DoneFragment;
import com.rathana.materialdesign.fragment.HomeFragment;
import com.rathana.materialdesign.fragment.SnoozedFragment;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPager;

    ViewPagerAdapter viewPagerAdapter;
    List<Fragment> fragments=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        tabLayout=findViewById(R.id.tabLayout);
        toolbar=findViewById(R.id.tool_bar);
        viewPager=findViewById(R.id.viewPager);

        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        //setup ViewPager
        fragments.add(new HomeFragment());
        fragments.add(new SnoozedFragment());
        fragments.add(new DoneFragment());
        fragments.add(new DoneFragment());

        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for(int i=0 ;i<= tabLayout.getTabCount();i++){
             TabLayout.Tab  tab= tabLayout.getTabAt(i);
             if(i==0)  tab.setIcon(R.drawable.ic_home_black_24dp);
             else if(i==1) tab.setIcon(R.drawable.ic_snooze_gray_24dp);
             else if(i==2) tab.setIcon(R.drawable.ic_done_gray_24dp);
             else if(i==3) tab.setIcon(R.drawable.ic_settings_gray_24dp);

        }

    }
}
