package com.febinrukfan.news365.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.febinrukfan.news365.domain.model.Article
import kotlinx.coroutines.flow.Flow


/**
 * Created by Febin Rukfan on 2024-02-19.
 * febinrukfan@gmail.com
 */

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM Article")
    fun getArticles(): Flow<List<Article>>
}