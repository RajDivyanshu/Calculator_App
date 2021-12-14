package com.kotlinninja.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlinninja.mycalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //providing a direct reference for the root view of the corresponding layout file
        //Pass the root view to setContentView() to make it the active view on the screen.




    }
}