package com.hitzvera.kartunama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hitzvera.kartunama.ui.theme.KartuNamaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KartuNamaTheme {
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
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF003a4a)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(Modifier.weight(2f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
            Text(
                text = "Jennifer Doe",
                color = Color.White,
                fontSize = 36.sp
            )
            Text(
                text = "Android Developer Extraordinaire",
                color = Color(0xFF3ddc84),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(top = 32.dp)
                .background(color = Color(0xFF003a4a)),
        ) {
            ItemContactInfo(icon = painterResource(id = R.drawable.ic_baseline_local_phone_24), info = "+11 (123) 44 55 66", contentDes = "phone")
            ItemContactInfo(icon = painterResource(id = R.drawable.ic_baseline_share_24), info = "@AndroidDev", contentDes = "share")
            ItemContactInfo(icon = painterResource(id = R.drawable.ic_baseline_chat_24), info = "jen.doe@android.com", contentDes = "email")
        }

    }
}
@Preview(showBackground = true)
@Composable
fun ContactInfo(){

}

@Composable
fun ItemContactInfo(icon: Painter, info: String, contentDes: String){
    Column {
        Divider(
            color = Color.White,
            thickness = 1.dp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp, start = 24.dp, bottom = 16.dp)
        ){
            Icon(painter = icon, contentDescription = contentDes)
            Text(text = info, modifier = Modifier.padding(start = 16.dp), color = Color.White)
        }
    }

}
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    KartuNamaTheme {
//        Greeting("Android")
//    }
//}