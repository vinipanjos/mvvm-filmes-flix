package com.vinipanjos.mvvm_filmesflix.framework.api.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vinipanjos.mvvm_filmesflix.framework.api.MovieRestApiTask
import com.vinipanjos.mvvm_filmesflix.data.MovieRepository
import com.vinipanjos.mvvm_filmesflix.domain.Movie
import com.vinipanjos.mvvm_filmesflix.implementation.MovieDataSourceImplementation
import com.vinipanjos.mvvm_filmesflix.usecase.MoviesListUseCase

class MovieListViewModel :  ViewModel(){

    companion object{
        const val TAG = "MovieListViewModel"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val moviesListUseCase = MoviesListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList : LiveData<List<Movie>>
    get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread{
            try {
                _moviesList.postValue(moviesListUseCase.invoke())
            } catch (exception: Exception){
                Log.d(TAG, exception.message.toString())
            }
        }.start()

    }

}