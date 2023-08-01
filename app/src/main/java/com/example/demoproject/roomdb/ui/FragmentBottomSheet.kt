package com.example.demoproject.roomdb.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.demoproject.R
import com.example.demoproject.ToastDemo
import com.example.demoproject.databinding.FragmentBottomSheetBinding
import com.example.demoproject.databinding.FragmentHomeMarkKTScreenBinding
import com.example.demoproject.roomdb.room.User
import com.example.demoproject.roomdb.viewModel.AddUserViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.launch

class FragmentBottomSheet: BottomSheetDialogFragment() {

    lateinit var binding: FragmentBottomSheetBinding
    private val viewModel: AddUserViewModel by viewModels()

    companion object {
        private const val ARG_DATA_KEY = "user"

        fun newInstance(user: User): FragmentBottomSheet {
            val args = Bundle().apply {
                putParcelable(ARG_DATA_KEY, user)
            }
            val fragment = FragmentBottomSheet()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            bindObservres()
            setupUI()
    }

    private fun bindObservres() {
        lifecycleScope.launch {
            launch {
                viewModel.updateSuccess.observe(viewLifecycleOwner) {
                    if (it.isNotEmpty()) {
                        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun setupUI() {
        val data = arguments?.getParcelable(ARG_DATA_KEY, User::class.java)
        binding.user = data

        binding.btnInsert.setOnClickListener {
            data?.let { it1 -> viewModel.updateUser(it1) }
        }
    }
}