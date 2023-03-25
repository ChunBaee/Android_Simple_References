package com.kichu.androidreferences.ui.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kichu.androidreferences.databinding.ItemRvType1Binding
import com.kichu.androidreferences.databinding.ItemRvType2Binding

/** ViewHolder를 여러개 사용하게 되므로, 공통적인 타입인 RecyclerView.ViewHolder로 반환한다.*/
class ExamRvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class Type1ViewHolder(private val binding : ItemRvType1Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(){ }
    }

    inner class Type2ViewHolder(private val binding : ItemRvType2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() { }
    }

    /** 이 메서드로 아이템의 뷰타입을 구분시켜준다. */
    /** 여기서는 짝수 / 홀수 로 나누는 예시 (2로 나눈 나머지가 1이면 홀수, 아니면 짝수) */
    override fun getItemViewType(position: Int): Int = position % 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            /** 홀수일 때 1번 ViewHolder를 연결시켜준다. */
            1 -> Type1ViewHolder(ItemRvType1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
            /** 짝수일 때(나머지) 2번 ViewHolder를 연결시켜준다. */
            else -> Type2ViewHolder(ItemRvType2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    /** 아이템 갯수는 편의상 10개로 고정했다. */
    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        /** ViewHolder가 여러개이므로, 어떤 ViewHolder에 담겨있는지 판단 후 연결해줘야 한다. 특히 뷰홀더마다 사용하는 데이터가 다를 때! */
        when(holder) {
            is Type1ViewHolder -> {
                holder.bind()
            }
            is Type2ViewHolder -> {
                holder.bind()
            }
        }
    }
}