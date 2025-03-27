package com.example.quotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotes.models.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn {
        items(data) { quote ->  // Fixed variable reference
            QuoteListItem(quote = quote, onClick=onClick )
        }
    }
}
