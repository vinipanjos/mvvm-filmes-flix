package com.vinipanjos.mvvm_filmesflix.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MovieRestApiTask {

    companion object{
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }

    private fun movieProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi(): MovieApi = movieProvider().create(MovieApi::class.java)
}