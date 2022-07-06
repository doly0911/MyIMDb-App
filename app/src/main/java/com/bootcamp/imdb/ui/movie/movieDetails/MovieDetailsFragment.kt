package com.bootcamp.imdb.ui.movie.movieDetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bootcamp.imdb.R
import com.bootcamp.imdb.data.local.dataSource.AppDataBase
import com.bootcamp.imdb.data.local.dataSource.MovieLocalDataSource
import com.bootcamp.imdb.data.remote.dataSources.movie.MovieRemoteDataSource
import com.bootcamp.imdb.domain.remote.movie.MovieRepositoryImpl
import com.bootcamp.imdb.data.remote.RetrofitClient
import com.bootcamp.imdb.databinding.FragmentMovieDetailsBinding
import com.bumptech.glide.Glide
import kotlin.properties.Delegates

class MovieDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailsBinding
    private var movieId by Delegates.notNull<Int>()

    //Inyeccion de dependencias manual
    private val viewModel by viewModels<MovieDetailsViewModel> {
        MovieDetailsViewModel.MovieDetailsViewModelFactory(MovieRepositoryImpl(
            MovieRemoteDataSource((RetrofitClient.webService)),
            MovieLocalDataSource(AppDataBase.getInstance(requireContext()).movieDao())
        ))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //Recuperar argumento enviado
        val args = arguments?.let { MovieDetailsFragmentArgs.fromBundle(it) }
        movieId = args!!.movieId

        viewModel.getDetails(movieId)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailsBinding.bind(view)

        viewModel.movieDetailsResponse.observe(viewLifecycleOwner, Observer {
            it?.let {
                it?.id.let { id ->
                    binding.titleMovie.text = it.title
                    binding.titleOriginal.text = it.original_title
                    binding.subtitleDetailsMovieTxt.text = it.original_language
                    binding.rating.text = it.vote_average.toString()
                    binding.description.text = it.overview
                    Glide.with(requireContext())
                        .load("https://image.tmdb.org/t/p/original${it.poster_path}")
                        .into(binding.movieImage)

                    Log.d("movieDetailsFragment", "Video desde uri: ${it.video}")
                }
            }
        })

    }


}