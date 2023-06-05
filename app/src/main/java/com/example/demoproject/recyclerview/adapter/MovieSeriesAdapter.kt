package com.example.demoproject.recyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.FragmentMovieSeriesBinding
import com.example.demoproject.databinding.ItemMovieBinding
import com.example.demoproject.databinding.ItemSeriesBinding
import com.example.demoproject.recyclerview.model.MovieSeries
import com.example.demoproject.recyclerview.type.ViewType
import java.lang.reflect.Type

class MovieSeriesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val movieseries: MutableList<MovieSeries> = mutableListOf()

    class ViewHolderMovie(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieSeries) {
            binding.movieSeries = movie
        }
    }

    class ViewHolderSeries(private val binding: ItemSeriesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieSeries) {
            binding.movieSeries = movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (ViewType.values()[viewType]) {
            ViewType.MOVIE -> ViewHolderMovie(
                ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent,false)
            )

            ViewType.SERIES -> ViewHolderSeries(
                ItemSeriesBinding.inflate(LayoutInflater.from(parent.context), parent,false)
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (movieseries[position].type == ViewType.MOVIE) ViewType.MOVIE.ordinal else ViewType.SERIES.ordinal
    }

    override fun getItemCount(): Int {
        return movieseries.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolderMovie)?.let {
            holder.bind(movieseries[position])
        }
        (holder as? ViewHolderSeries)?.let {
            holder.bind(movieseries[position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitMovieSeries(list: List<MovieSeries>) {
        movieseries.clear()
        movieseries.addAll(list)
        notifyDataSetChanged()
    }
}