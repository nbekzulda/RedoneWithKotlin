package com.example.kotlinsharedpreferernces

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent







class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)


        save.setOnClickListener {
            val data = editText.text.toString().trim()

            val editor = sharedPreferences.edit()
            editor.putString("data", data)
            editor.apply()
            Toast.makeText(this, "Data is saved", Toast.LENGTH_LONG).show()
            editText.setText("")

        }

        load.setOnClickListener {
            val data = sharedPreferences.getString("data", "")

            editText.setText(data)
            Toast.makeText(this, "Data is loaded", Toast.LENGTH_LONG).show()
        }


        share.setOnClickListener {
            val mSharingIntent = Intent(Intent.ACTION_SEND)
            mSharingIntent.type = "text/plain"
            mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "text")
            mSharingIntent.putExtra(Intent.EXTRA_TEXT, editText.text.toString())
            startActivity(Intent.createChooser(mSharingIntent, "Share text via"))
        }
    }
}
