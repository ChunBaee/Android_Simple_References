package com.kichu.androidreferences.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.core.view.WindowCompat
import com.kichu.androidreferences.R
import com.kichu.androidreferences.ui.withStatus.WithStatusActivity
import com.kichu.androidreferences.ui.withoutStatus.WithoutStatusActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val withActivityButton = findViewById<Button>(R.id.btn_with_statusbar_activity).also {
            it.setOnClickListener {
                startActivity(Intent(this, WithStatusActivity::class.java))
            }
        }

        val withoutActivityButton = findViewById<Button>(R.id.btn_without_statusbar_activity).also {
            it.setOnClickListener {
                startActivity(Intent(this, WithoutStatusActivity::class.java))
            }
        }
    }
}