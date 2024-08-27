package com.example.simpleinventoryapproomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.simpleinventoryapproomdatabase.ui.screens.MainScreen
import com.example.simpleinventoryapproomdatabase.ui.theme.SimpleInventoryAppRoomDatabaseTheme
import com.example.simpleinventoryapproomdatabase.ui.viewmodels.InventoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inventoryViewModel = ViewModelProvider(this)[InventoryViewModel::class.java]

        setContent {
            SimpleInventoryAppRoomDatabaseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ){
                    MainScreen(inventoryViewModel)
                }
            }
        }
    }
}
