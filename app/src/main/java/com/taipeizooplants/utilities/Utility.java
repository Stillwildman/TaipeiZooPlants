package com.taipeizooplants.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.AppController;

import androidx.annotation.StringRes;

public class Utility {


    public static void forceKillTask() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static void toastShort(String msg) {
        Toast.makeText(AppController.getInstance().getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastShort(@StringRes int msgResId) {
        toastShort(AppController.getInstance().getApplicationContext().getString(msgResId));
    }

    public static void toastLong(String msg) {
        Toast.makeText(AppController.getInstance().getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public static void toastLong(@StringRes int msgResId) {
        toastLong(AppController.getInstance().getApplicationContext().getString(msgResId));
    }

    public static int getScreenWidth() {
        DisplayMetrics dm = AppController.getInstance().getApplicationContext().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        DisplayMetrics dm = AppController.getInstance().getApplicationContext().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public static boolean isNetworkEnabled() {
        ConnectivityManager cm = (ConnectivityManager) AppController.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo ni = null;
        if (cm != null) {
            ni = cm.getActiveNetworkInfo();
        }

        return ni != null && ni.isAvailable();
    }
}
