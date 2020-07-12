package me.bndev.memorizeapps.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import me.bndev.memorizeapps.BuildConfig;

public class SessionManager {
    private static final String TAG = "SessionManager";

    private static final String preferencesConfigFile = BuildConfig.APPLICATION_ID + ".preferences";

    public static final String keyUserId = "user-id";
    public static final String keyUserName = "user-name";
    public static final String keyFullName = "full-name";


    private SharedPreferences mSharedPreferences;

    SessionManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(
                preferencesConfigFile, Context.MODE_PRIVATE);
    }

    public static SessionManager init(Context context) {
        return new SessionManager(context);
    }

    public String getString(String key) {
        return getString(key, "");
    }

    public String getString(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    public void setValue(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public SharedPreferences.Editor putString(String key, String value) {
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        return editor.putString(key, value);
    }

    public SharedPreferences.Editor edit() {
        return mSharedPreferences.edit();
    }

    public void printSession() {
        Log.i(TAG, "User has logged: \n" +
                "user-id: " + getString(keyUserId) + ", \n" +
                "user-name: " + getString(keyUserName) + ", \n" +
                "full-name: " + getString(keyFullName)
        );
    }

}
