package com.kapss.pwr;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Igor on 17.09.2016.
 */
public class InternetConnectionChecker {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        boolean isConnected = (activeNetworkInfo != null && activeNetworkInfo.isConnected());

        return isConnected;
    }
}
