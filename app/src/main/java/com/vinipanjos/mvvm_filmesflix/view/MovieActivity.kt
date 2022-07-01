package com.vinipanjos.mvvm_filmesflix.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinipanjos.mvvm_filmesflix.databinding.ActivityMainBinding
import com.vinipanjos.mvvm_filmesflix.model.Movie
import com.vinipanjos.mvvm_filmesflix.viewmodel.MovieListViewModel

class MovieActivity : AppCompatActivity() {
    private lateinit var movieListViewModel: MovieListViewModel
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)

        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
        loadingVisibility(true)
    }

    private fun initObserver(){
        movieListViewModel.moviesList.observe(this) {
            if (it.isNotEmpty()){
                populateList(it)
                loadingVisibility(false)
            }

        }
    }
    private fun populateList(list: List<Movie>){
        binding.rvMovies.hasFixedSize()
        binding.rvMovies.adapter = MoviesAdapter(list)

    }

    private fun loadingVisibility(isLoading: Boolean){
        binding.progressBar.visibility = if (isLoading)View.VISIBLE else View.GONE
    }
}