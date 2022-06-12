package com.madtitan94.firstapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val TAG = "MainActivityViewModel"

    var number = 0
    val currentNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    public fun Increment(){

        number = number?.plus(1)
        currentNumber.value = number
        Log.e("Current value is "," -- > ${currentNumber.value.toString()}")

    }


    init {
    }

    override fun onCleared() {
        super.onCleared()
    }
}