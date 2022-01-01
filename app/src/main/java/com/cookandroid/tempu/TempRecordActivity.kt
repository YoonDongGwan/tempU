package com.cookandroid.tempu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_temp_record.*
import java.util.*
import kotlin.collections.ArrayList

class TempRecordActivity : AppCompatActivity() {
    private val DAY_OF_WEEK = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_record)
        var calendar = Calendar.getInstance()

        var list: ArrayList<String> = ArrayList()

        addDayOfWeek(list)
        makeHeader(calendar.clone() as Calendar, list)
        val maximumDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        for(i in 1..maximumDay) list.add(i.toString())
        makeTail(calendar.clone() as Calendar, list)
        calendarLayout.post {
            val height = calendarLayout.height
            val width = calendarLayout.width
            tempRecordCustomCalendar.layoutManager = GridLayoutManager(applicationContext, DAY_OF_WEEK)
            tempRecordCustomCalendar.adapter = CustomCalendarRecyclerViewAdapter(list, height, width)

        }
    }
    private fun makeHeader(calendar: Calendar, list: ArrayList<String>){
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1) // calendar 객체의 달을 전 달로 설정
        val prevMaxDate = calendar.getActualMaximum(Calendar.DATE)

        val maxDayOfPrevMonth = calendar.get(Calendar.DAY_OF_WEEK)

        val header = (prevMaxDate - maxDayOfPrevMonth) % DAY_OF_WEEK

        for(i in 1..header) list.add("")
    }
    private fun addDayOfWeek(list: ArrayList<String>){
        val days = listOf("일", "월", "화", "수", "목", "금", "토")
        for(day in days) list.add(day)
    }
    private fun makeTail(calendar: Calendar, list: ArrayList<String>){
        for(i in 1..49 - list.size) list.add("")
    }
}