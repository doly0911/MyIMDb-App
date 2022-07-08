package com.bootcamp.imdb.domain.remote.movie

import android.util.Log
import com.bootcamp.imdb.data.local.models.MovieEntity
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.domain.FakeErrorMovieRemoteDataSource
import com.bootcamp.imdb.domain.FakeMovieLocalDataSource
import com.bootcamp.imdb.domain.FakeMovieRemoteDataSource
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsSame
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieRepositoryTest {
    private val movieRemote1 = Movie(1, false, "path", "title", "en", "text", 5.0,
    "path2", "date", "marvel", false, 4.5, 3, "type" )
    private val movieRemote2 = Movie(2, false, "path", "title", "en", "text", 5.0,
        "path2", "date", "title2", false, 4.5, 3, "type" )

    private val remoteMovies = listOf(movieRemote1, movieRemote2).sortedBy { it.id }
    private val localMovies = mutableListOf<Movie>()

    private lateinit var movieRemoteDataSource: FakeMovieRemoteDataSource
    private lateinit var movieLocalDataSource: FakeMovieLocalDataSource
    private lateinit var movieRepository: MovieRepositoryImpl


    private val initialLocalMovies = listOf(movieRemote1, movieRemote2).sortedBy { it.id }

    private lateinit var errorMovieRemoteDataSource: FakeErrorMovieRemoteDataSource
    private lateinit var movieLocalDataSourceWithInitData: FakeMovieLocalDataSource
    private lateinit var errorMovieRepository: MovieRepositoryImpl

    @Before
    fun createRepository(){
        movieRemoteDataSource = FakeMovieRemoteDataSource(remoteMovies.toMutableList())
        movieLocalDataSource = FakeMovieLocalDataSource(localMovies)
        movieRepository = MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource)

        errorMovieRemoteDataSource = FakeErrorMovieRemoteDataSource()
        movieLocalDataSourceWithInitData = FakeMovieLocalDataSource(initialLocalMovies.toMutableList())
        errorMovieRepository = MovieRepositoryImpl(errorMovieRemoteDataSource, movieLocalDataSourceWithInitData)

        mockkStatic(Log::class)
        every { Log.v(any(), any()) } returns 0
        every { Log.d(any(), any()) } returns 0
        every { Log.i(any(), any()) } returns 0
        every { Log.e(any(), any()) } returns 0
    }

    @Test
    fun getMovies_requestTopMoviesFromRemoteDataSource() = runBlockingTest {

        //When
        val topMovies = movieRepository.findTopRatedMovies()

        //Then
        assertThat(topMovies.results, IsEqual(localMovies))

    }

    @Test
    fun getMovies_requestTopMoviesFromLocalDataSource() = runBlockingTest {

        //When
        val topMovies = errorMovieRepository.findTopRatedMovies()

        //Then
        assertThat(topMovies.results, IsEqual(initialLocalMovies))

    }

    @Test
    fun findMovie_requestSearchMovieFromRemoteDataSource() = runBlockingTest {
        //When
        val searchedMovie = movieRepository.findMovie("marvel")

        //Then
        assertThat(searchedMovie.results, IsEqual(listOf(movieRemote1)))
    }

}