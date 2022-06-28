package com.bootcamp.imdb.ui.movie.movieDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bootcamp.imdb.R
import com.bootcamp.imdb.data.remote.dataSources.movie.MovieRemoteDataSource
import com.bootcamp.imdb.domain.remote.movie.MovieRepositoryImpl
import com.bootcamp.imdb.data.repositories.RetrofitClient
import com.bootcamp.imdb.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailsBinding

    //Inyeccion de dependencias manual
    private val viewModel by viewModels<MovieDetailsViewModel> {
        MovieDetailsViewModel.MovieDetailsViewModelFactory(MovieRepositoryImpl(MovieRemoteDataSource((RetrofitClient.webService))))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailsBinding.bind(view)
    }


}