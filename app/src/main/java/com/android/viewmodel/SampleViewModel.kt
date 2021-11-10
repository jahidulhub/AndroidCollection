package com.android.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

var wordList = mutableListOf(
    "queen",
    "hospital",
    "basketball",
    "cat",
    "change",
    "snail",
    "soup",
    "calendar",
    "sad",
    "desk",
    "guitar",
    "home",
    "railway",
    "zebra",
    "jelly",
    "car",
    "crow")

class SampleViewModel(application: Application) : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status
    init {
        getResult()
    }
    private fun getResult() {
        _status.value = "status value in initialized by calling getResult function."
    }


    var list = mutableStateListOf<String>()
    fun addItem(item: String) {
        list.add(item)
    }
    fun getItem(index: Int) {
        list[index]
    }
    fun removeItem(item: String, index: Int) {
        if (list.isNotEmpty()) {
            list.remove(item)
            list.removeAt(index)
            list.removeRange(fromIndex = 4, toIndex = 6)
        }
    }
    fun clear() {
        list.clear()
    }
    fun getRandomWord() {
        wordList.shuffled().take(1)
        list.shuffled()
    }
    fun getAlphabeticWord() {
        wordList.sorted()
        list.sorted()
    }

}