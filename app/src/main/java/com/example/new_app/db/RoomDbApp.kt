package com.example.new_app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class RoomAppDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private const val DATABASE_NAME = "app_database"

        @Volatile
        private var instance: RoomAppDb? = null

        fun getAppDatabase(context: Context): RoomAppDb {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomAppDb::class.java,
                    DATABASE_NAME
                ).build()
                instance = newInstance
                newInstance
            }
        }
    }
}
