package com.example.appweather

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class SharePrefs internal constructor(private val context: Context){

    companion object{
        private const val SHARED_PREPS_NAME = "my_prefs"
        private const val KEY_CITY = "city"

        @SuppressLint("StaticFiledLeak")
        private var instance : SharePrefs? = null

        fun getInstance(context: Context):SharePrefs{
            if(instance == null) {
                instance = SharePrefs(context.applicationContext)
            }
                return instance!!
        }

    }
    private val prefs : SharedPreferences by lazy {
        context.getSharedPreferences(SHARED_PREPS_NAME, Context.MODE_PRIVATE)
    }

    fun setValue(key:String, value:String){
        prefs.edit().putString(key,value)
    }

    fun getValue(key:String):String?{
        return prefs.getString(key, null)
    }

    fun setValueOrNull(key:String?, value:String?){
        if(key!=null && value!=null){

            prefs.edit().putString(key, value).apply()
        }

    }
    fun getValueOrNull(key:String?):String?{
        if(key!=null ){

            return prefs.getString(key, null)
        }
        return null
    }

    // clean the sharedprefs
    fun clearCityValue(){
        prefs.edit().remove(KEY_CITY).apply()
    }

}