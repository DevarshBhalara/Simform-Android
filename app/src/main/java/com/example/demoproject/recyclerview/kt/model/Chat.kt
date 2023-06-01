package com.example.demoproject.recyclerview.kt.model

import android.net.Uri
import java.util.*

data class Chat (
    val message: String? = "",
    val messageType: MessageType? = MessageType.SEND,
    val time: String?,
    val dateTime: Date = Calendar.getInstance().time,
    val image: Uri? = null,
) {

    companion object {


        private fun getDate(): Date {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR, 2022)
            calendar.set(Calendar.MONTH, Calendar.JANUARY)
            calendar.set(Calendar.DAY_OF_MONTH, 3)
            return calendar.time
        }
        val dummyData: List<Chat> = listOf(
            Chat("Hello", MessageType.SEND, "4:55", getDate()),
            Chat("Hello", MessageType.SEND, "4:55", getDate()),
            Chat("Hello", MessageType.RECEIVE, "4:55", getDate()),
            Chat("Hello", MessageType.RECEIVE, "4:55", getDate()),
            Chat("Hello", MessageType.SEND, "4:55", getDate()),
            Chat("Hello", MessageType.SEND, "4:55", getDate()),
            Chat("Hello", MessageType.RECEIVE, "4:55", getDate()),
            Chat("Hello", MessageType.SEND, "4:55", getDate()),
            Chat("Hello", MessageType.RECEIVE, "4:55", getDate()),
            Chat("Hello", MessageType.RECEIVE, "4:55", getDate()),
            Chat("Hello", MessageType.RECEIVE, "4:55", getDate()),
            Chat("Hello", MessageType.SEND, "4:55", getDate()),
            Chat("Hello", MessageType.RECEIVE, "4:55", getDate()),
            Chat("Hello", MessageType.SEND, "4:55", getDate()),
        )
    }
}