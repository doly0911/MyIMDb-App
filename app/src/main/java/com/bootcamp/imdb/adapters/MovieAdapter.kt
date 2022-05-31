package com.bootcamp.imdb.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.imdb.R

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    private var titles = arrayOf("Queen of the South", "Queen Sugar", "Queen", "Queenpins", "The Queens Gambit", "Marvel")
    private var years = arrayOf("2016", "2016", "2013", "2021", "2020", "2021")
    private var people = arrayOf("Alice Braga, Hemky Madera", "Rutina Wesley, Dawn-Lyen Gardner",
            "Kangana Ranaut, Rajkummar Rao","Kristen Bell, Kirby Howell-Baptiste", "Anya Taylor-Joy", "Thor, Wanda Vision")
    private var images = intArrayOf(R.drawable.img_queen_of_south, R.drawable.img_queen_sugar, R.drawable.img_queen,
            R.drawable.img_queenpins, R.drawable.img_queen_gambit, R.drawable.img_marvel)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.itemName.text = titles[position]
        holder.itemYear.text = years[position]
        holder.itemPeople.text = people[position]
        holder.itemImage.setImageResource(images[position])
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

   inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
       var itemName: TextView = itemView.findViewById(R.id.txt_name_movie)
       var itemYear: TextView = itemView.findViewById(R.id.txt_year_movie)
       var itemPeople: TextView = itemView.findViewById(R.id.txt_people)
       var itemImage: ImageView = itemView.findViewById(R.id.movie_image)
   }
}