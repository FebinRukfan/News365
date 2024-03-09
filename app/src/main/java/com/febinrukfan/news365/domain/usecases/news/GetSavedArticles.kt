package com.febinrukfan.news365.domain.usecases.news

import com.febinrukfan.news365.data.local.NewsDao
import com.febinrukfan.news365.domain.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * Created by Febin Rukfan on 2024-03-08.
 * febinrukfan@gmail.com
 */
class GetSavedArticles @Inject constructor(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}