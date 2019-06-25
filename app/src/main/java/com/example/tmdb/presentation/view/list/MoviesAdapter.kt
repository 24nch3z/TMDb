package com.example.tmdb.presentation.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.data.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie.*
import ru.s4nchez.logger.Logger

class MoviesAdapter(private val clickListener: ClickListener) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

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

    class MoviesViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(clickListener: ClickListener, movie: Movie) {
            val context = itemView.context

            title_view.text = movie.title
            description_view.text = movie.overview
            rating_view.text = context.getString(R.string.item_movie_rating,
                    movie.voteAverage.toString(), movie.voteCount.toString())
            year_view.text = movie.releaseDate.substring(0, 4)

            if (adapterPosition % 2 == 0) {
                itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.item_movie_background))
            } else {
                itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.transparent))
            }

            when {
                movie.voteCount == 0 -> rating_view.setTextColor(ContextCompat
                        .getColor(context, R.color.main_text_color))
                movie.voteAverage >= 7.5f -> rating_view.setTextColor(ContextCompat
                        .getColor(context, R.color.item_movie_rating_very_good))
                movie.voteAverage >= 5.0f -> rating_view.setTextColor(ContextCompat
                        .getColor(context, R.color.item_movie_rating_good))
                movie.voteAverage >= 4.0f -> rating_view.setTextColor(ContextCompat
                        .getColor(context, R.color.item_movie_rating_medium))
                else -> rating_view.setTextColor(ContextCompat
                        .getColor(context, R.color.item_movie_rating_bad))
            }

            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                    .into(poster_view)

            itemView.setOnClickListener { clickListener.onClick(movie) }
        }
    }

    interface ClickListener {
        fun onClick(movie: Movie)
    }
}