package com.example.demoproject.recyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.ItemLoaddingBinding
import com.example.demoproject.databinding.ItemSongBinding
import com.example.demoproject.recyclerview.model.Song

class SongAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ViewType {
        SONG,
        LOADING
    }

    private val songs: MutableList<Song> = mutableListOf()
    var isLoading = false

    class ViewHolder(
        private val binding: ItemSongBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(song: Song) {
            binding.song = song
        }
    }

    class LoadingViewHolder(
        private val binding: ItemLoaddingBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(isLoading: Boolean) {
            binding.isLoading = isLoading
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ViewType.values()[viewType]) {
            ViewType.SONG -> ViewHolder(
                ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            ViewType.LOADING -> LoadingViewHolder(
                ItemLoaddingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    fun showLoading() {
        isLoading = true
        notifyItemInserted(songs.count())
    }

    fun hideLoading() {
        isLoading = false
        notifyItemRemoved(songs.count())
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<Song>) {
        songs.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = if(isLoading) {
        songs.count() + 1
    } else {
        songs.count()
    }

    override fun getItemViewType(position: Int): Int {
        return if(isLoading && position == songs.count()) ViewType.LOADING.ordinal else ViewType.SONG.ordinal
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> holder.bind(songs[position])
            is LoadingViewHolder -> holder.bind(isLoading)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitSong(list: List<Song>){
        songs.clear()
        songs.addAll(list)
        notifyDataSetChanged()
    }
}