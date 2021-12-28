package com.cookandroid.tempu

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NicknameChangePopup: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nickname_change);
    }
}

        //(context: Context, Interface: CustomDialogInterface) : Dialog(context) {
//
//    // 액티비티에서 인터페이스를 받아옴
//    private var customDialogInterface: CustomDialogInterface = Interface
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.nickname_change)
//
//
//
//        // 배경을 투명하게함
//        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))