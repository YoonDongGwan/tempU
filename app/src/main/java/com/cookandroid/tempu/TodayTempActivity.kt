package com.cookandroid.tempu

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_today_temp.*

class TodayTempActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today_temp)

        today_temp_submit_btn.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { v ->
        when (v?.id) {
            R.id.today_temp_submit_btn -> {
                progressBar.setProgress(Integer.parseInt(edit_temp.text.toString()))
            }
        }
    }
}