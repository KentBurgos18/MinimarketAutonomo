package com.example.minimarketautonomo

import android.app.Application
import androidx.room.Room
import com.example.minimarketautonomo.database.MinimarketDatabase

class Inicio: Application() {

    companion object{
        lateinit var preferencias:Preferencias
        lateinit var room: MinimarketDatabase


    }

    override fun onCreate() {
        super.onCreate()
        preferencias = Preferencias(applicationContext)
        room = Room
            .databaseBuilder(applicationContext, MinimarketDatabase::class.java, "minimarket_database")
            .fallbackToDestructiveMigration()
            .build()
    }
}