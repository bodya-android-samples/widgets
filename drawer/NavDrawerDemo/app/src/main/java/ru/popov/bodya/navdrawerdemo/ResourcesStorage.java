package ru.popov.bodya.navdrawerdemo;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

public class ResourcesStorage {
    private ArrayList<Drawable> icons;
    private ArrayList<String> labels;

    public ResourcesStorage(Context appContext) {

        icons = new ArrayList<>();
        icons.add(ContextCompat.getDrawable(appContext, R.drawable.dashboard_icon));
        icons.add(ContextCompat.getDrawable(appContext, R.drawable.android_icon));
        icons.add(ContextCompat.getDrawable(appContext, R.drawable.settings_icon));

        labels = new ArrayList<>();
        labels.add(appContext.getString(R.string.dashboard));
        labels.add(appContext.getString(R.string.android));
        labels.add(appContext.getString(R.string.preferences));
    }

    public ArrayList<Drawable> getIcons() {
        return icons;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }
}
