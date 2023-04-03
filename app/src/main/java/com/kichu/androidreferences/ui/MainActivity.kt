package com.kichu.androidreferences.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kichu.androidreferences.R
import com.kichu.androidreferences.data.OuterData
import com.kichu.androidreferences.databinding.ActivityMainBinding
import com.kichu.androidreferences.ui.adapter.MainOuterAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRv()
    }

    private fun initRv() {
        binding.mainRvRecycler.adapter = MainOuterAdapter(returnOuterList())
    }

    /** Dummy **/

    private fun returnOuterList() : List<OuterData> =
        mutableListOf<OuterData>().apply {
            for(i in 0 until 10) {
                this.add(OuterData("$i 번째 바깥 리스트 아이템", returnInnerList(i)))
            }
        }

    private fun returnInnerList(position : Int) : List<OuterData.InnerData> =
        mutableListOf<OuterData.InnerData>().apply {
            for(i in 0 until 5) {
                this.add(OuterData.InnerData("$position - $i 번째"))
            }
        }
}