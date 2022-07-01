package com.vinipanjos.mvvm_filmesflix.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vinipanjos.mvvm_filmesflix.databinding.MovieItemBinding
import com.vinipanjos.mvvm_filmesflix.model.Movie

class MoviesAdapter(private val movieList: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var adapterMovies: MoviesAdapter
        fun bind(movie: Movie) {
            binding.titleTxt.text = movie.titulo
            binding.descriptionTxt.text = movie.descricao
            binding.premiereTxt.text = movie.dataLancamento

            Glide.with(binding.root.context)
                .load(movie.imagem)
                .into(binding.ivMovie)

        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(movieList[position])

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = movieList.size

}