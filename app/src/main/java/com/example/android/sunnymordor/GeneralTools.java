package com.example.android.sunnymordor;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;

// implements methods that will be useful to many activities
public class GeneralTools {

    private Context myContext;
    private Handler handler = new Handler();

    public final static int touchVibDelay = 50;

    GeneralTools(Context context) {
        myContext = context;
    }



    // show a toast popup message
    public void showToast(String msg) {
        Toast toast = Toast.makeText(myContext, msg, Toast.LENGTH_LONG);
        TextView toastMessage = toast.getView().findViewById(android.R.id.message);
        toastMessage.setTextColor(Color.CYAN);
        toast.show();
    }


}
