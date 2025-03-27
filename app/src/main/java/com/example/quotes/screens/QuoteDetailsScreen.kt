package com.example.quotes.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.DataManager
import com.example.quotes.models.Quote  // Fixed model import
import com.example.quotes.pages

@Composable
fun QuoteDetails(quote: Quote) {
    BackHandler() {
        DataManager.switchpages( null)
    }
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    colors = listOf(Color(0xFF000000), Color(0xFFE3E3E3))
                )
            )
            .clickable { DataManager.currentstate.value = pages.Listing } // Back to list
    ) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(15.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.Favorite,
                    colorFilter = ColorFilter.tint(Color.Red),
                    contentDescription = "Heart Icon",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180f)
                        .background(Color.White)
                )

                Text(
                    text = quote.text,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )

                Spacer(modifier = Modifier.size(12.dp))

                Text(
                    text = quote.author,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}