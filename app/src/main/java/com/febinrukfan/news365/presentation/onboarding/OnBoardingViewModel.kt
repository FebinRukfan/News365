package com.febinrukfan.news365.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.febinrukfan.news365.domain.usecases.AppEntryUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

    fun onEvent(event: OnBoardingEvent){

        when (event){

            is OnBoardingEvent.SaveAppEntry -> {

                saveUserEntry()
            }
        }
    }

    private fun saveUserEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }    }
}