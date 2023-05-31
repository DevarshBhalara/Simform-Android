package com.example.demoproject.recyclerview.kt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.R
import com.example.demoproject.databinding.ItemChatDateBinding
import com.example.demoproject.databinding.ItemChatLeftBinding
import com.example.demoproject.databinding.ItemChatRightBinding
import com.example.demoproject.recyclerview.kt.StickyHeaderDecoration
import com.example.demoproject.recyclerview.kt.model.Chat
import com.example.demoproject.recyclerview.kt.model.MessageType

class ChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), StickyHeaderDecoration.StickyHeaderInterface {

    val chats: MutableList<Chat> = mutableListOf()

    class UserMessageViewHolder(private val binding: ItemChatRightBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            binding.chat = chat
        }
    }

    class AutoMessageViewHolder(private val binding: ItemChatLeftBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            binding.chat = chat
        }
    }

    class DateViewHolder(private val binding: ItemChatDateBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (MessageType.values()[viewType]) {
            MessageType.SEND -> UserMessageViewHolder(ItemChatRightBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            MessageType.RECEIVE -> AutoMessageViewHolder(ItemChatLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            MessageType.DATE -> DateViewHolder(ItemChatDateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemCount(): Int {
        return chats.count()
    }

    override fun getItemViewType(position: Int): Int {
        return if(chats[position].messageType == MessageType.SEND) MessageType.SEND.ordinal else MessageType.RECEIVE.ordinal
    }

    fun addChat(chat: Chat) {
        chats.add(chat)
        notifyItemInserted(chats.count())
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is UserMessageViewHolder -> holder.bind(chats[position])
            is AutoMessageViewHolder -> holder.bind(chats[position])
            is DateViewHolder -> holder.bind()
        }
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        var _itemPosition = itemPosition
        var headerPosition = 0
        do {
            if(this.isHeader(itemPosition)) {
                headerPosition = itemPosition
                break
            }
            _itemPosition =- _itemPosition
        } while (_itemPosition >= 0)
        return headerPosition
    }

    override fun getHeaderLayout(headerPosition: Int): Int {
        return when (chats[headerPosition].messageType) {
            MessageType.DATE -> {
                R.layout.item_chat_date
            }
            MessageType.SEND -> {
                R.layout.item_chat_right
            }
            else -> {
                R.layout.item_chat_left
            }
        }
    }

    override fun bindHeaderData(header: View?, headerPosition: Int) {

    }

    override fun isHeader(itemPosition: Int): Boolean {
        return chats[itemPosition].messageType == MessageType.DATE
    }
}