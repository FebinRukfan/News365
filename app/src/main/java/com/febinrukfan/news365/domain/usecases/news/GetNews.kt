package com.febinrukfan.news365.domain.usecases.news

import androidx.paging.PagingData
import com.febinrukfan.news365.domain.model.Article
import com.febinrukfan.news365.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * Created by Febin Rukfan on 2024-02-18.
 * febinrukfan@gmail.com
 */
class GetNews  @Inject constructor (
    private val newsRepository: NewsRepository

) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}