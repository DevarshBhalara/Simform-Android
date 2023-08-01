package com.example.demoproject.roomdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.demoproject.databinding.ActivityInsertUserBinding
import com.example.demoproject.roomdb.adapter.UserRoomDBAdapter
import com.example.demoproject.roomdb.helpers.SwipeToDeleteCallback
import com.example.demoproject.roomdb.listners.ItemClickListener
import com.example.demoproject.roomdb.room.User
import com.example.demoproject.roomdb.viewModel.AddUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InsertUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityInsertUserBinding
    private val viewModel: AddUserViewModel by viewModels()
    private val adapter = UserRoomDBAdapter()
    lateinit var users: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindObservers()
        setupUI()
    }

    private fun bindObservers() {
        lifecycleScope.launch {
            launch {
                viewModel.insertSuccess.observe(this@InsertUserActivity) {
                    runOnUiThread {
                        if (it.isNotEmpty()) {
                            Toast.makeText(this@InsertUserActivity, it, Toast.LENGTH_SHORT).show()
                            viewModel.getAllUser()
                        }
                    }
                }
            }

            launch {
                viewModel.user.collectLatest {
                    users = it
                    runOnUiThread { adapter.submitList(it) }
                }
            }

            launch {
                viewModel.deleteSuccess.observe(this@InsertUserActivity) {
                    runOnUiThread {
                        if (it.isNotEmpty()) {
                            Toast.makeText(this@InsertUserActivity, it, Toast.LENGTH_SHORT).show()
                            viewModel.getAllUser()
                        }
                    }
                }
            }
        }
    }

    private fun setupUI() {
        binding.rvUsers.adapter = adapter
        viewModel.getAllUser()
        adapter.itemClickListener = object : ItemClickListener<User> {
            override fun onClick(item: User, position: Int) {
                Log.d("click", "item")
                val bottomSheetFragment = FragmentBottomSheet.newInstance(users[position])
                bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
            }
        }
        val itemTouchHelper = ItemTouchHelper(
            SwipeToDeleteCallback { position ->
                viewModel.deleteUser(users[position])
            }
        )
        itemTouchHelper.attachToRecyclerView(binding.rvUsers)

        binding.btnInsert.setOnClickListener {
            val firstName = binding.edName.text.toString()
            val lastName = binding.edLastName.text.toString()
            Log.d("btn", "click")
            viewModel.insertUser(User(firstName = firstName, lastName = lastName))
        }
    }
}