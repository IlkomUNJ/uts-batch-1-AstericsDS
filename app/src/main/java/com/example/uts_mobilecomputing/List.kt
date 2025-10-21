package com.example.uts_mobilecomputing

import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.composables.icons.lucide.LucideIcon
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun List(viewModel: AddViewModel, navController: NavController) {
    val contacts = viewModel.contacts
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                contacts.forEach { contact ->
                    Column (
                        modifier = Modifier.fillMaxWidth().border(1.dp, Color.Gray,
                            RoundedCornerShape(5.dp)
                        ).padding(16.dp).combinedClickable(
                            onClick = {},
                            onLongClick = {
                                navController.navigate(Routes.EditScreen + "/${contact.name}")
                            }
                        )
                    ) {
                        Text(text = "Nama: ${contact.name}")
                        Text(text = "Alamat: ${contact.address}")
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            FloatingActionButton(
                onClick = { navController.navigate(Routes.AddScreen) },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                LucideIcon(
                    id = "plus",
                    contentDescription = null
                )
            }
        }
    }

}