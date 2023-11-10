package com.example.films

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val setOnListenerB1 = findViewById<Button>(R.id.button_1)
        val setOnListenerB2 = findViewById<Button>(R.id.button_2)
        val setOnListenerB3 = findViewById<Button>(R.id.button_3)
        val setOnListenerB4 = findViewById<Button>(R.id.button_4)
        val setOnListenerB5 = findViewById<Button>(R.id.button_5)
        setOnListenerB1.setOnClickListener {
            Toast.makeText(this, R.string.button_1, Toast.LENGTH_SHORT).show()
        }
        setOnListenerB2.setOnClickListener {
            Toast.makeText(this, R.string.button_2, Toast.LENGTH_SHORT).show()
        }
        setOnListenerB3.setOnClickListener {
            Toast.makeText(this, R.string.button_3, Toast.LENGTH_SHORT).show()
        }
        setOnListenerB4.setOnClickListener {
            Toast.makeText(this, R.string.button_4, Toast.LENGTH_SHORT).show()
        }
        setOnListenerB5.setOnClickListener {
            Toast.makeText(this, R.string.button_5, Toast.LENGTH_SHORT).show()
        }

    }
}