package com.example.films.view.fragments


import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.films.R
import com.example.films.databinding.FragmentDetailsBinding
import com.example.films.domain.Film

class DetailsFragment : Fragment() {
private lateinit var binding: FragmentDetailsBinding
    private lateinit var film: Film
    init {
        exitTransition = Fade()
        reenterTransition = Fade()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFilmsDetails(view)
        sendToFriend()
        onOffFavorites()
    }

    private fun setFilmsDetails(view: View) = with(binding) {
        film = arguments?.get("film") as Film
        detailsPoster.setImageResource(film.poster)
        detailsToolbar.title = film.title
        detailsDescription.text = film.description
    }


    private fun sendToFriend() {
        binding.detailsFab.setOnClickListener {
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

     private fun onOffFavorites() = with(binding) {
        favariteq.setImageResource(
            if (film.isInFavorites) R.drawable.baseline_favorite
            else R.drawable.baseline_favorite_no

        )
        favariteq.setOnClickListener {
            if (!film.isInFavorites) {
                favariteq.setImageResource(R.drawable.baseline_favorite)
                film.isInFavorites = true



            } else {
                favariteq.setImageResource(R.drawable.baseline_favorite_no)
                film.isInFavorites = false
            }
        }


    }


}


