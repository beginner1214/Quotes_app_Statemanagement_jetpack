package com.example.quotes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotes.models.Quote  // Fixed import

@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClick(quote) }

    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White)
            ) {
                Image(
                    imageVector = Icons.Filled.Favorite,
                    colorFilter = ColorFilter.tint(Color.Red),
                    contentDescription = "Heart Icon",
                    modifier = Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = quote.text, style = MaterialTheme.typography.bodyLarge
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.4f) // Fixed function usage
                        .background(Color.Blue)
                        .height(2.dp)
                )
                Text(
                    text = quote.author, fontWeight = FontWeight.W300
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewQuoteListItem() {
    QuoteListItem(
        quote = Quote("Genius is 1% inspiration and 99% perspiration.", "Thomas Edison"),
        onClick = {})
}
