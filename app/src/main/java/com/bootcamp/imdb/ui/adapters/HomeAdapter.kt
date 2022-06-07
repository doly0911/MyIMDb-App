package com.bootcamp.imdb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.imdb.R

class HomeAdapter:RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var images = intArrayOf(R.drawable.img_dune, R.drawable.img_the_suicide_squad, R.drawable.img_free_guy,
            R.drawable.img_queenpins, R.drawable.img_queen_gambit, R.drawable.img_marvel)
    private var rating = arrayOf("4.5", "4.5", "4.5", "4.6", "4.3", "5.0")
    private var titleMovie = arrayOf("Dune", "The Suicide Squad", "Free Guy",
            "Queenpins","The Queens Gambit", "Marvel")

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
        holder.itemImageMovie.setImageResource(images[position])
        holder.itemRating.text = rating[position]
        holder.itemTitleMovie.text = titleMovie[position]
    }

    override fun getItemCount(): Int {
        return titleMovie.size
    }
}