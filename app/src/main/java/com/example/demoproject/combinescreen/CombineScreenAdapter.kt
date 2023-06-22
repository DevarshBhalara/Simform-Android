package com.example.demoproject.combinescreen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.ItemCombineScreenBinding
import com.example.demoproject.databinding.ItemCombineScreenHeaderBinding

class CombineScreenAdapter(val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val compontents = mutableListOf<CombineScreenModel>()

    inner class ViewHolderBody(private val binding: ItemCombineScreenBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(combineScreen: CombineScreenModel, position: Int) {
            binding.component = combineScreen
            binding.layout.setOnClickListener {

                if(combineScreen.clazz != null) {
                    val intent = Intent(context, combineScreen.clazz)
                    context.startActivity(intent)
                } else {
                    val intent = Intent(context, HostActivity::class.java)
                    intent.putExtra("position", position)
                    context.startActivity(intent)
                }


            }
        }
    }

    inner class ViewHolderHeader(private val binding: ItemCombineScreenHeaderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(combineScreenModel: CombineScreenModel, position: Int) {
            binding.component = combineScreenModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ComponentType.values()[viewType]) {
            ComponentType.BODY -> ViewHolderBody(ItemCombineScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            ComponentType.HEADER -> ViewHolderHeader(ItemCombineScreenHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemCount(): Int {
        return compontents.count()
    }

    override fun getItemViewType(position: Int): Int {
        return if(compontents[position].type == ComponentType.HEADER) ComponentType.HEADER.ordinal else ComponentType.BODY.ordinal
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderBody -> holder.bind(compontents[position], position)
            is ViewHolderHeader -> holder.bind(compontents[position], position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(list: List<CombineScreenModel>) {
        compontents.clear()
        compontents.addAll(list)
        notifyDataSetChanged()
    }
}