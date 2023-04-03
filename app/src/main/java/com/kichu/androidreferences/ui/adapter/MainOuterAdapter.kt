package com.kichu.androidreferences.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kichu.androidreferences.data.OuterData
import com.kichu.androidreferences.databinding.ItemMainRvOuterBinding

class MainOuterAdapter (private val data : List<OuterData>) : RecyclerView.Adapter<MainOuterAdapter.MainOuterViewHolder>() {

    inner class MainOuterViewHolder(private val binding : ItemMainRvOuterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : OuterData) {
            binding.itemMainRvOuterItemTv.text = item.outerText

            binding.itemMainRvOuterItemRv.adapter = MainInnerAdapter(item.innerList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainOuterViewHolder {
        return MainOuterViewHolder(ItemMainRvOuterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainOuterViewHolder, position: Int) {
        holder.bind(data[position])
    }
}