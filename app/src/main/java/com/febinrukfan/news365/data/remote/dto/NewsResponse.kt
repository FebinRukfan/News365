package com.febinrukfan.news365.data.remote.dto

import com.febinrukfan.news365.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)