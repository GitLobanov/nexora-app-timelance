package com.nexora.timelance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nexora.timelance.ui.theme.TimelanceTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimelanceTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    TimelanceTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {

    val progressItems = listOf(
        ProgressData("Java Practice", "3H 17 min", 0.5f),
        ProgressData("Japanese Vocabulary", "1H 7 min", 0.5f),
        ProgressData("English Vocabulary", "47 min", 0.5f),
        ProgressData("English Reading", "37 min", 0.5f),
        ProgressData("English Reading", "37 min", 0.5f),
        ProgressData("English Reading", "37 min", 0.5f)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Время управления
            Column {
                Text(
                    text = "Time management"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "7 H 16 M"
                )
            }

            Text(
                text = "Today's recent tracking",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.height(200.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                userScrollEnabled = true
            ) {
                items(progressItems) { item ->
                    ProgressItem(title = item.title, time = item.time, progress = item.progress)
                }
            }

            // Статистика и ближайшая цель
            Column {
                Text(
                    text = "Total Statistics",
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Time: 2000 H 56 M\nStreak days: 202 d"
                )
                Spacer(modifier = Modifier.height(16.dp))
                ProgressItem(title = "Nearest goal: Java", time = "460 / 520 H", progress = 0.91f)
            }

            // Кнопки внизу
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {}) { Text("ГЛ") }
                Button(onClick = {}) { Text("ГР") }
                Button(onClick = {}) { Text("НА") }
                Button(onClick = {}) { Text("ОТ") }
            }
        }
    }
}

data class ProgressData(val title: String, val time: String, val progress: Float)

@Composable
fun ProgressItem(title: String, time: String, progress: Float) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(4.dp))

        LinearProgressIndicator(
            progress = {
                progress
            },
            modifier = Modifier.fillMaxWidth(),
            color = Color.Yellow,
            trackColor = Color.Gray,
        )
        Spacer(modifier = Modifier.height(4.dp))


        val percent:String = (progress*100).roundToInt().toString();

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = time, style = MaterialTheme.typography.bodySmall)
            Text(text = "$percent%", style = MaterialTheme.typography.bodySmall)
        }

    }
}
