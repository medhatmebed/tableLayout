package com.example.tablelayout


import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBtn.setOnClickListener { 
        var androidVersion = androidCodeEditTxt.text.toString()
            var androidCode = androidCodeEditTxt.text.toString()  
            if (androidCode.isNotEmpty() && androidVersion.isNotEmpty()) {
                addNewRow(androidVersion,androidCode)
            }else {
                Toast.makeText(this, "please add text", Toast.LENGTH_SHORT).show()
            }
        }
    }
    @SuppressLint("Range")
    fun addNewRow(version:String, code:String){

        // Create a new table row.
        val tableRow = TableRow(getApplicationContext())
        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT)
        tableRow.setLayoutParams(layoutParams)
        tableRow.setBackgroundColor(Color.WHITE)
        tableRow.setPadding(1,10,1,3)


        val verTextView = TextView(this)
        verTextView.textSize = 28f
        verTextView.text = version
        verTextView.gravity = Gravity.CENTER


        verTextView.setBackgroundColor(Color.parseColor("#F44336"))

        val codeTextView = TextView(this)
        codeTextView.textSize = 28f
        codeTextView.text = code
        codeTextView.gravity = Gravity.CENTER
        codeTextView.setBackgroundColor(Color.parseColor("#F44336"))

        // add values into row by calling addView()
        tableRow.addView(verTextView,0)
        tableRow.addView(codeTextView,1)
        // Finally add the created row row into layout


        tblView.addView(tableRow) // id from Layout_file

    }
}