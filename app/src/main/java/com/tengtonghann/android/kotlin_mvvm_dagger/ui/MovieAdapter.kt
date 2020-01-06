package com.tengtonghann.android.kotlin_mvvm_dagger.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tengtonghann.android.kotlin_mvvm_dagger.R
import com.tengtonghann.android.kotlin_mvvm_dagger.data.model.Movie
import com.tengtonghann.android.kotlin_mvvm_dagger.databinding.ItemMovieBinding

class MovieAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MoviesViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
    )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerViewMovieBinding.movie = movies[position]
    }

    inner class MoviesViewHolder(
        val recyclerViewMovieBinding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(recyclerViewMovieBinding.root)
}