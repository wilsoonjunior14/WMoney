package wmoney.wilson.com.wmoney.utils

import android.content.Context
import android.content.SharedPreferences
import models.User
import wmoney.wilson.com.wmoney.R

class Preferences {

    fun save_login(context: Context, user: User){
        val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        sharedPreferences.edit().putInt("id", user.getId()).commit()
        sharedPreferences.edit().putString("name", user.getName()).commit()
        sharedPreferences.edit().putString("email", user.getEmail()).commit()
        System.err.println("USERDATA -> "+sharedPreferences.getString("userdata", ""))
    }

    fun getLogin(context: Context) : User{
        val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        return User(context, sharedPreferences.getInt("id", 0), sharedPreferences.getString("email", ""), "", sharedPreferences.getString("name", ""))
    }

}