package com.hitzvera.birthdayapp

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hitzvera.birthdayapp.ui.theme.BirthDayAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthDayAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(message = getString(R.string.happy_birthday), from = getString(
                                            R.string.farhan))
                }
            }
        }
    }
}


@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    Column {
        Text(
            text = message, fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp)
        )
        Text(
            text = from, fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }

}
@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    BirthDayAppTheme {
        BirthdayGreetingWithImage( "Happy Birthday Sam!", "- from Emma")
    }
}
@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)
    //Step 3 create a box to overlap image and texts
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}
// composable should be a noun
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BirthDayAppTheme {
        BirthdayGreetingWithText(message = "Happy Birthday Mujahid ", "-from farhan")
    }
}