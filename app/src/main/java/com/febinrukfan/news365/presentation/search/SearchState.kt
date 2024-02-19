package com.febinrukfan.news365.presentation.search

import androidx.paging.PagingData
import com.febinrukfan.news365.domain.model.Article
import kotlinx.coroutines.flow.Flow


/**
 * Created by Febin Rukfan on 2024-02-18.
 * febinrukfan@gmail.com
 */
data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)