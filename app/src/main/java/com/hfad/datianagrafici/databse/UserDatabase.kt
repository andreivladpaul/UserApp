package com.hfad.datianagrafici.databse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hfad.datianagrafici.dao.UserDao
import com.hfad.datianagrafici.data.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase:RoomDatabase() {

    abstract fun userDao(): UserDao

    //creazione di una singola instanza del database
    companion object{
        @Volatile
        private var INSTANCE:UserDatabase? = null

        fun getDatabase(context: Context):UserDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    name = "user_table"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }

}