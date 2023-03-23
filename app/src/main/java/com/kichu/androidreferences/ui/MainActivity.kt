package com.kichu.androidreferences.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.kichu.androidreferences.R
import com.kichu.androidreferences.databinding.ActivityMainBinding
import com.kichu.androidreferences.ui.adapter.ExamVPAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initVP()

        setContentView(binding.root)
    }

    private fun initVP() {
        binding.mainVpExam.adapter = ExamVPAdapter(returnImageList())

        /** 이 부분을 통해, TabLayout과 ViewPager를 연결해준다 */
        TabLayoutMediator(binding.mainTabExam, binding.mainVpExam) { _, _ ->
        }.attach()

    }

    private fun returnImageList(): List<Int> = listOf(
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background
    )
}