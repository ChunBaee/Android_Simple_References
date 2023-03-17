package com.kichu.androidreferences.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kichu.androidreferences.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onlyThisMonth = findViewById<Button>(R.id.btn_calendar_only_this_month).also {
            it.setOnClickListener {
                startActivity(Intent(this, OnlyThisMonthActivity::class.java))
            }
        }
    }
}