package com.example.demoproject.webservices.viewmodel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.webservices.data.ProgressCallback
import com.example.demoproject.webservices.data.ProgressRequestBody
import com.example.demoproject.webservices.interfaces.UserMockApiService
import com.example.demoproject.webservices.repository.UploadImageRepository
import com.example.demoproject.webservices.retrofitinstance.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class UploadImageViewModel @Inject constructor( @Named("UploadImage")
    private val uploadImageRepository: UploadImageRepository
) : ViewModel() {

    private val _imageResponse = MutableLiveData<Boolean>()
    val imageResponse = _imageResponse

    fun uploadImage(file: File) {

//        var requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
        val partTo = ProgressRequestBody(file, "image/*".toMediaTypeOrNull(), object : ProgressCallback {
            override fun onProgress(progress: Long) {
                Log.e("Progress", progress.toString())
            }

        })
        val part = MultipartBody.Part.createFormData("image", file.name, partTo)


        viewModelScope.launch {
           uploadImageRepository.uploadImage(part)
            uploadImageRepository.imageResponse.observeForever {
                imageResponse.value = it
            }
        }
    }
}