package com.febinrukfan.news365.domain.usecases.news

import com.febinrukfan.news365.data.local.NewsDao
import com.febinrukfan.news365.domain.model.Article
import javax.inject.Inject


/**
 * Created by Febin Rukfan on 2024-02-19.
 * febinrukfan@gmail.com
 */
class UpsertArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.upsert(article = article)
    }

}