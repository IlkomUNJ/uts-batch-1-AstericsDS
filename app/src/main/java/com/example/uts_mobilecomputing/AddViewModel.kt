package com.example.uts_mobilecomputing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class Contact(
    val name: String,
    val address: String
)

class AddViewModel : ViewModel() {
    var contacts by mutableStateOf<List<Contact>>(emptyList())
        private set

    fun addContact(contact: Contact) {
        contacts = contacts + contact
    }
    fun updateContact(oldName: String, updated: Contact) {
        contacts = contacts.map {
            if (it.name == oldName) updated else it
        }
    }


}