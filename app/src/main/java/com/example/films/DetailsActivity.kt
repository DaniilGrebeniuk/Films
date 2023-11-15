package com.example.films


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val film = intent.extras?.get("film") as Film
        findViewById<AppCompatImageView>(R.id.details_poster).setImageResource(film.poster)
        findViewById<androidx.appcompat.widget.Toolbar>(R.id.details_toolbar).title = film.title
        findViewById<TextView>(R.id.details_description).text = film.description

        findViewById<FloatingActionButton>(R.id.favarite).setOnClickListener{
            Toast.makeText(this,"В избранное",Toast.LENGTH_SHORT).show()
        }
        findViewById<FloatingActionButton>(R.id.watch_later).setOnClickListener{
            Toast.makeText(this,"Смотреть позже",Toast.LENGTH_SHORT).show()
        }
    }
}