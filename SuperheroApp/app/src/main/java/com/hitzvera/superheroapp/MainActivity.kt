package com.hitzvera.superheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitzvera.superheroapp.model.Hero
import com.hitzvera.superheroapp.model.HeroesRepository.heroes
import com.hitzvera.superheroapp.ui.theme.SuperheroAppTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SuperHeroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperHeroesApp(){
    Scaffold {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)){
            items(heroes){
                HeroItem(it)
            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier){
    Card(
        modifier = modifier.padding(16.dp),
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ){
            HeroInformation(heroName = hero.nameRes, heroDesc = hero.descriptionRes)
            HeroIcon(heroImage = hero.imageRes)
        }
    }

}
@Composable
fun HeroInformation(@StringRes heroName: Int, @StringRes heroDesc: Int){
    Column {
        Text(
            text = stringResource(id = heroName),
            style = MaterialTheme.typography.h2
        )
        Text(
            text = stringResource(id = heroDesc),
            style = MaterialTheme.typography.body1
        )
    }
}
@Composable
fun HeroIcon(@DrawableRes heroImage: Int){
    Image(
        painter = painterResource(id = heroImage),
        contentDescription = null
    )
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperheroAppTheme {
        SuperHeroesApp()
    }
}