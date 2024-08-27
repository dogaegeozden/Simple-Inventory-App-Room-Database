package com.example.simpleinventoryapproomdatabase.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * A data class to represent inventory items
 */
@Entity
data class Item (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var quantity: Int,
    var updatedAt: Date,
)