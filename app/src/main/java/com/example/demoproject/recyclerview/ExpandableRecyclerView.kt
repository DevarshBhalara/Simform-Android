package com.example.demoproject.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demoproject.R
import com.example.demoproject.databinding.FragmentExpandableRecyclerViewBinding
import com.example.demoproject.recyclerview.adapter.SeriesAdapter
import com.example.demoproject.recyclerview.data.SeriesData
import com.example.demoproject.recyclerview.model.Series

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExpandableRecyclerView.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExpandableRecyclerView : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentExpandableRecyclerViewBinding
    private val seriesAdapter = SeriesAdapter()
    var series = mutableListOf<Series>()

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
        binding = FragmentExpandableRecyclerViewBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        addData()
    }



    private fun setUpUI() {
        series = SeriesData.getAllSeries(requireContext())
        seriesAdapter.submitList(series)
        binding.rvExpandable.adapter = seriesAdapter

    }

    private fun addData() {
        binding.addData.setOnClickListener {
            seriesAdapter.addItem(SeriesData.addData(requireContext()))
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ExpandableRecyclerView.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExpandableRecyclerView().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}