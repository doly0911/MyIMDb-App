package com.bootcamp.imdb.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.imdb.R
import com.bootcamp.imdb.ui.adapters.MovieAdapter
import com.bootcamp.imdb.databinding.FragmentMovieListBinding

class MovieListFragment : Fragment(), MovieAdapter.MovieAdapterOnClickListener {

    private lateinit var binding: FragmentMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieListBinding.bind(view)

        //RecyclerView
        val viewAdapter = MovieAdapter(this)
        binding.recyclerViewMovieList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter =viewAdapter
        }


    }

    override fun movieCardOnclick(view: View) {
        view.findNavController().navigate(R.id.action_movieListFragment_to_movieDetailsFragment)
    }
}