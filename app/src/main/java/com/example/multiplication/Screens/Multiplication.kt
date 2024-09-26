package com.example.multiplication.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.navigation.NavController
import com.example.multiplication.DataStore.Store


@Composable
fun show(navCOntroller: NavController) {
    val context = LocalContext.current
    val dataStore = Store(context)
    //get saved fname and lname

    val firstName by dataStore.getFirstName.collectAsState(initial = "")
    val lastName by dataStore.getLastName.collectAsState(initial = "")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Text(text = "$firstName")
        Text(text = "$lastName",
            modifier = Modifier.padding(top=20.dp))
    }
}
