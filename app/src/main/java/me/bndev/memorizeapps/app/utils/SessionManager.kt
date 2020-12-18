package me.bndev.memorizeapps.app.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import me.bndev.memorizeapps.BuildConfig

class SessionManager(context: Context) {
    private val TAG = "SessionManager"
    private val preferencesConfigFile = BuildConfig.APPLICATION_ID + ".preferences"
    private var mSharedPreferences: SharedPreferences

    companion object {
        const val keyUserId = "user-id"
        const val keyUserName = "user-name"
        const val keyFullName = "full-name"
        const val keyUserToken = "user-token"
    }

    init {
        mSharedPreferences = context.getSharedPreferences(
            preferencesConfigFile, Context.MODE_PRIVATE
        )
    }

    fun getString(key: String?): String? {
        return getString(key, "")
    }

    fun getString(key: String?, defValue: String?): String? {
        return mSharedPreferences.getString(key, defValue)
    }

    fun setValue(key: String?, value: String?) {
        val editor = mSharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun putString(key: String?, value: String?): SharedPreferences.Editor {
        @SuppressLint("CommitPrefEdits") val editor = mSharedPreferences.edit()
        return editor.putString(key, value)
    }

    fun edit(): SharedPreferences.Editor {
        return mSharedPreferences.edit()
    }

    fun printSession() {

    }

}