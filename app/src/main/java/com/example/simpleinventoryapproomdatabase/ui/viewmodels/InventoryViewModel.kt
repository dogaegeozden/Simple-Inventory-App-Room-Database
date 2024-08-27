package com.example.simpleinventoryapproomdatabase.ui.viewmodels

import androidx.compose.ui.graphics.Path
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleinventoryapproomdatabase.MainApplication
import com.example.simpleinventoryapproomdatabase.data.models.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class InventoryViewModel: ViewModel() {

    val inventoryDao = MainApplication.inventoryDatabase.getInventoryDao()
    val itemList: LiveData<List<Item>> = inventoryDao.getAllItems()

    fun addItem(name: String, quantity: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            inventoryDao.addItem(Item(name = name, quantity = quantity, updatedAt = Date.from(Instant.now())))
        }
    }

    fun deleteItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            inventoryDao.deleteItem(id)
        }
    }

    fun updateItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            inventoryDao.updateItem(item)
        }
    }

}