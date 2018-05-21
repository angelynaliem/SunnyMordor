package com.example.android.sunnymordor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

// used for loading and navigating page fragments
public class PageFragment extends Fragment implements View.OnClickListener {

    private ArrayList<MordorInfo> myInfo = new ArrayList<>();
    private View rootView;
    private ListView infoListView;

    // listView position of category header to jump to
    private ArrayList<GotoButton> myGotos = new ArrayList<>();

    // need a separate list for TextViews, since TextViews are not serializable,
    // it works out ok though, since we get the TextViews during onCreateView() anyway
    private ArrayList<TextView> myGotoTexts = new ArrayList<>();

    // the currently highlighted goto button
    private TextView prevGoto = null;

    public PageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.info_list, container, false);

        if (savedInstanceState != null) {
            // we have a saved state, possibly from an orientation change
            myInfo = (ArrayList<MordorInfo>) savedInstanceState.getSerializable(getString(R.string.myInfos));
            myGotos = (ArrayList<GotoButton>) savedInstanceState.getSerializable(getString(R.string.myGotos));
        }

        initViews();

        initAdapter();

        return rootView;
    }

    // I figured out handling orientation changes by saving state and serializing ArrayLists at
    // http://code.hootsuite.com/orientation-changes-on-android/
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        // Make sure to call the super method so that the states of our views are saved
        super.onSaveInstanceState(outState);
        // Save our own state now
        outState.putSerializable(getString(R.string.myInfos), myInfo);
        outState.putSerializable(getString(R.string.myGotos), myGotos);
    }

    // user clicked a navigation TextView
    @Override
    public void onClick(View v) {
        int numGoto = Integer.parseInt(v.getTag().toString());
        jumpToView(myGotos.get(numGoto).position);
    }

    // Passed to the ArrayAdapter so it can tell us when a header category is displayed
    // on the screen.
    public void setButtonCallback(int position) {
        highlightButton(myGotoTexts.get(position));
    }

    // add an info item to the info ArrayList
    public void addInfo(MordorInfo newInfo) {
        myInfo.add(newInfo);
    }

    // add a navigation TextView to the goto ArrayList
    public void addGoto(int textRes, String name) {
        myGotos.add(new GotoButton(textRes, name, myInfo.size() - 1));
    }

    // get ref to the ListView and set its ArrayAdapter
    private void initAdapter() {
        infoViewAdapter infoAdapter = new infoViewAdapter(getActivity(), myInfo, this);

        infoListView = rootView.findViewById(R.id.list);

        infoListView.setAdapter(infoAdapter);
    }

    // set up clickable navigation TextViews
    private void initViews() {
        for (GotoButton g : myGotos) {
            TextView v = rootView.findViewById(g.textViewRes);
            v.setText(g.name);
            v.setOnClickListener(this);
            myGotoTexts.add(v);
        }
    }

    // highlight a navigation TextView
    private void highlightButton(TextView v) {
        if (prevGoto != null) {
            prevGoto.setTextColor(Color.GRAY);
        }
        prevGoto = v;

        v.setTextColor(Color.WHITE);
    }

    // scroll to a header catgory in the ListView
    private void jumpToView(int position) {
        infoListView.smoothScrollToPositionFromTop(position, 10);
    }
}
