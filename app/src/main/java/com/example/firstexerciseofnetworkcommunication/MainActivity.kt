package com.example.firstexerciseofnetworkcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstexerciseofnetworkcommunication.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            runBlocking {
                delayValue()
                increment()
            }
        }
    }

    private suspend fun delayValue() {
        delay(2000)
    }

    private fun increment() {
        val userInput = binding.edInput.text.toString()
        val userInput2 = userInput.toInt()
        val result = "This is your input ${userInput2 + 1 + count++}"
        binding.TVResult.text = result

    }
}