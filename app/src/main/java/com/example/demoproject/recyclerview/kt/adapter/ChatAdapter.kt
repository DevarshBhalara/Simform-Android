package com.example.demoproject.recyclerview.kt.adapter

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.R
import com.example.demoproject.databinding.ItemChatDateBinding
import com.example.demoproject.databinding.ItemChatLeftBinding
import com.example.demoproject.databinding.ItemChatRightBinding
import com.example.demoproject.databinding.ItemChatRightImageBinding
import com.example.demoproject.recyclerview.kt.StickyHeaderDecoration
import com.example.demoproject.recyclerview.kt.model.Chat
import com.example.demoproject.recyclerview.kt.model.MessageType

class ChatAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnCreateContextMenuListener {
    lateinit var context: Context
    val chats: MutableList<Chat> = mutableListOf()

    inner class UserMessageViewHolder(private val binding: ItemChatRightBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat, position: Int) {
            binding.chat = chat
            setupOnLongClick(position, binding.layout, binding.tvMessage)
        }
    }

    private fun setupOnLongClick(position: Int, view: View, message: TextView? = null) {
       view.setOnLongClickListener {
            val popUp = PopupMenu(context, view)
            popUp.inflate(R.menu.chat_menu)
            popUp.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.delete -> deleteMessage(position)
                    R.id.copy -> message?.let {
                        copyMessage(message.text.toString())
                     }
                }
                return@setOnMenuItemClickListener true
            }
            popUp.show()
            return@setOnLongClickListener true
        }
    }

    private fun copyMessage(message: String) {
        val clipboardManager: ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("text", message)
        clipboardManager.setPrimaryClip(clip)
        Toast.makeText(context, "Message Coped to clipboard", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun deleteMessage(position: Int) {
        Log.d("delete", position.toString())
        Log.d(" delete chat size", chats.size.toString())
        chats.removeAt(position)
        notifyDataSetChanged()
    }

    inner class AutoMessageViewHolder(private val binding: ItemChatLeftBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat, position: Int) {
            binding.chat = chat
            setupOnLongClick(position, binding.layout, binding.tvMessage)
        }
    }

    inner class UserMessageImageViewHolder(private val binding: ItemChatRightImageBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat, position: Int) {
            binding.chatImage.setImageURI(chat.image)
            binding.chat = chat
            setupOnLongClick(position, binding.layout)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (MessageType.values()[viewType]) {
            MessageType.SEND -> UserMessageViewHolder(ItemChatRightBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            MessageType.RECEIVE -> AutoMessageViewHolder(ItemChatLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            MessageType.SEND_IMAGE -> UserMessageImageViewHolder(ItemChatRightImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemCount(): Int {
        return chats.count()
    }

    override fun getItemViewType(position: Int): Int {
        return when(chats[position].messageType) {
            MessageType.SEND -> MessageType.SEND.ordinal
            MessageType.RECEIVE -> MessageType.RECEIVE.ordinal
            MessageType.SEND_IMAGE -> MessageType.SEND_IMAGE.ordinal
            else -> { MessageType.SEND.ordinal }
        }

    }

    fun addChat(chat: Chat) {
        chats.add(chat)
        notifyItemInserted(chats.count())
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addInitialChat(list: List<Chat>) {
        chats.clear()
        chats.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is UserMessageViewHolder -> holder.bind(chats[position], position)
            is AutoMessageViewHolder -> holder.bind(chats[position], position)
            is UserMessageImageViewHolder -> holder.bind(chats[position], position)
        }
    }

    override fun onCreateContextMenu(
        p0: ContextMenu?,
        p1: View?,
        p2: ContextMenu.ContextMenuInfo?
    ) {
        TODO("Not yet implemented")
    }
}