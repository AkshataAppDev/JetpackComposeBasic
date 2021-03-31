package com.example.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
               MyScreenContent()
            }
        }
    }
}


// Composable functions dont return UI components, they emit them.So they must return Unit
// contains UI code specific to this activity so Greeting could be reusable
// Also, MyApp can now be used in multiple places as it defines a top level configuration.
// MyApp is now a container function.
@Composable
fun MyApp(content: @Composable () -> Unit)
{
    JetpackComposeBasicTheme {  // this name should be as per your project name
        // A surface container using the 'background' color from the theme
        Surface(color = Color.Yellow) { 
           content()
        }
    }
}



@Composable // now greeting is reusable
fun Greeting(name: String) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp)) // will be drawn on the surface color
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android","There !!"))
{
    Column {
        // UI elements are emitted by calling Composable functions
        for(name in names)
        Greeting(name = name)
        Divider(color = Color.Black)
    }
}

@Preview("MyScreen Preview") // Preview mark when any parameterless function to show preview of UI in Design or split view
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
    
}