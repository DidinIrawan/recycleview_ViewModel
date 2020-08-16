package com.exercise_recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercise_recycle.language.viewmodel.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.language_item_layout.*

class MainActivity : AppCompatActivity(), RecycleClickListener {

    val languageViewModel by viewModels<LanguageViewModel>()
    lateinit var languageRecycleAdapter: LanguageRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycleview.layoutManager = LinearLayoutManager(this)
        languageRecycleAdapter = LanguageRecycleAdapter(languageViewModel.languagesLiveData.value!!)
        languageRecycleAdapter.listener = this
        language_recycleview.adapter = languageRecycleAdapter

        languageViewModel.languagesLiveData.observe(this, Observer {
            println(it.joinToString())
           languageRecycleAdapter.notifyDataSetChanged()
        })
    }

    fun addLanguage(view: View) {
        val languageName = language_name_input.text.toString()
        languageViewModel.addLanguage(languageName)
    }

    override fun onItemClick(view: View, index: Int) {
        languageViewModel.removeLanguage(index)
        Toast.makeText(this,"${index.plus(1)}  Deleted!", Toast.LENGTH_SHORT).show()
    }
}