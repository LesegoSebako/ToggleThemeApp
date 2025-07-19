package com.example.togglethemeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.togglethemeapp.ui.theme.ToggleThemeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToggleThemeAppTheme {
                ToggleThemeApp()


            }
        }
    }
}
@Composable
fun ToggleThemeApp() {
    var isDarkTheme by remember {mutableStateOf(false)}
    var counter by remember { mutableIntStateOf(0) }

    //Define background and text color based on the theme
    val backgroundColor = if (isDarkTheme) Color.Black else Color.White
    val textColor = if (isDarkTheme) Color.White else Color.Black

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = if (isDarkTheme) "Dark Mode" else "Light Mode",
                fontSize = 25.sp,
                color = textColor
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick ={ isDarkTheme = !isDarkTheme}){
                Text("toggle Theme")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text (
                    text = "Counter: $counter",
                    fontSize = 28.sp,
                    color = textColor
                    )

            Spacer (modifier = Modifier.height(16.dp))

            Row {

                Button (onClick = { counter++}, modifier = Modifier.padding(end = 8.dp)){
                    Text("Increment")

            }

                Button(onClick = {counter = 0}){
                    Text("Reset")


                }
            }
        }

    }

}