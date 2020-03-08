package com.solosen.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class), exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): MyDao
}

object MyDatabase {
    @Volatile private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        instance ?: synchronized(this) {
            instance = Room.databaseBuilder(context, AppDatabase::class.java, context.getString(R.string.app_name))
                .fallbackToDestructiveMigration()
                .build()

        }

        return instance!!
    }
}