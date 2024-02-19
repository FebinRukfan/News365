package com.febinrukfan.news365.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.febinrukfan.news365.domain.model.Article


/**
 * Created by Febin Rukfan on 2024-02-19.
 * febinrukfan@gmail.com
 */

@Database(entities = [Article::class],version = 1,)
@TypeConverters(NewsTypeConvertor::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract val newsDao: NewsDao

}