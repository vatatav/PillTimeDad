package com.vatatav.pilltimedad

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vatatav.pilltimedad.ui.theme.PillTimeDadTheme

@Composable
fun MainScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "İlaç Hatırlatma Uygulaması",
            style = MaterialTheme.typography.headlineMedium
        )
        // İlaç hatırlatıcıları ve şarj durumu burada gösterilecek
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PillTimeDadTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen()
        }
    }
}