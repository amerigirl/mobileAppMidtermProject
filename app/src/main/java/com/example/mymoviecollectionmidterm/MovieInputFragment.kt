package com.example.mymoviecollectionmidterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch

class MovieInputFragment : Fragment() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextDirector: EditText
    private lateinit var editTextReleaseYear: EditText
    private lateinit var editTextGenre: EditText
    private lateinit var editTextRating: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonCancel: Button
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextTitle = view.findViewById(R.id.editTextTitle)
        editTextDirector = view.findViewById(R.id.editTextDirector)
        editTextReleaseYear = view.findViewById(R.id.editTextReleaseYear)
        editTextGenre = view.findViewById(R.id.editTextGenre)
        editTextRating = view.findViewById(R.id.editTextRating)
        buttonSave = view.findViewById(R.id.buttonSave)
        buttonCancel = view.findViewById(R.id.buttonCancel)    // add cancel button

        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        buttonSave.setOnClickListener {
            saveMovie()
        }

        buttonCancel.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun saveMovie() {
        val title = editTextTitle.text.toString().trim()
        val director = editTextDirector.text.toString().trim()
        val releaseYear = editTextReleaseYear.text.toString().toIntOrNull() ?: 0
        val genre = editTextGenre.text.toString().trim()
        val rating = editTextRating.text.toString().toFloatOrNull() ?: 0f

        if (title.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter a movie title", Toast.LENGTH_SHORT).show()
            return
        }

        val newMovie = Movie(
            title = title,
            director = director,
            releaseYear = releaseYear,
            genre = genre,
            rating = rating,

        )

        lifecycleScope.launch {
            movieViewModel.insert(newMovie)
            Toast.makeText(requireContext(), "Movie saved", Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
        }
    }
}
