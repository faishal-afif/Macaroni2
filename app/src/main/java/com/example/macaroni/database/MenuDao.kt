package com.example.macaroni.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update

@Dao
interface MenuDao {

    @Query("SELECT * FROM menus WHERE name LIKE :name")
    fun findMenu(name: String): List<Menu>

    @Query("SELECT price FROM menus WHERE :id LIMIT 1")
    fun isFavorite(id: String): String

    @Update
    fun favoriteMenu(menu: Menu): Int

    @Insert(onConflict = IGNORE)
    fun insertAll(menus: List<Menu>): List<Long>
}