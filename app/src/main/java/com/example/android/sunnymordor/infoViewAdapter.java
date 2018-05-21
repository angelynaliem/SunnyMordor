package com.example.android.sunnymordor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


// custom array adapter
public class infoViewAdapter extends ArrayAdapter<MordorInfo> {

    private Context myContext;
    private List<MordorInfo> infoList;
    private PageFragment pageCallback = null;

    infoViewAdapter(Context context, ArrayList<MordorInfo> list, PageFragment cb) {
        super (context, 0, list);
        myContext = context;
        infoList = list;
        pageCallback = cb;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null) {
            listItem = LayoutInflater.from(myContext).inflate(R.layout.piece_of_info, parent, false);
        }

        MordorInfo currentInfo = getItem(position);

        if (currentInfo == null) {
            Log.e("ERROR", "infoViewAdapter:getView() could not get currentInfo");
            return listItem;
        }

        TextView infoWordsText = listItem.findViewById(R.id.infoWordsView);
        TextView infoGotoText = listItem.findViewById(R.id.infoGoto);


        ImageView infoImage = listItem.findViewById(R.id.infoImageView);
        if (currentInfo.pic != CategoryAdapter.NO_PIC) {
            // info block
            infoWordsText.setVisibility(View.VISIBLE);
            infoImage.setVisibility(View.VISIBLE);
            infoGotoText.setVisibility(View.GONE);

            infoWordsText.setText(currentInfo.words);
            infoImage.setImageResource(currentInfo.pic);
        } else {
            // category header
            infoWordsText.setVisibility(View.GONE);
            infoImage.setVisibility(View.GONE);
            infoGotoText.setVisibility(View.VISIBLE);

            infoGotoText.setText(currentInfo.words);

            // highlight goto button when we uncover a category header textview
            pageCallback.setButtonCallback(currentInfo.gotoRef);
        }

        return listItem;
    }
}
