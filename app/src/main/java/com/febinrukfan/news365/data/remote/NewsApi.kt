package com.febinrukfan.news365.data.remote

import com.febinrukfan.news365.data.remote.dto.NewsResponse
import com.febinrukfan.news365.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Febin Rukfan on 2024-02-18.
 * febinrukfan@gmail.com
 */
interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}