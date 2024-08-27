package com.example.simpleinventoryapproomdatabase.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.simpleinventoryapproomdatabase.data.models.Item

@Database(entities = [Item::class], version = 1)
@TypeConverters(Converters::class)
abstract class InventoryDatabase: RoomDatabase() {

    companion object {
        const val NAME = "Inventory_DB"
    }

    abstract fun getInventoryDao(): InventoryDao
}