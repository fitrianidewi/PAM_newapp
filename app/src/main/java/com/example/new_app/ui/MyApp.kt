package com.example.new_app.ui

import android.app.Application
import androidx.room.Room
import com.example.new_app.db.RoomAppDb

class MyApp : Application() {

    companion object {
        lateinit var database: RoomAppDb
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            RoomAppDb::class.java, "my-database"
        ).build()
    }
}
