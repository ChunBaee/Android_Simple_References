package com.kichu.androidreferences.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kichu.androidreferences.data.OuterData
import com.kichu.androidreferences.databinding.ItemMainRvInnerBinding

class MainInnerAdapter (private val data : List<OuterData.InnerData>) : RecyclerView.Adapter<MainInnerAdapter.MainInnerViewHolder>() {

    inner class MainInnerViewHolder(private val binding : ItemMainRvInnerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : OuterData.InnerData) {
            binding.itemMainRvInnerItemTv.text = item.innerText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainInnerViewHolder {
        return MainInnerViewHolder(ItemMainRvInnerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainInnerViewHolder, position: Int) {
        return holder.bind(data[position])
    }
}