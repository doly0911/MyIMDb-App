package com.bootcamp.imdb.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.imdb.R
import com.bootcamp.imdb.data.remote.models.Movie
import com.bumptech.glide.Glide

class HomeAdapter (private val listener: HomeAdapterOnClickListener):
    ListAdapter<Movie, HomeAdapter.ViewHolder>(HomeAdapterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_item_list_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemRating.text = getItem(position).vote_average.toString()
        holder.itemTitleMovie.text = getItem(position).title
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/original${getItem(position).poster_path}")
            .centerCrop()
            .into(holder.itemImageMovie)
    }

    interface HomeAdapterOnClickListener {
        fun movieCardOnclick(view: View)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImageMovie: ImageView = itemView.findViewById(R.id.img_movie_card_home)
        var itemRating: TextView = itemView.findViewById(R.id.rating_movie_card_home)
        var itemTitleMovie: TextView = itemView.findViewById(R.id.title_movie_card_home)
    }
}

    class HomeAdapterDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
        }

    }

