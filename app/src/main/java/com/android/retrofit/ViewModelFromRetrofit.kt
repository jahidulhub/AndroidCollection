package com.android.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelFromRetrofit : ViewModel() {
    private var _response = MutableLiveData<List<ModelData>>()
    val response: LiveData<List<ModelData>> = _response

    init {
        getData()
    }
    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val listResult = RetrofitBuilder.retrofitService.getProperties()
            _response.value = listResult
        }
    }
}