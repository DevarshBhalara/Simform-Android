package com.example.demoproject.ktscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.demoproject.R
import com.example.demoproject.databinding.FragmentLivingRoomScreenBinding
import com.example.demoproject.ktscreen.model.AppBarModel
import com.example.demoproject.ktscreen.model.LivingRoomCardModel
import com.example.demoproject.ktscreen.viewmodel.LivingRoomViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LivingRoomScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LivingRoomScreenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentLivingRoomScreenBinding

    private lateinit var outLightDoor: LivingRoomCardModel
    private lateinit var smartTV: LivingRoomCardModel
    private lateinit var indoorLights: LivingRoomCardModel
    private lateinit var deskLamp: LivingRoomCardModel
    private lateinit var heater: LivingRoomCardModel
    private lateinit var motionSensor: LivingRoomCardModel
    private lateinit var wifi: LivingRoomCardModel
    private lateinit var ac: LivingRoomCardModel

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
        binding = FragmentLivingRoomScreenBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        radioButtonChange()
    }

    private fun radioButtonChange() {

        binding.card.rdOnOff.setOnClickListener {
            outLightDoor.isOn = !outLightDoor.isOn
            binding.outDoorLight = outLightDoor
        }

        binding.cardIndoorLights.rdOnOff.setOnClickListener {
            indoorLights.isOn = !indoorLights.isOn
            binding.indoorLights = indoorLights
        }

        binding.cardTV.rdOnOff.setOnClickListener {
            smartTV.isOn = !smartTV.isOn
            binding.smartTV = smartTV
        }

        binding.cardDeskLamp.rdOnOff.setOnClickListener {
            deskLamp.isOn = !deskLamp.isOn
            binding.deskLamp = deskLamp
        }

        binding.cardHeater.rdOnOff.setOnClickListener {
            heater.isOn = !heater.isOn
            binding.heater = heater
        }

        binding.cardMotionSensor.rdOnOff.setOnClickListener {
            motionSensor.isOn = !motionSensor.isOn
            binding.motionSensor = motionSensor
        }

        binding.cardWifi.rdOnOff.setOnClickListener {
            wifi.isOn = !wifi.isOn
            binding.wifi = wifi
        }

        binding.cardAC.rdOnOff.setOnClickListener {
            ac.isOn = !ac.isOn
            binding.ac = ac
        }

    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setupUi() {
        binding.appbar = AppBarModel(
            "LivingRoom",
            "20 Devices"
        )
        outLightDoor = LivingRoomCardModel(
            "OutDoor Lights",
            "Off",
            "20Watt",
            false,
            false,
            false,
            requireContext().getDrawable(R.drawable.lightbulb),

            )

        binding.outDoorLight = outLightDoor

        indoorLights = LivingRoomCardModel(
            "Indoor Lights",
            "On",
            "84Watt",
            true,
            true,
            false,
            requireContext().getDrawable(R.drawable.lightbulb),
            totalProgress = 90,
        )
        binding.indoorLights = indoorLights


        smartTV = LivingRoomCardModel(
            "SmartTV",
            "Off",
            "24Watt",
            false,
            false,
            true,
            requireContext().getDrawable(R.drawable.baseline_tv_24),
            bottomTitle = "Pulangnya Kapaaldfjbgaskjfsk",
            bottomSubTitle = "RCTI"
        )
        binding.smartTV = smartTV

        deskLamp = LivingRoomCardModel(
            "Desk Lamp",
            "On",
            "24Watt",
            isOn = false,
            isProgressBarVisible = false,
            false,
            requireContext().getDrawable(R.drawable.desklamp),

            )
        binding.deskLamp = deskLamp

        heater = LivingRoomCardModel(
            "Heater",
            "On",
            "84Watt",
            isOn = true,
            isProgressBarVisible = true,
            false,
            requireContext().getDrawable(R.drawable.heater),
            totalProgress = 80

        )
        binding.heater = heater

        motionSensor = LivingRoomCardModel(
            "Motion Sensor",
            "Off",
            "84Watt",
            false,
            false,
            false,
            requireContext().getDrawable(R.drawable.motion_sensor),
        )
        binding.motionSensor = motionSensor

        wifi = LivingRoomCardModel(
            "Wifi",
            "On",
            "64Watt",
            true,
            false,
            false,
            requireContext().getDrawable(R.drawable.signal),
        )
        binding.wifi = wifi

        ac = LivingRoomCardModel(
            "AC",
            "On",
            "64Watt",
            true,
            false,
            false,
            requireContext().getDrawable(R.drawable.air_conditioner),

            )
        binding.ac = ac
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LivingRoomScreenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LivingRoomScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}