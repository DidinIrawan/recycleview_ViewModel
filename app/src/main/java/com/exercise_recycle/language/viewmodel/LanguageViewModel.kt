package com.exercise_recycle.language.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LanguageViewModel:ViewModel(){
    val languageList = mutableListOf<String>("Java","Phyton","C","C++","C#","Swift","Kotlin","Ruby","JS","Dart","R")

    val languagesLiveData: MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(name:String){
        languageList.add(name)
        languagesLiveData.value = languageList
//        languagesLiveData.value?.add(name)
//        println(languagesLiveData.value?.joinToString())
    }
    fun removeLanguage(positon:Int){
        languageList.removeAt(positon)
        languagesLiveData.value = languageList
    }
}