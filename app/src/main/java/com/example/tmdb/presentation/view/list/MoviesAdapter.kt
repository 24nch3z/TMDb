package com.example.tmdb.presentation.view.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.tmdb.R
import com.example.tmdb.data.model.Movie

class MoviesAdapter(
        private val clickListener: ClickListener
) : PagedListAdapter<Movie, MoviesViewHolder>(MoviesDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        getItem(position)?.let { movie ->
            holder.bind(movie)
            holder.itemView.setOnClickListener { clickListener.onClick(movie) }
        }
    }

    interface ClickListener {
        fun onClick(movie: Movie)
    }

    companion object {
        private val MoviesDiffUtilCallback = object : DiffUtil.ItemCallback<Movie>() {

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}