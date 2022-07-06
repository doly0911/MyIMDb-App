package com.bootcamp.imdb.ui.movie.movieList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.imdb.R
import com.bootcamp.imdb.data.local.dataSource.AppDataBase
import com.bootcamp.imdb.data.local.dataSource.MovieLocalDataSource
import com.bootcamp.imdb.data.remote.dataSources.movie.MovieRemoteDataSource
import com.bootcamp.imdb.domain.remote.movie.MovieRepositoryImpl
import com.bootcamp.imdb.data.remote.RetrofitClient
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.databinding.FragmentMovieListBinding

class MovieListFragment : Fragment(), MovieAdapter.MovieAdapterOnClickListener {

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var viewModelFactory : MovieViewModelFactory
    private lateinit var viewModel : MovieViewModel

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
        viewModelFactory = MovieViewModelFactory(
            MovieRepositoryImpl(
                MovieRemoteDataSource(RetrofitClient.webService),
                MovieLocalDataSource(AppDataBase.getInstance(requireContext()).movieDao())
            )
        )
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)

        viewModel.moviesList.observe(viewLifecycleOwner,{
            viewAdapter.submitList(it?.results)
        })

        binding.searchViewMovie.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchMovie(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchMovie(newText!!)
                return false
            }
        })

    }

    override fun movieCardOnclick(movie: Movie, view: View) {
        movie.id.let {
            view.findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(it))
        }

    }
}