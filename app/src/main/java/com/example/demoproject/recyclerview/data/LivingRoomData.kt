package com.example.demoproject.recyclerview.data

import androidx.core.content.ContentProviderCompat.requireContext
import com.example.demoproject.R
import com.example.demoproject.ktscreen.model.LivingRoomCardModel

class LivingRoomData {
    companion object{
        fun getAllCard(): List<LivingRoomCardModel> {
            return listOf(
                LivingRoomCardModel(
                    "OutDoor Lights",
                    "Off",
                    "20Watt",
                    false,
                    false,
                    false,
                    imageResourse = R.drawable.lightbulb
                )
            )
        }
    }
}