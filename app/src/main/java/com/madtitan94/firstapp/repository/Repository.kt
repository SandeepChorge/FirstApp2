package com.madtitan94.firstapp.repository

import androidx.lifecycle.LiveData
import com.madtitan94.firstapp.api.MyRetrofitBuilder
import com.madtitan94.firstapp.models.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.lang.StringBuilder

object Repository {

    var job: CompletableJob? =null

    fun getUser(userId: String): LiveData<User>{
        job = Job()
        return object: LiveData<User>(){
            override fun onActive() {
                super.onActive()
                job?.let { job->
                    CoroutineScope(IO+job).launch {
                        val user = MyRetrofitBuilder.apiService.getUser(userId)
                        withContext(Main){
                            value = user
                            job.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }
}