package com.hfad.datianagrafici.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName:String,
    val lastName:String,
    val age:Int,
    val cityBirth:String,
    val provinceBirth: String,
    val Sex:String
)