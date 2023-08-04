package com.example.jokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jokeapp.api.IJoke
import com.example.jokeapp.databinding.ActivityMainBinding
import com.example.jokeapp.network.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var coin = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvCoin.text = coin.toString()
        binding.buttonNext.setOnClickListener {
            getJoke()
            //coin--
        }


    }

    private fun getJoke() {

        GlobalScope.launch(Dispatchers.IO) {
            val response = Singleton.api.getJoke()
            if (response.isSuccessful) {
                val data = response.body()!!

                withContext(Dispatchers.Main) {
                    binding.tvCoin.text = coin.toString()
                    if (coin > 0) {
                        binding.tvJoke.text = "${data.setup}\n${data.delivery}"

                    }else {
                        binding.tvJoke.text = "Paran bitti, Fakirler gulemez"
                        binding.buttonNext.isClickable = false

                    }
                    coin --


                }

            }

        }

    }

}