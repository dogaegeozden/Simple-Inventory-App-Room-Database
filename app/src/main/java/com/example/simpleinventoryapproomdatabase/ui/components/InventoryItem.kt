package com.example.simpleinventoryapproomdatabase.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpleinventoryapproomdatabase.R
import com.example.simpleinventoryapproomdatabase.data.models.Item
import com.example.simpleinventoryapproomdatabase.ui.viewmodels.InventoryViewModel
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale

@Composable
fun InventoryItem(
    item: Item,
    viewModel: InventoryViewModel,
){
    var expanded by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf(item.name) }
    var quantity by remember { mutableStateOf(item.quantity) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = { expanded = true }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_edit_note_24),
                contentDescription = "Update",
                tint = Color.White,
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Update title") },
                singleLine = true,
                modifier = Modifier.padding(16.dp)
            )

            TextField(
                value = quantity.toString(),
                onValueChange = {
                    quantity = it.toIntOrNull() ?: 0 // Validate input as integer
                },
                label = { Text("Quantity") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.padding(16.dp)
            )

            Button(
                onClick = {
                    viewModel.updateItem(Item(id = item.id, name = name, quantity = quantity, updatedAt = item.updatedAt))
                    expanded = false
                },
                modifier = Modifier.padding(start=16.dp)
            ){
                Text("Save")
            }
        }

        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = SimpleDateFormat("HH:mm:aa, dd/mm", Locale.ENGLISH).format(item.updatedAt),
                fontSize = 12.sp,
                color = Color.LightGray,
            )
            Text(
                text = item.quantity.toString() + " " + item.name,
                fontSize = 20.sp,
                color = Color.White,
            )
        }
        IconButton(
            onClick = {
                viewModel.deleteItem(item.id)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = Color.White,
            )
        }

    }
}
