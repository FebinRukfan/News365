package com.febinrukfan.news365.domain.usecases

import com.febinrukfan.news365.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManger: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}