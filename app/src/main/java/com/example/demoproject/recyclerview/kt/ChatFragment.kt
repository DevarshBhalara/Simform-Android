package com.example.demoproject.recyclerview.kt

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
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
    private val chatAdapter = ChatAdapter()
    lateinit var time: Date
    @SuppressLint("SimpleDateFormat")
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    @SuppressLint("SimpleDateFormat")
    val formatter = SimpleDateFormat("K:mm a")

    private val url =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK) {

                val url = result.data?.data
                if (url != null) {
                    Log.d("url D", url.toString())
                    addImage(url)
                } else {
                    for ( i in 0 until result.data!!.clipData!!.itemCount) {
                        addImage(result.data!!.clipData!!.getItemAt(i).uri)
                    }

                }
            }
        }


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
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        attachButton()
        setUpInitialDate()
    }

    @SuppressLint("SetTextI18n")
    private fun setUpInitialDate() {
        if (chatAdapter.chats.isEmpty()) {
            binding.date.text = "Today"
        } else {
            setDateInHeader(binding.rvChat)
        }
    }

    private fun attachButton() {

        binding.attach.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            url.launch(intent)
        }

    }


    @SuppressLint("SimpleDateFormat", "ClickableViewAccessibility")
    private fun setUpRecyclerView() {
        binding.rvChat.adapter = chatAdapter
        chatAdapter.context = requireContext()
        chatAdapter.addInitialChat(Chat.dummyData)
        binding.rvChat.smoothScrollToPosition(chatAdapter.chats.size)

        binding.button.setOnClickListener {

            if (binding.edMsg.text.isNotEmpty()) {
                val formatter = SimpleDateFormat("K:mm a")
                val current = formatter.format(Calendar.getInstance().time)

                chatAdapter.addChat(
                    Chat(
                        binding.edMsg.text.toString(),
                        MessageType.SEND,
                        current.toString()
                    )
                )
                binding.rvChat.smoothScrollToPosition(chatAdapter.chats.size)
                addAutoGeneratedMessage(current, MessageType.SEND)
            }

        }

        binding.rvChat.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                setDateInHeader(recyclerView)
            }
        })

    }

    @SuppressLint("SimpleDateFormat")
    private fun addImage(url: Uri) {

        time = Calendar.getInstance().time
        val current = formatter.format(time)
        Log.e("Time", current.toString())

        chatAdapter.addChat(
            Chat(messageType = MessageType.SEND_IMAGE, image = url, time = current)
        )
        binding.rvChat.smoothScrollToPosition(chatAdapter.chats.size)
        addAutoGeneratedMessage(current, MessageType.SEND_IMAGE)

        binding.rvChat.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                setDateInHeader(recyclerView)
            }
        })
    }

    private fun addAutoGeneratedMessage(time: String, senderType: MessageType) {
        Handler(Looper.getMainLooper()).postDelayed( {
            chatAdapter.addChat(
                Chat(
                    when (senderType) {
                        MessageType.SEND -> "Hey There!"
                        MessageType.SEND_IMAGE -> "Nice Pic!"
                        MessageType.RECEIVE -> "Hey There"
                    }, MessageType.RECEIVE, time
                )
            )
            binding.rvChat.smoothScrollToPosition(chatAdapter.chats.size)
        }, 2000)
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun setDateInHeader(recyclerView: RecyclerView) {

        val position = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        val list = chatAdapter.chats

        val lastDate = list.subList(0, position + 1).findLast { it.messageType == MessageType.SEND || it.messageType == MessageType.RECEIVE || it.messageType == MessageType.SEND_IMAGE}?.dateTime

        val date = lastDate?.let { simpleDateFormat.format(it) }

        val time = Calendar.getInstance().time
        val todayDate = simpleDateFormat.format(time)

        if (todayDate.equals(date)) {
            binding.date.text = "Today"
        } else {
            binding.date.text = date
        }

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