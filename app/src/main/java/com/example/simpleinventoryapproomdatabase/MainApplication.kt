package com.example.simpleinventoryapproomdatabase

import android.app.Application
import androidx.room.Room
import com.example.simpleinventoryapproomdatabase.data.databases.InventoryDatabase

class MainApplication: Application() {

    // Initializing the database
    companion object {
        lateinit var inventoryDatabase: InventoryDatabase
    }

    override fun onCreate() {
        super.onCreate()
        inventoryDatabase = Room.databaseBuilder(
            applicationContext,
            InventoryDatabase::class.java,
            InventoryDatabase.NAME,
        ).build()
    }
}