package com.example.demoproject.webservices.repository

import androidx.lifecycle.MutableLiveData
import com.example.demoproject.webservices.interfaces.UserMockApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import java.io.File

class UploadImageRepository(private val uploadImageService: UserMockApiService) {

    private val _imageResponse = MutableLiveData<Boolean?>()
    val imageResponse = _imageResponse

    suspend fun uploadImage(part: MultipartBody.Part) {
        val response = uploadImageService.uploadImage("f8fe9a449ea4b2a9b7387b9e0d3d59c7", part)
        _imageResponse.postValue(response.success)
    }
}