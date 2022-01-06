package com.cookandroid.tempu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_temp_record.*
import java.util.*
import kotlin.collections.ArrayList

class TempRecordActivity : AppCompatActivity() {
    private val DAY_OF_WEEK = 7
    lateinit var calendar: Calendar
    var list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_record)
        recordBackBtn.setOnClickListener{
            finish()
        }
        calendar = Calendar.getInstance()

        makeCalendar()
        var adapter = ArrayAdapter.createFromResource(this, R.array.calendar2022, R.layout.support_simple_spinner_dropdown_item)
        calendarSpinner.adapter = adapter
        calendarSpinner.onItemSelectedListener = onSelectedListener
    }
    private var onSelectedListener = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            var selectedDateString = calendarSpinner.selectedItem.toString().substring(0, 2)
            var selectedDateInt = selectedDateString.toInt()
            tempRecordMonth.text = selectedDateString + "월"
            calendar.set(Calendar.MONTH, selectedDateInt - 1)
            makeCalendar()
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
            TODO("Not yet implemented")
        }

    }
    private fun makeCalendar(){
        list.clear()
        addDayOfWeek(list)
        makeHeader(calendar.clone() as Calendar, list)
        val maximumDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        for(i in 1..maximumDay) list.add(i.toString())
        makeTail(list)
        calendarLayout.post {
            val height = calendarLayout.height
            val width = calendarLayout.width
            tempRecordCustomCalendar.layoutManager = GridLayoutManager(applicationContext, DAY_OF_WEEK)
            tempRecordCustomCalendar.adapter = CustomCalendarRecyclerViewAdapter(list, height, width)

        }
    }
    private fun makeHeader(calendar: Calendar, list: ArrayList<String>){
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1) // calendar 객체의 달을 전 달로 설정
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))

        val maxDayOfPrevMonth = calendar.get(Calendar.DAY_OF_WEEK)

        for(i in 1..(maxDayOfPrevMonth % 7)) list.add("")
    }
    private fun addDayOfWeek(list: ArrayList<String>){
        val days = resources.getStringArray(R.array.DaysOfWeek)
        for(day in days) list.add(day)
    }
    private fun makeTail(list: ArrayList<String>){
        for(i in 1..49 - list.size) list.add("")
    }
}