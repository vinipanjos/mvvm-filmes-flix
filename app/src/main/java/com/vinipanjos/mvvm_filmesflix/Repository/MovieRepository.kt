package com.vinipanjos.mvvm_filmesflix.Repository

import android.util.Log
import com.vinipanjos.mvvm_filmesflix.api.MovieRestApiTask
import com.vinipanjos.mvvm_filmesflix.model.Movie

class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    fun getAllMovies(): List<Movie> {

        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful){
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }

        }

        return movieList
    }

}