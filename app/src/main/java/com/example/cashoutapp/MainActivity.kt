package com.example.cashoutapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //make full screen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //start button click
        btn_add.setOnClickListener {

            if(et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter the store name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(Constants.STORE_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }

            val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

            val storeName = sharedPref.getString(Constants.STORE_NAME, "Store Name")
            val totalAmount = sharedPref.getInt(Constants.TOTAL_AMOUNT, 0)


        }




           btn_refresh.setOnClickListener{
               et_amount.setText("")
               et_name.setText("")
               tv_amount.setText("0")
               tv_last.setText("Last Amount Spend at None")
           }

        }

    }
