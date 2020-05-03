package com.example.myplayer;

import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabLayout = findViewById(R.id.activity_home_bottom_tab);
        viewPager = findViewById(R.id.activity_home_viewPager);
        fragments.add(new FlameFragment());
        fragments.add(new LibraryFragment());
        fragments.add(new AccountFragment());
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @NonNull
            public Fragment getItem(int positoin) {
                return fragments.get(positoin);
            }

            public int getCount() {
                return fragments.size();
            }

            public CharSequence getPageTitle(int position) {
                return null;
            }
        });
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

    }
}
