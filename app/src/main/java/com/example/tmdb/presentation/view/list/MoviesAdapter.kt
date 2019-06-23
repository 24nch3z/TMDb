package com.example.tmdb.presentation.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.data.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie.*
import java.text.SimpleDateFormat

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var list = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(newItems: ArrayList<Movie>) {
        list = ArrayList(newItems)
        notifyDataSetChanged()
    }

    class MoviesViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(movie: Movie) {
            title_view.text = movie.title
            description_view.text = movie.overview
            rating_view.text = containerView.context.getString(R.string.item_movie_rating,
                    movie.voteAverage.toString(), movie.voteCount.toString())
            year_view.text = movie.releaseDate.substring(0, 4)

            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                    .into(poster_view)
        }
    }
}