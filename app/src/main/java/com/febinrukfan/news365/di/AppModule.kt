package com.febinrukfan.news365.di

import android.app.Application
import androidx.room.Room
import com.febinrukfan.news365.data.local.NewsDao
import com.febinrukfan.news365.data.local.NewsDatabase
import com.febinrukfan.news365.data.local.NewsTypeConvertor
import com.febinrukfan.news365.data.manager.LocalUserManagerImpl
import com.febinrukfan.news365.data.remote.NewsApi
import com.febinrukfan.news365.data.repository.NewsRepositoryImpl
import com.febinrukfan.news365.domain.manager.LocalUserManager
import com.febinrukfan.news365.domain.repository.NewsRepository
import com.febinrukfan.news365.domain.usecases.app_entry.AppEntryUseCases
import com.febinrukfan.news365.domain.usecases.app_entry.ReadAppEntry
import com.febinrukfan.news365.domain.usecases.app_entry.SaveAppEntry
import com.febinrukfan.news365.domain.usecases.news.GetNews
import com.febinrukfan.news365.domain.usecases.news.NewsUseCases
import com.febinrukfan.news365.domain.usecases.news.SearchNews
import com.febinrukfan.news365.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )


    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}