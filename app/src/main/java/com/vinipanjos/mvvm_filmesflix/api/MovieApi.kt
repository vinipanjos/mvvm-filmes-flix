package com.vinipanjos.mvvm_filmesflix.api

import com.vinipanjos.mvvm_filmesflix.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("vinipanjos/filmes-flix-api/master/moviesList")
    fun getAllMovies():Call<List<Movie>>

}