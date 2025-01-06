package com.jinsub.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jinsub.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "first"
            ) {
                composable("first") { FirstScreen(navController) }
                composable(
                    route = "second/{userName}?age={age}",
                    arguments = listOf(
                        navArgument("userName") {
                            type = NavType.StringType
                        },
                        navArgument("age") {
                            type = NavType.StringType
                            defaultValue = "30"
                            nullable = true
                        }
                    )
                ) { backStackEntry ->
                    SecondScreen(
                        navController,
                        backStackEntry.arguments?.getString("userName").toString(),
                        backStackEntry.arguments?.getString("age").toString()
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {

    Column(
        modifier = Modifier.padding(50.dp)
    ) {
        Text(text = "첫 번째 화면")

        var enteredText by remember {
            mutableStateOf("")
        }

        var enteredText2 by remember {
            mutableStateOf("")
        }

        TextField(
            value = enteredText,
            onValueChange = { enteredText = it },
            label = { Text(text = "Enter Your Name") }
        )
        TextField(
            value = enteredText2,
            onValueChange = { enteredText2 = it },
            label = { Text(text = "Enter Your age") }
        )

        Button(onClick = {
            navController.navigate("second/$enteredText?age=$enteredText2")
        }) {
            Text(text = "2 번째 화면 이동")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController, username: String, age: String) {
    Column(
        modifier = Modifier.padding(50.dp)
    ) {
        Text(text = "Welcome $username, Your age is $age")

        Button(onClick = {
            navController.navigateUp()
        }) {
            Text(text = "1 번째 화면 이동")
        }
    }
}

