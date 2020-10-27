package com.example.kotlinmutiplatformsample

import SpotifyApi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import generatingMessageToShow
import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    val scope = CoroutineScope(Job() + Dispatchers.Main)

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_welcome?.text = generatingMessageToShow()
        val soptifyAPI = SpotifyApi()
        scope.launch {
            tv_welcome?.text =  "Loading..."
            val result = withContext(Dispatchers.IO) { soptifyAPI.getCategories() }
            tv_welcome?.text = "$result"
        }
    }

}
