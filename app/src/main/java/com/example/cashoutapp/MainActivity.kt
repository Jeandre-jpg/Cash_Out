package com.example.cashoutapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btn_add = findViewById<Button>(R.id.btn_add)

        val tv_amount = findViewById<TextView>(R.id.tv_amount)
        val tv_last = findViewById<TextView>(R.id.tv_last)

        val et_amount = findViewById<EditText>(R.id.et_amount)
        val et_name = findViewById<EditText>(R.id.et_name)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        val storeName = sharedPref.getString(Constants.STORE_NAME, "Store Name")
        var totalAmount = sharedPref.getInt(Constants.TOTAL_AMOUNT, 0)

        tv_last.text = "$storeName"
        tv_amount.text = "$totalAmount"

        et_name.text.insert(0, "$storeName")
        et_amount.text.insert(0, "$totalAmount")

        btn_add.setOnClickListener {

            val editor = sharedPref.edit()
            editor.putString(Constants.STORE_NAME, tv_last.text.toString())

            val sum = totalAmount + Integer.parseInt(et_amount.text.toString())
            editor.putInt(Constants.TOTAL_AMOUNT, sum)

            tv_last.text = "Last Amount Spent at " + et_name.text.toString()

            tv_amount.text = sum.toString()
            editor.apply()
            totalAmount = sum

            et_amount.text.clear()
            et_name.text.clear()

            if(et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter the store name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(Constants.STORE_NAME, tv_last.text.toString())
                startActivity(intent)
                finish()
            }
        }

           btn_refresh.setOnClickListener{
               et_amount.setText("")
               et_name.setText("")
               tv_amount.setText("0")
               tv_last.setText("Last Amount Spend at None")
           }

        }

    }
