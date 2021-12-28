package com.cookandroid.tempu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val change_nickname_btn=findViewById<ImageButton>(R.id.change_nickname_btn);
        change_nickname_btn.setOnClickListener {
            val Intent = Intent(this, NicknameChangePopup::class.java)
            startActivity(Intent)
        }
    }
}