package com.madtitan94.firstapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.madtitan94.firstapp.models.User
import com.madtitan94.firstapp.repository.Repository

class CoroutineViewModel : ViewModel() {

    private val _userId : MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = Transformations
        .switchMap(_userId){_userId->
            Repository.getUser(_userId)
        }

    fun setUserId(userId: String){
        val update = userId
        if(_userId.value == update){
            return
        }
        _userId.value = update
    }

    fun cancelJobs(){
        Repository.cancelJobs()
    }
}