package com.example.films

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.films.databinding.ActivityMainBinding

class HomeFragment : Fragment() {

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.main_recycler).apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmDataBase)
    }
}

