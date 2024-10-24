package com.project.navigate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.navigate.ui.theme.MainScreen
import com.project.navigate.ui.theme.NavigateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
app(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun app(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "registration") {
        composable(route = "registration") {
            LoginScreen(navController)
        }
        composable(route = "application") {
            applicationScreen(navController)
        }
        composable(route = "main") {
            MainScreen(navController)
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    Text(
        text = "registration",
        style = MaterialTheme.typography.displayLarge,
        modifier = Modifier.clickable {
            navController.navigate("application")
        }
    )
}

@Composable
fun applicationScreen(navController: NavController) {
    Text(
        text = "application",
        style= MaterialTheme.typography.displayLarge,
        modifier = Modifier.clickable{navController.navigate("main")}
    )
}

@Composable
fun MainScreen(navController: NavController) {
    Text(
        text = "main",
        style=MaterialTheme.typography.displayLarge,
    )
}

