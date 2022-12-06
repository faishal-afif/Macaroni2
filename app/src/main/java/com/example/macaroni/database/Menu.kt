package com.example.macaroni.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "menus", indices = [Index(value = ["name"], unique = true)])
data class Menu(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "name") var title: String = "",
    @ColumnInfo(name = "price") var price: String = "",
    @ColumnInfo(name = "description") var description: String = ""
)
