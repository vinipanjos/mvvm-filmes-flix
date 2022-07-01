package com.vinipanjos.mvvm_filmesflix.data

import com.vinipanjos.mvvm_filmesflix.domain.Movie

interface MovieDataSource {

    fun getAllMoviesFromApi(): List<Movie>

}