package com.example.mymoviecollectionmidterm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieListItem.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListItem : Fragment() {

    private var movieTitle: String? = null
    private var movieDirector: String? = null

    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieTitle = it.getString(ARG_MOVIE_TITLE)
            movieDirector = it.getString(ARG_MOVIE_DIRECTOR)
        }
    }

    // TODO: Rename and change types of parameters
    companion object {
        private const val ARG_MOVIE_TITLE = "movie_title"
        private const val ARG_MOVIE_DIRECTOR = "movie_director"
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"


        fun newInstance(title: String, director: String) = MovieListItem().apply {
            arguments = Bundle().apply {
                putString(ARG_MOVIE_TITLE, title)
                putString(ARG_MOVIE_DIRECTOR, director)
            }
        }
    }

    // Inflate the layout for this fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list_item, container, false)
    }
  }

