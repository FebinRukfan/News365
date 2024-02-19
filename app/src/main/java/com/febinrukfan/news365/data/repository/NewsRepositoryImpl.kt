package com.febinrukfan.news365.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.febinrukfan.news365.data.remote.NewsApi
import com.febinrukfan.news365.data.remote.NewsPagingSource
import com.febinrukfan.news365.data.remote.SearchNewsPagingSource
import com.febinrukfan.news365.domain.model.Article
import com.febinrukfan.news365.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow


/**
 * Created by Febin Rukfan on 2024-02-18.
 * febinrukfan@gmail.com
 */
class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository{

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    api = newsApi,
                    searchQuery = searchQuery,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }


}