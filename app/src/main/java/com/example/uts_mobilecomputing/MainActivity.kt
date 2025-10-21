package com.example.uts_mobilecomputing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.composables.icons.lucide.LucideIcon
import com.example.uts_mobilecomputing.ui.theme.UTS_MobileComputingTheme

class MainActivity : ComponentActivity() {
    private val contactViewModel by viewModels<AddViewModel>()
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UTS_MobileComputingTheme {
                val navController = rememberNavController()
                NavHost(navController, Routes.ListScreen) {
                    composable(Routes.ListScreen) {
                        List(contactViewModel, navController)
                    }
                    composable(Routes.AddScreen) {
                        Add(contactViewModel, navController)
                    }
                    composable(Routes.EditScreen + "/{name}") { backStackEntry ->
                        val name = backStackEntry.arguments?.getString("name")
                        Edit(contactViewModel, navController, name)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Dashboard")
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            AddButton(modifier = Modifier.align(Alignment.BottomEnd))
        }
    }
}

@Composable
fun AddButton(modifier: Modifier
) {
    FloatingActionButton(
        onClick = {},
        modifier = modifier
    ) {
        LucideIcon(
            id = "plus",
            contentDescription = null
        )
    }
}