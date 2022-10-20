package com.hitzvera.thirtydaysapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitzvera.thirtydaysapplication.model.Qoute
import com.hitzvera.thirtydaysapplication.model.QouteDataSource
import com.hitzvera.thirtydaysapplication.model.QouteDataSource.qoutes
import com.hitzvera.thirtydaysapplication.ui.theme.ThirtyDaysApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(){

    LazyColumn(

    ){
        itemsIndexed(qoutes){ index, item ->
            QouteItem(index+1, item)
        }
    }
}
@Composable
fun QouteList(){

}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QouteItem(day: Int, qoute: Qoute){
    var expanded by remember { mutableStateOf(false)}
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp,
        onClick = { expanded = !expanded },
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ),
        ) {
            Text(text = "Day $day")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = qoute.qoute))
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = qoute.qouteImg),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            if(expanded){
                QouteDetail(detail = qoute.qouteDes)
            }
        }
    }
}
@Composable
fun QouteDetail(detail: Int){
    Spacer(Modifier.height(16.dp))
    Text(
        text = stringResource(id = detail)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThirtyDaysApplicationTheme {

    }
}