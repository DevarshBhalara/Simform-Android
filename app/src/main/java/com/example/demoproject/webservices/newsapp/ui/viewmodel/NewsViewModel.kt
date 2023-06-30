package com.example.demoproject.webservices.newsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.webservices.newsapp.ui.model.News
import com.example.demoproject.webservices.newsapp.ui.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    private var _news = MutableLiveData<News>()
    val news: LiveData<News> = _news

    fun getNews() {
        viewModelScope.launch {
            val news = newsRepository.getNews()
            news?.let {
                _news.value = it
            }
        }
    }
}