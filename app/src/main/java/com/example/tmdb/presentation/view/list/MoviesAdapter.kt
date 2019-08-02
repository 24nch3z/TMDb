package com.example.tmdb.presentation.view.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.data.model.Movie

class MoviesAdapter(private val clickListener: ClickListener) : RecyclerView.Adapter<MoviesViewHolder>() {

    private var list = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(clickListener, list[position])
    }

    fun setItems(newItems: ArrayList<Movie>) {
        list = ArrayList(newItems)
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onClick(movie: Movie)
    }
}