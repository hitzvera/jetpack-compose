package com.hitzvera.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.key.Key.Companion.Ro
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitzvera.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}


@Composable
fun ArtSpaceScreen(
    image: Int,
    title: String,
    author: String
){
    val roundedCornerShape: Shape = RoundedCornerShape(4.dp)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .border(1.dp, Color.Black)
                .padding(16.dp)
                .shadow(
                    elevation = 2.dp,
                    shape = roundedCornerShape
                )
        ){
            Image(
                painter = painterResource(id = image),
                contentDescription = "$title by $author"
            )
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            ColumnTitleAndAuthor(title = title, author = author)
            RowButton()
        }

    }
}
@Composable
fun ColumnTitleAndAuthor(
    title: String,
    author: String,
){
    Column (
        modifier = Modifier
            .wrapContentWidth(Alignment.CenterHorizontally)
            .border(1.dp, Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
            ){
        Text(
            text = title,
        )
        Text(author)
    }
}

@Composable
fun RowButton() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
    modifier = Modifier
        .fillMaxSize()
        .padding(0.dp, 16.dp),){
        Button(
            onClick = {},
            Modifier.size(width = 100.dp, height = 50.dp)
        ){
            Text(text = "Previous")
        }
        Button(
            onClick = {},
            Modifier.size(width = 100.dp, height = 50.dp)
        ){
            Text(text = "Next")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen(image = R.drawable.image1, title = "this is a test", author = "Mujahid")
    }
}