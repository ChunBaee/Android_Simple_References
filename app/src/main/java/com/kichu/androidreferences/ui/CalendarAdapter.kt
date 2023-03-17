package com.kichu.androidreferences.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kichu.androidreferences.R
import com.kichu.androidreferences.databinding.ItemCalendarDayBinding

class CalendarAdapter(private val calendarList : List<String>) : RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    inner class CalendarViewHolder(private val binding : ItemCalendarDayBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : String) {
            binding.itemCalendarDayTvDay.text = item

            /** 일요일의 경우 텍스트 색상을 빨간색으로, 토요일은 파란색으로 처리하기 */

            if(adapterPosition % 7 == 0) {
                binding.itemCalendarDayTvDay.setTextColor(Color.RED)
            } else if(adapterPosition % 7 == 6) {
                binding.itemCalendarDayTvDay.setTextColor(Color.BLUE)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        return CalendarViewHolder(ItemCalendarDayBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = calendarList.size

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(calendarList[position])
    }
}