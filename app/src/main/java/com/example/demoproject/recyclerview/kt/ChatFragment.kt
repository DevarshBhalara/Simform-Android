package com.example.demoproject.recyclerview.kt

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.R
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
    private val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    private val formatter = SimpleDateFormat("K:mm a", Locale.getDefault())

    private val url =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK) {

                val url = result.data?.data
                if (url != null) {
                    Log.d("url D", url.toString())
                    addImage(url)
                } else {
                    for (i in 0 until result.data!!.clipData!!.itemCount) {
                        addImage(result.data!!.clipData!!.getItemAt(i).uri)
                    }

                }
            }
        }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private val camera =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK) {
                Log.d("image",
                    result.data?.getParcelableExtra("data", Bitmap::class.java).toString()
                )
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
//        cameraButton()
        setUpInitialDate()
    }

//    private fun cameraButton() {
//
//        binding.camera.setOnClickListener {
//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            camera.launch(intent)
//        }
//    }

    private fun setUpInitialDate() {
        if (chatAdapter.chats.isEmpty()) {
            binding.date.text = getString(R.string.today)
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

    private fun setUpRecyclerView() {
        binding.rvChat.adapter = chatAdapter
        chatAdapter.context = requireContext()
        chatAdapter.addInitialChat(Chat.dummyData)
        binding.rvChat.smoothScrollToPosition(chatAdapter.chats.size)

        binding.button.setOnClickListener {

            if (binding.edMsg.text.isNotEmpty()) {
                val current = formatter.format(Calendar.getInstance().time)

                chatAdapter.addChat(
                    Chat(
                        binding.edMsg.text.toString().trim(),
                        MessageType.SEND,
                        current.toString()
                    )
                )
                binding.rvChat.smoothScrollToPosition(chatAdapter.chats.size)
                binding.edMsg.text.clear()
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
        Handler(Looper.getMainLooper()).postDelayed({
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


    private fun setDateInHeader(recyclerView: RecyclerView) {

        var position =
            (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        if (position == -1) position = 0
        Log.e("postions", "${chatAdapter.chats.subList(position, chatAdapter.chats.count())}")

        val lastDate = simpleDateFormat.format(
            chatAdapter.chats.subList(position, chatAdapter.chats.count()).first().dateTime
        )
        val todayDate = simpleDateFormat.format(Calendar.getInstance().time)

        Log.e("dates", "$lastDate $todayDate")
        if (todayDate.equals(lastDate)) {
            binding.date.text = getString(R.string.today)
        } else {
            binding.date.text = lastDate
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