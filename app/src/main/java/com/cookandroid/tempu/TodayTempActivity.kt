package com.cookandroid.tempu

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_today_bet.*
import kotlinx.android.synthetic.main.activity_today_temp.*
import kotlinx.android.synthetic.main.activity_today_temp.edit_temp
import kotlinx.android.synthetic.main.activity_today_temp.progressBar
import java.text.SimpleDateFormat
import java.util.*

class TodayTempActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today_temp)

        val long_now = System.currentTimeMillis()
        val t_date = Date(long_now)
        val t_dateFormat = SimpleDateFormat("yyyy-MM-dd (E)", Locale("ko", "KR"))
        val str_date = t_dateFormat.format(t_date)
        today_temp_date.setText("Today. "+str_date)

        today_temp_submit_btn.setOnClickListener(onClickListener)
        today_temp_back.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { v ->
        when (v?.id) {
            R.id.today_temp_submit_btn -> {
                progressBar.setProgress(Integer.parseInt(edit_temp.text.toString()))
            }
            R.id.today_temp_back -> {
                finish()
            }
        }
    }
}