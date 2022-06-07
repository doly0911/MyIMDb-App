package com.bootcamp.imdb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.imdb.R
import com.bootcamp.imdb.data.models.Movie
import com.bootcamp.imdb.data.repositories.MovieRepository

class HomeAdapter:RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var repository = MovieRepository()
    private var bestMovies : List<Movie> = repository.findBestMovies()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImageMovie: ImageView = itemView.findViewById(R.id.img_movie_card_home)
        var itemRating: TextView = itemView.findViewById(R.id.rating_movie_card_home)
        var itemTitleMovie: TextView = itemView.findViewById(R.id.title_movie_card_home)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_item_list_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImageMovie.setImageResource(bestMovies[position].image)
        holder.itemRating.text = bestMovies[position].rating.toString()
        holder.itemTitleMovie.text = bestMovies[position].title
    }

    override fun getItemCount(): Int {
        return bestMovies.size
    }
}