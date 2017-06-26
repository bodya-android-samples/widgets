package ru.popov.bodya.navdrawerdemo;


import android.app.Application;

public class NavDemoApplication extends Application implements ModelProvider {

    private ResourcesStorage resourcesStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        resourcesStorage = new ResourcesStorage(this);
    }

    @Override
    public ResourcesStorage getResourcesStorage() {
        return resourcesStorage;
    }
}
