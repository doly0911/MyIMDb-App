package com.bootcamp.imdb.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.imdb.R
import com.bootcamp.imdb.data.remote.dataSources.movie.MovieRemoteDataSource
import com.bootcamp.imdb.domain.remote.movie.MovieRepositoryImpl
import com.bootcamp.imdb.data.repositories.RetrofitClient
import com.bootcamp.imdb.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), HomeAdapter.HomeAdapterOnClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModelFactory: HomeViewModel.HomeViewModelFactory
    private lateinit var viewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val viewAdapter = HomeAdapter(this)
        binding.recyclerViewMejoresSelecciones.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = viewAdapter
        }


        viewModelFactory = HomeViewModel.HomeViewModelFactory(
            MovieRepositoryImpl(
                MovieRemoteDataSource(
                    RetrofitClient.webService
                )
            )
        )
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        viewModel.getPopularMovies()

        viewModel.moviesList.observe(viewLifecycleOwner,{
            viewAdapter.submitList(it?.results)
        })
    }

    override fun movieCardOnclick(view: View) {
        //view.findNavController().navigate(R.id.action_movieListFragment_to_movieDetailsFragment)
    }
}