package com.vinipanjos.mvvm_filmesflix.data

class MovieRepository(private val movieDataSource: MovieDataSource) {

    fun getAllMoviesFromDataSource() = movieDataSource.getAllMoviesFromApi()

}