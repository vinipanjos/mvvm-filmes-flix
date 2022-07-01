package com.vinipanjos.mvvm_filmesflix.usecase

import com.vinipanjos.mvvm_filmesflix.data.MovieRepository

class MoviesListUseCase(private val movieRepository : MovieRepository) {
    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()
}