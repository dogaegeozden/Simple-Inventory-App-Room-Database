package com.example.simpleinventoryapproomdatabase.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleinventoryapproomdatabase.data.models.Item
import com.example.simpleinventoryapproomdatabase.ui.components.InventoryItem
import com.example.simpleinventoryapproomdatabase.ui.components.TopAppBar
import com.example.simpleinventoryapproomdatabase.ui.viewmodels.InventoryViewModel

@Composable
fun MainScreen(
    viewModel: InventoryViewModel
) {

    val itemList by viewModel.itemList.observeAsState()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main_screen",
    ){
        composable("main_screen") {
            Scaffold(
                topBar = { TopAppBar() },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { navController.navigate("add_item_screen") },
                        content = { Icon(Icons.Filled.Add, "Add") }
                    )
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(it), // Add padding to avoid overlapping with the FAB
                ) {
                    itemList?.let {
                        LazyColumn(
                            content = {
                                itemsIndexed(it) { index: Int, item: Item ->
                                    InventoryItem(
                                        item = item,
                                        viewModel,
                                    )
                                }
                            }
                        )
                    } ?: Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "No items yet",
                        fontSize = 16.sp
                    )
                }
            }
        }
        composable("add_item_screen") {
            AddItemScreen(viewModel = viewModel)
        }
    }
}