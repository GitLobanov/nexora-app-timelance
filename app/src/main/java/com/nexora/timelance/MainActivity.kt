package com.nexora.timelance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}


@Preview
@Composable
fun MainScreen () {
    Box(modifier = Modifier
        .fillMaxSize()
        .background (
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(
                        android.graphics.Color.parseColor("#59469d")
                    ),
                    Color(
                        android.graphics.Color.parseColor("#643d67")
                    )
                )
            )
        )
    )
}
