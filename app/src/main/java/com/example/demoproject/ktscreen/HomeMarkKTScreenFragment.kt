package com.example.demoproject.ktscreen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demoproject.R
import com.example.demoproject.databinding.FragmentHomeMarkKTScreenBinding
import com.example.demoproject.databinding.FragmentLivingRoomScreenBinding
import com.example.demoproject.ktscreen.model.AppBarModel
import com.example.demoproject.ktscreen.model.HomeMartModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeMarkKTScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeMarkKTScreenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var _temp: HomeMartModel
    private lateinit var _wifi: HomeMartModel
    private lateinit var _light: HomeMartModel
    private lateinit var _smartTV: HomeMartModel
    lateinit var binding: FragmentHomeMarkKTScreenBinding

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
        binding = FragmentHomeMarkKTScreenBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
        radioButtonClick()
    }

    private fun radioButtonClick() {
        binding.cardLamp.swDemo.setOnClickListener {
            _light.isOn = !_light.isOn
            binding.light = _light
        }

        binding.cardTv.swDemo.setOnClickListener {
            _smartTV.isOn = !_smartTV.isOn
            binding.smartTV = _smartTV
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables", "ResourceAsColor")
    private fun setUpUI() {
        binding.appbar = AppBarModel(
            "HomeMart",
            "Efficiency is Everything"
        )
        binding.appBar.subtitle.setTextColor(R.color.black)

        _temp = HomeMartModel(
            requireContext().getDrawable(R.drawable.lightbulb),
            "Temp",
            "24C"
        )
        binding.temp =  _temp

       _wifi = HomeMartModel(
            requireContext().getDrawable(R.drawable.wifi),
            "Wi-Fi",
            "100mbps"
        )
        binding.wifi = _wifi

       _light = HomeMartModel(
            requireContext().getDrawable(R.drawable.lightbulb),
            "Lamp",
            "24watt"
        )
        binding.light = _light

        _smartTV = HomeMartModel(
            requireContext().getDrawable(R.drawable.baseline_tv_24),
            "TV",
            "24watt"
        )
        binding.smartTV =  _smartTV
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeMarkKTScreenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeMarkKTScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}