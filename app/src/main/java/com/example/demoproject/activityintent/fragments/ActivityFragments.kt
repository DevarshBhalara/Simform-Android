package com.example.demoproject.activityintent.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        setUpFragment()
    }

    private fun setUpFragment() {
        val bundle = Bundle()
        bundle.putString("fromActivity", "From Activity")
        binding.btnFragmentOne.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host, FragmentOne::class.java, bundle)
            }
        }

        binding.btnFragmentTwo.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host, FragmentTwo())
            }
        }
    }
}