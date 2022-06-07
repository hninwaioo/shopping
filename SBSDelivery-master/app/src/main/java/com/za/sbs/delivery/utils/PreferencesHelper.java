package com.za.sbs.delivery.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {

    private static SharedPreferences mPref;
    private static SharedPreferences.Editor mEditor;
    /*
    * File Name
    * */
    private static final String USER_PREF = "user_pref_file";

    /*
    * LoginUser related constants
    * */
    public static final String USER = "user";
    public static final String TOKEN = "token";
    public static final String FIRST_TIME = "FIRST_TIME";
    public static final String IS_ZAWGYI = "is_zawgyi";
    public static final String IS_FIRST_TIME = "first_time";
    public static final String IS_FIRST_TIME_LOGIN = "IS_FIRST_TIME_LOGIN";
    public static final String MYANMAR_LANGUAGE = "my";
    //public static final

    public PreferencesHelper(Context context) {
        mPref = context.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);
        mEditor = mPref.edit();
    }

    public void clear() {
        mPref.edit().clear().apply();
    }

    public void putString(String key, String value) {
        mEditor.putString(key, value).commit();
    }

    public String getString(String key, String defaultValue) {
        return mPref.getString(key, defaultValue);
    }

    public void putInt(String key, int value) {
        mEditor.putInt(key, value).commit();
    }

    public int getInt(String key, int defaultValue) {
        return mPref.getInt(key, defaultValue);
    }

    public void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return mPref.getBoolean(key, defaultValue);
    }



}
