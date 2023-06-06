package com.example.demoproject.activityintent.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityFragmentsBinding

class ActivityFragments : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fragments)
        setContentView(binding.root)

        setUpInitalFragment()
        setUpFragment()
    }

    private fun setUpInitalFragment() {
        val bundle = Bundle()
        bundle.putString("fromActivity", "From Activity")
        supportFragmentManager.commit {
            add(R.id.fragment_host, FragmentOne().apply { arguments = bundle })
            addToBackStack("FragmentOne")
        }
    }

    private fun setUpFragment() {
        val bundle = Bundle()
        bundle.putString("fromActivity", "From Activity")
        binding.btnFragmentOne.setOnClickListener {
            supportFragmentManager.commit {
                add(R.id.fragment_host, FragmentOne().apply { arguments = bundle })
                addToBackStack("FragmentOne")
            }
        }

        binding.btnFragmentTwo.setOnClickListener {
            supportFragmentManager.commit {
                add(R.id.fragment_host, FragmentTwo())
            }
        }
    }
}