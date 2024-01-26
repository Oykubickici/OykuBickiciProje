package com.example.gameproje

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController



@Composable
fun IkinciSayfa(navController: NavController){
    Image(painter = painterResource(id = R.drawable.arkaplana),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()


    )
    Column(

        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "WHICH LEVEL?",
            color= Color.White,


            modifier = Modifier
                .width(200.dp)
                .height(200.dp)

        )
        Button(onClick = {
                         navController.navigate("AoyunSayfasi")

        },
            modifier=Modifier
            .width(150.dp)
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(200 ,170 ,193),
                contentColor = Color.White
            )

        ) {
            Text(text = "A1-A2",
            )

        }
        Button(onClick ={
            navController.navigate("BoyunSayfasi")

        },
             modifier=Modifier
                 .width(250.dp)
                     ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(150,100,200),
                contentColor = Color.White
            )
            ) {
            Text(text = "B1-B2"

            )

        }
        Button(onClick = {
            navController.navigate("CoyunSayfasi")

        }, modifier=Modifier
            .width(350.dp)
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(16,78,180),
                contentColor = Color.White
            )) {
            Text(text = "C1-C2"

            )

        }
        Button(onClick = {
            navController.popBackStack()
        },
            modifier=Modifier
                .padding(0.dp,20.dp,0.dp,50.dp)
            ,

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(85,26,139),
                contentColor = Color.White
            )) {
            Text(text = "BACK")
        }


    }


}
