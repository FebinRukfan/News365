package com.febinrukfan.news365.domain.usecases.news

import com.febinrukfan.news365.domain.usecases.news.GetNews

data class NewsUseCases (
    val getNews: GetNews,
    val searchNews: SearchNews
)
