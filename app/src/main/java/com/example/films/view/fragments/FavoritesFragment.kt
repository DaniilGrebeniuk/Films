package com.example.films.view.fragments

import android.os.Bundle
import android.transition.Fade
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.films.view.MainActivity
import com.example.films.view.rv_adapter.FilmListRecyclerAdapter
import com.example.films.view.rv_adapter.TopSpacingItemDecoration
import com.example.films.databinding.FragmentFavoritesBinding
import com.example.films.domain.Film
import com.example.films.utils.AnimationHelper
import com.example.films.viewmodel.HomeFragmentViewModel

class FavoritesFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(HomeFragmentViewModel::class.java)

    }
    private var filmDataBase = mutableListOf<Film>()
        set(value) {
            if (field == value) return
            field = value
            filmsAdapter.addItems(field)
        }

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    private lateinit var binding: FragmentFavoritesBinding

    init {
        exitTransition = Fade()
        reenterTransition = Fade()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(requireView(), requireActivity(), 2)

        ininFavoritRC()

        viewModel.filmListLiveData.observe(viewLifecycleOwner) {filmDataBase.filter { it.isInFavorites }
        }


    }

    private fun ininFavoritRC() = with(binding) {
        favoritesRecycler.apply {

            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)

                    }
                })
            favoritesRecycler.adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            /* val t = Scroll(favoritesRecycler.adapter as FilmListRecyclerAdapter)
             val collback = ItemTouchHelper(t)
             collback.attachToRecyclerView(favoritesRecycler)
             */
            val decoration = TopSpacingItemDecoration(8)
            addItemDecoration(decoration)


        }

    }


}

