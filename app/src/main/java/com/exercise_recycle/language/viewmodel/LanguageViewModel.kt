package com.exercise_recycle.language.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LanguageViewModel:ViewModel(){
    private val languageList = mutableListOf<String>("Golang","React","Java")

    val languagesLiveData: MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(name:String){
        languageList.add(name)
        languagesLiveData.value = languageList
    }
    fun removeLanguage(positon:Int){
        languageList.removeAt(positon)
        languagesLiveData.value = languageList
    }
}