package com.bootcamp.imdb.data.repositories

import com.bootcamp.imdb.R
import com.bootcamp.imdb.data.models.Movie

class MovieRepository: IMovieRepository {

    override fun findBestMovies(): List<Movie> {
        return listOf(
                Movie("Dune", "2021", "Timothée Chalamet, Rebecca Ferguson, Zendaya","Acción","Adaptación de la novela de ciencia ficción de Frank Herbert, sobre el hijo de una familia noble encargada de proteger un planeta especiado.", 8.0f, R.drawable.img_dune),
                Movie("The Suicide Squad", "2021", "Margot Robbie", "Acción","Los villanos Harley Quinn, Bloodsport, Peacemaker y una colección de estafadores en la prisión de Belle Reve se unen al grupo de trabajo súper secreto y súper sombrío X", 7.2f, R.drawable.img_the_suicide_squad ),
                Movie("Free Guy", "2021", "Ryan Reynolds", "Comedia", "Un empleado de banco descubre que en realidad es un personaje dentro de un videojuego.", 7.1f, R.drawable.img_free_guy),
                Movie("Queenpins", "2021", "Queenpins", "Comedia", "Un par de amas de casa crean una estafa de cupones de 40 millones de dólares.", 6.3f, R.drawable.img_queenpins),
                Movie("The Queens Gambit", "2020", "Anya Taylor-Joy", "Drama", "Ambientada en la Guerra Fría; una huérfana llamada Beth Harmon con un don para el ajedrez lucha contra las adicciones mientras intenta ser la mejor jugadora del mundo.", 8.6f, R.drawable.img_queen_gambit),
                Movie("Marvel", "2020", "Jesse Falcon", "Documental", "Los impactos históricos, culturales y sociales del Universo Marvel Comics y su intersección con el mundo.", 6.4f, R.drawable.img_marvel ))
    }

    override fun findAllMovies(): List<Movie>{
        return listOf(
                Movie("Queen of the South", "2016", "Alice Braga, Hemky Madera", "Crimen", "Teresa huye de México después de que su novio narcotraficante sea asesinado. Estableciéndose en Dallas, busca convertirse en la contrabandista reinante del país y vengar el asesinato de su amante.", 7.9f, R.drawable.img_queen_of_south),
                Movie("Queen Sugar", "2016", "Rutina Wesley, Dawn-Lyen Gardner", "Drama", "Tres hermanos se mudan a Luisiana para reclamar la herencia de su padre recientemente fallecido: una granja con 800 acres de caña de azúcar.", 7.5f,  R.drawable.img_queen_sugar),
                Movie("Queen", "2013", "Kangana Ranaut, Rajkummar Rao", "Aventura", "Una chica de Delhi de una familia tradicional emprende una luna de miel en solitario después de que su matrimonio sea cancelado.", 8.1f, R.drawable.img_queen),
                Movie("Queenpins", "2021", "Queenpins", "Comedia", "Un par de amas de casa crean una estafa de cupones de 40 millones de dólares.", 6.3f, R.drawable.img_queenpins),
                Movie("The Queens Gambit", "2020", "Anya Taylor-Joy", "Drama", "Ambientada en la Guerra Fría; una huérfana llamada Beth Harmon con un don para el ajedrez lucha contra las adicciones mientras intenta ser la mejor jugadora del mundo.", 8.6f, R.drawable.img_queen_gambit),
                Movie("Marvel", "2020", "Jesse Falcon", "Documental", "Los impactos históricos, culturales y sociales del Universo Marvel Comics y su intersección con el mundo.", 6.4f, R.drawable.img_marvel)
        )
    }
}