package com.example.gameproje

import kotlin.random.Random
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.navigation.NavController as NavController
var puan=""
data class Question(val word: String, val correctMeaning: String, val otherOptions: List<String>)

@Composable
fun AoyunSayfasi(navController: NavController, name: String) {
        var score by remember { mutableStateOf(0) }
        var questionCount by remember { mutableStateOf(1) }
        var timeRemaining by remember { mutableStateOf(15) }
        var isGameOver by remember { mutableStateOf(false) }

        var currentQuestion by remember { mutableStateOf(generateQuestion()) }

        val selectedOption by remember { mutableStateOf("") }
        val correctAnswerScore=20
        var selectedOptions = remember {
                mutableSetOf<String>()
        }
        Image(
                painter = painterResource(id = R.drawable.arkaplana),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()

        )


        // sure
        LaunchedEffect(Unit) {
                while (questionCount <= 10) {
                        delay(1000)
                        if (!isGameOver) {
                                timeRemaining--
                                if (timeRemaining == 0) {
                                        // Zaman dolduğunda yeni soru göster
                                        currentQuestion = generateQuestion()
                                        questionCount++
                                        timeRemaining = 15
                                }
                        }
                }

                isGameOver = true
        }

        Column(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
                //kullanici adi
                Text(text =name , color = Color.White)
                // Skor göstergesi
                Text("PUANINIZ: $score", fontWeight = FontWeight.Bold, color = Color.White)

                // Zaman göstergesi
                Text("SURE: $timeRemaining seconds", fontWeight = FontWeight.Bold, color = Color.White)

                // Soru ve seçenekleri gösteren kutu
                Box(
                        modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.5f)
                                .background(
                                        color = Color(50,100,200),
                                        shape = RoundedCornerShape(16.dp)
                                )
                                .padding(16.dp),
                        contentAlignment = Alignment.Center
                ) {
                        Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                                Text("Question $questionCount/10", fontWeight = FontWeight.Bold)
                                if (questionCount==10){
                                        Button(onClick = {
                                                //son sayfaya yonelndirme butonu
                                                navController.navigate("SonSayfa")
                                        },
                                                colors = ButtonDefaults.buttonColors(
                                                        containerColor = Color(85,26,139),
                                                        contentColor = Color.White
                                                ),
                                                modifier = Modifier
                                                        .align(Alignment.CenterHorizontally)

                                        ) {
                                                Text(text = "FINISH")

                                        }

                                }

                                Text(text = currentQuestion.word, style = MaterialTheme.typography.bodyMedium)

                                // Seçenekleri gösteren döngü
                                currentQuestion.otherOptions.forEach { option ->
                                        OptionRow(
                                                option = option,
                                                isSelected = option in selectedOption,
                                                onOptionSelected = {
                                                       if(it !in  selectedOptions){

                                                               selectedOptions.add(it)
                                                               if(it==currentQuestion.correctMeaning){
                                                                       score +=correctAnswerScore
                                                                       //score= puan.toInt()
                                                               }
                                                               else{
                                                                       score-=correctAnswerScore
                                                               }
                                                       }
                                                }
                                        )
                                }
                        }
                }

                //sonraki sayfa butonu
                IconButton(
                        onClick = {
                                currentQuestion = generateQuestion()
                                questionCount++
                                timeRemaining = 15
                        },
                        modifier = Modifier
                                .size(48.dp)
                                .background(color = Color.Gray, shape = RoundedCornerShape(24.dp))
                ) {
                        Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = null)
                }

                // Oyun bittiğinde sonuç gösteriyoruz
                if (isGameOver) {
                        navController.navigate("SonSayfa/$score")
                }
        }
}




@Composable
fun OptionRow(option: String, isSelected: Boolean, onOptionSelected: (String) -> Unit) {
        Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(if (isSelected) Color.Gray else Color.Transparent)
                        .clickable { onOptionSelected(option) },
                verticalAlignment = Alignment.CenterVertically
        ) {
                // Seçenek metni
                Text(text = option, style = MaterialTheme.typography.bodyMedium)
        }
}

fun generateQuestion(): Question {
        // Rastgele kelime ve anlamları
        val words = listOf(
                "WATER" to "SU",
                "WELCOME" to "HOSGELDINIZ",
                "WIND" to "SARMAK",
                "WINNER" to "GALIP"
        )

        // Rastgele bir kelime seçme kismi
        val (word, correctMeaning) = words.random()

        // Diğer seçenekleri oluşturma ksimi
        val otherOptions = mutableListOf<String>()
        while (otherOptions.size < 3) {
                val randomOption = words.random().second
                if (randomOption != correctMeaning && randomOption !in otherOptions) {
                        otherOptions.add(randomOption)
                }
        }

        // Doğru anlamlı seçeneği rastgele bir konuma yerleştirilir
        otherOptions.add(index=Random.nextInt(4) , correctMeaning)

        return Question(word, correctMeaning, otherOptions)
}

@Preview
@Composable
fun AoyunSayfasi(){
        AoyunSayfasi()
}







