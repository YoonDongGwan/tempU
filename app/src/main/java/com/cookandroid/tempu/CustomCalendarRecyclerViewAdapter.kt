package com.cookandroid.tempu

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.calendar_item.view.*

class CustomCalendarRecyclerViewAdapter(val date: ArrayList<String>, val height: Int, val width: Int): RecyclerView.Adapter<CustomCalendarRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private var v: View = view

        fun bind(item: String, height: Int, width: Int){
            v.calendarItemDay.layoutParams.height = height / 7
            v.calendarItemDay.layoutParams.width = width / 7
            v.calendarItemDay.text = item
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomCalendarRecyclerViewAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.calendar_item, parent, false)
        return CustomCalendarRecyclerViewAdapter.ViewHolder(inflatedView)

    }

    override fun onBindViewHolder(holder: CustomCalendarRecyclerViewAdapter.ViewHolder, position: Int) {
        val item = date[position]
        holder.bind(item, height, width)
    }

    override fun getItemCount(): Int {
        return date.size
    }
}