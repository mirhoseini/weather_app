package com.mirhoseini.weatherapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by Mohsen on 5/9/16.
 */
public abstract class WeatherApplication extends Application {
    private WeatherApplicationComponent component;

    public static WeatherApplication get(Context context) {
        return (WeatherApplication) context.getApplicationContext();
    }

    protected WeatherApplicationModule getApplicationModule() {
        return new WeatherApplicationModule(this);
    }

    public WeatherApplicationComponent getComponent() {
        return component;
    }

    public void setComponent(WeatherApplicationComponent component) {
        this.component = component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initApplication();

        component = DaggerWeatherApplicationComponent.builder()
                .weatherApplicationModule(getApplicationModule())
                .build();
    }

    abstract void initApplication();
}
