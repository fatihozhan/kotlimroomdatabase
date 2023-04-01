package com.example.roomkullanimi

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Kisiler::class], version = 2)
abstract class Veritabani : RoomDatabase() {
    abstract fun kisilerDao(): KisilerDao

    companion object {
        var INSTANCE: Veritabani? = null
        fun veritabaniErisim(context: Context): Veritabani? {
            if (INSTANCE == null) {
                synchronized(Veritabani::class) {
                    INSTANCE == Room.databaseBuilder(
                        context.applicationContext,
                        Veritabani::class.java,
                        "rehber.sqlite"
                    ).createFromAsset("rehber.sqlite").build()
                }
                Log.e("hata" , INSTANCE.toString())
            }
            return INSTANCE!!
        }
    }
}