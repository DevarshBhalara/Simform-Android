package com.example.demoproject.binding

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.demoproject.R
import com.example.demoproject.model.SongModel

class Helper {
    fun getSongs(context: Context): List<SongModel> {
        return listOf(
            SongModel(
                context.resources.getStringArray(R.array.songLessThenZero)[0], context.resources.getStringArray(R.array.songLessThenZero)[1], context.resources.getStringArray(R.array.songLessThenZero)[2]
            ),
            SongModel(
                context.resources.getStringArray(R.array.songTakeMyBreath)[0], context.resources.getStringArray(R.array.songTakeMyBreath)[1], context.resources.getStringArray(R.array.songTakeMyBreath)[2]
            )
        )
    }
}