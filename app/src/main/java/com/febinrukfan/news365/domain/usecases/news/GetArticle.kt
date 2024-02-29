package com.febinrukfan.news365.domain.usecases.news

import com.febinrukfan.news365.data.local.NewsDao
import com.febinrukfan.news365.domain.model.Article


class GetArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}