package com.example.android.sunnymordor;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// Photos courtesy of :
//
// https://www.flickr.com/photos/missrogue/458309472
// https://www.pinterest.com/curly_locks89/dragon-tattoo-inspiration/
// https://www.maxpixel.net/Beach-Sunset-Tropical-Tropical-Beach-Summer-Sunset-1651426

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        if (viewPager != null) {
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(3);
        }

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
        }
    }
}
