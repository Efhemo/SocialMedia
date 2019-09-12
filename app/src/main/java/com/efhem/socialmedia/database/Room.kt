package com.efhem.socialmedia.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.efhem.socialmedia.model.UserHistory
import com.efhem.socialmedia.util.Converter


@Database(entities = [UserHistory::class], version = 1, exportSchema = false)
@TypeConverters((Converter::class))
abstract class SocialMediaDatabase : RoomDatabase() {
    abstract val dao: Dao
}

private lateinit var INSTANCE: SocialMediaDatabase

fun database(context: Context): SocialMediaDatabase {
    synchronized(SocialMediaDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                SocialMediaDatabase::class.java, "SocialMedia"
            ).build()
        }
    }
    return INSTANCE
}

