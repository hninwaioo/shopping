package com.za.sbs.delivery.utils;

import android.content.Context;
import android.location.Location;

import com.google.gson.Gson;

public class Storage {

    private static Storage mInstance = null;

    private PreferencesHelper mPreferencesHelper;

    private Storage(Context context) {
        mPreferencesHelper = new PreferencesHelper(context);
    }

    public static Storage make(Context context) {
        if (mInstance == null) {
            mInstance = new Storage(context);
        }

        return mInstance;
    }

    public static Storage createNew(Context context) {
        mInstance = new Storage(context);

        return mInstance;
    }

    public String getAuthToken() {
        return mPreferencesHelper.getString(PreferencesHelper.TOKEN, null);
    }

    public void setAuthToken(String token) {
        mPreferencesHelper.putString(PreferencesHelper.TOKEN, token);
    }

    public Location getLocation() {
        Gson gson = new Gson();
        String json = mPreferencesHelper.getString("locationObj", "");
        return gson.fromJson(json, Location.class);
    }

    public void setLocation(Location location) {
        Gson gson = new Gson();
        String json = gson.toJson(location);
        mPreferencesHelper.putString("locationObj", json);
    }

    public void clearLoginData() {
        mPreferencesHelper.clear();
    }

    public boolean getIsZawgyi() {
        return mPreferencesHelper.getBoolean(PreferencesHelper.IS_ZAWGYI, false);
    }

    public void saveIsZawgyi(boolean isZawgyi) {
        mPreferencesHelper.putBoolean(PreferencesHelper.IS_ZAWGYI, isZawgyi);
    }

    public boolean getIsFirstTime() {
        return mPreferencesHelper.getBoolean(PreferencesHelper.IS_FIRST_TIME_LOGIN, true);
    }

    public void saveIsFirstTime(boolean isFirstTime) {
        mPreferencesHelper.putBoolean(PreferencesHelper.IS_FIRST_TIME_LOGIN, isFirstTime);
    }
}
