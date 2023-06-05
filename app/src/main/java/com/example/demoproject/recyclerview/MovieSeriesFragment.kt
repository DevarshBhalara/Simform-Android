package com.example.demoproject.recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demoproject.R
import com.example.demoproject.databinding.FragmentMovieSeriesBinding
import com.example.demoproject.recyclerview.adapter.MovieSeriesAdapter
import com.example.demoproject.recyclerview.model.MovieSeries
import com.example.demoproject.recyclerview.type.ViewType

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieSeriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieSeriesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentMovieSeriesBinding
    val movieSeriesAdapter = MovieSeriesAdapter()

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
        binding = FragmentMovieSeriesBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRv()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setUpRv() {
        binding.rvMovieSeries.adapter = movieSeriesAdapter
        val movieseries = listOf(
            MovieSeries("FastX",8.5f, listOf("Hindi", "English", "tamil"), time = "2h 14m", type = ViewType.MOVIE, image = requireContext().getDrawable(R.drawable.fastx)),
            MovieSeries("Avatar",9.2f, listOf("Hindi", "English", "tamil", "Telugu"), time = "2h 46m", type = ViewType.MOVIE, image = requireContext().getDrawable(R.drawable.avatar)),
            MovieSeries("Farzi",8.5f, listOf("Hindi", "tamil", "Telugu"), type = ViewType.SERIES, seasons = 1, totalEpisodes = 1, gerne = listOf("Crime", "Action") , image = requireContext().getDrawable(R.drawable.farzi2) ),
            MovieSeries("Mission Impossible",8.1f, listOf("Hindi", "English", "tamil", "telugu"),  type = ViewType.MOVIE, image = requireContext().getDrawable(R.drawable.mip) ),
            MovieSeries("Stranger Things",8.2f, listOf("Hindi", "English"), type = ViewType.SERIES, seasons = 4, totalEpisodes = 40, gerne = listOf("Sci-fi", "Horror", "Mystery"),image = requireContext().getDrawable(R.drawable.st)),
        )
        movieSeriesAdapter.submitMovieSeries(movieseries)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MovieSeriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MovieSeriesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}