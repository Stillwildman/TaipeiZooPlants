package com;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class AppController extends MultiDexApplication {

    private static AppController appInstance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static synchronized AppController getInstance() {
        return appInstance;
    }

    public void openWebWithNativeBrowser(String webUrl) {
        if (webUrl != null && webUrl.startsWith("http")) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(webUrl));

            this.startActivity(intent);
        }
    }
}
