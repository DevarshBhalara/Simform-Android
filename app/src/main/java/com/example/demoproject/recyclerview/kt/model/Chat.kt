package com.example.demoproject.recyclerview.kt.model

data class Chat (
    val message: String,
    val messageType: MessageType,
    val time: String,
) {
    companion object {
        val dummyData: List<Chat> = listOf(
            Chat("Hello", MessageType.RECEIVE, "0:00")
        )
    }
}