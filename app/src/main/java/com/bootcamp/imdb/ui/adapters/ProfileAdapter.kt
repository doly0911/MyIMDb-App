package com.bootcamp.imdb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.imdb.R
import com.bootcamp.imdb.data.models.Movie


class ProfileAdapter: RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    private var description = arrayOf("Calificar y obtener recomendaciones", "Agregar a lista", "Aun sin iniciar", "Otraaa")
    private var titles = arrayOf("Calificaciones", "Listas", "Comenzar", "Finalizaar")
    private var num = arrayOf("0", "4", "0", "2")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_card_profile, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemDescription.text = description[position]
        holder.itemTitle.text = titles[position]
        holder.itemNumber.text = num[position]
    }

    override fun getItemCount(): Int {
        return description.size
    }

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemDescription: TextView = itemView.findViewById(R.id.description_text_card)
        var itemTitle : TextView = itemView.findViewById(R.id.title_card)
        var itemNumber : TextView = itemView.findViewById(R.id.numberTotal)

    }

}