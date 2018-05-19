package com.example.android.sunnymordor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;


public class CategoryAdapter extends FragmentPagerAdapter {

    private Context myContext;

    private String tabTitles[];



    CategoryAdapter(@NonNull Context c, FragmentManager fm) {
        super(fm);

        myContext = c;

        tabTitles = new String[] { myContext.getString(R.string.featured),
                myContext.getString(R.string.generalInfo), myContext.getString(R.string.visiting),
                myContext.getString(R.string.livingHere) };
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            PageFragment featuredPageFrag = new PageFragment();
            setupFeaturedPageFrag(featuredPageFrag);
            return featuredPageFrag;
        } else if (position == 1) {
            PageFragment generalInfoPageFrag = new PageFragment();
            setupGeneralInfoPageFrag(generalInfoPageFrag);
            return generalInfoPageFrag;
        } else if (position == 2) {
            PageFragment visitingPageFrag = new PageFragment();
            setupVisitingPageFrag(visitingPageFrag);
            return visitingPageFrag;
        } else {
            PageFragment livingHerePageFrag = new PageFragment();
            setupLivingHerePageFrag(livingHerePageFrag);
            return livingHerePageFrag;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return 4;
    }

    private void setupFeaturedPageFrag(PageFragment pageFrag) {
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.featured), -1, 0));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.featured));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.sponsors), -1, 1));
        pageFrag.addGoto(R.id.goto1, myContext.getResources().getString(R.string.sponsors));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.gollum, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.sunset, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));
    }

    private void setupGeneralInfoPageFrag(PageFragment pageFrag) {
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.history), -1, 0));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.history));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.geography), -1, 1));
        pageFrag.addGoto(R.id.goto1, myContext.getResources().getString(R.string.geography));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.language), -1, 2));
        pageFrag.addGoto(R.id.goto2, myContext.getResources().getString(R.string.language));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));
    }

    private void setupVisitingPageFrag(PageFragment pageFrag) {
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.travelling), -1, 0));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.travelling));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.attractions), -1, 1));
        pageFrag.addGoto(R.id.goto1, myContext.getResources().getString(R.string.attractions));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.necessities), -1, 2));
        pageFrag.addGoto(R.id.goto2, myContext.getResources().getString(R.string.necessities));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.additionalInfo), -1, 3));
        pageFrag.addGoto(R.id.goto3, myContext.getResources().getString(R.string.additionalInfo));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));
    }

    private void setupLivingHerePageFrag(PageFragment pageFrag) {
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.careers), -1, 0));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.careers));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.housing), -1, 1));
        pageFrag.addGoto(R.id.goto1, myContext.getResources().getString(R.string.housing));
        pageFrag.addInfo(new MordorInfo("It", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("goan be", R.drawable.eye_of_sauron, -1));
        pageFrag.addInfo(new MordorInfo("general info", R.drawable.eye_of_sauron, -1));
    }
}
