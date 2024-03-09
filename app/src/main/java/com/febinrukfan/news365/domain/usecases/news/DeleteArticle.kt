package com.febinrukfan.news365.domain.usecases.news

import com.febinrukfan.news365.data.local.NewsDao
import com.febinrukfan.news365.domain.model.Article
import javax.inject.Inject


/**
 * Created by Febin Rukfan on 2024-03-08.
 * febinrukfan@gmail.com
 */
class DeleteArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }

}