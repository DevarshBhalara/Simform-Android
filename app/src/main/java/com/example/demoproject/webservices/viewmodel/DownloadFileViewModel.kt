package com.example.demoproject.webservices.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.webservices.repository.DownloadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DownloadFileViewModel @Inject constructor(
    private val downloadRepository: DownloadRepository
): ViewModel() {

    fun downloadFile() {
        viewModelScope.launch {
            downloadRepository.downloadFile()
        }
    }
}