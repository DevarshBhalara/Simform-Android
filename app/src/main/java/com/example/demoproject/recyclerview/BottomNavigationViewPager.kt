package com.example.demoproject.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.demoproject.R
import com.example.demoproject.databinding.FragmentBottomNavigationViewPagerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomNavigationViewPager.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomNavigationViewPager : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentBottomNavigationViewPagerBinding

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
        binding = FragmentBottomNavigationViewPagerBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
    }

    private fun setUpUI() {
        binding.viewPager.adapter = BottomNavAdapter(requireActivity(), 3)
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bottomNavigation.selectedItemId = R.id.song
                    1 -> binding.bottomNavigation.selectedItemId = R.id.movieSeries
                    2 -> binding.bottomNavigation.selectedItemId = R.id.series
                }
                super.onPageSelected(position)
            }
        })

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.song -> binding.viewPager.setCurrentItem(0,true)
                R.id.movieSeries -> binding.viewPager.setCurrentItem(1,true)
                R.id.series -> binding.viewPager.setCurrentItem(2,true)
                else -> {
                    binding.viewPager.setCurrentItem(0,true)
                }
            }
            true
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BottomNavigationViewPager.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BottomNavigationViewPager().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}