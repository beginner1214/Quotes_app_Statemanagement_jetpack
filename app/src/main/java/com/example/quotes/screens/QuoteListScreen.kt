package com.example.quotes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.models.Quote

@Composable
fun QuotelistScreen(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "quotesapp",
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center, // Fixed
            modifier = Modifier
                .padding(8.dp, 29.dp,)
                .fillMaxWidth(), // Fixed
        )
        QuoteList(data = data, onClick = onClick) // Fixed
    }
}
