package com.febinrukfan.news365.domain.usecases

import com.febinrukfan.news365.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
private val localUserManger: LocalUserManager
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }

}