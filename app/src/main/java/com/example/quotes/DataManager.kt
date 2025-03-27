package com.example.quotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.models.Quote
import com.google.gson.Gson

object DataManager {

    var currentstate = mutableStateOf(pages.Listing)
    var currentQuote: Quote? = null
    var data = emptyArray<Quote>()
    var dataloaded = mutableStateOf(false)
    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8) // Fixed charset usage
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        dataloaded.value = true
    }


    fun switchpages(quote: Quote?) {
        if (currentstate.value == pages.Listing) {
            currentQuote = quote
            currentstate.value = pages.Detal
        } else {
            currentstate.value = pages.Listing
        }
    }

}
