package com.example.demoproject.recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.demoproject.R
import com.example.demoproject.databinding.FragmentSongBinding
import com.example.demoproject.recyclerview.adapter.SongAdapter
import com.example.demoproject.recyclerview.itemdecoration.RecyclerViewItemDecoration
import com.example.demoproject.recyclerview.model.Song

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SongFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SongFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentSongBinding
    private val songAdapter = SongAdapter()

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
        binding = FragmentSongBinding.inflate(layoutInflater).apply {
            recyclerSong.adapter = songAdapter
        }
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setUpRecyclerView() {
        val songs = listOf(
            Song("Less Than Zero", "3:23", "DawnFM", 2022, true,requireContext().getDrawable(R.drawable.dawnfm_icon)),
            Song("Moth to flame", "4:23", "DawnFM", 2022,false, requireContext().getDrawable(R.drawable.dawnfm_icon)),
            Song("Sacrifice", "2:13", "DawnFM", 2022, false, requireContext().getDrawable(R.drawable.dawnfm_icon)),
            Song("Happier", "2:13", "Divider", 2015, false, requireContext().getDrawable(R.drawable.divide)),
            Song("Out of time", "3:23", "DawnFM", 2022,false, requireContext().getDrawable(R.drawable.dawnfm_icon)),
            Song("Take my breath", "4:23", "DawnFM", 2022, false, requireContext().getDrawable(R.drawable.dawnfm_icon)),
            Song("Shape of you", "4:13", "Divider", 2015, true, requireContext().getDrawable(R.drawable.divide)),
            Song("Castle on the hill", "5:13", "Divider", 2015, true, requireContext().getDrawable(R.drawable.divide)),
            Song("Moth to flame", "4:23", "DawnFM", 2022,false, requireContext().getDrawable(R.drawable.dawnfm_icon)),
            Song("Sacrifice", "2:13", "DawnFM", 2022, false, requireContext().getDrawable(R.drawable.dawnfm_icon)),
        )

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerSong.layoutManager = layoutManager
//        binding.recyclerSong.addItemDecoration(
//            DividerItemDecoration(
//                context,
//                layoutManager.orientation
//            )
//        )

        binding.recyclerSong.addItemDecoration(RecyclerViewItemDecoration(requireContext(), R.drawable.item_divider_recyclerview))
        songAdapter.submitSong(songs)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SongFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SongFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}