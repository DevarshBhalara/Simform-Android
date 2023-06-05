package com.example.demoproject.recyclerview.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.demoproject.R
import com.example.demoproject.ktscreen.model.LivingRoomCardModel

class LivingRoomData {
    companion object{
        @SuppressLint("UseCompatLoadingForDrawables")
        fun getAllCard(context: Context): List<LivingRoomCardModel> {
            return listOf(
                LivingRoomCardModel(
                    "OutDoor Lights",
                    "Off",
                    "20Watt",
                    false,
                    false,
                    false,
                    image = context.getDrawable(R.drawable.lightbulb)
                ),
                LivingRoomCardModel(
                    "Indoor Lights",
                    "On",
                    "84Watt",
                    true,
                    true,
                    false,
                    image = context.getDrawable(R.drawable.lightbulb),
                    totalProgress = 90,
                ),
                LivingRoomCardModel(
                    "SmartTV",
                    "Off",
                    "24Watt",
                    false,
                    false,
                    true,
                    context.getDrawable(R.drawable.baseline_tv_24),
                    bottomTitle = "Pulangnya Kapaaldfjbgaskjfsk",
                    bottomSubTitle = "RCTI"
                ),
                LivingRoomCardModel(
                    "Heater",
                    "On",
                    "84Watt",
                    isOn = true,
                    isProgressBarVisible = true,
                    false,
                    context.getDrawable(R.drawable.heater),
                    totalProgress = 80

                ),
                LivingRoomCardModel(
                    "Motion Sensor",
                    "Off",
                    "84Watt",
                    isOn = false,
                    isProgressBarVisible = false,
                    isBottomTextVisible = false,
                    image = context.getDrawable(R.drawable.motion_sensor),
                ),
                LivingRoomCardModel(
                    "OutDoor Lights",
                    "Off",
                    "20Watt",
                    false,
                    false,
                    false,
                    image = context.getDrawable(R.drawable.lightbulb)
                ),
                LivingRoomCardModel(
                    "Indoor Lights",
                    "On",
                    "84Watt",
                    true,
                    true,
                    false,
                    image = context.getDrawable(R.drawable.lightbulb),
                    totalProgress = 90,
                ),
                LivingRoomCardModel(
                    "SmartTV",
                    "Off",
                    "24Watt",
                    false,
                    false,
                    true,
                    context.getDrawable(R.drawable.baseline_tv_24),
                    bottomTitle = "Pulangnya Kapaaldfjbgaskjfsk",
                    bottomSubTitle = "RCTI"
                ),
                LivingRoomCardModel(
                    "Heater",
                    "On",
                    "84Watt",
                    isOn = true,
                    isProgressBarVisible = true,
                    false,
                    context.getDrawable(R.drawable.heater),
                    totalProgress = 80

                ),
                LivingRoomCardModel(
                    "Motion Sensor",
                    "Off",
                    "84Watt",
                    isOn = false,
                    isProgressBarVisible = false,
                    isBottomTextVisible = false,
                    image = context.getDrawable(R.drawable.motion_sensor),
                ),
            )
        }
    }
}