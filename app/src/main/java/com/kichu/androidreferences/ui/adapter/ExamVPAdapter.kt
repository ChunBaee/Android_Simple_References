package com.kichu.androidreferences.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kichu.androidreferences.databinding.ItemVpMainExamBinding

class ExamVPAdapter(val images : List<Int>) : RecyclerView.Adapter<ExamVPAdapter.ExamViewHolder>() {

    inner class ExamViewHolder(private val binding : ItemVpMainExamBinding) : RecyclerView.ViewHolder(binding.root) {
        /** 예제에서는 링크가 아닌 Resource Id를 통해 사진을 가져오므로 임시로 Int를 사용했다. */
        fun bind(item : Int) {
            binding.itemVpMainExamIvImage.setImageResource(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamViewHolder {
        return ExamViewHolder(ItemVpMainExamBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ExamViewHolder, position: Int) {
        holder.bind(images[position])
    }
}