package com.example.macaroni.ui

import android.content.Context
import android.util.Log
import com.example.macaroni.database.Menu
import com.example.macaroni.database.MenuDatabase

class MenuSearchEngine(private val context: Context) {

    fun search(query: String): List<Menu>? {
        Thread.sleep(2000)
        Log.d("Searching", "Searching for $query")
        return MenuDatabase.getInstance(context).menuDao().findMenu("%$query%")
    }

}