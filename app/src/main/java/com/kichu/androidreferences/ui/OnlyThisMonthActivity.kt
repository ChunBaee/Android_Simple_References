package com.kichu.androidreferences.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kichu.androidreferences.databinding.ActivityOnlyThisMonthBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class OnlyThisMonthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnlyThisMonthBinding
    private lateinit var calendarAdapter : CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnlyThisMonthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCalendarView()
    }

    private fun initCalendarView() {
        binding.onlyThisMonthTvYearAndMonth.text = yearMonthMapper()

        calendarAdapter = CalendarAdapter(getCalendarDates())
        binding.onlyThisMonthRvCalendar.adapter = calendarAdapter
    }

    private fun yearMonthMapper(): String = "${getCurrentYear()} / ${getCurrentMonth()}"


    private fun getCurrentYear(): String {
        return SimpleDateFormat("yyyy", Locale.KOREA).format(Date(System.currentTimeMillis()))
    }

    private fun getCurrentMonth(): String {
        return SimpleDateFormat("MM", Locale.KOREA).format(Date(System.currentTimeMillis()))
    }

    private fun getCalendarDates() : List<String> {
        /** 해당 월의 시작 요일을 알기 위함 */
        val mCal = Calendar.getInstance()
        mCal.set(getCurrentYear().toInt(), getCurrentMonth().toInt() - 1, 1)
        /** 월 은 배열처럼 구분되어 0,1,2 와 같은 식으로 적용되므로 -1을 해주자! */

        /** 일요일이 1으로 시작점이나, 배열의 시작점은 0부터이므로 -1을 해주자 (일요일을 시작점으로 잡을 시)*/
        val startDay = mCal.get(Calendar.DAY_OF_WEEK) - 1
        val lastDate = mCal.getActualMaximum(Calendar.DAY_OF_MONTH)

        return getActualCalendarDates(startDay, lastDate)
    }

    private fun getActualCalendarDates(startDay : Int, lastDate : Int) : List<String> {
        return mutableListOf<String>().apply {
        /** 시작일 이전의 날들을 공백으로 만들기 */
            for(i in 0 until startDay) {
                this.add(" ")
            }
            for(i in 1 until lastDate + 1) {
                this.add(i.toString())
            }
        }
    }
}