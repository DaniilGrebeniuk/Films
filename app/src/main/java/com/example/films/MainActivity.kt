package com.example.films

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.films.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //initializing the binding class
        setContentView(binding.root)
        val annotation = AnimationUtils.loadAnimation(this, R.anim.poster_animation)
        binding.topAppbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, R.string.Settings, Toast.LENGTH_SHORT).show()
                    annotation.start()

                    true
                }
                else -> false
            }
        }

        binding.navigationBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, R.string.Favorites, Toast.LENGTH_SHORT).show()

                    true
                }
                R.id.view_later -> {
                    Toast.makeText(this, R.string.ViewLater, Toast.LENGTH_SHORT).show()
                    true

                }
                R.id.stands -> {
                    Toast.makeText(this, R.string.Stands, Toast.LENGTH_SHORT).show()
                    true

                }
                else -> false
            }
        }
    }
}