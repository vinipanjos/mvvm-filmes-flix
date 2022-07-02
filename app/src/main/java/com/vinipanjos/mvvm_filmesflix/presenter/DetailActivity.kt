package com.vinipanjos.mvvm_filmesflix.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.vinipanjos.mvvm_filmesflix.databinding.ActivityDetailBinding
import com.vinipanjos.mvvm_filmesflix.domain.Movie

class DetailActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    object Extras {
        const val MOVIE = "EXTRA_MOVIE"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadMovieFromExtra()
    }

    private fun loadMovieFromExtra() {
        intent?.extras?.getParcelable<Movie>(Extras.MOVIE)?.let {
            Glide.with(this).load(it.imagem).into(binding.ivMovie)

            binding.descriptionTxt.text = it.descricao
            binding.titleTxt.text = it.titulo
            binding.premiereTxt.text = it.dataLancamento
        }
    }
}