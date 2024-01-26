package com.example.gameproje

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gameproje.ui.theme.Purple40
var isim=""
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IlkSayfa(navController: NavController)

 {
     var name by remember {
         mutableStateOf<String>("") }



     Image(painter = painterResource(id = R.drawable.arkaplana),
         contentDescription = null,
         modifier = Modifier.fillMaxSize()

     )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Image(
            painter = painterResource(R.drawable.girisfoto),
            contentDescription = "giris karsilama fotosu",
            modifier = Modifier
                .padding(10.dp, 10.dp, 10.dp, 10.dp)
                .width(250.dp)
                .height(250.dp)
                .clip(shape = CircleShape)

        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = name,
            onValueChange ={
                if (name.length<20){
                    name = it
                } },
            supportingText = {
                Text(text = "${name.length}/20",
            modifier =Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
                textAlign = TextAlign.End)

        },
            label = {
                Text(text = "Enter Username", color = Color.White)
            },
            leadingIcon={ Icon(imageVector=Icons.Outlined.Person,contentDescription=null) },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
                 keyboardActions = KeyboardActions(
                onDone = {
                    val bundle = Bundle().apply {
                        putString("name", name)
                    }
                    navController.navigate("AoyunSayfasi"+"?name={name}")
                }

                 )

        )
        Row(modifier = Modifier
            .padding(10.dp,10.dp,10.dp,10.dp)) {


            Button(onClick = {
                navController.navigate("Ikinci_sayfa")


            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(85,26,139),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .align(Alignment.Bottom)
            ) {
                Text(text = "LOGIN")

            }
        }
    }

    }














