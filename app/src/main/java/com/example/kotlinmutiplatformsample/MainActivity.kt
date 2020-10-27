package com.example.kotlinmutiplatformsample

import SpotifyApi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import generatingMessageToShow
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    val scope = CoroutineScope(Job() + Dispatchers.Main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val soptifyAPI = SpotifyApi()
        tv_welcome?.text =  "Loading..."
        scope.launch {
            val result = withContext(Dispatchers.IO) { soptifyAPI.getCategories() }
            withContext(Dispatchers.Main){ tv_welcome?.text = "$result" }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        scope.coroutineContext.cancelChildren()
    }
}
