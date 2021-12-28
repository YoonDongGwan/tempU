package com.cookandroid.tempu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todayTemp.setOnClickListener(onClickListener)
        todayBet.setOnClickListener(onClickListener)
        tempRecord.setOnClickListener(onClickListener)
        hallOfFame.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { v ->
        when (v?.id) {
            R.id.todayTemp -> {
                intent = Intent(applicationContext, TodayTempActivity::class.java)
            }
            R.id.todayBet ->{
                intent = Intent(applicationContext, TodayBetActivity::class.java)
            }
            R.id.tempRecord ->{
                intent = Intent(applicationContext, TempRecordActivity::class.java)
            }
            R.id.hallOfFame ->{
                intent = Intent(applicationContext, HallOfFameActivity::class.java)
            }
        }
        startActivity(intent)
    }
}