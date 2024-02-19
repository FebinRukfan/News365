package com.febinrukfan.news365.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.febinrukfan.news365.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * Created by Febin Rukfan on 2024-02-18.
 * febinrukfan@gmail.com
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases

) : ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    val news = newsUseCases.getNews(
        sources = listOf("bbc-news","abc-news","al-jazeera-english")
    ).cachedIn(viewModelScope)

}