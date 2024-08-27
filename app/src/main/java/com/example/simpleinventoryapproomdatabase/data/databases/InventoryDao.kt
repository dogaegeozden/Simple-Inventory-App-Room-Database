package com.example.simpleinventoryapproomdatabase.data.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.simpleinventoryapproomdatabase.data.models.Item

@Dao
interface InventoryDao {

    @Query("SELECT * FROM Item ORDER BY updatedAt DESC")
    fun getAllItems(): LiveData<List<Item>>

    @Insert
    fun addItem(item: Item)

    @Query("DELETE FROM Item WHERE id = :id")
    fun deleteItem(id: Int)

    @Update
    fun updateItem(item: Item)

}
