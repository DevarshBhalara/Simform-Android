package com.example.demoproject.recyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.ItemSongBinding
import com.example.demoproject.recyclerview.model.Song

class SongAdapter : RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    private val songs: MutableList<Song> = mutableListOf()

    class ViewHolder(
        private val binding: ItemSongBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(song: Song) {
            binding.song = song
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = songs.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(songs[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitSong(list: List<Song>){
        songs.clear()
        songs.addAll(list)
        notifyDataSetChanged()
    }
}