package com.example.tmdb.presentation.view.list

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.data.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie.*

class MoviesViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(movie: Movie) {
        val context = itemView.context

        title_view.text = movie.title
        description_view.text = movie.overview
        rating_view.text = context.getString(
                R.string.item_movie_rating,
                movie.voteAverage.toString(), movie.voteCount.toString()
        )
        year_view.text = movie.releaseDate.substring(0, 4)

        if (adapterPosition % 2 == 0) {
            itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.item_movie_background_even))
        } else {
            itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.item_movie_background_odd))
        }

        when {
            movie.voteCount == 0 -> rating_view.setTextColor(
                    ContextCompat.getColor(context, R.color.main_text_color)
            )
            movie.voteAverage >= 7.5f -> rating_view.setTextColor(
                    ContextCompat.getColor(context, R.color.item_movie_rating_very_good)
            )
            movie.voteAverage >= 5.0f -> rating_view.setTextColor(
                    ContextCompat.getColor(context, R.color.item_movie_rating_good)
            )
            movie.voteAverage >= 4.0f -> rating_view.setTextColor(
                    ContextCompat.getColor(context, R.color.item_movie_rating_medium)
            )
            else -> rating_view.setTextColor(
                    ContextCompat.getColor(context, R.color.item_movie_rating_bad)
            )
        }

        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                .into(poster_view)
    }
}