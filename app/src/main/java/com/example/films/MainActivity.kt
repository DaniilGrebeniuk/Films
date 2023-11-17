package com.example.films

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.films.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigation()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()


    }

    fun launchDetailsFragment(film: Film) {
        val bundle = Bundle()

        bundle.putParcelable("film", film)

        val fragment = DetailsFragment()

        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun initNavigation() {
        findViewById<BottomNavigationView>(R.id.navigation_bar).setOnNavigationItemSelectedListener {
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

    override fun onBackPressed() {
       if (supportFragmentManager.backStackEntryCount==1){
        AlertDialog.Builder(ContextThemeWrapper(this,R.style.MyDialog))
            .setTitle("Вы хотите выйти?")
            .setIcon(R.drawable.baseline_exit_to_app_24)
            .setPositiveButton("Да") { _, _ ->
                finish()
            }
            .setNegativeButton("Нет") { _, _ ->


            }
            .setNeutralButton("Не знаю") { _, _ ->
                Toast.makeText(this, "Решайся", Toast.LENGTH_SHORT).show()
            }
            .show()
       }else {
           super.onBackPressed()
       }
    }



}