package com.bootcamp.imdb.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.imdb.R
import com.bootcamp.imdb.data.remote.models.Movie

class MovieAdapter(private val listener: MovieAdapterOnClickListener) :
    ListAdapter<Movie, MovieAdapter.ViewHolder>(MovieAdapterDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.itemName.text = getItem(position).title
        holder.itemYear.text = getItem(position).release_date
        holder.itemPeople.text = getItem(position).original_title
        //holder.itemImage.setImageResource(getItem(position).image)
        holder.onBindMovieCard()
    }

    inner class ViewHolder(itemView: View, private val listener: MovieAdapterOnClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.txt_name_movie)
        var itemYear: TextView = itemView.findViewById(R.id.txt_year_movie)
        var itemPeople: TextView = itemView.findViewById(R.id.txt_people)
        var itemImage: ImageView = itemView.findViewById(R.id.movie_image)
        var movieCard: CardView = itemView.findViewById(R.id.cardView_movie_list)

        fun onBindMovieCard() {
            movieCard.setOnClickListener {
                listener.movieCardOnclick(it)
            }
        }

    }

    interface MovieAdapterOnClickListener {
        fun movieCardOnclick(view: View)
    }
}

class MovieAdapterDiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}