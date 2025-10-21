package com.example.uts_mobilecomputing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Edit(viewModel: AddViewModel, navController: NavController, name: String?) {
    val contact = viewModel.contacts.find { it.name == name }

    val oldName = contact?.name.toString()
    val oldAddress = contact?.address.toString()
    var newName by remember { mutableStateOf(contact?.name ?: "") }
    var newAddress by remember { mutableStateOf(contact?.address ?: "") }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = newName,
                    onValueChange = { newName = it },
                    label = { Text("Nama") },
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = newAddress,
                    onValueChange = { newAddress = it },
                    label = { Text("Alamat") },
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (!newName.isNullOrBlank() && !newAddress.isNullOrBlank() && oldName != null) {
                            viewModel.updateContact(oldName!!, Contact(newName, newAddress))
                            navController.navigate(Routes.ListScreen)
                        }
                    },
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text("Save Changes")
                }

            }
        }
    }
}
