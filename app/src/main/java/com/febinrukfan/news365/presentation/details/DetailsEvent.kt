package com.febinrukfan.news365.presentation.details

import com.febinrukfan.news365.domain.model.Article


/**
 * Created by Febin Rukfan on 2024-02-19.
 * febinrukfan@gmail.com
 */
sealed class DetailsEvent {



    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()


    object RemoveSideEffect : DetailsEvent()

}