package com.example.cards

import android.content.Context
import android.content.SharedPreferences

object SharedPrefUtil {

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            "${BuildConfig.APPLICATION_ID}.shared_preferences", Context.MODE_PRIVATE)
    }

    fun setCardDataLiked(id: String, value: Boolean) {
        setBoolean(id, value)
    }

    fun getCardDataLiked(id: String): Boolean {
        return getBoolean(id)
    }

    private fun setBoolean(name: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(name, value).apply()
    }

    private fun getBoolean(name: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(name, defaultValue)
    }
}