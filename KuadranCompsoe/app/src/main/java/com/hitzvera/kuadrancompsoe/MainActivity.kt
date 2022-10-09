package com.hitzvera.kuadrancompsoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitzvera.kuadrancompsoe.ui.theme.KuadranCompsoeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KuadranCompsoeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(Modifier.fillMaxWidth()) {
                        Row(Modifier.weight(1f)) {
                           CardMessage(title = "Text composable", content = "Displays text and follows Material Design guidelines.", color = Color.Green, Modifier.weight(1f))
                           CardMessage(title = "Image composable", content = "Creates a composable that lays out and draws a given Painter class object.", color = Color.Yellow, Modifier.weight(1f))
                        }
                        Row(Modifier.weight(1f)) {
                           CardMessage(title = "Row composable", content = "A layout composable that places its children in a horizontal sequence.", color = Color.Cyan, Modifier.weight(1f))
                           CardMessage(title = "Column composable", content = "A layout composable that places its children in a vertical sequence.", color = Color.LightGray, Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun KuadranComposeScreen(name: String) {
    Text(text = "Hello $name!")
}
@Composable
fun CardMessage(
    title: String,
    content: String,
    color: Color,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KuadranCompsoeTheme {

    }
}