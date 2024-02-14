package com.febinrukfan.news365.di

import android.app.Application
import com.febinrukfan.news365.data.manager.LocalUserManagerImpl
import com.febinrukfan.news365.domain.manager.LocalUserManager
import com.febinrukfan.news365.domain.usecases.AppEntryUseCases
import com.febinrukfan.news365.domain.usecases.ReadAppEntry
import com.febinrukfan.news365.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}