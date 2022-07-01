package com.vinipanjos.mvvm_filmesflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vinipanjos.mvvm_filmesflix.model.Movie

class MovieListViewModel :  ViewModel(){

    private val listOfMovies = arrayListOf(
        Movie(
            id = 0,
            titulo = "titanic",
            descricao = null,
            imagem = null,
            dataLancamento = null
        ),
        Movie(
            id = 1,
            titulo = "titanic 2",
            descricao = null,
            imagem = null,
            dataLancamento = null,
        )
    )

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList : LiveData<List<Movie>>
    get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
    _moviesList.value = listOfMovies
    }

}