package com.example.demoproject.recyclerview.kt

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.FragmentChatBinding
import com.example.demoproject.recyclerview.kt.adapter.ChatAdapter
import com.example.demoproject.recyclerview.kt.model.Chat
import com.example.demoproject.recyclerview.kt.model.MessageType
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentChatBinding
    val chatAdapter = ChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    @SuppressLint("SimpleDateFormat")
    private fun setUpRecyclerView() {
        binding.rvChat.adapter = chatAdapter
        binding.rvChat.addItemDecoration(StickyHeaderDecoration())
        binding.button.setOnClickListener {

            val time = Calendar.getInstance().time
            val formatter = SimpleDateFormat("HH:mm")
            val current = formatter.format(time)
            Log.e("Time", current.toString())
            chatAdapter.addChat(
                Chat(
                    binding.editText.text.toString(),
                    MessageType.SEND,
                    current.toString()
                )
            )
            binding.rvChat.smoothScrollToPosition(chatAdapter.chats.size)
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                chatAdapter.addChat(Chat("Hey There!", MessageType.RECEIVE, current.toString()))
                binding.rvChat.smoothScrollToPosition(chatAdapter.chats.size)
            }, 500)

            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                chatAdapter.addChat(Chat("DATE!", MessageType.DATE, current.toString()))
                binding.rvChat.smoothScrollToPosition(chatAdapter.chats.size)
            }, 1000)
        }
        binding.rvChat.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val postion = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                val list = chatAdapter.chats
                list.subList(0,postion + 1).findLast { it.messageType == MessageType.DATE }
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}