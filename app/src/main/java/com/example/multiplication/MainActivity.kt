package com.example.multiplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.multiplication.DataStore.Store
import com.example.multiplication.Navigation.AppNavigation
import com.example.multiplication.Screens.UserName
import com.example.multiplication.Screens.show
import com.example.multiplication.ui.theme.MultiplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()

        }
}


@Composable
fun ScreenWork(){
    val context = LocalContext.current
    val dataStore = Store(context)
    val flag by dataStore.getFlag.collectAsState(initial = false)
    val start :String?
    if(flag as Boolean) {
     start = "screen_B"
    }else{
        start = "screen_A"
    }



    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = start, builder = {


        composable("screen_A"){
            UserName(navController)
        }
        composable("screen_B"){
            show(navController)
        }

    })


}

}