package com.example.mymoviecollectionmidterm

import MovieAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieAdapter

    // Example data class for Movie; replace or expand with your own model if different
    data class Movie(val title: String, val year: Int)

    // Sample data for demonstration - replace with ViewModel LiveData in real app
    private val movieList = listOf(
        Movie("The Matrix", 1999),
        Movie("Inception", 2010),
        Movie("Interstellar", 2014)
    )

    override fun onResume() {
        super.onResume()
        activity?.title = "Awesome Movie List"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewMovies)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = MovieAdapter(movieList)
        recyclerView.adapter = adapter
        return view
    }
}
