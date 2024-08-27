package com.example.simpleinventoryapproomdatabase.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleinventoryapproomdatabase.ui.components.TopAppBar
import com.example.simpleinventoryapproomdatabase.ui.viewmodels.InventoryViewModel

@Composable
fun AddItemScreen(
    viewModel: InventoryViewModel,
) {

    var nameInput by remember {
        mutableStateOf("")
    }

    var quantityInput by remember {
        mutableStateOf(1)
    }

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "add_item_screen",
    ){
        composable("add_item_screen") {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding(),
            ) {
                TopAppBar()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = CenterVertically
                ){
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = nameInput,
                        label = { Text("Item Name") },
                        onValueChange = {
                            nameInput = it
                        }
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = CenterVertically
                ){
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = quantityInput.toString(),
                        label = { Text("Quantity") },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = {
                            quantityInput = it.toIntOrNull() ?: 0
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = CenterVertically
                ) {
                    Button(
                        onClick = { navController.navigate("main_screen") },
                    ) {
                        Text(text="Back")
                    }
                    Button(
                        onClick = {
                            viewModel.addItem(nameInput, quantityInput)
                            nameInput = ""
                            quantityInput = 0
                        }
                    ) {
                        Text(text="Add")
                    }
                }
            }
        }
        composable("main_screen") {
            MainScreen(viewModel = viewModel)
        }
    }
}