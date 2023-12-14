package com.example.new_app

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.new_app.db.RoomAppDb

class MyApp : Application() {

    companion object {
        private lateinit var database: RoomAppDb

        fun getAppDatabase(context: Context): RoomAppDb {
            if (!::database.isInitialized) {
                synchronized(this) {
                    if (!::database.isInitialized) {
                        database = Room.databaseBuilder(
                            context.applicationContext,
                            RoomAppDb::class.java,
                            "nama-database-anda"
                        ).build()
                    }
                }
            }
            return database
        }
    }

    override fun onCreate() {
        super.onCreate()
        // Inisialisasi hal-hal lain yang mungkin Anda perlukan saat aplikasi dimulai
    }
}
