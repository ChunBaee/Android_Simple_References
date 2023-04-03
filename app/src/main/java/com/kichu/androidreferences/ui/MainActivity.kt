package com.kichu.androidreferences.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kichu.androidreferences.R
import com.kichu.androidreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}