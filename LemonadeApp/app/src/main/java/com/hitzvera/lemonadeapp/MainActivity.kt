package com.hitzvera.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hitzvera.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MainContent(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var currentStep by remember { mutableStateOf(1) }
        var text by remember { mutableStateOf("") }
        var imageResource by remember { mutableStateOf(-1)}
        var numberOfSqueze by remember { mutableStateOf(2)}
        var checkSqueze by remember { mutableStateOf(1)}
        when(currentStep){
            1 -> {
                text = stringResource(id = R.string.lemon_tree)
                imageResource = R.drawable.lemon_tree
            }
            2 -> {
                text = stringResource(id = R.string.lemon)
                imageResource = R.drawable.lemon_squeeze
            }
            3 -> {
                text = stringResource(id = R.string.glass_of_lemonade)
                imageResource = R.drawable.lemon_drink
            }
            4 -> {
                text = stringResource(id = R.string.empty_glass)
                imageResource = R.drawable.lemon_restart
            }
            else -> {
                currentStep = 1
            }
        }
        Text(text = text, fontSize = 18.sp)
        Spacer(Modifier.height(16.dp))
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "lemon tree",
            modifier = Modifier
                .border(2.dp, Color(105, 205, 216, 255))
                .padding(8.dp)
                .clickable {
                    if(currentStep == 2){
                        numberOfSqueze = (2..4).random()
                        checkSqueze = 1
                        if(checkSqueze <= numberOfSqueze){
                            checkSqueze++
                        } else {
                            currentStep++
                        }
                    } else {
                        currentStep++
                    }

                }
            )
    }
}