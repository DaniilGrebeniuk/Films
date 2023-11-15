package com.example.films

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.films.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter


    private val filmDataBase = listOf(
        Film("WandaVision",R.drawable.poster_6,"Blends the style of classic sitcoms with the MCU, in which Wanda Maximoff and Vision - two super-powered beings living their ideal suburban lives - begin to suspect that everything is not as it seems."),
        Film("American Fiction",R.drawable.poster_5,"A novelist who's fed up with the establishment profiting from \"Black\" entertainment uses a pen name to write a book that propels him to the heart of hypocrisy and the madness he claims to disdain."),
        Film("Loki",R.drawable.poster_7,"The mercurial villain Loki resumes his role as the God of Mischief in a new series that takes place after the events of “Avengers: Endgame.”"),
        Film("Beekeeper",R.drawable.poster_8,"In The Beekeeper, one man's brutal campaign for vengeance takes on national stakes after he is revealed to be a former operative of a powerful and clandestine organization known as \"Beekeepers\"."),
        Film("Mandalorian",R.drawable.poster_9,"The travels of a lone bounty hunter in the outer reaches of the galaxy, far from the authority of the New Republic."),
        Film("Book Of Boba Fett",R.drawable.poster_10,"Bounty hunter Boba Fett and mercenary Fennec Shand navigate the underworld when they return to Tatooine to claim Jabba the Hutt's old turf."),
        Film("Boys in the Boat",R.drawable.poster_11,"A 1930s-set story centered on the University of Washington's rowing team, from their Depression-era beginnings to winning gold at the 1936 Berlin Olympics."),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //initializing the binding class
        setContentView(binding.root)

        binding.mainRecycler.apply {
         filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
             override fun click(film: Film) {
                 val bundle = Bundle()
                 bundle.putParcelable("film",film)
                 val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                 intent.putExtras(bundle)
                 startActivity(intent)
             }
         })
         //Присваиваем адаптер
         adapter = filmsAdapter
         //Присвои layoutmanager
         layoutManager = LinearLayoutManager(this@MainActivity)
         //Применяем декоратор для отступов
         val decorator = TopSpacingItemDecoration(8)
         addItemDecoration(decorator)
     }
        filmsAdapter.addItems(filmDataBase)
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