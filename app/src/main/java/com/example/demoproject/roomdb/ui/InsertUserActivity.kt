package com.example.demoproject.roomdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.demoproject.databinding.ActivityInsertUserBinding
import com.example.demoproject.roomdb.repository.UserRepository
import com.example.demoproject.roomdb.room.User
import com.example.demoproject.roomdb.room.UserDatabase
import com.example.demoproject.roomdb.viewModel.AddUserViewModel
import com.example.demoproject.roomdb.viewModel.UserViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InsertUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityInsertUserBinding
    private val viewModel: AddUserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindObservers()
        setupUI()
    }

    private fun bindObservers() {
        GlobalScope.launch {
            viewModel.user.collectLatest {
                Log.d("users", it.toString())
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun setupUI() {
        viewModel.getAllUser()
        binding.btnInsert.setOnClickListener {
            val firstName = binding.edName.text.toString()
            val lastName = binding.edLastName.text.toString()

            GlobalScope.launch {
                viewModel.insertUser(User(firstName = firstName, lastName = lastName))
            }
        }
    }
}