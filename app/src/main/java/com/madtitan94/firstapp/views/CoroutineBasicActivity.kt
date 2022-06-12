package com.madtitan94.firstapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.madtitan94.firstapp.R
import com.madtitan94.firstapp.databinding.ActivityCoroutineBasicBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineBasicActivity : AppCompatActivity() {

    lateinit var binding: ActivityCoroutineBasicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_coroutine_basic)
        title = "Basic Coroutine Example"

        binding.button.setOnClickListener {

            //IO - For network req and db requests
            //Main - For Main thread
            //Default - For Heavy Computation

            CoroutineScope(IO).launch {
                fakeAPIReq()

            }
        }
    }

    private fun setString(value:String){
        val newText = binding.resultTv.text.toString() + "\n$value"
        binding.resultTv.text = newText
    }

    private suspend fun setTextOnMainThread(value: String){
        withContext(Main){
            setString(value)
        }
    }
    private suspend fun fakeAPIReq(){
        val result1 = getResultFromAPI()
        setTextOnMainThread(result1)

        val result2 = getResultFromAPI2()
        setTextOnMainThread(result2)
    }
    private suspend fun getResultFromAPI():String{
        logThread("getResultFromAPI")
        //This will delay only This coroutine
        delay(1000)

        //This will delay a thread and all the coroutines in in
        //Thread.sleep(1000)

        return  "REsult #1"
    }

    private suspend fun getResultFromAPI2():String{
        logThread("getResultFromAPI2")
        delay(1000)
        return  "REsult #2"
    }

    private fun logThread(methodName: String){
        println("DEBUG: ${methodName}: ${Thread.currentThread().name}")
    }
}