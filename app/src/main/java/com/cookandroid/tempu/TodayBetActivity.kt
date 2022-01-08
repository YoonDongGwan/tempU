package com.cookandroid.tempu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.android.synthetic.main.activity_today_bet.*

class TodayBetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today_bet)

        today_bet_back.setOnClickListener(onClickListener)
        today_bet_confirm_btn.setOnClickListener(onClickListener)

        val long_now = System.currentTimeMillis()
        val t_date = Date(long_now)
        val t_dateFormat = SimpleDateFormat("yyyy-MM-dd (E)", Locale("ko", "KR"))
        val str_date = t_dateFormat.format(t_date)
        today_bet_date.setText("Today. "+str_date)
    }
    private val onClickListener = View.OnClickListener { v->
        when(v?.id){
            R.id.today_bet_back ->{
                finish()
            }
            R.id.today_bet_confirm_btn->{
                intent=Intent(this, TodayBetResultActivity::class.java)
                startActivity(intent)
            }

        }
    }

}