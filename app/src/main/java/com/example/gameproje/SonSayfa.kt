package com.example.gameproje

import android.hardware.camera2.params.InputConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SonSayfa(score: Int, name: String, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

       Text(name, fontWeight = FontWeight.Bold)
        Text("Puaniniz: $score", fontWeight = FontWeight.Bold)
        val  resultMessage = if (score>=100){
            "Bu Seviyede basarilisiniz"
        }
        else{
            "Bu seviyeyi Tekrar denemelisiniz"

        }
        Text(resultMessage, fontWeight = FontWeight.Bold)

        IconButton(
            onClick = {
                navController.navigate("IlkSayfa") {
                    popUpTo("IlkSayfa") { inclusive = true }
                }
            },
            modifier = Modifier
                .size(48.dp)
                .background(color = Color.DarkGray, shape = RoundedCornerShape(24.dp))
        ) {

        }
    }
}


