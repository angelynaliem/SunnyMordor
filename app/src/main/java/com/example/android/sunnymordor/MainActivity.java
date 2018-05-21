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
// https://commons.wikimedia.org/wiki/File:GANDALF.jpg
// https://frightfind.com/timberline-lodge-overlook-hotel-shining/
// https://me.me/i/d-d-joke-an-orc-walks-into-a-club-he-takes-20151753
// https://commons.wikimedia.org/wiki/File:%27Volcano,_Kilauea,_Island_of_Hawaii%27_by_Jules_Tavernier,_1885,_gouache_and_pastel_.jpg
// https://www.pexels.com/photo/aerial-view-of-green-mountain-163550/
// http://www.conceptart.org/forums/showthread.php/277006-EOW-Round-228-Arachnid-s-Lair?styleid=39
// https://www.pinterest.com/pin/377669118734545843/
// https://www.tickld.com/wow/2008130/spthis-would-happen-if-the-army-of-mordor-went-up-against-the-roman-empire/
// http://www.puttyandpaint.com/projects/2001
// http://marcopfurtado.blogspot.com/2014/09/orc-with-bikini.html
// https://funnyjunk.com/funny_pictures/3496425/Good+guy+sauron/50
// https://aminoapps.com/c/lotr/page/blog/sea-of-nurnen/7WfP_u8eZdDZ4YW6MBpqDg5Bz3E303
// http://villainstournament.wikia.com/wiki/File:Sauron%27s_Army.jpg
//
// And special thanks to the Mordor wikitravel travel page for reinforcing my desire to do this and providing great info
//           https://wikitravel.org/en/Mordor

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
            viewPager.setOffscreenPageLimit(CategoryAdapter.NUM_PAGE_FRAGS - 1);
        }

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
        }
    }
}
