package com.example.multiplication.Screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.multiplication.DataStore.Store
import kotlinx.coroutines.launch


@Composable
fun UserName(navController:NavController) {
    var flag = false
    val context = LocalContext.current
    var Ftext by remember{ mutableStateOf("") }
    var Ltext by remember{ mutableStateOf("") }
    //dataStore
    val dataStoreF = Store(context)
   //scope
    val scope = rememberCoroutineScope()


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(top=40.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
            Image(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "",
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = "Welcome!!",



                )
        }
  Column(
      modifier = Modifier.padding(top = 60.dp),
      horizontalAlignment = Alignment.CenterHorizontally
  ) {
      // first name ko lagi
      OutlinedTextField(value = Ftext, onValueChange = { Ftext = it },
          shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp),
          label = { Text("first name") })

      //last name  ko lagi
      OutlinedTextField(value = Ltext, onValueChange = { Ltext = it },
          shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp),
          modifier = Modifier
              .padding(top = 10.dp)
              .background(Color.White),
          label = {
              Text("last name")
          })
  }




            Button(
                onClick = {
                    if(Ftext.isEmpty()){
                        Toast.makeText(context,"first name cannnot be empty",Toast.LENGTH_SHORT).show()
                        return@Button

                    }else if(Ltext.isEmpty()){
                        Toast.makeText(context,"last name cannnot be empty",Toast.LENGTH_SHORT).show()
                        return@Button

                    } else{
                        navController.navigate("screen_B")
                        flag=true
                        //launching coroutine for saving information
                        scope.launch {
                            dataStoreF.saveFirstName(Ftext)
                            dataStoreF.saveLastName(Ltext)
                            dataStoreF.saveFlag(flag)

                        }
                    }




                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth(.80f)
                    .padding(
                        top = 10.dp
                    )
            ) {
            Text(text = "Submit")

        }
        }
    }
}

