package com.febinrukfan.news365.presentation.bookmark

import com.febinrukfan.news365.domain.model.Article


/**
 * Created by Febin Rukfan on 2024-02-19.
 * febinrukfan@gmail.com
 */
data class BookmarkState(
    val articles: List<Article> = emptyList()
)