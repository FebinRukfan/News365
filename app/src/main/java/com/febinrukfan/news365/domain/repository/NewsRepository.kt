package com.febinrukfan.news365.domain.repository

import androidx.paging.PagingData
import com.febinrukfan.news365.domain.model.Article
import kotlinx.coroutines.flow.Flow


/**
 * Created by Febin Rukfan on 2024-02-18.
 * febinrukfan@gmail.com
 */
interface NewsRepository {


    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>
}