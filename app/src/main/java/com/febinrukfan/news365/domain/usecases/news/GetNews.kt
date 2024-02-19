package com.febinrukfan.news365.domain.usecases.news

import androidx.paging.PagingData
import com.febinrukfan.news365.domain.model.Article
import com.febinrukfan.news365.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow


/**
 * Created by Febin Rukfan on 2024-02-18.
 * febinrukfan@gmail.com
 */
class GetNews(
    private val newsRepository: NewsRepository

) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}