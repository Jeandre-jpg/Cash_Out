package com.example.rona

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cashoutapp.Constants
import com.example.cashoutapp.R
import kotlinx.android.synthetic.main.activity_main.*


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val storeName = intent.getStringExtra(Constants.STORE_NAME)
        val totalAmount = intent.getIntExtra(Constants.TOTAL_AMOUNT, 0)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply {
            putString(Constants.STORE_NAME, storeName)
            putInt(Constants.TOTAL_AMOUNT, totalAmount)

            apply()
        }

        btn_refresh.setOnClickListener{
          tv_last.setText("")
            tv_amount.setText("")
        }
    }
}