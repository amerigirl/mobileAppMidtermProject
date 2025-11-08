package com.example.mymoviecollectionmidterm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private var movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // ViewHolder holding references to item views
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.textViewTitle)
        val directorText: TextView = itemView.findViewById(R.id.textViewDirector)
        val yearText: TextView = itemView.findViewById(R.id.textViewYear)
    }

    // Inflate item layout and return ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie_list_item, parent, false)
        return MovieViewHolder(view)
    }

    // Bind movie data to item views
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleText.text = movie.title
        holder.directorText.text = movie.director
        holder.yearText.text = movie.releaseYear.toString()
    }

    override fun getItemCount() = movies.size

    // Updates adapter's movie data and refreshes list
    fun setMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }
}
