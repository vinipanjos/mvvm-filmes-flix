package com.vinipanjos.mvvm_filmesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vinipanjos.mvvm_filmesflix.Repository.MovieRepository
import com.vinipanjos.mvvm_filmesflix.api.MovieRestApiTask
import com.vinipanjos.mvvm_filmesflix.model.Movie

class MovieListViewModel :  ViewModel(){

    companion object{
        const val TAG = "MovieListViewModel"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList : LiveData<List<Movie>>
    get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread{
            try {
                _moviesList.postValue(movieRepository.getAllMovies())
            } catch (exception: Exception){
                Log.d(TAG, exception.message.toString())
            }
        }

    }

}