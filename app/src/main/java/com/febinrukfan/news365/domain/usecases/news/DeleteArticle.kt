package com.febinrukfan.news365.domain.usecases.news

import com.febinrukfan.news365.data.local.NewsDao
import com.febinrukfan.news365.domain.model.Article


class DeleteArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }

}