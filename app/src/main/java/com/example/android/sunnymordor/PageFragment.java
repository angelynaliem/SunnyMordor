package com.example.android.sunnymordor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PageFragment extends Fragment implements View.OnClickListener {

    private ArrayList<MordorInfo> myInfo = new ArrayList<>();
    View rootView;
    private ListView infoListView;

    // listView position of category header to jump to
    private ArrayList<GotoButton> myGotos = new ArrayList<>();
    private int goto1Position;
    private int goto2Position;
    private TextView prevGoto = null;

    public PageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.info_list, container, false);

        initViews();

        initAdapter();

        return rootView;
    }

    @Override
    public void onClick(View v) {
        int numGoto = Integer.parseInt(v.getTag().toString());
        jumpToView(myGotos.get(numGoto).position);
    }

    private void initAdapter() {
        infoViewAdapter infoAdapter = new infoViewAdapter(getActivity(), myInfo, this);

        infoListView = rootView.findViewById(R.id.list);

        infoListView.setAdapter(infoAdapter);
    }

    private void initViews() {
        for (GotoButton g : myGotos) {
            g.text = rootView.findViewById(g.textViewRes);
            g.text.setText(g.name);
            g.text.setOnClickListener(this);
        }
    }

    private void highlightButton(TextView v) {
        if (prevGoto != null) {
            prevGoto.setTextColor(Color.GRAY);
        }
        prevGoto = v;

        v.setTextColor(Color.WHITE);
    }

    private void jumpToView(int position) {
        infoListView.smoothScrollToPositionFromTop(position, 10);
    }

    public void setButtonCallback(int position) {
        highlightButton(myGotos.get(position).text);
    }

    public void addInfo(MordorInfo newInfo) {
        myInfo.add(newInfo);
    }

    public void addGoto(int textRes, String name) {
        myGotos.add(new GotoButton(textRes, name, myInfo.size() - 1));
    }
}
