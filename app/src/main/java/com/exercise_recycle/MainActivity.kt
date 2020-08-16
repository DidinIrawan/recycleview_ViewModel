package com.exercise_recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercise_recycle.language.viewmodel.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.language_item_layout.*

class MainActivity : AppCompatActivity() {

    val languageViewModel by viewModels<LanguageViewModel>()
    lateinit var languageRecycleAdapter: LanguageRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycleview.layoutManager = LinearLayoutManager(this)
        languageRecycleAdapter = LanguageRecycleAdapter(languageViewModel.languagesLiveData.value!!)
        language_recycleview.adapter = languageRecycleAdapter

        languageViewModel.languagesLiveData.observe(this, Observer {
//            language_recycleview.adapter = LanguageRecycleAdapter(it)
            println(it.joinToString())
           languageRecycleAdapter.notifyDataSetChanged()
        })
//        adapter = LanguageRecycleAdapter(languageViewModel.languagesLiveData.value!!)
//        language_recycleview.adapter = adapter
    }

    fun addLanguage(view: View) {
        val languageName = language_name_input.text.toString()
        languageViewModel.addLanguage(languageName)
    }
}