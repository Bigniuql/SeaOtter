package com.example.seaotter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.seaotter.ui.theme.SeaOtterTheme

class MainActivity : ComponentActivity() {

    val navigationItems = listOf(
        Pair("首页", Icons.Default.Home),
        Pair("项目", Icons.Default.Call),
        Pair("分类", Icons.Default.Place),
        Pair("我的", Icons.Default.Person),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeaOtterTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    var currentNavigationIndex by remember {
                        mutableStateOf(0)
                    }
                    Scaffold(
                        bottomBar = {
                            BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
                                navigationItems.forEachIndexed { index, pair ->
                                    BottomNavigationItem(selected = currentNavigationIndex == index, onClick = {
                                        currentNavigationIndex = index
                                    }, icon = {
                                        Icon(imageVector = pair.second, contentDescription = null)
                                    }, label = {
                                        Text(text = pair.first)
                                    }, selectedContentColor = Color(0xff149ee7),
                                        unselectedContentColor = Color(0xff999999)
                                    )
                                }
                            }
                        }
                    ){
                        Box(modifier = Modifier.padding(it)) {
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SeaOtterTheme {
        Greeting("Android")
    }
}