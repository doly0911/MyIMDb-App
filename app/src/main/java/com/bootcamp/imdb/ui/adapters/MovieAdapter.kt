package com.bootcamp.imdb.ui.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.imdb.R
import com.bootcamp.imdb.data.models.Movie
import com.bootcamp.imdb.data.repositories.MovieRepository

class MovieAdapter(private val listener: MovieAdapterOnClickListener): RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    private var repository = MovieRepository()
    private var allMovies : List<Movie> = repository.findBestMovies()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.itemName.text = allMovies[position].title
        holder.itemYear.text = allMovies[position].year
        holder.itemPeople.text = allMovies[position].topCast
        holder.itemImage.setImageResource(allMovies[position].image)
        holder.onBindMovieCard()
    }

    override fun getItemCount(): Int {
        return allMovies.size
    }

   inner class ViewHolder (itemView: View, private val listener: MovieAdapterOnClickListener): RecyclerView.ViewHolder(itemView) {
       var itemName: TextView = itemView.findViewById(R.id.txt_name_movie)
       var itemYear: TextView = itemView.findViewById(R.id.txt_year_movie)
       var itemPeople: TextView = itemView.findViewById(R.id.txt_people)
       var itemImage: ImageView = itemView.findViewById(R.id.movie_image)
       var movieCard : CardView = itemView.findViewById(R.id.cardView_movie_list)

       fun onBindMovieCard(){
           movieCard.setOnClickListener{
               listener.movieCardOnclick(it)
           }
       }

   }

    interface MovieAdapterOnClickListener {
        fun movieCardOnclick(view: View)
    }
}