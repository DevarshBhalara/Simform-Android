package com.example.demoproject.ktscreen

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demoproject.R
import com.example.demoproject.databinding.FragmentLivingRoomTempScreenBinding
import com.example.demoproject.ktscreen.model.AppBarModel
import com.example.demoproject.ktscreen.model.TempModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LivingRoomTempScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class LivingRoomTempScreen : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentLivingRoomTempScreenBinding
    private lateinit var _ac: TempModel
    private lateinit var _indoor: TempModel
    private lateinit var _lamp: TempModel
    private lateinit var _heater: TempModel
    private lateinit var _tv: TempModel
    private lateinit var _music: TempModel
    private lateinit var _sensor: TempModel
    private lateinit var _outdoor: TempModel

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
        binding = FragmentLivingRoomTempScreenBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        itemButtonClick()
    }

    private fun itemButtonClick() {

        binding.itemAC.btnItems.setOnClickListener {
            _ac = updateItems(_ac)
            updateAllModel()
        }

        binding.itemHeater.btnItems.setOnClickListener {
            _heater = updateItems(_heater)
           updateAllModel()
        }

        binding.itemIndoor.btnItems.setOnClickListener {
            _indoor = updateItems(_indoor)
            updateAllModel()
        }

        binding.itemLamp.btnItems.setOnClickListener {
            _lamp = updateItems(_lamp)
            updateAllModel()
        }

        binding.itemTV.btnItems.setOnClickListener {
            _tv = updateItems(_tv)
            updateAllModel()
        }

        binding.itemMusic.btnItems.setOnClickListener {
            _music = updateItems(_music)
            updateAllModel()
        }

        binding.itemSensor.btnItems.setOnClickListener {
            _sensor = updateItems(_sensor)
            updateAllModel()
        }

        binding.itemOutdoor.btnItems.setOnClickListener {
            _outdoor = updateItems(_outdoor)
            updateAllModel()
        }
    }

    private fun updateAllModel() {
        binding.ac = _ac
        binding.indoor = _indoor
        binding.lamp = _lamp
        binding.tv = _tv
        binding.heater = _heater
        binding.music = _music
        binding.sensor = _sensor
        binding.outdoor = _outdoor
    }

    private fun updateItems(item: TempModel): TempModel {
        _heater.isEnabled = false
        _ac.isEnabled = false
        _indoor.isEnabled = false
        _lamp.isEnabled = false
        _tv.isEnabled = false
        _music.isEnabled = false
        _sensor.isEnabled = false
        _outdoor.isEnabled = false
        item.isEnabled = !item.isEnabled
       return item
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setUpUI() {
        binding.appbar = AppBarModel(
            "LivingRoom",
            "20 Devices"
        )
        _ac = TempModel(
            requireContext().getDrawable(R.drawable.air_conditioner_32),
            "AC",
            true
        )
        binding.ac = _ac

        _indoor = TempModel(
            requireContext().getDrawable(R.drawable.idea),
            "Indoor",
            false
        )
        binding.indoor = _indoor

        _heater = TempModel(
            requireContext().getDrawable(R.drawable.room_heater_32),
            "Heater",
            false
        )
        binding.heater = _heater

        _lamp = TempModel(
            requireContext().getDrawable(R.drawable.desk_lamp_32),
            "Lamp",
            false
        )
        binding.lamp = _lamp

        _tv = TempModel(
            requireContext().getDrawable(R.drawable.baseline_tv_32),
            "TV",
            false
        )
        binding.tv = _tv

        _music = TempModel(
            requireContext().getDrawable(R.drawable.music_32),
            "Music",
            false
        )
        binding.music = _music

        _sensor = TempModel(
            requireContext().getDrawable(R.drawable.motion_sensor_32png),
            "Sensor",
            false
        )
        binding.sensor = _sensor

        _outdoor = TempModel(
            requireContext().getDrawable(R.drawable.idea),
            "Outdoor",
            false
        )
        binding.outdoor = _outdoor
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getImage(): Drawable {
        val data: Drawable = requireContext().getDrawable(R.drawable.lightbulb)!!
        requireContext().getDrawable(R.drawable.air_conditioner)?.let {
            return it
        }
        return data
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LivingRoomTempScreen.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LivingRoomTempScreen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}