package com.example.gameproje

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gameproje.ui.theme.GameProjeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameProjeTheme {

                Surface() {
                    SayfaGecisleri()
                }
            }
        }
    }
@Composable
fun SayfaGecisleri() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Ilk_sayfa") {

        composable(route = "Ilk_sayfa") {
            IlkSayfa(navController)
        }
        composable(route = "Ikinci_sayfa") {

            IkinciSayfa(navController)
        }
        composable(route = "AoyunSayfasi" + "?name={name}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                    defaultValue = "kullanici adi girilmedi"

                }
            )
        ) {navBackStackEntry->
            val name = navBackStackEntry.arguments?.getString("name")!!
            AoyunSayfasi(navController,name)
        }
        composable(route = "BoyunSayfasi") {
            BoyunSayfasi(navController)
        }
        composable(route = "CoyunSayfasi") {
            CoyunSayfasi(navController)
        }
         composable(route="SonSayfa") {
            SonSayfa(score= puan.toInt(), name = isim , navController = navController)
        }

    }

}




}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GameProjeTheme {

    }
}