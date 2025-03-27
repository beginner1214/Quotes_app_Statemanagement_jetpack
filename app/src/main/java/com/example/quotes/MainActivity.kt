package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotes.screens.QuoteDetails
import com.example.quotes.screens.QuotelistScreen
import com.example.quotes.ui.theme.QuotesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {
            QuotesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    if (DataManager.dataloaded.value) {
        if (DataManager.currentstate.value == pages.Listing) {
            QuotelistScreen(data = DataManager.data) {
                DataManager.switchpages(it)
            }

        } else {
            DataManager.currentQuote?.let { QuoteDetails(quote = it) }
        }
    }
}

enum class pages {
    Listing, Detal
}