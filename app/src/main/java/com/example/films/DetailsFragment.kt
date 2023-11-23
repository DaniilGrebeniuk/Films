package com.example.films


import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailsFragment : Fragment() {
    init {
        enterTransition = Slide(Gravity.TOP).apply { duration = 600; }
        returnTransition = Slide(Gravity.TOP).apply { duration = 600;mode = Slide.MODE_OUT }
    }
    private lateinit var film: Film
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFilmsDetails(view)
        sendToFriend()
    }

    private fun setFilmsDetails(view: View) {
        film = arguments?.get("film") as Film

        view.findViewById<AppCompatImageView>(R.id.details_poster).setImageResource(film.poster)
        view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.details_toolbar).title =
            film.title
        view.findViewById<TextView>(R.id.details_description).text = film.description

    }

    private fun sendToFriend() {
        view?.findViewById<FloatingActionButton>(R.id.details_fab)?.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Посмотри этот фильм: ${film.title} \n\n ${film.description}"
            )
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))

        }
    }
    private fun onOffFavorites() {
        view?.findViewById<FloatingActionButton>(R.id.favorites)?.setOnClickListener{
            if (!film.isInFavorites) {
                view?.findViewById<FloatingActionButton>(R.id.favorites)?.setImageResource(R.drawable.baseline_favorite_no)
            film.isInFavorites = true
            }else {
                view?.findViewById<FloatingActionButton>(R.id.favorites)?.setImageResource(R.drawable.baseline_favorite)
                film.isInFavorites = false

            }
        }
    }


}