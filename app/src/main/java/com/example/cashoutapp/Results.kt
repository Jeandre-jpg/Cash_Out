package com.example.cashoutapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

    class ResultActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val storeName = intent.getStringExtra(Constants.STORE_NAME)
            val totalAmount = intent.getIntExtra(Constants.TOTAL_AMOUNT, 0)

            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

            val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            editor.apply{
                putString(Constants.STORE_NAME, storeName)
                putInt(Constants.TOTAL_AMOUNT, totalAmount)
                apply()
            }

    }
}