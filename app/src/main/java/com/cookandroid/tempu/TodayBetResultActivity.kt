package com.cookandroid.tempu

import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_today_bet.*
import kotlinx.android.synthetic.main.activity_today_bet.today_bet_date
import kotlinx.android.synthetic.main.activity_today_bet_result.*
import java.text.SimpleDateFormat
import java.util.*

class TodayBetResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today_bet_result)

        val long_now = System.currentTimeMillis()
        val t_date = Date(long_now)
        val t_dateFormat = SimpleDateFormat("yyyy-MM-dd (E)", Locale("ko", "KR"))
        val str_date = t_dateFormat.format(t_date)
        today_bet_result_date.setText("Today. "+str_date)

        today_bet_result_back.setOnClickListener(onClickListener)
        today_bet_home.setOnClickListener(onClickListener)
    }
    private val onClickListener = View.OnClickListener { v ->
        when(v?.id){
            R.id.today_bet_result_back ->{
                finish()
            }
            R.id.today_bet_home ->{
            }
        }
    }


}

