package com.example.android.sunnymordor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

// loads fragments
public class CategoryAdapter extends FragmentPagerAdapter {

    private final static int NULL_POS = -1;
    public final static int NO_PIC = -2;

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
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.featured), NO_PIC, 0));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.featured));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.sunnyMordor), R.drawable.postcard, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.mountDoom), R.drawable.mountdoom, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.pointyHat), R.drawable.gandalf, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.shelob), R.drawable.shelob, NULL_POS));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.sponsors), NO_PIC, 1));
        pageFrag.addGoto(R.id.goto1, myContext.getResources().getString(R.string.sponsors));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.preciousTours), R.drawable.gollum, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.butcher), R.drawable.orc_butcher, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.nazgulAir), R.drawable.sunset, NULL_POS));
    }

    private void setupGeneralInfoPageFrag(PageFragment pageFrag) {
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.history), NO_PIC, 0));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.history));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.history1), R.drawable.middleearthsmall, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.history2), R.drawable.pres, NULL_POS));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.geography), NO_PIC, 1));
        pageFrag.addGoto(R.id.goto1, myContext.getResources().getString(R.string.geography));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.geography1), R.drawable.doom, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.geography2), R.drawable.mountains, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.geography3), R.drawable.sea, NULL_POS));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.language), NO_PIC, 2));
        pageFrag.addGoto(R.id.goto2, myContext.getResources().getString(R.string.language));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.blackSpeech), R.drawable.lang, NULL_POS));
    }

    private void setupVisitingPageFrag(PageFragment pageFrag) {
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.travelling), NO_PIC, 0));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.travelling));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.passes), R.drawable.pass, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.nazgulAir), R.drawable.sunset, NULL_POS));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.attractions), NO_PIC, 1));
        pageFrag.addGoto(R.id.goto1, myContext.getResources().getString(R.string.attractions));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.palace), R.drawable.barad_dur, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.blackGate), R.drawable.blackgate2, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getString(R.string.mountDoom), R.drawable.mountdoom, NULL_POS));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.lodging), NO_PIC, 2));
        pageFrag.addGoto(R.id.goto2, myContext.getResources().getString(R.string.lodging));
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.honeymoonSuite), R.drawable.honeymoonsuite, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.overlook), R.drawable.overlook, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.shelob), R.drawable.shelob, NULL_POS));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.additionalInfo), NO_PIC, 3));
        pageFrag.addGoto(R.id.goto3, myContext.getResources().getString(R.string.additionalInfo));
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.noPhotos), R.drawable.nophoto, NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.noJokes), R.drawable.orcjoke , NULL_POS));
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.pointyHat), R.drawable.gandalf, NULL_POS));
    }

    private void setupLivingHerePageFrag(PageFragment pageFrag) {
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.careers), NO_PIC, 0));
        pageFrag.addGoto(R.id.goto0, myContext.getResources().getString(R.string.careers));
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.army), R.drawable.army, NULL_POS));

        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.housing), NO_PIC, 1));
        pageFrag.addGoto(R.id.goto1, myContext.getResources().getString(R.string.housing));
        pageFrag.addInfo(new MordorInfo(myContext.getResources().getString(R.string.caves), R.drawable.cave, NULL_POS));
    }
}
