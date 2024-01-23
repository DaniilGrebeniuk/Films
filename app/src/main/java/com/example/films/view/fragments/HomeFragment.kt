package com.example.films.view.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.transition.Fade
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.films.*
import com.example.films.databinding.MergeHomeScreenContentBinding
import com.example.films.domain.Film
import com.example.films.utils.AnimationHelper
import com.example.films.view.rv_adapter.FilmListRecyclerAdapter
import com.example.films.view.rv_adapter.TopSpacingItemDecoration
import com.example.films.viewmodel.HomeFragmentViewModel
import com.example.films.view.MainActivity
import java.util.*


class HomeFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(HomeFragmentViewModel::class.java)

    }

    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private lateinit var binding: MergeHomeScreenContentBinding

    private var filmDataBase = mutableListOf<Film>()
        set(value) {
            if (field == value) return
            field = value
            filmsAdapter.addItems(field)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    retainInstance = true
    }

    init {
        exitTransition = Fade()
        reenterTransition = Fade()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = MergeHomeScreenContentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root


    }

    override fun onStart() {
        super.onStart()
        binding.mainRecycler.setOnClickListener {
            val a = activity as FragmentActivity
            a.supportFragmentManager.beginTransaction()
                .replace(R.id.main_recycler, DetailsFragment()).addToBackStack(null).commit()
        }
    }


    @SuppressLint("CutPasteId")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(
            binding.homeFragmentRoot,
            requireActivity(),
            1
        )
        initSearchView()
        initRecycler()

        viewModel.filmListLiveData.observe(viewLifecycleOwner) { filmDataBase =
            it as MutableList<Film>

        }



    }

    private fun initSearchView() {
        binding.searchView.setOnClickListener {
            binding.searchView.isIconified =
                false
        }
        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    if (newText.isEmpty()) {
                        filmsAdapter.addItems(filmDataBase)
                        return true
                    }
                }
                val result = filmDataBase.filter {
                    it.title.lowercase(Locale.getDefault())
                        .contains(newText!!.lowercase(Locale.getDefault()))
                }
                filmsAdapter.addItems(result)
                return true
            }

        })

    }

    private fun initRecycler() {
        binding.mainRecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
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


    }
    /*  binding.mainRecycler.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
                if (scrollY > oldScrollY) {
                    binding.searchView.visibility =
                        View.GONE

                } else {
                   binding.searchView.visibility =
                        View.VISIBLE
                }
            }
*/


}

